package com.moller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import com.moller.Models.ComboItem;
import com.moller.Models.MetadataCharts;
import com.moller.ViewModifications.ComboItemListCell;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ViewHelper {
    /**
     * Iterates through the metadata directories to add all relevant data to the
     * associated tags.
     *
     * @param contentPane The FlowPane to populate.
     * @param imgFile     The image to read metadata from.
     * @return Returns the provided FlowPane with data fields.
     */
    public static FlowPane DisplayImageMetadata(FlowPane contentPane, File imgFile) {
        HashMap<String, HashMap<Integer, String>> metadataDirectories = new HashMap<>();
        Boolean bretval = HelperClass.GetDirectories(metadataDirectories, imgFile);

        // Nested for loops due to nested hashmaps. Bad idea?
        // The bad idea is because it starts from the hashmap that was added most
        // recently.
        for (var directory : metadataDirectories.entrySet()) {
            GridPane directoryLabel = new GridPane();
            directoryLabel.setPadding(new Insets(10, 10, 10, 10));
            directoryLabel.setMinWidth(contentPane.getWidth());
            directoryLabel.add(new Label(directory.getKey()), 0, 0);
            contentPane.getChildren().add(directoryLabel);
            for (var metadataEntry : directory.getValue().entrySet()) {
                contentPane.getChildren().add(
                        ViewHelper.AddMetadataField(
                                metadataEntry.getKey(),
                                metadataEntry.getValue(),
                                directory.getKey()));
            }
        }
        return contentPane;
    }

    /**
     * Adds a single metadata tag in a {@code GridPane} element. Contains a
     * {@code Label} element and a {@code TextField} element.
     *
     * @param tagName   The name of the metadata tag.
     * @param value     The associated value of the metadata tag, if any.
     * @param directory The directory the tag is from.
     * @return Returns a {@code GridPane} element for the {@code FlowPane} element.
     * @see ViewHelper#DisplayImageMetadata(FlowPane, File)
     */
    public static GridPane AddMetadataField(Integer tag, String value, String directory) {
        GridPane gpretval = new GridPane();
        gpretval.setPadding(new Insets(10, 10, 10, 10));
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setHgrow(Priority.ALWAYS);
        gpretval.getColumnConstraints().add(col0);
        Label fieldName = new Label();
        fieldName.setTooltip(new Tooltip(tag.toString()));
        // Pulling on the tagset to find the name for the hex ID.
        fieldName.setText(HelperClass.IdentifyEXIFTag(tag, directory));
        gpretval.add(fieldName, 0, 0);
        Node valueField = createValueField(tag, value, directory);
        gpretval.add(valueField, 0, 1);
        return gpretval;
    }

    /**
     * This method checks whether to make a {@code ComboBox} or a {@code TextField}
     * depending on if there's a populated hashmap associated with the tag.
     *
     * @param tag
     * @param value     Text
     * @param directory The directory the tag is from.
     * @return
     * @see {@link https://stackoverflow.com/a/43586473}
     */
    private static Node createValueField(Integer tag, String value, String directory) {
        ArrayList<ComboItem> optionList = new ArrayList<>();

        // TODO: Find a better way of doing that.
        switch (directory) {
            case "EXIF Data":
                optionList = MetadataCharts.rootOptionSelectionMap(tag);
                break;
            case "GPS Data":
                optionList = MetadataCharts.gpsOptionSelectionMap(tag);
                break;

            default:
                break;
        }

        if (optionList.size() > 0) {
            ComboBox<ComboItem> comboList = new ComboBox<>();
            comboList.getItems().addAll(optionList);
            for (ComboItem comboItem : optionList) {
                if (value == comboItem.GetValue()) {
                    comboList.setValue(comboItem);
                }
            }
            comboList.setCellFactory(lv -> new ComboItemListCell());
            comboList.setButtonCell(new ComboItemListCell());

            return comboList;
        } else {
            TextField valueField = new TextField();
            valueField.setText(value);
            return valueField;
        }
    }

    /**
     * Removes tag fields from the user's view if they are not within the specified
     * search scope. Or they should be.
     *
     * @param contentPane The tags to iterate through
     * @param searchTerm  The search scope to filter for
     * @see ViewHelper#AddMetadataField(String, String)
     */
    public static void FilterShownTags(FlowPane contentPane, String searchTerm) {
        if (!searchTerm.isEmpty() || !searchTerm.isBlank()) {
            for (Node dataField : contentPane.getChildren()) {
                GridPane tagField = (GridPane) dataField;
                if (tagField.getChildren().size() > 1) {
                    Label tag = (Label) tagField.getChildren().get(0);
                    if (!tag.getText().toLowerCase().contains(searchTerm.toLowerCase())) {
                        dataField.setDisable(true);
                        // tagField.setVisible(false);
                        // tagField.setMaxWidth(0);
                    } else {
                        dataField.setDisable(false);
                        // tagField.setVisible(true);
                    }
                }
            }
        } else {
            for (Node dataField : contentPane.getChildren()) {
                GridPane tagField = (GridPane) dataField;
                tagField.setDisable(false);
            }
        }
    }

    public static Boolean prepForMetadataSaving(String destination, String imgFile) {
        Boolean bretval = true;

        if (destination.isBlank() || destination.isEmpty()) {
            return false;
        }

        String imagePathSections[] = imgFile.split(File.pathSeparator);
        String completeDestination = destination + File.pathSeparator + imagePathSections[imagePathSections.length - 1];

        if (imgFile.toLowerCase(Locale.getDefault()).equals(completeDestination.toLowerCase(Locale.getDefault()))) {
            bretval = false;
        }

        return bretval;
    }

    public static void saveMetadata(FlowPane contentPane, File imgFile) {
        HashMap<String, HashMap<Integer, String>> valuesToSave = new HashMap<>();
        Boolean successfulExtraction = extractValues(valuesToSave, contentPane);

        if (successfulExtraction) {
            HelperClass.SaveMetadataEdits(valuesToSave, imgFile);
        }
    }

    private static Boolean extractValues(HashMap<String, HashMap<Integer, String>> valuesToSave, FlowPane contentPane) {
        Boolean bretval = false;
        String currentDirectory = "";
        for (Node node : contentPane.getChildren()) {
            GridPane metadataField = (GridPane) node;

            if (metadataField.getChildren().size() == 1) {
                currentDirectory = extractValueFromNode(metadataField.getChildren())[0];
                valuesToSave.put(currentDirectory, new HashMap<>());
            } else {
                String[] extractedValues = extractValueFromNode(metadataField.getChildren());
                valuesToSave.get(currentDirectory).put(Integer.parseInt(extractedValues[0]), extractedValues[1]);
            }
        }
        return bretval;
    }

    /**
     * Extracts values from TextFields or ComboBoxes.
     * The first index can either be a directory name or the tag ID corresponding to
     * the value.
     *
     * @param observableList The Node to extract data from.
     * @return The String values from the node.
     */
    private static String[] extractValueFromNode(ObservableList<Node> observableList) {
        String[] saretval = { "", "" };
        Label valueLabel = (Label) observableList.get(0);

        if (observableList.size() == 1) {
            saretval[0] = valueLabel.getText();
            return saretval;
        }

        // Grab the associated ID
        saretval[0] = valueLabel.getTooltip().getText();

        // It's either TextFields or ComboBoxes, so using a try-catch as an either-or
        // works fine. I think.
        try {
            TextField valueField = (TextField) observableList.get(1);
            saretval[1] = valueField.getText();
        } catch (ClassCastException e) {
            // If it's not a TextField, it's a ComboBox.
            ComboBox<ComboItem> valueCombo = (ComboBox) observableList.get(1);
            saretval[1] = valueCombo.getValue().GetValue();
        }

        return saretval;
    }

}
