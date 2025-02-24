package com.moller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.ImagingException;
import org.apache.commons.imaging.common.RationalNumber;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegPhotoshopMetadata;
import org.apache.commons.imaging.formats.jpeg.exif.ExifRewriter;
import org.apache.commons.imaging.formats.jpeg.iptc.IptcRecord;
import org.apache.commons.imaging.formats.jpeg.iptc.PhotoshopApp13Data;
import org.apache.commons.imaging.formats.tiff.TiffDirectory;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata.GpsInfo;
import org.apache.commons.imaging.formats.tiff.constants.TiffDirectoryConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffDirectoryType;
import org.apache.commons.imaging.formats.tiff.fieldtypes.AbstractFieldType;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfo;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoAscii;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoLong;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoRational;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoShort;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputDirectory;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputSet;

import com.moller.Models.MetadataCharts;
import com.moller.Models.MetadataObject;

import javafx.scene.layout.FlowPane;

public class HelperClass {

    /**
     * This method puts a human readable name to the given tag.
     *
     * @param tag       The tag to name.
     * @param directory The directory it's found in
     * @return A string containing the name of the tag.
     * @see HelperClass#GetDirectories(HashMap, File)
     * @see MetadataCharts
     */
    public static String identifyEXIFTag(Integer tag, String directory) {
        String sretval = "Unknown Tag (" + tag.toString() + ")";
        MetadataObject[] tagSet = null;

        switch (directory) {
            case "EXIF Data":
                tagSet = MetadataCharts.GetExifDirectory();
                break;
            case "GPS Data":
                tagSet = MetadataCharts.GetGPSDirectory();
                break;
            default:
                break;
        }

        if (tagSet != null) {
            for (MetadataObject metadataObject : tagSet) {
                if (tag == metadataObject.GetMetadataId()) {
                    sretval = metadataObject.GetMetadataTag();
                    break;
                }
            }
        }

        return sretval;
    }

