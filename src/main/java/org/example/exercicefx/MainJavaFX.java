package org.example.exercicefx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainJavaFX extends Application {

    private static final String[] NOMS_EQUIPE = {"Canadiens", "Lightnings", "Bruins", "Maple Leafs"};
    private Text[] nomsEquipes;
    private Text[] scoresText;
    private int[] scores;

    @Override
    public void start(Stage stage) {
        HBox root = new HBox();
        Scene scene = new Scene(root, 600, 200);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);


        int n = NOMS_EQUIPE.length;
        nomsEquipes = new Text[n];
        scoresText = new Text[n];
        scores = new int[n];

        for (int i = 0; i < n; i++) {
            VBox col = new VBox();
            col.setAlignment(Pos.CENTER);
            col.setSpacing(10);


            nomsEquipes[i] = new Text(NOMS_EQUIPE[i]);
            nomsEquipes[i].setFont(Font.font(18));

            scores[i] = 0;
            scoresText[i] = new Text("Score : " + scores[i]);


            Button bouton = new Button("Compter un point!");
            int index = i; // nécessaire pour la lambda
            bouton.setOnAction(e -> {
                scores[index]++;
                scoresText[index].setText("Score : " + scores[index]);
                surlignerGagnant();
            });

            col.getChildren().addAll(nomsEquipes[i], scoresText[i], bouton);


            root.getChildren().add(col);


            if (i < n - 1) {
                Separator sep = new Separator(Orientation.VERTICAL);
                root.getChildren().add(sep);
            }
        }

        stage.setTitle("Compteur de scores - N équipes");
        stage.setScene(scene);
        stage.show();
    }

    private void surlignerGagnant() {

        for (Text nom : nomsEquipes) {
            nom.setFill(Color.BLACK);
        }


        int max = 0;
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max && max > 0) {
                nomsEquipes[i].setFill(Color.GREEN);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }


}