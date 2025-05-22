package co.edu.uniquindio.hospital.model;

import java.time.LocalDate;

public class CitaMedica {
    Paciente paciente;
    LocalDate fecha;
    String hora;
    Medico profesional;
    Especialidad especialidad;
    Sala consultorio;

    public CitaMedica(Paciente paciente, LocalDate fecha, Medico profesional, String hora, Especialidad especialidad, Sala consultorio) {
        this.fecha = fecha;
        this.profesional = profesional;
        this.hora = hora;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
                "fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", profesional=" + profesional +
                ", Especialidad='" + especialidad + '\'' +
                ", consultorio=" + consultorio +
                '}';
    }
}
