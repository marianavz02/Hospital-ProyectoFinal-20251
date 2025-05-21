package co.edu.uniquindio.hospital.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medico extends Persona {
    private Especialidad especialidad;

    public Medico(int id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento, Especialidad especialidad) {
        super(id, nombre, telefono, email, direccion, fechaNacimiento);
        this.especialidad = especialidad;
    }


    public Especialidad getEspecialidad() {
        return especialidad;
    }


    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "especialidad=" + especialidad +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

}
