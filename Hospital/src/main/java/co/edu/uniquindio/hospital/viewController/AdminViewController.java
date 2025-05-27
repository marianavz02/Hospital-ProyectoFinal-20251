package co.edu.uniquindio.hospital.viewController;

import co.edu.uniquindio.hospital.App;
import co.edu.uniquindio.hospital.controller.HospitalController;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import co.edu.uniquindio.hospital.model.Especialidad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;

public class AdminViewController {
    App app;
    HospitalController hospitalController;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarMedico;

    @FXML
    private Button btnActualizarPaciente;

    @FXML
    private Button btnCancelarCita;

    @FXML
    private Button btnCerrarCesion;

    @FXML
    private Button btnCrearMedico;

    @FXML
    private Button btnCrearPaciente;

    @FXML
    private Button btnEliminarMedico;

    @FXML
    private Button btnEliminarPaciente;

    @FXML
    private Button btnEliminarSala;

    @FXML
    private Button btnIngresarHorario;

    @FXML
    private Button btnMostrarHorario;

    @FXML
    private Button btnReporteIndividualAutorizacion;

    @FXML
    private Button btnReporteIndividualMedico;

    @FXML
    private Button btnReporteIndividualPaciente;

    @FXML
    private Button btnReporteTotalCitas;

    @FXML
    private Button btnReporteTotalMedicos;

    @FXML
    private Button btnReporteTotalPacientes;

    @FXML
    private Button btnReporteTotalSalas;

    @FXML
    private Button btnSalaActualizar;

    @FXML
    private Button btnSalaCrear;

    @FXML
    private Button btnSolicitarCita;

    @FXML
    private ChoiceBox<DayOfWeek> choiceDiaHorario;

    @FXML
    private ChoiceBox<DayOfWeek> choiceDiaSolicitarCita;

    @FXML
    private ChoiceBox<Especialidad> choiceEspecialidadActualizarMedico;

    @FXML
    private ChoiceBox<Especialidad> choiceEspecialidadCita;

    @FXML
    private ChoiceBox<Especialidad> choiceEspecialidadCrearMedico;

    @FXML
    private DatePicker fechaNacimientoActualizarMedico;

    @FXML
    private DatePicker fechaNacimientoActualizarPaciente;

    @FXML
    private DatePicker fechaNacimientoCrearMedico;

    @FXML
    private DatePicker fechaNacimientoCrearPaciente;

    @FXML
    private TextField lblAutorizacionReporte;

    @FXML
    private TextField lblCorreoActualizarMedico;

    @FXML
    private TextField lblCorreoActualizarPaciente;

    @FXML
    private TextField lblCorreoCrearMedico;

    @FXML
    private TextField lblCorreoCrearPaciente;

    @FXML
    private TextField lblDireccionActualizarMedico;

    @FXML
    private TextField lblDireccionActualizarPaciente;

    @FXML
    private TextField lblDireccionCrearMedico;

    @FXML
    private TextField lblDireccionCrearPaciente;

    @FXML
    private TextField lblIdActualizarHorario;

    @FXML
    private TextField lblIdActualizarMedico;

    @FXML
    private TextField lblIdActualizarPaciente;

    @FXML
    private TextField lblIdCrearMedico;

    @FXML
    private TextField lblIdCrearPaciente;

    @FXML
    private TextField lblIdMedicoEliminar;

    @FXML
    private TextField lblIdMedicoReporteIndividual;

    @FXML
    private TextField lblIdPacienteEliminar;

    @FXML
    private TextField lblIdPacienteReporte;

    @FXML
    private TextField lblNombreActualizarMedico;

    @FXML
    private TextField lblNombreActualizarPaciente;

    @FXML
    private TextField lblNombreCrearMedico;

    @FXML
    private TextField lblNombreCrearPaciente;

    @FXML
    private TextField lblTelefonoActualizarMedico;

    @FXML
    private TextField lblTelefonoActualizarPaciente;

    @FXML
    private TextField lblTelefonoCrearMedico;

    @FXML
    private TextField lblTelefonoCrearPaciente;

    @FXML
    private TextField txtCancelarCita;

    @FXML
    private TextField txtCedulaSolicitarCita;

