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

import java.io.IOException;

public class MainJavaFX extends Application {

    private Text nomEquipe1;
    private Text nomEquipe2;
    private int scoreCanadiens = 0;
    private int scoreLightnings = 0;

    @Override
    public void start(Stage stage) {
        HBox root = new HBox();
        Scene scene = new Scene(root, 350, 150);

        VBox col1 = new VBox();
        VBox col2 = new VBox();

        Separator sep = new Separator();

        sep.setOrientation(Orientation.VERTICAL);

        root.getChildren().addAll(col1, sep, col2);

        col1.setAlignment(Pos.CENTER_LEFT);
        col2.setAlignment(Pos.CENTER_RIGHT);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);

        nomEquipe1 = new Text("Canadiens");
        nomEquipe1.setFont(Font.font(18));
        Text score1 = new Text("Score : " + scoreCanadiens);
        Button compterPoint1 = new Button("Compter un point!");

        compterPoint1.setOnAction((event) -> {
            scoreCanadiens++;
            score1.setText("Score : " + scoreCanadiens);
            surlignerGagnant();
        });

        col1.getChildren().addAll(nomEquipe1, score1, compterPoint1);

        nomEquipe2 = new Text("Lightnings");
        nomEquipe2.setFont(Font.font(18));
        Text score2 = new Text("Score : " + scoreLightnings);
        Button compterPoint2 = new Button("Compter un point!");

        compterPoint2.setOnAction((event) -> {
            scoreLightnings++;
            score2.setText("Score : " + scoreLightnings);
            surlignerGagnant();
        });
        col2.getChildren().addAll(nomEquipe2, score2, compterPoint2);

        stage.setTitle("Compteur de scores");
        stage.setScene(scene);
        stage.show();
    }

    private void surlignerGagnant() {
        nomEquipe1.setFill(Color.BLACK);
        nomEquipe2.setFill(Color.BLACK);

        if(scoreCanadiens > scoreLightnings) {
            nomEquipe1.setFill(Color.GREEN);
        } else if(scoreLightnings > scoreCanadiens) {
            nomEquipe2.setFill(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        launch();
    }


}