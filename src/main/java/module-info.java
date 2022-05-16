module awholenewworld.awholenewworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.desktop;

    opens mallowstudios to javafx.fxml;
    exports mallowstudios;
}