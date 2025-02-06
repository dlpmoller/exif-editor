package com.moller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.ImagingException;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegPhotoshopMetadata;
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
import org.apache.commons.imaging.formats.tiff.write.TiffOutputDirectory;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputSet;

import com.moller.Models.MetadataCharts;
import com.moller.Models.MetadataObject;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class HelperClass {

    /**
     *
     * @param tag
     * @param directory
     * @return
     * @see HelperClass#GetDirectories(HashMap, File)
     * @see MetadataCharts
     */
    public static String IdentifyEXIFTag(Integer tag, String directory) {
        String sretval = "Unknown Tag (" + tag.toString() + ")";
        MetadataObject[] tagSet = null;

        // TODO: Find way to make this less obtuse to debug! Add .ToLower or something?
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
     * @param contentPane The metadata from the GUI.
     * @param imgFile     The image file to save the metadata to.
     * @see ViewHelper#DisplayImageMetadata(FlowPane, File)
     * @see ViewHelper#AddMetadataField(String, String)
     */
    public static void SaveMetadataEdits(FlowPane contentPane, File imgFile) {
        // TODO: Getting the metadata can be made into it's own thing.
        TiffImageMetadata exifData = null;
        TiffOutputSet metadataChanges;
        TiffOutputDirectory exifDirectory;
        TiffOutputDirectory gpsDirectory;
        TiffOutputDirectory rootDirectory;
        Double latitude = null;
        Double longitude = null;
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

            exifDirectory = metadataChanges.getOrCreateExifDirectory();
            gpsDirectory = metadataChanges.getOrCreateGpsDirectory();

        } catch (ImagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO: Directory name dictates OutputSet
        for (Node node : contentPane.getChildren()) {
            GridPane metadataField = (GridPane) node;
            // Refer to DisplayImageMetadata method for the order and element types of the
            // contents.
            if (metadataField.getChildren().size() == 1) {
                // TODO: Create method to initialize and iterate through directories. Likely
                // with Hashmaps again.
            }
            // TODO: Add this part to ViewHelper
            Label tagField = (Label) metadataField.getChildren().get(0);
            TextField valueField = (TextField) metadataField.getChildren().get(1);
            // Test to see if value extraction works like that.
            System.out.println(tagField.getText() + ": " + valueField.getText());
        }
    }

    /**
     * Removes field from the output set and adds the new value if applicable.
     *
     * @param outputDir The output set to remove and add fields to/from.
     * @param tagList   The list of tags to compare the tag ID to.
     * @param tag       The tag ID to save the value to.
     * @param value     The value from the {@code TextField} input.
     * @return Returns the provided output set with the specified field removed or
     *         updated.
     */
    public static Boolean handleOutputField(TiffOutputDirectory outputDir, MetadataObject[] tagList,
            int tag,
            String value) {
        Boolean bretval = false;
        outputDir.removeField(tag);
        bretval = true;
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
     *
     * @param outputDir
     * @param tag
     * @param value
     * @return
     */
    private static Boolean addFieldToOutput(TiffOutputDirectory outputDir, MetadataObject tag, String value) {
        Boolean bretval = false;
        try {
            switch (tag.GetValueType()) {
                case "String":
                    outputDir.add(
                            new TagInfoAscii(
                                    tag.GetMetadataTag(), tag.GetMetadataId(), tag.GetValueLength(),
                                    TiffDirectoryType.TIFF_DIRECTORY_ROOT));
                    bretval = true;
                    break;

                default:
                    break;
            }
        } catch (ImagingException imgEx) {
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
     * @return Uhhhh
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
                if (jpgMetaData != null) {
                    // Fetch specific directories. May be null.
                    TiffImageMetadata exifMetadata = jpgMetaData.getExif();
                    JpegPhotoshopMetadata iptcMetadata = jpgMetaData.getPhotoshop();

                    HashMap<Integer, String> exifDirectory = new HashMap<>();
                    HashMap<Integer, String> gpsHashMap = new HashMap<>();

                    Boolean generatedGPSDirectory = getGPSInfo(exifMetadata, gpsHashMap);
                    Boolean generatedRootDirectory = getExifInfo(exifMetadata, exifDirectory);

                    metadataDirectories.put("EXIF Data", exifDirectory);
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
     * @param exifMetadata  The image metadata to read from.
     * @param exifDirectory The hashmap to add extracted data into.
     * @return Whether the data pull completed successfully or not.
     */
    private static Boolean getExifInfo(TiffImageMetadata exifMetadata, HashMap<Integer, String> exifDirectory) {
        Boolean bretval = false;
        MetadataObject[] exifTags = MetadataCharts.GetExifDirectory();

        try {
            for (MetadataObject tag : exifTags) {
                String metadataValue = "";
                TiffField exifField = exifMetadata.findField(createField(tag, "Root"));

                if (exifField != null) {
                    metadataValue = exifField.getValue().toString();
                }

                exifDirectory.put(tag.GetMetadataId(), metadataValue);
            }

        } catch (ImagingException imgEx) {
            imgEx.printStackTrace();
            bretval = false;
        }

        return bretval;
    }

    /**
     * Extracts the GPS directory metadata from the EXIF data.
     *
     * @param exifMetadata the image metadata to read data from.
     * @param directoryMap The hashmap to insert data into.
     * @return Whether the data pull completed successfully or not.
     */
    private static Boolean getGPSInfo(TiffImageMetadata exifMetadata, HashMap<Integer, String> directoryMap) {
        Boolean bretval = false;
        MetadataObject[] gpsTags = MetadataCharts.GetGPSDirectory();
        TiffDirectory gpsDir = exifMetadata.findDirectory(TiffDirectoryConstants.DIRECTORY_TYPE_GPS);

        try {
            // Pull GPSInfo. May be null.
            GpsInfo gpsData = exifMetadata.getGpsInfo();

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

        } catch (ImagingException imgEx) {
            // TODO Auto-generated catch block
            imgEx.printStackTrace();
            bretval = false;
        }

        return bretval;
    }

    // #region TiffField creation
    /**
     * Returns a {@code TagInfo} bound for the GPS directory.
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

    private static TiffDirectoryType getDirectoryType(String directory) {
        TiffDirectoryType dirretval = TiffDirectoryType.EXIF_DIRECTORY_UNKNOWN;

        switch (directory) {
            case "Root":
                dirretval = TiffDirectoryType.TIFF_DIRECTORY_ROOT;
                break;
            case "GPS":
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
     *
     * @param valueType
     * @return
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
