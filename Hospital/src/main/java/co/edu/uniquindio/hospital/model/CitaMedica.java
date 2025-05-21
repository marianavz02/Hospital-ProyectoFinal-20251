package co.edu.uniquindio.hospital.model;

import java.time.LocalDate;

public class CitaMedica {
    LocalDate fecha;
    String hora;
    Medico profesional;
    String descripcion;
    Sala consultorio;

    public CitaMedica(LocalDate fecha, Medico profesional, String hora, String descripcion, Sala consultorio) {
        this.fecha = fecha;
        this.profesional = profesional;
        this.hora = hora;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
                ", descripcion='" + descripcion + '\'' +
                ", consultorio=" + consultorio +
                '}';
    }
}
