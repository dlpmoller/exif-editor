package com.moller;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Babby's First EXIF Editor");

        // Sets the first page to the EditorPage in the Views class.
        // By the way, don't make a Views class if you have multiple Views to make.
        // The better way is to make each View its own class and having a Views folder.
        scene = new Scene(Views.EditorPage(stage), 800, 600);
        stage.setScene(scene);

        stage.show();
    }

    // These are here in case I suddenly start working with FXML.
    // static void setRoot(String fxml) throws IOException {
    // scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +
    // ".fxml"));
    // return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

}
