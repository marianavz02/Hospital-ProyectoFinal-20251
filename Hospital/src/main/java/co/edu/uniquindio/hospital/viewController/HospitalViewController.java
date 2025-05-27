package co.edu.uniquindio.hospital.viewController;

import co.edu.uniquindio.hospital.App;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.hospital.controller.HospitalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class HospitalViewController {
    App app;
    HospitalController hospitalController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnTrabajador;


    @FXML
    private Button btnUsuario;

    @FXML
    void click(ActionEvent event) {
        Object clicked = event.getSource();
        if (clicked == btnAdmin) {
            app.openLoginAdmin();

        }
        if (clicked == btnTrabajador) {
            app.openLoginMedico();
        }
        if (clicked == btnUsuario) {
            app.openLoginPaciente();
        }

    }



    @FXML
    void initialize() {
        assert btnAdmin != null : "fx:id=\"btnAdmin\" was not injected: check your FXML file 'Hospital.fxml'.";
        assert btnTrabajador != null : "fx:id=\"btnTrabajador\" was not injected: check your FXML file 'Hospital.fxml'.";
        assert btnUsuario != null : "fx:id=\"btnUsuario\" was not injected: check your FXML file 'Hospital.fxml'.";

    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setHospitalController(HospitalController hospitalController) {
        this.hospitalController = hospitalController;
    }

}

