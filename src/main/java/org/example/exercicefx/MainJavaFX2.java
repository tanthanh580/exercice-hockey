package org.example.exercicefx;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;


public class MainJavaFX2 extends Application {

    private TextArea texte;
    private Label label;
    private Random random = new Random();


    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        //titre
        Text titre = new Text("Compteur de mots");
        titre.setFont(Font.font(20));


        //scene
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Compteur de mots");
        stage.setScene(scene);

        //Text Area
        texte = new TextArea();
        texte.setEditable(true); //permet de changer
        texte.setWrapText(true); //empeche les longue phrase en une ligne

        //Detection changement
        texte.setOnKeyPressed(e -> {
            System.out.println("On a mdifie le texte!");
            System.out.println("Le texte est desormais ; " + texte.getText());

        });

        label = new Label("Nombre de mot : 0");
        texte.textProperty().addListener((observable, oldValue, newValue) -> {
            label.setText("Nombre de mots : " + compterMots(newValue));
        });

        Button button = new Button("Effacer un mots au harsard!");
        button.setOnAction(e -> {
            suprimerMots();

        });

        root.getChildren().addAll(titre, texte, label, button);
        stage.setScene(scene);
        stage.show();
    }

    private void suprimerMots() {
        String text = texte.getText();
        if (text.isEmpty()) {
            return;
        }

        String[] mots = text.split(" ");
        if (mots.length == 0) {
            return;
        }

        int index = random.nextInt(mots.length);

        StringBuilder nouveauTexte = new StringBuilder();
        for (int i = 0; i < mots.length; i++) {
            if (i != index) {
                nouveauTexte.append(mots[i]);
                if (i < mots.length - 1) {
                    nouveauTexte.append(" ");
                }

            }
        }
        texte.setText(nouveauTexte.toString());
        label.setText("Nombre de mots : " + compterMots(nouveauTexte.toString()));

    }



    private int compterMots(String texte) {
        if (texte == null || texte.isBlank()) return 0;
        String[] mots = texte.trim().split("\\s+"); // Découpe par espaces
        return mots.length;
    }

    public static void main(String[] args) {
        launch(args);
    }


}
