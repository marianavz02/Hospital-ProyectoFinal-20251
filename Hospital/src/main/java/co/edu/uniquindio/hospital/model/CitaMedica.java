package co.edu.uniquindio.hospital.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CitaMedica {
    Paciente paciente;
    DayOfWeek diaSemana;
    LocalTime horaInicio;
    int autorizacion;
    Medico profesional;
    Especialidad especialidad;
    Sala consultorio;

    public CitaMedica(Paciente paciente, DayOfWeek diaSemana, LocalTime horaInicio, Medico profesional, Especialidad especialidad) {
        this.paciente = paciente;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.profesional = profesional;
        this.especialidad = especialidad;
        this.autorizacion= autorizacion;
    }

    public int getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(int autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }



    public Medico getProfesional() {
        return profesional;
    }

    public void setProfesional(Medico profesional) {
        this.profesional = profesional;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Sala getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Sala consultorio) {
        this.consultorio = consultorio;
    }


    @Override
    public String toString() {
        return "CitaMedica{" +
                "paciente=" + paciente +
                ", diaSemana=" + diaSemana +
                ", horaInicio=" + horaInicio +
                ", autorizacion=" + autorizacion +
                ", profesional=" + profesional.getNombre() +
                ", especialidad=" + especialidad +
                ", consultorio=" + consultorio +
                '}';
    }
}
