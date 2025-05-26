package co.edu.uniquindio.hospital;

import co.edu.uniquindio.hospital.controller.LoginController;
import co.edu.uniquindio.hospital.model.Especialidad;
import co.edu.uniquindio.hospital.model.Hospital;
import co.edu.uniquindio.hospital.viewController.LoginViewController;
import co.edu.uniquindio.hospital.viewController.HospitalViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

/**
 * javaFX APP
 */

public class App extends Application {
    private Stage primaryStage;
    public static Hospital hospital = new Hospital("CENTRAL");

    public static void main(String[] args) { launch(args); }

    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Hospital");
        openHospital();
    }

    public void openHospital() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Hospital.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HospitalViewController hospitalViewController = loader.getController();
            hospitalViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }






    public void openLoginMedico(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Login.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LoginViewController loginViewController = loader.getController();
            loginViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
