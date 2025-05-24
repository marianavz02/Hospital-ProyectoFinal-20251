package co.edu.uniquindio.hospital.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Medico extends Persona {
    private Especialidad especialidad;
    private Map<DayOfWeek,Horario> horarioDisponible;

    public Medico(int id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento, Especialidad especialidad) {
        super(id, nombre, telefono, email, direccion, fechaNacimiento);
        this.especialidad = especialidad;
        this.horarioDisponible = new HashMap<>();
    }


    public void setHorario(DayOfWeek day, LocalTime horaInicio, LocalTime horaFin) {
        horarioDisponible.put(day,new Horario(horaInicio,horaFin));
    }

    public Map<DayOfWeek, Horario> getHorarioDisponible() {
        return horarioDisponible;
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
