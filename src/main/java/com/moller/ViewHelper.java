package com.moller;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ViewHelper {
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
