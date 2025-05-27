package co.edu.uniquindio.hospital.viewController;

import co.edu.uniquindio.hospital.App;
import co.edu.uniquindio.hospital.controller.HospitalController;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PacienteViewController {
    App app;
    HospitalController hospitalController;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarDatos;

    @FXML
    private Button btnCancelarCita;

    @FXML
    private Button btnCerrarCesion;

    @FXML
    private Button btnHistoriaMedica;

    @FXML
    private Button btnProximasCitas;

    @FXML
    private Button btnSolicitarCita;

    @FXML
    private ChoiceBox<?> choiceEspecialidad;

    @FXML
    private TextField txtCancelarCita;

    @FXML
    private TextField txtCedulaActualizar;

    @FXML
    private TextField txtCedulaConsultas;

    @FXML
    private TextField txtCedulaSolicitarCita;

    @FXML
    private TextField txtCorreoActualizar;

    @FXML
    private TextField txtDiaSolicitarCita;

    @FXML
    private TextField txtDireccionActualizar;

    @FXML
    private DatePicker txtFechaNacimientoActualizar;

    @FXML
    private TextField txtHoraSolicitarCita;

    @FXML
    private TextField txtMinSolicitarCita;

    @FXML
    private TextField txtNombreActualizar;

    @FXML
    private TextField txtTelefonoActualizar;

    @FXML
    void click(ActionEvent event) {
        Object eve =event.getSource();
        if(eve == btnCerrarCesion){
            app.openHospital();
        }

    }

    @FXML
    void initialize() {
        assert btnActualizarDatos != null : "fx:id=\"btnActualizarDatos\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnCancelarCita != null : "fx:id=\"btnCancelarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnCerrarCesion != null : "fx:id=\"btnCerrarCesion\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnHistoriaMedica != null : "fx:id=\"btnHistoriaMedica\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnProximasCitas != null : "fx:id=\"btnProximasCitas\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnSolicitarCita != null : "fx:id=\"btnSolicitarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert choiceEspecialidad != null : "fx:id=\"choiceEspecialidad\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCancelarCita != null : "fx:id=\"txtCancelarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCedulaActualizar != null : "fx:id=\"txtCedulaActualizar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCedulaConsultas != null : "fx:id=\"txtCedulaConsultas\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCedulaSolicitarCita != null : "fx:id=\"txtCedulaSolicitarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCorreoActualizar != null : "fx:id=\"txtCorreoActualizar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtDiaSolicitarCita != null : "fx:id=\"txtDiaSolicitarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtDireccionActualizar != null : "fx:id=\"txtDireccionActualizar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtFechaNacimientoActualizar != null : "fx:id=\"txtFechaNacimientoActualizar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtHoraSolicitarCita != null : "fx:id=\"txtHoraSolicitarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtMinSolicitarCita != null : "fx:id=\"txtMinSolicitarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtNombreActualizar != null : "fx:id=\"txtNombreActualizar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtTelefonoActualizar != null : "fx:id=\"txtTelefonoActualizar\" was not injected: check your FXML file 'Paciente.fxml'.";

    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setHospitalController(HospitalController hospitalController) {
        this.hospitalController = hospitalController;
    }

}
