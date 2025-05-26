package co.edu.uniquindio.hospital.controller;

import co.edu.uniquindio.hospital.model.Hospital;
import co.edu.uniquindio.hospital.model.TipoProcedimiento;
import co.edu.uniquindio.hospital.model.Paciente;
import javafx.event.ActionEvent;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class HospitalController {
    Hospital hospital;




    public HospitalController(Hospital hospital) {
        this.hospital = hospital;
    }



//loguin
    public boolean iniciarCesionGeneral(String id, String email) {
        return hospital.iniciarCesionGeneral(id, email);
    }

    public boolean iniciarCesionAdmin(String id, String email) {
        return hospital.iniciarCesionAdmin(id, email);
    }



//Medico
    public boolean modificarHorario(String idMedico, DayOfWeek day, LocalTime horaInicio, LocalTime horaFin) {
        return hospital.modificarHorario(idMedico, day, horaInicio, horaFin);
    }

    public String mostrarHorarioString (String idMedico) {
        return hospital.mostrarHorarioString(idMedico);
    }

    public String  mostrarCitasPorMedico (String idMedico) {
        return hospital.mostrarCitasPorMedico(idMedico);
    }

    public boolean crearProcedimiento(String idPaciente, TipoProcedimiento tipoProcedimiento, String descripcion, String idMedico){
        return hospital.crearProcedimiento(idPaciente, tipoProcedimiento, descripcion, idMedico);
    }

    public Paciente buscarPaciente(String idPaciente) {
        return hospital.buscarPaciente(idPaciente);
    }





}
