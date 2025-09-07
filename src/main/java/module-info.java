module org.example.exercicefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.exercicefx to javafx.fxml;
    exports org.example.exercicefx;
}