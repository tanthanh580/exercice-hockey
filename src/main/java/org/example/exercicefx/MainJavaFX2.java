package org.example.exercicefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class MainJavaFX2 extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        HBox root = new HBox();
        Scene scene = new Scene(root, 640, 320);

        Text titre = new Text("Compteur de mots");

        root.getChildren().add(titre);

        stage.setTitle("Compteur de scores");
        stage.setScene(scene);
        stage.show();

    }
}
