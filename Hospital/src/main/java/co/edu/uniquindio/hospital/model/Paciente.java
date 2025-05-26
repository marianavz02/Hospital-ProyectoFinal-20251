package co.edu.uniquindio.hospital.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Persona{
    ArrayList<Procedimiento> listHistoria = new ArrayList<Procedimiento>();

    public Paciente(String id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento) {
        super(id, nombre, telefono, email, direccion, fechaNacimiento);
        this.listHistoria = listHistoria;
    }

    public ArrayList<Procedimiento> getListHistoria() {
        return listHistoria;
    }

    public void setListHistoria(ArrayList<Procedimiento> listHistoria) {
        this.listHistoria = listHistoria;
    }


    @Override
    public String toString() {
        return "Paciente{" +

                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +

                "listHistoria=" + listHistoria +
                '}';
    }

    @Override
    public boolean iniciarCesion(String id, String email, Persona persona){
        boolean flag = false;
        if (persona instanceof Paciente && persona.getId().equals(id) && persona.getEmail().equals(email)) {
            flag = true;
        }
        return flag;
    }


    @Override
    public void cerrarCesion() {

    }
}
