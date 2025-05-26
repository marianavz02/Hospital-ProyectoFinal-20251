module co.edu.uniquindio.hospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires java.logging;
    requires java.desktop;
    requires org.testng;


    opens co.edu.uniquindio.hospital to javafx.fxml;
    exports co.edu.uniquindio.hospital;

    opens co.edu.uniquindio.hospital.viewController to javafx.fxml;
    exports co.edu.uniquindio.hospital.viewController;


    opens co.edu.uniquindio.hospital.controller to javafx.fxml;
    exports co.edu.uniquindio.hospital.controller;

    opens co.edu.uniquindio.hospital.model to javafx.fxml;
    exports co.edu.uniquindio.hospital.model;
}