    @FXML
    private TextField txtHoraFinHoraActualizarHorario;

    @FXML
    private TextField txtHoraIFinMinutoActualizarHorario1;

    @FXML
    private TextField txtHoraInicioHoraActualizarHorario;

    @FXML
    private TextField txtHoraInicioMinutoActualizarHorario;

    @FXML
    private TextField txtHoraSolicitarCita;

    @FXML
    private TextField txtIdMedicoSalaActualizar;

    @FXML
    private TextField txtIdMedicoSalaCrear;

    @FXML
    private TextField txtMinutoSolicitarCita;

    @FXML
    private TextField txtNumeroSalaActualizar;

    @FXML
    private TextField txtNumeroSalaCrear;

    @FXML
    private TextField txtSalaEliminar;

    @FXML
    void click(ActionEvent event) {
        Object clicked = event.getSource();

        if (clicked == btnCerrarCesion) {
            app.openHospital();
        }

        if (clicked == btnReporteIndividualPaciente) {
            String idPaciente = lblIdPacienteReporte.getText();
            String resultado = hospitalController.buscarPaciente(idPaciente).toString();
            JOptionPane.showMessageDialog(null, resultado);
        }

        if (clicked == btnReporteTotalPacientes){
            String lista = hospitalController.getListPacientes().toString();
            JOptionPane.showMessageDialog(null,lista);
        }

        if(clicked == btnCrearPaciente){
            if(!lblIdCrearPaciente.getText().isEmpty() && !lblNombreCrearPaciente.getText().isEmpty()
            && !lblTelefonoCrearPaciente.getText().isEmpty() && !lblCorreoCrearPaciente.getText().isEmpty() && !lblDireccionCrearPaciente.getText().isEmpty()) {
                String id = lblIdCrearPaciente.getText();
                String nombre = lblNombreCrearPaciente.getText();
                String telefono = lblTelefonoCrearPaciente.getText();
                String correo = lblCorreoCrearPaciente.getText();
                String direccion = lblDireccionCrearPaciente.getText();
                LocalDate fechaNacimiento = fechaNacimientoCrearPaciente.getValue();

                boolean resultado = hospitalController.crearPaciente(id,nombre,telefono, correo,direccion,fechaNacimiento);
                if (resultado == true) {
                    JOptionPane.showMessageDialog(null, "Paciente creado con exito");
                } else if (resultado == false) {
                    JOptionPane.showMessageDialog(null, "Error");

                }
            }

        }


        if (clicked == btnActualizarPaciente) {
            if (!lblIdActualizarPaciente.getText().isEmpty() && !lblNombreActualizarPaciente.getText().isEmpty()
            && !lblTelefonoActualizarPaciente.getText().isEmpty() && !lblCorreoActualizarPaciente.getText().isEmpty() && !lblDireccionActualizarPaciente.getText().isEmpty()) {
                String id = lblIdActualizarPaciente.getText();
                String nombre = lblNombreActualizarPaciente.getText();
                String telefono = lblTelefonoActualizarPaciente.getText();
                String correo = lblCorreoActualizarPaciente.getText();
                String direccion = lblDireccionActualizarPaciente.getText();
                LocalDate fechaNacimiento = fechaNacimientoActualizarPaciente.getValue();

                boolean resultado = hospitalController.actualizarPaciente(id, nombre, telefono, correo,direccion,fechaNacimiento);
                if (resultado == true) {
                    JOptionPane.showMessageDialog(null, "Paciente actualizado con exito");
                } else if (resultado == false) {
                    JOptionPane.showMessageDialog(null, "Error");

                }
            }
        }


        if (clicked == btnEliminarPaciente) {
            boolean resultado = hospitalController.eliminarPaciente(lblIdPacienteReporte.getText());
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, "Paciente eliminado");
            }else if (resultado == false) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }





        if (clicked == btnReporteIndividualMedico) {
            String id = lblIdMedicoReporteIndividual.getText();
            String resultado = hospitalController.buscarMedico(id).toString();
            JOptionPane.showMessageDialog(null, resultado);
        }

        if (clicked == btnReporteTotalMedicos){
            String lista = hospitalController.getListMedicos().toString();
            JOptionPane.showMessageDialog(null,lista);
        }

        if(clicked == btnActualizarMedico){
            String idMedico = lblIdActualizarMedico.getText();
            String nombre = lblNombreActualizarMedico.getText();
            String telefono = lblTelefonoActualizarMedico.getText();
            String correo = lblCorreoActualizarMedico.getText();
            String direccion = lblDireccionActualizarMedico.getText();
            LocalDate fechaNacimiento = fechaNacimientoActualizarMedico.getValue();
            Especialidad especialidad = choiceEspecialidadActualizarMedico.getValue();

            boolean resultado = hospitalController.actualizarMedico(idMedico,nombre,telefono,correo,direccion,fechaNacimiento,especialidad);
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, resultado);
            }else if (resultado == false) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }


        if (clicked == btnCrearMedico){
            String id = lblIdCrearMedico.getText();
            String nombre = lblNombreCrearMedico.getText();
            String telefono = lblTelefonoCrearMedico.getText();
            String correo = lblCorreoCrearMedico.getText();
            String direccion = lblDireccionCrearMedico.getText();
            LocalDate fechaNacimiento = fechaNacimientoCrearMedico.getValue();
            Especialidad especialidad = choiceEspecialidadCrearMedico.getValue();

            boolean resultado = hospitalController.crearMedico(id,nombre,telefono,correo,direccion,fechaNacimiento,especialidad);
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, resultado);
            }else if (resultado == false) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }

        if (clicked == btnEliminarMedico) {
            String id = lblIdMedicoEliminar.getText();
            boolean resultado = hospitalController.eliminarMedico(id);
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, resultado);
            }else if (resultado == false) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }

        if (clicked == btnIngresarHorario) {
            String id = lblIdActualizarHorario.getText();
            int horaInicio = Integer.parseInt(txtHoraInicioHoraActualizarHorario.getText());
            int minutoInicio = Integer.parseInt(txtHoraInicioMinutoActualizarHorario.getText());
            int horaFin = Integer.parseInt(txtHoraFinHoraActualizarHorario.getText());
            int minutoFin = Integer.parseInt(txtHoraIFinMinutoActualizarHorario1.getText());
            DayOfWeek day = choiceDiaHorario.getValue();

            boolean resultado = hospitalController.modificarHorario(id,day, LocalTime.of(horaInicio,minutoInicio),LocalTime.of(horaFin,minutoFin));
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, "Horario Modificado");
            } else if (resultado == false) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }

        if(clicked == btnMostrarHorario){
            if(lblIdActualizarHorario.getText() != null){
                String horario = hospitalController.mostrarHorarioString(lblIdActualizarHorario.getText());
                JOptionPane.showMessageDialog(null, horario);
            }
        }


        if(clicked == btnReporteTotalCitas){
            String resultado = hospitalController.getListCitas().toString();
            JOptionPane.showMessageDialog(null, resultado);
        }


        if (clicked == btnReporteIndividualAutorizacion){
            String resultado = hospitalController.buscarPaciente(lblAutorizacionReporte.getText()).getListHistoria().toString();
            JOptionPane.showMessageDialog(null, resultado);
        }

        if (clicked == btnSolicitarCita){
            if(!txtCedulaSolicitarCita.getText().isEmpty() && !txtHoraSolicitarCita.getText().isEmpty() && !txtMinutoSolicitarCita.getText().isEmpty()){

                String idPaciente = txtCedulaSolicitarCita.getText();
                int hora = Integer.parseInt(txtHoraSolicitarCita.getText());
                int min = Integer.parseInt(txtMinutoSolicitarCita.getText());
                DayOfWeek dia = choiceDiaSolicitarCita.getValue();
                Especialidad especialidad = choiceEspecialidadCita.getValue();
                Boolean resultado = hospitalController.crearCita(idPaciente,especialidad,dia, LocalTime.of(hora, min));
                if(resultado == true){
                    JOptionPane.showMessageDialog(null, "Cita creada con exito");
                }else{JOptionPane.showMessageDialog(null, "No se pudo crear la cita");}
            }

        }


        if (clicked == btnCancelarCita){
            int autorizacion = Integer.parseInt(txtCancelarCita.getText());
            boolean r = hospitalController.cancelarCita(autorizacion);
            if(r == true){
                JOptionPane.showMessageDialog(null, "Cita cancelada con exito");
            } else if (r == false) {
                JOptionPane.showMessageDialog(null, "No se pudo cancelar la cita");
            }
        }

        if (clicked == btnReporteTotalSalas){
            String resultado = hospitalController.getListSalas().toString();
            JOptionPane.showMessageDialog(null, resultado);
        }

        if (clicked == btnSalaCrear){
            int sala= Integer.parseInt(txtNumeroSalaCrear.getText());
            boolean r = hospitalController.crearSala(sala, txtIdMedicoSalaCrear.getText());
            if(r == true){
                JOptionPane.showMessageDialog(null, "Sala Creada con exito");

            } else if (r == false) {
                JOptionPane.showMessageDialog(null, "No se pudo crear la sala");

            }
        }

        if (clicked == btnEliminarSala){
            int sala = Integer.parseInt(txtSalaEliminar.getText());
            boolean r = hospitalController.eliminarSala(sala);
            if(r == true){
                JOptionPane.showMessageDialog(null, "Sala Eliminada con exito");
            } else if (r == false) {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la sala");

            }
        }

        if (clicked == btnSalaActualizar){
            int sala = Integer.parseInt(txtNumeroSalaActualizar.getText());
            boolean r = hospitalController.actualizarSala(sala, txtIdMedicoSalaActualizar.getText());
            if(r == true){
                JOptionPane.showMessageDialog(null, "Sala Actualizada con exito");
            } else if (r == false) {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la sala");

            }
        }











    }

    @FXML
    void initialize() {
        assert btnActualizarMedico != null : "fx:id=\"btnActualizarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnActualizarPaciente != null : "fx:id=\"btnActualizarPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnCancelarCita != null : "fx:id=\"btnCancelarCita\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnCerrarCesion != null : "fx:id=\"btnCerrarCesion\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnCrearMedico != null : "fx:id=\"btnCrearMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnCrearPaciente != null : "fx:id=\"btnCrearPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnEliminarMedico != null : "fx:id=\"btnEliminarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnEliminarPaciente != null : "fx:id=\"btnEliminarPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnEliminarSala != null : "fx:id=\"btnEliminarSala\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnIngresarHorario != null : "fx:id=\"btnIngresarHorario\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnMostrarHorario != null : "fx:id=\"btnMostrarHorario\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnReporteIndividualAutorizacion != null : "fx:id=\"btnReporteIndividualAutorizacion\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnReporteIndividualMedico != null : "fx:id=\"btnReporteIndividualMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnReporteIndividualPaciente != null : "fx:id=\"btnReporteIndividualPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnReporteTotalCitas != null : "fx:id=\"btnReporteTotalCitas\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnReporteTotalMedicos != null : "fx:id=\"btnReporteTotalMedicos\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnReporteTotalPacientes != null : "fx:id=\"btnReporteTotalPacientes\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnReporteTotalSalas != null : "fx:id=\"btnReporteTotalSalas\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnSalaActualizar != null : "fx:id=\"btnSalaActualizar\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnSalaCrear != null : "fx:id=\"btnSalaCrear\" was not injected: check your FXML file 'Admin.fxml'.";
        assert btnSolicitarCita != null : "fx:id=\"btnSolicitarCita\" was not injected: check your FXML file 'Admin.fxml'.";
        assert choiceDiaHorario != null : "fx:id=\"choiceDiaHorario\" was not injected: check your FXML file 'Admin.fxml'.";
        assert choiceDiaSolicitarCita != null : "fx:id=\"choiceDiaSolicitarCita\" was not injected: check your FXML file 'Admin.fxml'.";
        assert choiceEspecialidadActualizarMedico != null : "fx:id=\"choiceEspecialidadActualizarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert choiceEspecialidadCita != null : "fx:id=\"choiceEspecialidadCita\" was not injected: check your FXML file 'Admin.fxml'.";
        assert choiceEspecialidadCrearMedico != null : "fx:id=\"choiceEspecialidadCrearMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert fechaNacimientoActualizarMedico != null : "fx:id=\"fechaNacimientoActualizarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert fechaNacimientoActualizarPaciente != null : "fx:id=\"fechaNacimientoActualizarPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert fechaNacimientoCrearMedico != null : "fx:id=\"fechaNacimientoCrearMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert fechaNacimientoCrearPaciente != null : "fx:id=\"fechaNacimientoCrearPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblAutorizacionReporte != null : "fx:id=\"lblAutorizacionReporte\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblCorreoActualizarMedico != null : "fx:id=\"lblCorreoActualizarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblCorreoActualizarPaciente != null : "fx:id=\"lblCorreoActualizarPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblCorreoCrearMedico != null : "fx:id=\"lblCorreoCrearMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblCorreoCrearPaciente != null : "fx:id=\"lblCorreoCrearPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblDireccionActualizarMedico != null : "fx:id=\"lblDireccionActualizarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblDireccionActualizarPaciente != null : "fx:id=\"lblDireccionActualizarPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblDireccionCrearMedico != null : "fx:id=\"lblDireccionCrearMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblDireccionCrearPaciente != null : "fx:id=\"lblDireccionCrearPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdActualizarHorario != null : "fx:id=\"lblIdActualizarHorario\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdActualizarMedico != null : "fx:id=\"lblIdActualizarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdActualizarPaciente != null : "fx:id=\"lblIdActualizarPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdCrearMedico != null : "fx:id=\"lblIdCrearMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdCrearPaciente != null : "fx:id=\"lblIdCrearPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdMedicoEliminar != null : "fx:id=\"lblIdMedicoEliminar\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdMedicoReporteIndividual != null : "fx:id=\"lblIdMedicoReporteIndividual\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdPacienteEliminar != null : "fx:id=\"lblIdPacienteEliminar\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblIdPacienteReporte != null : "fx:id=\"lblIdPacienteReporte\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblNombreActualizarMedico != null : "fx:id=\"lblNombreActualizarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblNombreActualizarPaciente != null : "fx:id=\"lblNombreActualizarPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblNombreCrearMedico != null : "fx:id=\"lblNombreCrearMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblNombreCrearPaciente != null : "fx:id=\"lblNombreCrearPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblTelefonoActualizarMedico != null : "fx:id=\"lblTelefonoActualizarMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblTelefonoActualizarPaciente != null : "fx:id=\"lblTelefonoActualizarPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblTelefonoCrearMedico != null : "fx:id=\"lblTelefonoCrearMedico\" was not injected: check your FXML file 'Admin.fxml'.";
        assert lblTelefonoCrearPaciente != null : "fx:id=\"lblTelefonoCrearPaciente\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtCancelarCita != null : "fx:id=\"txtCancelarCita\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtCedulaSolicitarCita != null : "fx:id=\"txtCedulaSolicitarCita\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtHoraFinHoraActualizarHorario != null : "fx:id=\"txtHoraFinHoraActualizarHorario\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtHoraIFinMinutoActualizarHorario1 != null : "fx:id=\"txtHoraIFinMinutoActualizarHorario1\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtHoraInicioHoraActualizarHorario != null : "fx:id=\"txtHoraInicioHoraActualizarHorario\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtHoraInicioMinutoActualizarHorario != null : "fx:id=\"txtHoraInicioMinutoActualizarHorario\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtHoraSolicitarCita != null : "fx:id=\"txtHoraSolicitarCita\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtIdMedicoSalaActualizar != null : "fx:id=\"txtIdMedicoSalaActualizar\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtIdMedicoSalaCrear != null : "fx:id=\"txtIdMedicoSalaCrear\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtMinutoSolicitarCita != null : "fx:id=\"txtMinutoSolicitarCita\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtNumeroSalaActualizar != null : "fx:id=\"txtNumeroSalaActualizar\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtNumeroSalaCrear != null : "fx:id=\"txtNumeroSalaCrear\" was not injected: check your FXML file 'Admin.fxml'.";
        assert txtSalaEliminar != null : "fx:id=\"txtSalaEliminar\" was not injected: check your FXML file 'Admin.fxml'.";

    }



    public void setApp(App app) {
        this.app = app;
    }

    public void setHospitalController(HospitalController hospitalController) {
        this.hospitalController = hospitalController;
    }
}
