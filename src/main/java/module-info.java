module org.example.exercicefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.exercicefx to javafx.fxml;
    exports org.example.exercicefx;
}