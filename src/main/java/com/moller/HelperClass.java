package com.moller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.ImagingException;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputSet;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class HelperClass {

    // Testing
    public static void PrintMetadataInfo() {
        try {
            ImageMetadata metadata = Imaging.getMetadata(new File(
                    "C:\\source\\exif-editor\\src\\main\\resources\\com\\moller\\Images\\IMG_20241209_120112947_HDR.jpg"));

            if (metadata != null) {

                JpegImageMetadata jpegmetadata = (JpegImageMetadata) metadata;
                TiffImageMetadata tiffData = jpegmetadata.getExif();

                List<TiffField> tiffList = tiffData.getAllFields();

                for (TiffField tiffThing : tiffList) {
                    System.out.println(tiffThing.getTagName());
                    System.out.println(tiffThing.getValue());
                }

                // List itemList = metadata.getItems();

                // for (Object metadataObject : itemList) {
                // if (metadataObject.getClass() == TiffMetadataItem.class) {
                // TiffMetadataItem currentItem = (TiffMetadataItem) metadataObject;
                // System.out.println(currentItem.getKeyword());
                // System.out.println(currentItem.getText());
                // }

                // if (metadataObject.getClass() == GenericImageMetadataItem.class) {
                // GenericImageMetadataItem currentItem = (GenericImageMetadataItem)
                // metadataObject;
                // System.out.println(currentItem.getKeyword());
                // System.out.println(currentItem.getText());
                // }

                // }

                System.out.println(metadata);
            }

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static FlowPane DisplayImageMetadata(FlowPane contentPane, File imgFile) {

        String fileType = imgFile.getAbsolutePath().split("\\.")[1].toLowerCase();

        switch (fileType) {
            case "jpg":
            case "jpeg":
                // TODO: Create all the fields possible for an image.
                JpegImageMetadata jpegMetadata = GetMetadataFromImage(imgFile);
                if (jpegMetadata != null) {
                    TiffImageMetadata exifData = jpegMetadata.getExif();

                    for (TiffField metadataField : exifData.getAllFields()) {
                        GridPane item = new GridPane();
                        item.setPadding(new Insets(10, 10, 10, 10));
                        Label fieldName = new Label();
                        if (metadataField.getTagName().contains("Unknown Tag")) {
                            fieldName.setText(
                                    IdentifyEXIFTag(metadataField.getTagName()));
                        } else {
                            fieldName.setText(metadataField.getTagName());
                        }
                        item.add(fieldName, 0, 0);
                        TextField value = new TextField();
                        item.add(value, 0, 1);
                        value.setText(metadataField.getValueDescription());

                        contentPane.getChildren().add(item);
                    }
                }
                break;

            default:
                break;
        }

        return contentPane;
    }

    // This will require maintenance I suppose
    private static String IdentifyEXIFTag(String tagName) {
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

    public static void SaveMetadataEdits(FlowPane contentPane, File imgFile) {
        // TODO: Getting the metadata can be made into it's own thing.
        TiffImageMetadata exifData = null;
        TiffOutputSet metadataChanges;
        JpegImageMetadata jpegImageMetadata = GetMetadataFromImage(imgFile);

        if (jpegImageMetadata != null) {
            exifData = jpegImageMetadata.getExif();
        }

        if (exifData != null) {
            try {
                metadataChanges = exifData.getOutputSet();
            } catch (ImagingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            metadataChanges = new TiffOutputSet();
        }

        for (Node node : contentPane.getChildren()) {
            GridPane metadataField = (GridPane) node;
            // Refer to DisplayImageMetadata method for the order and element types of the
            // contents. But essentially:
            // Contentpane is a collection of GridPanes
            // GridPane is a group consisting of
            // One Label and one TextField, in that order.
            Label tagField = (Label) metadataField.getChildren().get(0);
            TextField valueField = (TextField) metadataField.getChildren().get(1);
            // Test to see if value extraction works like that.
            System.out.println(tagField.getText() + ": " + valueField.getText());
        }
    }

    // TODO: Handle more metadata directories than just Jpeg ones.
    public static JpegImageMetadata GetMetadataFromImage(File file) {
        JpegImageMetadata jimretval = null;

        try {
            jimretval = (JpegImageMetadata) Imaging.getMetadata(file);
        } catch (ImagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jimretval;
    }

}
