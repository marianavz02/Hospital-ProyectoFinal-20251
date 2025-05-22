package co.edu.uniquindio.hospital.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hospital {

    ArrayList<Paciente> listPacientes = new ArrayList<Paciente>();
    ArrayList<Medico> listMedicos = new ArrayList<Medico>();
    ArrayList<CitaMedica> listCitas = new ArrayList<CitaMedica>();
    ArrayList<Sala> listSalas = new ArrayList<Sala>();
    String nombreHospital;

    public Hospital(ArrayList<Paciente> listPacientes, ArrayList<CitaMedica> listCitas, ArrayList<Medico> listMedicos, ArrayList<Sala> listSalas, String nombreHospital) {
        this.listPacientes = listPacientes;
        this.listCitas = listCitas;
        this.listMedicos = listMedicos;
        this.listSalas = listSalas;
        this.nombreHospital = nombreHospital;
    }

    public ArrayList<Paciente> getListPacientes() {
        return listPacientes;
    }

    public void setListPacientes(ArrayList<Paciente> listPacientes) {
        this.listPacientes = listPacientes;
    }

    public ArrayList<Medico> getListMedicos() {
        return listMedicos;
    }

    public void setListMedicos(ArrayList<Medico> listMedicos) {
        this.listMedicos = listMedicos;
    }

    public ArrayList<CitaMedica> getListCitas() {
        return listCitas;
    }

    public void setListCitas(ArrayList<CitaMedica> listCitas) {
        this.listCitas = listCitas;
    }

    public ArrayList<Sala> getListSalas() {
        return listSalas;
    }

    public void setListSalas(ArrayList<Sala> listSalas) {
        this.listSalas = listSalas;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "listPacientes=" + listPacientes +
                ", listMedicos=" + listMedicos +
                ", listCitas=" + listCitas +
                ", listSalas=" + listSalas +
                ", nombreHospital='" + nombreHospital + '\'' +
                '}';
    }


    //METODO DE LA CLASE

    //Buscar paciente id
    public Paciente  buscarPaciente(int id) {
        Paciente pacienteEncontrado= null;
        for (Paciente paciente : listPacientes) {
            if (paciente.getId() == id) {
                pacienteEncontrado = paciente;
                break;
            }
        }return pacienteEncontrado;
    }

    //Buscar medico id
    public Medico  buscarMedico(int id) {
        Medico medicoEncontrado = null;
        for (Medico medico : listMedicos) {
            if (medico.getId() == id) {
                medicoEncontrado = medico;
                break;
            }
        }return medicoEncontrado;
    }


    //CRUD MEDICO
    //crear medico
    public boolean crearMedico(int id, String nombre, String telefono, String email,
                               String direccion, LocalDate fechaNacimiento, Especialidad especialidad) {
        boolean flag = false;
        if(buscarMedico(id) == null) {
            Medico nuevoMedico = new Medico(id, nombre, telefono, email, direccion, fechaNacimiento, especialidad);
            listMedicos.add(nuevoMedico);
            flag = true;
        }
        return flag;
    }

    //eliminar medico
    public boolean eliminarMedico(int id) {
        boolean flag = false;
        if (buscarMedico(id).equals(id)) {
            listMedicos.remove(buscarMedico(id));
            flag = true;
        }return flag;
    }

    //actualizar medico
    public boolean actualizarMedico (int id,String nombre, String telefono, String email,
                                     String direccion, LocalDate fechaNacimiento, Especialidad especialidad){
        boolean flag = false;
        Medico medicoActualizar = buscarMedico(id);
        if (medicoActualizar != null) {
            medicoActualizar.setNombre(nombre);
            medicoActualizar.setTelefono(telefono);
            medicoActualizar.setEmail(email);
            medicoActualizar.setDireccion(direccion);
            medicoActualizar.setFechaNacimiento(fechaNacimiento);
            medicoActualizar.setEspecialidad(especialidad);
            flag = true;
        }return flag;
    }

    //Mostrar medico
    public String mostrarMedico(int id) {
        Medico medico = buscarMedico(id);
        String medicoMostrar = null;
        if (medico != null) {
            medicoMostrar = medico.toString();
        }return medicoMostrar;
    }


    //CRUD PACIENTE
    // crear paciente
    public boolean crearPaciente(int id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento) {
        boolean flag = false;
        if(buscarPaciente(id) == null) {
            Paciente nuevoPaciente = new Paciente(id, nombre, telefono, email, direccion, fechaNacimiento);
            listPacientes.add(nuevoPaciente);
            flag = true;
        }return flag;
    }

    // eliminar paciente
    public boolean eliminarPaciente(int id) {
        boolean flag = false;
        if (buscarPaciente(id) != null) {
            listPacientes.remove(buscarPaciente(id));
            flag = true;
        }return flag;
    }

    // actualizar paciente
    public boolean actualizarPaciente (int id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento){
        boolean flag = false;
        Paciente pacienteActualizar = buscarPaciente(id);
        if (pacienteActualizar != null) {
            pacienteActualizar.setNombre(nombre);
            pacienteActualizar.setTelefono(telefono);
            pacienteActualizar.setEmail(email);
            pacienteActualizar.setDireccion(direccion);
            pacienteActualizar.setFechaNacimiento(fechaNacimiento);
            flag = true;
        }return flag;
    }

    //mostrar paciente
    public String mostrarPaciente(int id) {
        Paciente paciente = buscarPaciente(id);
        String pacienteMostrar = null;
        if (paciente != null) {
            pacienteMostrar = paciente.toString();
        }return pacienteMostrar;
    }


    //CRUD CITA MEDICA

    //crear cita (SIN TERMINAR)
    public boolean crearCita (int idPaciente, LocalDate fecha, Medico profesional, String hora, Especialidad especialidad, Sala consultorio){
        boolean flag = false;
        Paciente personaSeleccionada= buscarPaciente(idPaciente);
        if (personaSeleccionada != null) {
            CitaMedica nuevaCita= new CitaMedica(personaSeleccionada, fecha, profesional, hora, especialidad, consultorio);

        }return flag;
    }


}
