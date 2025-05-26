package co.edu.uniquindio.hospital.viewController;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.hospital.App;
import co.edu.uniquindio.hospital.controller.HospitalController;
import co.edu.uniquindio.hospital.model.CitaMedica;
import co.edu.uniquindio.hospital.model.TipoProcedimiento;
import co.edu.uniquindio.hospital.model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import javax.swing.*;

public class MedicoViewController {
    App app;
    HospitalController hospitalController;






    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBuscarHistorial;

    @FXML
    private Button btnMostrarCitas;

    @FXML
    private Button btnCerrarCesion;

    @FXML
    private Tab btnHistoria;

    @FXML
    private Tab btnHorario;

    @FXML
    private Button btnIngresarHorario;

    @FXML
    private Button btnIngresarProcedimiento;

    @FXML
    private Button btnMostrarHorario;

    @FXML
    private Tab btnProcedimiento;

    @FXML
    private ChoiceBox<DayOfWeek> choiceDiaSemana;

    @FXML
    private ChoiceBox<TipoProcedimiento> choiceProcedimiento;

    @FXML
    private TableColumn<ArrayList, CitaMedica> tabCitas;

    @FXML
    private TableView<ArrayList> tabCitasGeneral;

    @FXML
    private TableView<?> tabHistoriaGeneral;

    @FXML
    private TableColumn<?, ?> tabHistoriaMedica;

    @FXML
    private TableView<?> tabHorario;

    @FXML
    private TableColumn<?, ?> tabJueves;

    @FXML
    private TableColumn< ?, ?> tabLunes;

    @FXML
    private TableColumn<?, ?> tabMartes;

    @FXML
    private TableColumn<?, ?> tabMiercoles;

    @FXML
    private TableColumn<?, ?> tabViernes;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtHoraFinalHora;

    @FXML
    private TextField txtHoraFinalMinutos;

    @FXML
    private TextField txtHoraInicioHora;

    @FXML
    private TextField txtHoraInicioMinutos;

    @FXML
    private TextField txtIdMedicoHorario;

    @FXML
    private TextField txtIdMedicoProcedimiento;

    @FXML
    private TextField txtIdPacienteHistorial;

    @FXML
    private TextField txtIdPacienteProcedimiento;

    @FXML
    void escribir(KeyEvent event) {

    }





    @FXML
    void click(ActionEvent event) {
        Object eve =event.getSource();
        if(eve == btnCerrarCesion){
            app.openHospital();
        }

        if(eve == btnIngresarHorario){
            String idMedico = txtIdMedicoHorario.getText();
            int horaInicio = Integer.parseInt(txtHoraInicioHora.getText());
            int minutosInicio = Integer.parseInt(txtHoraInicioMinutos.getText());
            int horaFinal = Integer.parseInt(txtHoraFinalHora.getText());
            int minutosFinal = Integer.parseInt(txtHoraFinalMinutos.getText());
            DayOfWeek day = choiceDiaSemana.getValue();
            hospitalController.modificarHorario(idMedico,day, LocalTime.of(horaInicio,minutosInicio),LocalTime.of(horaFinal,minutosFinal));
        }

        if(eve== btnMostrarHorario){
            if(txtIdMedicoHorario.getText() != null){
                String horarioMostrar = hospitalController.mostrarHorarioString(txtIdMedicoHorario.getText());
                JOptionPane.showMessageDialog(null, "Horario:"+horarioMostrar);

            }

        }

        if(eve ==btnMostrarCitas){
            if(txtIdMedicoHorario.getText() != null){
                String mostrar = hospitalController.mostrarCitasPorMedico(txtIdMedicoHorario.getText());
                JOptionPane.showMessageDialog(null, mostrar);
            }
        }

        if(eve == btnIngresarProcedimiento){
            String idPaciente = txtIdPacienteProcedimiento.getText();
            String idMedico = txtIdMedicoProcedimiento.getText();
            TipoProcedimiento tipo = choiceProcedimiento.getValue();
            String descripcion = txtDescripcion.getText();
            hospitalController.crearProcedimiento(idPaciente,tipo,descripcion,idMedico);
        }

        if(eve == btnBuscarHistorial){
            String idPaciente = txtIdPacienteHistorial.getText();
            Paciente paciente = hospitalController.buscarPaciente(idPaciente);
            JOptionPane.showMessageDialog(null, "Paciente:"+paciente.getListHistoria());

        }




    }

