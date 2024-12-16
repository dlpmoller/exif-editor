package com.moller;

import java.io.File;
import java.net.MalformedURLException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Views {
    public static GridPane EditorPage(Stage stage) {
        GridPane gpretval = new GridPane();
        // This could be done in a seperate method.
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.ALWAYS);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHgrow(Priority.ALWAYS);
        gpretval.getColumnConstraints().addAll(col1, col2, col3, col4);
        gpretval.setHgap(5);
        gpretval.setVgap(5);
        gpretval.setPadding(new Insets(10));
        gpretval.setGridLinesVisible(true);

        /// Add:
        /// First argument is Column placement
        /// Second argument is Row placement
        /// Third argument is Column span
        /// Fourth argument is Row span
        ScrollPane metadataDisplay = new ScrollPane();

        TextField searchField = new TextField();
        gpretval.add(searchField, 0, 0, 2, 1);
        Button searchButton = new Button("Search Tag");
        gpretval.add(searchButton, 2, 0);
        // TODO: Create search functionality

        FlowPane contentPane = new FlowPane();
        metadataDisplay.setContent(contentPane);
        metadataDisplay.setMinHeight(400);
        gpretval.add(metadataDisplay, 0, 1, 3, 1);

        ImageView chosenImage = new ImageView();
        chosenImage.setFitWidth(300);
        chosenImage.setPreserveRatio(true);
        BorderPane border = new BorderPane();
        border.setCenter(chosenImage);
        gpretval.add(border, 3, 1);

        Label fileChoiceLabel = new Label("File:");
        gpretval.add(fileChoiceLabel, 0, 3);

        TextField fileChoiceField = new TextField();
        fileChoiceField.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                FileChooser fileChooser = new FileChooser();
                File selectedFile = fileChooser.showOpenDialog(stage);
                FileChooser.ExtensionFilter fileFilter = new FileChooser.ExtensionFilter("Image Files (*.jpg, *.png)",
                        "*.jpg",
                        "*.png");
                fileChooser.getExtensionFilters().add(fileFilter);
                if (selectedFile != null) {
                    fileChoiceField.setText(selectedFile.getAbsolutePath());
                }
            }
        });
        fileChoiceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldPath, String newPath) {
                File imgFile = new File(newPath);
                if (imgFile.exists()) {
                    try {
                        chosenImage.setImage(new Image(imgFile.toURI().toURL().toExternalForm()));
                        HelperClass.DisplayImageMetadata(contentPane, imgFile);
                    } catch (MalformedURLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    chosenImage.setImage(null);
                    contentPane.getChildren().clear();
                }
            }
        });
        gpretval.add(fileChoiceField, 1, 3, 2, 1);

        Label destinationLabel = new Label("Destination folder:");
        gpretval.add(destinationLabel, 0, 4);

        TextField destinationField = new TextField();
        destinationField.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                DirectoryChooser directoryChooser = new DirectoryChooser();

                File selectedDirectory = directoryChooser.showDialog(stage);
                destinationField.setText(selectedDirectory.getAbsolutePath());
            }
        });
        gpretval.add(destinationField, 1, 4, 2, 1);

        Button saveButton = new Button();
        saveButton.setText("Save Edits");
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // TODO: Create popup asking for confirmation to overwrite if there's a danger
                // of doing so.
                HelperClass.SaveMetadataEdits(contentPane, new File(fileChoiceField.getText()));
                fileChoiceField.setText("");
            }

        });
        gpretval.add(saveButton, 0, 5);

        return gpretval;
    }
}
