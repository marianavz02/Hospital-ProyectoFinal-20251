package co.edu.uniquindio.hospital.viewController;

import co.edu.uniquindio.hospital.App;
import co.edu.uniquindio.hospital.controller.HospitalController;


import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import co.edu.uniquindio.hospital.model.Especialidad;
import co.edu.uniquindio.hospital.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;

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
    private ChoiceBox<Especialidad> choiceEspecialidad;

    @FXML
    private ChoiceBox<DayOfWeek> choiceDiaSolicitarCita;

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

        if (eve == btnCancelarCita) {
            if(!txtCancelarCita.getText().isEmpty()){
                int autorizacion = Integer.parseInt(txtCancelarCita.getText());
                hospitalController.cancelarCita(autorizacion);
            }

        }

        if (eve == btnHistoriaMedica){
            if (!txtCedulaConsultas.getText().isEmpty()){
                String idPaciente = txtCedulaConsultas.getText();
                Paciente paciente = hospitalController.buscarPaciente(idPaciente);
                JOptionPane.showMessageDialog(null, "Paciente:"+paciente.getListHistoria());


            }
        }

        if(eve == btnProximasCitas){
            if(!txtCedulaConsultas.getText().isEmpty()){
                String idPaciente = txtCedulaConsultas.getText();
                String mostrar = hospitalController.mostrarCitasPorPaciente(idPaciente);
                JOptionPane.showMessageDialog(null, "Paciente:"+mostrar);
            }
        }



        if(eve == btnSolicitarCita){
            if(!txtCedulaSolicitarCita.getText().isEmpty() && !txtHoraSolicitarCita.getText().isEmpty() && !txtMinSolicitarCita.getText().isEmpty()){

                String idPaciente = txtCedulaSolicitarCita.getText();
                int hora = Integer.parseInt(txtHoraSolicitarCita.getText());
                int min = Integer.parseInt(txtMinSolicitarCita.getText());
                DayOfWeek dia = choiceDiaSolicitarCita.getValue();
                Especialidad especialidad = choiceEspecialidad.getValue();
                Boolean resultado = hospitalController.crearCita(idPaciente,especialidad,dia, LocalTime.of(hora, min));
                if(resultado == true){
                    JOptionPane.showMessageDialog(null, "Cita creada con exito");
                }else{JOptionPane.showMessageDialog(null, "No se pudo crear la cita");}
            }

        }

        //String id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento
        if(eve == btnActualizarDatos){
            if(!txtCedulaActualizar.getText().isEmpty() && !txtNombreActualizar.getText().isEmpty()
                    && !txtTelefonoActualizar.getText().isEmpty() && !txtCorreoActualizar.getText().isEmpty()
                    && !txtDireccionActualizar.getText().isEmpty()){
                String idPaciente = txtCedulaActualizar.getText();
                String nombre = txtNombreActualizar.getText();
                String telefono = txtTelefonoActualizar.getText();
                String correo = txtCorreoActualizar.getText();
                String direccion = txtDireccionActualizar.getText();
                LocalDate fechaNacimiento = txtFechaNacimientoActualizar.getValue();

                boolean resultado = hospitalController.actualizarPaciente(idPaciente,nombre,telefono,correo,direccion,fechaNacimiento);
                if(resultado == true){
                    JOptionPane.showMessageDialog(null, "Paciente actualizado con exito");
                }else{JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos");}
            }

        }



    }

    @FXML
    void initialize() {
        choiceEspecialidad.getItems().addAll(Especialidad.values());
        choiceDiaSolicitarCita.getItems().addAll(DayOfWeek.values());
        assert btnActualizarDatos != null : "fx:id=\"btnActualizarDatos\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnCancelarCita != null : "fx:id=\"btnCancelarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnCerrarCesion != null : "fx:id=\"btnCerrarCesion\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnHistoriaMedica != null : "fx:id=\"btnHistoriaMedica\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnProximasCitas != null : "fx:id=\"btnProximasCitas\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert btnSolicitarCita != null : "fx:id=\"btnSolicitarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert choiceEspecialidad != null : "fx:id=\"choiceEspecialidad\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert choiceDiaSolicitarCita != null : "fx:id=\"choiceDiaSolicitarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCancelarCita != null : "fx:id=\"txtCancelarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCedulaActualizar != null : "fx:id=\"txtCedulaActualizar\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCedulaConsultas != null : "fx:id=\"txtCedulaConsultas\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCedulaSolicitarCita != null : "fx:id=\"txtCedulaSolicitarCita\" was not injected: check your FXML file 'Paciente.fxml'.";
        assert txtCorreoActualizar != null : "fx:id=\"txtCorreoActualizar\" was not injected: check your FXML file 'Paciente.fxml'.";
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
