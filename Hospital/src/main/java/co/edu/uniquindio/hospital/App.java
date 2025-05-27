package co.edu.uniquindio.hospital;

import co.edu.uniquindio.hospital.model.Especialidad;
import co.edu.uniquindio.hospital.model.Hospital;
import co.edu.uniquindio.hospital.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import co.edu.uniquindio.hospital.controller.HospitalController;

/**
 * javaFX APP
 */

public class App extends Application {
    private Stage primaryStage;
    public static Hospital hospital = new Hospital("CENTRAL");
    public HospitalController hospitalController = new HospitalController(hospital);


    public static void main(String[] args) { launch(args); }

    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Hospital");
        inicializarData();

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

    public void openLoginPaciente(){

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("LoginPaciente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LoginPacienteViewController loginPacienteViewController = loader.getController();
            loginPacienteViewController.setApp(this);
            loginPacienteViewController.setHospitalController(hospitalController);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openPaciente(){

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Paciente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PacienteViewController pacienteViewController = loader.getController();
            pacienteViewController.setApp(this);
            pacienteViewController.setHospitalController(hospitalController);
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
            loginViewController.setHospitalController(hospitalController);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void openMedico(){


        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Medico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MedicoViewController medicoViewController = loader.getController();
            medicoViewController.setApp(this);
            medicoViewController.setHospitalController(hospitalController);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }





    //servicios
    public void inicializarData(){
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario("12", DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));
        hospital.crearCita("1",Especialidad.GENERAL,DayOfWeek.MONDAY,LocalTime.of(7,10));
    }


}