    /**
     * Saves the metadata if there's any changes to the value specified.
     *
     * @param valuesToSave The metadata from the GUI.
     * @param imgFile      The image file to save the metadata to.
     * @see ViewHelper#DisplayImageMetadata(FlowPane, File)
     * @see ViewHelper#AddMetadataField(String, String)
     */
    public static void saveMetadataEdits(HashMap<String, HashMap<Integer, String>> valuesToSave, File imgFile,
            File destination) {
        File destFile = new File(destination + File.separator + imgFile.getName());
        if (!destFile.exists()) {

        }
        TiffImageMetadata exifData = null;
        TiffOutputSet metadataChanges;

        // TODO: Research how to make this more sensible.
        TiffOutputDirectory outputExifDirectory = null;
        TiffOutputDirectory outputGPSDirectory = null;
        JpegImageMetadata jpegImageMetadata = GetMetadataFromImage(imgFile);

        try {
            if (jpegImageMetadata != null) {
                exifData = jpegImageMetadata.getExif();
            }

            if (exifData != null) {
                metadataChanges = exifData.getOutputSet();

            } else {
                metadataChanges = new TiffOutputSet();
            }

            for (var directory : valuesToSave.entrySet()) {
                switch (directory.getKey()) {
                    case "EXIF Data":
                        outputExifDirectory = metadataChanges.getOrCreateExifDirectory();
                        for (var fieldToSave : directory.getValue().entrySet()) {
                            handleOutputField(outputExifDirectory, directory.getKey(), fieldToSave.getKey(),
                                    fieldToSave.getValue());
                        }
                        break;
                    case "GPS Data":
                        outputGPSDirectory = metadataChanges.getOrCreateGpsDirectory();
                        Double latitude = 0.0;
                        Double longitude = 0.0;
                        for (var fieldToSave : directory.getValue().entrySet()) {
                            if (fieldToSave.getKey() != 0x0002 || fieldToSave.getKey() != 0x0004) {
                                handleOutputField(outputGPSDirectory, directory.getKey(),
                                        fieldToSave.getKey(),
                                        fieldToSave.getValue());
                            } else {
                                try {
                                    switch (fieldToSave.getKey()) {
                                        case 0x0002:
                                            latitude = Double.parseDouble(fieldToSave.getValue());
                                            break;
                                        case 0x0004:
                                            longitude = Double.parseDouble(fieldToSave.getValue());
                                            break;
                                    }
                                } catch (NumberFormatException numEx) {
                                    // TODO: Setup proper error handling.
                                }

                            }

                        }
                        metadataChanges.setGpsInDegrees(longitude, latitude);
                        break;
                    default:
                        // TODO: Find out what to do in case of unknown directory.
                        break;
                }

                if (imgFile.getPath() != destFile.getPath()) {
                    if (!destFile.exists()) {
                        Files.copy(Path.of(imgFile.getPath()), Path.of(destFile.getPath()));
                    }
                }

                try (FileOutputStream fileStream = new FileOutputStream(destFile);
                        OutputStream outputStream = new BufferedOutputStream(fileStream)) {
                    new ExifRewriter().updateExifMetadataLossless(imgFile, outputStream, metadataChanges);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }

        } catch (ImagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Removes field from the output set and adds the new value if applicable.
     *
     * @param outputDir The output set to remove and add fields to/from.
     * @param directory The directory to use for the output set
     * @param tag       The tag ID to save the value to.
     * @param value     The value from the {@code TextField} input.
     * @return Returns the provided output set with the specified field removed or
     *         updated.
     */
    public static Boolean handleOutputField(TiffOutputDirectory outputDir, String directory, int tag, String value) {
        MetadataObject[] tagList = null;
        Boolean bretval = false;
        outputDir.removeField(tag);
        bretval = true;

        switch (directory) {
            case "EXIF Data":
                tagList = MetadataCharts.GetExifDirectory();
                break;
            case "GPS Data":
                tagList = MetadataCharts.GetGPSDirectory();
                break;
            default:
                break;
        }

        if (tagList == null) {
            return bretval;
        }

        if (!value.isBlank() || !value.isEmpty()) {
            for (MetadataObject metadataTag : tagList) {
                if (metadataTag.GetMetadataId() == tag) {
                    if (metadataTag.GetValueType() != null) {
                        addFieldToOutput(outputDir, metadataTag, value);
                    } else {
                        System.out.print(
                                "Write action for tag " + metadataTag.GetMetadataTag() + " has not been created.");
                    }
                }
            }
        }
        return bretval;
    }

    /**
     * Creates output field to add to the output directory.
     *
     * @param outputDir The directory to add the new field to.
     * @param tag       The {@code MetadataObject} used for reference
     * @param value     The value to add.
     * @param directory The directory
     * @return
     */
    private static Boolean addFieldToOutput(TiffOutputDirectory outputDir, MetadataObject tag, String value) {
        Boolean bretval = false;
        try {
            TagInfo field = createField(tag, value);
            switch (tag.GetValueType()) {
                case "String":
                    TagInfoAscii asciiField = new TagInfoAscii(field.name, field.tag, field.length,
                            field.directoryType);
                    outputDir.add(asciiField, value);
                    break;
                case "Short":
                    TagInfoShort shortField = new TagInfoShort(field.name, field.tag, field.directoryType);
                    outputDir.add(shortField, Short.parseShort(value));
                    break;
                case "Long":
                    TagInfoLong longField = new TagInfoLong(field.name, field.tag, field.directoryType);
                    outputDir.add(longField, Integer.parseInt(value));
                    break;
                case "Rational":
                    TagInfoRational ratField = new TagInfoRational(field.name, field.tag, field.directoryType);
                    outputDir.add(ratField, RationalNumber.valueOf(Double.parseDouble(value)));
                    break;
                case "Rationals":
                    break;
                case "Bytes":
                    break;
                default:
                    break;
            }

            bretval = true;

        } catch (Exception imgEx) {
            // TODO: handle exception
            System.err.println(imgEx);
        }
        return bretval;
    }

    // TODO: Handle more metadata directories than just Jpeg ones.
    /**
     * Retrieves metadata from the given image
     *
     * @param imgFile The Image to extract EXIF/GPS/IPTC data from
     * @return Returns a null value if the image has no metadata.
     */
    public static JpegImageMetadata GetMetadataFromImage(File imgFile) {
        JpegImageMetadata jimretval = null;

        try {
            jimretval = (JpegImageMetadata) Imaging.getMetadata(imgFile);
        } catch (ImagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jimretval;
    }

    /**
     * This method extracts the directories from the image provided, adding them to
     * a hashmap of hashmaps.
     *
     * @param metadataDirectories Hashmap of hashmaps of directories, consisting of
     *                            the tag ID and the value it contains.
     * @param imgFile             The image to pull the metadata directories from.
     * @return
     */
    public static Boolean GetDirectories(
            HashMap<String, HashMap<Integer, String>> metadataDirectories, File imgFile) {
        Boolean bretval = false;

        String fileType = imgFile.getAbsolutePath().split("\\.")[1].toLowerCase();

        switch (fileType) {
            case "jpg":
            case "jpeg":
                // Fetch JPEG metadata. May be null.
                JpegImageMetadata jpgMetaData = GetMetadataFromImage(imgFile);

                HashMap<Integer, String> exifDirectory = new HashMap<>();
                HashMap<Integer, String> gpsHashMap = new HashMap<>();

                Boolean generatedGPSDirectory = getGPSInfo(jpgMetaData, gpsHashMap);
                Boolean generatedRootDirectory = getExifInfo(jpgMetaData, exifDirectory);

                if (generatedRootDirectory) {
                    metadataDirectories.put("EXIF Data", exifDirectory);
                }

                if (generatedGPSDirectory) {
                    metadataDirectories.put("GPS Data", gpsHashMap);
                }

                // if (iptcMetadata != null) {
                // HashMap<String, String> iptcDirectory =
                // GetIPTCInfo(jpgMetaData.getPhotoshop());
                // metadataDirectories.put("IPTC Data", iptcDirectory);
                // }
                break;

            default:
                break;
        }
        return bretval;

    }

    /**
     * Extracts the IPTC data from the image metadata provided.
     *
     * @param photoshop The image metadata to read from.
     * @return Returns a hashmap of the values extracted.
     */
    private static HashMap<String, String> GetIPTCInfo(JpegPhotoshopMetadata photoshop) {
        HashMap<String, String> hmretval = new HashMap<>();

        PhotoshopApp13Data iptcData = photoshop.photoshopApp13Data;

        // Get block data too?
        List<IptcRecord> recordData = iptcData.getRecords();

        for (IptcRecord iptcRecord : recordData) {
            hmretval.put(iptcRecord.getIptcTypeName(), iptcRecord.getValue());
        }

        return hmretval;
    }

    /**
     * Extracts the EXIF data from the image metadata provided.
     *
     * @param jpgMetaData   The image metadata to read from.
     * @param exifDirectory The hashmap to add extracted data into.
     * @return Whether the data pull completed successfully or not.
     */
    private static Boolean getExifInfo(JpegImageMetadata jpgMetaData, HashMap<Integer, String> exifDirectory) {
        Boolean bretval = false;
        MetadataObject[] exifTags = MetadataCharts.GetExifDirectory();
        TiffImageMetadata exifData = null;

        try {
            if (jpgMetaData != null) {
                exifData = jpgMetaData.getExif();
            }

            for (MetadataObject tag : exifTags) {
                String metadataValue = "";
                TiffField exifField = null;

                if (exifData != null) {
                    exifField = exifData.findField(createField(tag, "Root"));

                    if (exifField != null) {
                        metadataValue = exifField.getValue().toString();
                    }
                }

                exifDirectory.put(tag.GetMetadataId(), metadataValue);
            }

            bretval = true;
        } catch (ImagingException imgEx) {
            imgEx.printStackTrace();
            bretval = false;
        }

        return bretval;
    }

    /**
     * Extracts the GPS directory metadata from the EXIF data.
     *
     * @param jpgMetaData  the image metadata to read data from.
     * @param directoryMap The hashmap to insert data into.
     * @return Whether the data pull completed successfully or not.
     */
    private static Boolean getGPSInfo(JpegImageMetadata jpgMetaData, HashMap<Integer, String> directoryMap) {
        Boolean bretval = false;
        MetadataObject[] gpsTags = MetadataCharts.GetGPSDirectory();
        TiffImageMetadata exifData = null;
        TiffDirectory gpsDir = null;
        GpsInfo gpsData = null;

        try {
            if (jpgMetaData != null) {
                exifData = jpgMetaData.getExif();

                // Pull GPS info. May be null.
                if (exifData != null) {
                    gpsDir = exifData.findDirectory(TiffDirectoryConstants.DIRECTORY_TYPE_GPS);
                    gpsData = exifData.getGpsInfo();
                }
            }

            for (MetadataObject tag : gpsTags) {
                String metadataValue = "";
                // if Latitude(0x0002) or Longitude(0x0004) crops up, just make the Imaging
                // library do it.
                if (tag.GetMetadataId() == 0x0002) {
                    if (gpsData != null) {
                        metadataValue = Double.toString(gpsData.getLatitudeAsDegreesNorth());
                    }
                } else if (tag.GetMetadataId() == 0x0004) {
                    if (gpsData != null) {
                        metadataValue = Double.toString(gpsData.getLongitudeAsDegreesEast());
                    }
                } else {
                    if (gpsDir != null) {
                        final TagInfo tagToFind = createField(tag, "GPS");
                        TiffField gpsField = gpsDir.findField(tagToFind);
                        if (gpsField != null) {
                            metadataValue = gpsField.getValue().toString();
                        }
                    }
                }

                directoryMap.put(tag.GetMetadataId(), metadataValue);
            }
            bretval = true;

        } catch (ImagingException imgEx) {
            // TODO Auto-generated catch block
            imgEx.printStackTrace();
            bretval = false;
        }

        return bretval;
    }

    // #region TiffField creation
    /**
     * Returns a {@code TagInfo}.
     *
     * @param tag       The metadata tag to base the TagInfo on.
     * @param directory The directory the field resides in. Used values are so far:
     *                  Root, GPS, IPTC
     * @return A {@code TagInfo}, populated by values from the provided
     *         {@code MetadataObject}
     */
    private static TagInfo createField(MetadataObject tag, String directory) {
        // Determine AbstractFieldType through the value type described in the char
        AbstractFieldType fieldType = getFieldType(tag.GetValueType());
        TiffDirectoryType directoryType = getDirectoryType(directory);

        // Looking at the way Apache does things, they seem to use -1 as no limit.
        int length = tag.GetValueLength();
        if (length == 0) {
            length = -1;
        }

        return new TagInfo(tag.GetMetadataTag(), tag.GetMetadataId(), fieldType, length,
                directoryType);
    }

    /**
     * Returns a {@code TiffDirectoryType} value depending on the directory String
     * value.
     *
     * @param directory
     * @return Returns {@code TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN} if the
     *         provided value is not recognized.
     */
    private static TiffDirectoryType getDirectoryType(String directory) {
        TiffDirectoryType dirretval = TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN;

        switch (directory) {
            case "Root":
            case "EXIF Data":
                dirretval = TiffDirectoryType.TIFF_DIRECTORY_ROOT;
                break;
            case "GPS":
            case "GPS Data":
                dirretval = TiffDirectoryType.EXIF_DIRECTORY_GPS;
                break;
            case "IPTC":
                // TODO: This one I need to think over
                // dirretval = TiffDirectoryType.
            default:
                break;
        }
        return dirretval;
    }

    /**
     * Provides a {@code AbstractFieldType} value depending on the tag's value type
     *
     * @param valueType The value type to evaluate
     * @return An {@code AbstractFieldType} appropriate for the given String value.
     *         Or {@code AbstractFieldType.UNDEFINED} if the specified value type is
     *         not recognized.
     */
    private static AbstractFieldType getFieldType(String valueType) {
        AbstractFieldType fieldtyperetval = AbstractFieldType.UNDEFINED;
        switch (valueType) {
            case "String":
                fieldtyperetval = AbstractFieldType.ASCII;
                break;
            case "Short":
                fieldtyperetval = AbstractFieldType.SHORT;
                break;
            case "Rationals":
            case "Rational":
                fieldtyperetval = AbstractFieldType.RATIONAL;
                break;
            case "Long":
                fieldtyperetval = AbstractFieldType.LONG;
                break;
            case "Bytes":
                fieldtyperetval = AbstractFieldType.BYTE;
                break;
        }

        return fieldtyperetval;
    }
    // #endregion

}
