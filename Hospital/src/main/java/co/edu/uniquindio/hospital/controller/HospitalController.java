package co.edu.uniquindio.hospital.controller;

import co.edu.uniquindio.hospital.model.*;
import javafx.event.ActionEvent;

import java.time.DayOfWeek;
import java.time.LocalDate;
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

    public boolean iniciarCesionMedico(String id, String email) {
        return hospital.iniciarCesionMedico(id,email);
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

    public Medico buscarMedico(String idMedico) {
        return hospital.buscarMedico(idMedico);
    }

    public ArrayList<Medico> getListMedicos() {
        return hospital.getListMedicos();
    }

    public boolean actualizarMedico(String id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento, Especialidad especialidad) {
        return hospital.actualizarMedico(id,nombre,telefono,email,direccion,fechaNacimiento,especialidad);
    }

    public boolean crearMedico(String id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento, Especialidad especialidad){
        return hospital.crearMedico(id,nombre,telefono,email,direccion,fechaNacimiento,especialidad);
    }

    public boolean eliminarMedico(String id) {
        return hospital.eliminarMedico(id);
    }







    public boolean crearCita(String idPaciente, Especialidad especialidad,DayOfWeek dia, LocalTime horaInicio) {
        return hospital.crearCita(idPaciente, especialidad, dia, horaInicio);
    }

    public boolean actualizarPaciente(String id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento) {
        return hospital.actualizarPaciente(id, nombre, telefono, email, direccion, fechaNacimiento);
    }

    public boolean cancelarCita(int autorizacion){
        return hospital.cancelarCita(autorizacion);
    }

    public String mostrarCitasPorPaciente(String idPaciente){
        return hospital.mostrarCitasPorPaciente(idPaciente);
    }

    public boolean crearPaciente(String id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento){
        return hospital.crearPaciente(id, nombre, telefono, email, direccion, fechaNacimiento);
    }


    public boolean eliminarPaciente(String idPaciente){
        return hospital.eliminarPaciente(idPaciente);
    }


    public ArrayList<Paciente> getListPacientes() {
        return hospital.getListPacientes();
    }

    public ArrayList<Sala> getListSalas() {
        return hospital.getListSalas();
    }

    public ArrayList<CitaMedica> getListCitas() {
        return hospital.getListCitas();
    }



    public boolean crearSala(int codigoSala, String idMedico){
        return hospital.crearSala(codigoSala, idMedico);
    }

    public boolean eliminarSala(int id){
        return hospital.eliminarSala(id);
    }

    public boolean actualizarSala(int codigoSala, String idMedico) {
        return hospital.actualizarSala(codigoSala, idMedico);
    }











    }
