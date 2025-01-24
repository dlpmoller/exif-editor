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
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata.GpsInfo;
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
    // This will require maintenance I suppose
    // Speaking of:
    // TAGS TO IMPLEMENT:
    // (0xa003)
    // (0xa002)
    public static String IdentifyEXIFTag(String tagName) {
        String sretval = "";
        String hexValue = tagName.split("Tag ")[1];

        // Source: https://exiftool.org/TagNames/EXIF.html
        switch (hexValue) {
            case "(0x8830)":
                sretval = "SensitivityType";
                break;
            case "(0x8832)":
                sretval = "RecommendedExposureIndex";
                break;
            case "(0x9010)":
                sretval = "OffsetTime";
                break;
            case "(0x9011)":
                sretval = "OffsetTimeOriginal";
                break;
            case "(0x9012)":
                sretval = "OffsetTimeDigitized";
                break;
            case "(0xa460)":
                sretval = "CompositeImage";
                break;
            default:
                sretval = tagName;
                break;
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
            // TODO: Find better way to implement tag selection
            switch (tagField.getText()) {
                case "LatitudeNorth":
                    latitude = Double.valueOf(valueField.getText());
                case "LongitudeEast":
                    longitude = Double.valueOf(valueField.getText());
                    break;

                default:
                    break;
            }
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
    public static TiffOutputDirectory handleOutputField(TiffOutputDirectory outputDir, MetadataObject[] tagList,
            int tag,
            String value) {
        outputDir.removeField(tag);
        if (!value.isBlank() || !value.isEmpty()) {
            for (MetadataObject metadataTag : tagList) {
                if (metadataTag.getMetadataId() == tag) {
                    if (metadataTag.getValueType() != null) {
                        addFieldToOutput(outputDir, metadataTag.getValueType(), value);
                    } else {
                        System.out.print(
                                "Write action for tag " + metadataTag.getMetadataTag() + " has not been created.");
                    }
                }
            }
        }
        return outputDir;
    }

    /**
     * Identifies the tag object and converts the value accordingly before adding it
     * to the output set
     *
     * @param outputDir The outputset to add to
     * @param writeTag  The tag to add
     * @param value
     */
    private static void addFieldToOutput(TiffOutputDirectory outputDir, Object writeTag, String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFieldToOutput'");
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

    public static HashMap<String, HashMap<String, String>> GetDirectories(
            HashMap<String, HashMap<String, String>> metadataDirectories, File imgFile) {

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
                    if (exifMetadata != null) {

                        HashMap<String, String> exifDirectory = new HashMap<>();
                        MetadataObject[] listofobjects = MetadataCharts.GetExifDirectory();

                        for (MetadataObject metadataObject : listofobjects) {
                            System.out.println(metadataObject.getMetadataId());
                        }
                        for (TiffField exifField : exifMetadata.getAllFields()) {
                            // System.out.println(exifField.getTag());
                            if (exifField.getTagName().contains("GPSInfo")) {
                                HashMap<String, String> gpsHashMap = GetGPSInfo(exifMetadata);

                                if (gpsHashMap.size() > 0) {
                                    metadataDirectories.put("GPS Info", gpsHashMap);
                                }

                            } else {
                                exifDirectory.put(exifField.getTagName(), exifField.getValueDescription());
                            }
                        }

                        metadataDirectories.put("EXIF Data", exifDirectory);
                    }

                    if (iptcMetadata != null) {
                        HashMap<String, String> iptcDirectory = GetIPTCInfo(jpgMetaData.getPhotoshop());
                        metadataDirectories.put("IPTC Data", iptcDirectory);
                    }
                }
                break;

            default:
                break;
        }
        return metadataDirectories;
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

    private static HashMap<String, String> GetGPSInfo(TiffImageMetadata exifMetadata) {
        HashMap<String, String> hmretval = new HashMap<>();

        try {
            // Pull GPSInfo. May be null.
            GpsInfo gpsData = exifMetadata.getGpsInfo();
            if (gpsData != null) {

                hmretval.put("LatitudeRef", gpsData.latitudeRef);
                hmretval.put("LongitudeRef", gpsData.longitudeRef);
                hmretval.put("LatitudeNorth", Double.toString(gpsData.getLatitudeAsDegreesNorth()));
                hmretval.put("LatitudeMinutes", gpsData.latitudeMinutes.toDisplayString());
                hmretval.put("LatitudeSeconds", gpsData.latitudeSeconds.toDisplayString());
                hmretval.put("LongitudeEast", Double.toString(gpsData.getLongitudeAsDegreesEast()));
                hmretval.put("LongitudeMinutes", gpsData.longitudeMinutes.toDisplayString());
                hmretval.put("LongitudeSeconds", gpsData.longitudeSeconds.toDisplayString());
            }

        } catch (ImagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return hmretval;
    }

}