    @FXML
    void initialize() {
        choiceDiaSemana.getItems().addAll(DayOfWeek.values());
        choiceProcedimiento.getItems().addAll(TipoProcedimiento.values());
        assert btnMostrarCitas != null : "fx:id=\"btnMostrarCitas\" was not injected: check your FXML file 'Medico.fxml'.";
        assert btnBuscarHistorial != null : "fx:id=\"btnBuscarHistorial\" was not injected: check your FXML file 'Medico.fxml'.";
        assert btnCerrarCesion != null : "fx:id=\"btnCerrarCesion\" was not injected: check your FXML file 'Medico.fxml'.";
        assert btnHistoria != null : "fx:id=\"btnHistoria\" was not injected: check your FXML file 'Medico.fxml'.";
        assert btnHorario != null : "fx:id=\"btnHorario\" was not injected: check your FXML file 'Medico.fxml'.";
        assert btnIngresarHorario != null : "fx:id=\"btnIngresarHorario\" was not injected: check your FXML file 'Medico.fxml'.";
        assert btnIngresarProcedimiento != null : "fx:id=\"btnIngresarProcedimiento\" was not injected: check your FXML file 'Medico.fxml'.";
        assert btnMostrarHorario != null : "fx:id=\"btnMostrarHorario\" was not injected: check your FXML file 'Medico.fxml'.";
        assert btnProcedimiento != null : "fx:id=\"btnProcedimiento\" was not injected: check your FXML file 'Medico.fxml'.";
        assert choiceDiaSemana != null : "fx:id=\"choiceDiaSemana\" was not injected: check your FXML file 'Medico.fxml'.";
        assert choiceProcedimiento != null : "fx:id=\"choiceProcedimiento\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabCitas != null : "fx:id=\"tabCitas\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabCitasGeneral != null : "fx:id=\"tabCitasGeneral\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabHistoriaGeneral != null : "fx:id=\"tabHistoriaGeneral\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabHistoriaMedica != null : "fx:id=\"tabHistoriaMedica\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabHorario != null : "fx:id=\"tabHorario\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabJueves != null : "fx:id=\"tabJueves\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabLunes != null : "fx:id=\"tabLunes\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabMartes != null : "fx:id=\"tabMartes\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabMiercoles != null : "fx:id=\"tabMiercoles\" was not injected: check your FXML file 'Medico.fxml'.";
        assert tabViernes != null : "fx:id=\"tabViernes\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtHoraFinalHora != null : "fx:id=\"txtHoraFinalHora\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtHoraFinalMinutos != null : "fx:id=\"txtHoraFinalMinutos\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtHoraInicioHora != null : "fx:id=\"txtHoraInicioHora\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtHoraInicioMinutos != null : "fx:id=\"txtHoraInicioMinutos\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtIdMedicoHorario != null : "fx:id=\"txtIdMedicoHorario\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtIdMedicoProcedimiento != null : "fx:id=\"txtIdMedicoProcedimiento\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtIdPacienteHistorial != null : "fx:id=\"txtIdPacienteHistorial\" was not injected: check your FXML file 'Medico.fxml'.";
        assert txtIdPacienteProcedimiento != null : "fx:id=\"txtIdPacienteProcedimiento\" was not injected: check your FXML file 'Medico.fxml'.";


    }


    public void setApp(App app) {
        this.app = app;
    }

    public void setHospitalController(HospitalController hospitalController) {
        this.hospitalController = hospitalController;
    }


}
