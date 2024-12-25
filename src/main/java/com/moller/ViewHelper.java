package com.moller;

import java.io.File;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class ViewHelper {
    public static FlowPane DisplayImageMetadata(FlowPane contentPane, File imgFile) {
        HashMap<String, HashMap<String, String>> metadataDirectories = new HashMap<>();

        metadataDirectories = HelperClass.GetDirectories(metadataDirectories, imgFile);

        if (metadataDirectories.isEmpty()) {
            Label emptyMetadata = new Label("This image does not contain any metadata.");
            contentPane.getChildren().add(emptyMetadata);
        } else {
            // Nested for loops due to nested hashmaps. Bad idea?
            for (var directory : metadataDirectories.entrySet()) {
                GridPane directoryLabel = new GridPane();
                directoryLabel.setPadding(new Insets(10, 10, 10, 10));
                directoryLabel.setMinWidth(contentPane.getWidth());
                directoryLabel.add(new Label(directory.getKey()), 0, 0);
                contentPane.getChildren().add(directoryLabel);
                for (var metadataEntry : directory.getValue().entrySet()) {
                    contentPane.getChildren().add(
                            ViewHelper.AddMetadataField(
                                    metadataEntry.getKey(), metadataEntry.getValue()));
                }
            }
        }

        return contentPane;
    }

    public static GridPane AddMetadataField(String tag, String value) {
        GridPane gpretval = new GridPane();
        gpretval.setPadding(new Insets(10, 10, 10, 10));
        Label fieldName = new Label();
        if (tag.contains("Unknown Tag")) {
            fieldName.setText(HelperClass.IdentifyEXIFTag(tag));
        } else {
            fieldName.setText(tag);
        }
        gpretval.add(fieldName, 0, 0);
        TextField valueField = new TextField();
        valueField.setText(value);
        gpretval.add(valueField, 0, 1);
        return gpretval;
    }

}
