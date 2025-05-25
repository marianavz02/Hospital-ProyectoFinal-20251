package co.edu.uniquindio.hospital.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class Hospital {

    ArrayList<Paciente> listPacientes = new ArrayList<Paciente>();
    ArrayList<Medico> listMedicos = new ArrayList<Medico>();
    ArrayList<CitaMedica> listCitas = new ArrayList<CitaMedica>();
    ArrayList<Sala> listSalas = new ArrayList<Sala>();

    String nombreHospital;

    public Hospital(String nombreHospital) {
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







    //METODOS DE LA CLASE

    //Buscar paciente id
    public Paciente buscarPaciente(int id) {
        Paciente pacienteEncontrado = null;
        for (Paciente paciente : listPacientes) {
            if (paciente.getId() == id) {
                pacienteEncontrado = paciente;
                break;
            }
        }
        return pacienteEncontrado;
    }

    //Buscar medico id
    public Medico buscarMedico(int id) {
        Medico medicoEncontrado = null;
        for (Medico medico : listMedicos) {
            if (medico.getId() == id) {
                medicoEncontrado = medico;
                break;
            }
        }
        return medicoEncontrado;
    }

    //Buscar sala
    public Sala buscarSala(int id) {
        Sala salaEncontrado = null;
        for (Sala sala : listSalas) {
            if (sala.getNumeroSala() == id) {
                salaEncontrado = sala;
                break;
            }
        }return salaEncontrado;
    }


    //Buscar ultimaCitaCreada
    public CitaMedica buscarUltimaCitaMedica() {
        CitaMedica citaMedicaEncontrado = null;
        int autorizacion = listCitas.size();
        for (CitaMedica citaMedica : listCitas) {
            if (citaMedica.getAutorizacion() == autorizacion) {
                citaMedicaEncontrado = citaMedica;
                break;
            }
        }return citaMedicaEncontrado;
    }



    //Buscar cita medica
    public CitaMedica buscarCita(int autorizacion){
        CitaMedica citaEncontrado = null;
        for (CitaMedica citaMedica : listCitas) {
            if (citaMedica.getAutorizacion() == autorizacion) {
                citaEncontrado = citaMedica;
                break;
            }
        }return citaEncontrado;
    }





    //CRUD MEDICO y horario
    //Modificar Horario
    public boolean modificarHorario(int idMedico, DayOfWeek day, LocalTime horaInicio, LocalTime horaFin) {
        boolean flag = false;
        if (buscarMedico(idMedico) != null) {
            Medico medico = buscarMedico(idMedico);
            medico.setHorario(day, horaInicio, horaFin);
            flag = true;
        }
        return flag;
    }

    //mostrarHorario medico
    public Map mostrarHorario(int idMedico) {
        Map map = new HashMap();
        if (buscarMedico(idMedico) != null) {
            Medico medico = buscarMedico(idMedico);
            map = medico.getHorarioDisponible();
        }
        return map;
    }




    //crear medico
    public boolean crearMedico(int id, String nombre, String telefono, String email,
                               String direccion, LocalDate fechaNacimiento, Especialidad especialidad) {
        boolean flag = false;
        if (buscarMedico(id) == null) {
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
        }
        return flag;
    }

    //actualizar medico
    public boolean actualizarMedico(int id, String nombre, String telefono, String email,
                                    String direccion, LocalDate fechaNacimiento, Especialidad especialidad) {
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
        }
        return flag;
    }

    //Mostrar medico
    public String mostrarMedico(int id) {
        Medico medico = buscarMedico(id);
        String medicoMostrar = null;
        if (medico != null) {
            medicoMostrar = medico.toString();
        }
        return medicoMostrar;
    }










    //CRUD PACIENTE
    // crear paciente
    public boolean crearPaciente(int id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento) {
        boolean flag = false;
        if (buscarPaciente(id) == null) {
            Paciente nuevoPaciente = new Paciente(id, nombre, telefono, email, direccion, fechaNacimiento);
            listPacientes.add(nuevoPaciente);
            flag = true;
        }
        return flag;
    }

    // eliminar paciente
    public boolean eliminarPaciente(int id) {
        boolean flag = false;
        if (buscarPaciente(id) != null) {
            listPacientes.remove(buscarPaciente(id));
            flag = true;
        }
        return flag;
    }

    // actualizar paciente
    public boolean actualizarPaciente(int id, String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento) {
        boolean flag = false;
        Paciente pacienteActualizar = buscarPaciente(id);
        if (pacienteActualizar != null) {
            pacienteActualizar.setNombre(nombre);
            pacienteActualizar.setTelefono(telefono);
            pacienteActualizar.setEmail(email);
            pacienteActualizar.setDireccion(direccion);
            pacienteActualizar.setFechaNacimiento(fechaNacimiento);
            flag = true;
        }
        return flag;
    }

    //mostrar paciente
    public String mostrarPaciente(int id) {
        Paciente paciente = buscarPaciente(id);
        String pacienteMostrar = null;
        if (paciente != null) {
            pacienteMostrar = paciente.toString();
        }
        return pacienteMostrar;
    }









    //PROCEDIMIENTOS
    //crearProcedimiento
    public boolean crearProcedimiento(int id, TipoProcedimiento tipoProcedimiento, String descripcion, int idMedico) {
        boolean flag = false;
        Medico medico = buscarMedico(idMedico);
        if (buscarPaciente(id) != null) {
            Procedimiento procedimiento = new Procedimiento(tipoProcedimiento, descripcion);
            Paciente persona = buscarPaciente(id);
            medico.actualizarHistoria(procedimiento, persona);
            flag = true;
        }
        return flag;
    }






    //SALA
    //crear sala
    public boolean crearSala(int codigoSala, int idMedico) {
        boolean flag = false;
        if (buscarMedico(idMedico) != null) {
            if (buscarSala(codigoSala) == null) {
                Medico medico = buscarMedico(idMedico);
                Sala sala = new Sala(codigoSala, medico);
                listSalas.add(sala);
                flag = true;
            }
        }
        return flag;
    }

    public boolean actualizarSala(int codigoSala, int idMedico) {
        boolean flag = false;
        Sala sala = buscarSala(codigoSala);
        if (sala != null) {
            sala.setMedico(buscarMedico(idMedico));
            flag = true;
        }
        return flag;
    }

    public boolean eliminarSala(int id) {
        boolean flag = false;
        if (buscarSala(id) != null) {
            Sala sala = buscarSala(id);
            listSalas.remove(sala);
            flag = true;
        }
        return flag;
    }


    //CRUD CITA MEDICA
    //Asignar consultorio/sala a una cita
    public boolean agregarSalaCita(CitaMedica citaMedica) {
        boolean flag = false;
        for (Sala sala : listSalas) {
            if (sala.getMedico().equals(citaMedica.getProfesional())) {
                citaMedica.setConsultorio(sala);
                flag = true;
                break;
            }
        }
        return flag;
    }



    //crear cita
    public boolean crearCita(int idPaciente, Especialidad especialidad, DayOfWeek dia, LocalTime horaInicio) {
        boolean flag = false;
        Paciente paciente = null;
        if (buscarPaciente(idPaciente) != null) {
            paciente = buscarPaciente(idPaciente);
            for (Medico medico : listMedicos) {
                if (medico.getHorarioDisponible().containsKey(dia) && horaDentroDeHorario(horaInicio,medico,dia) == true && especialidad.equals(medico.getEspecialidad()) && medicoDisponible(medico,horaInicio, dia)==true ){
                    CitaMedica nuevaCita= new CitaMedica(paciente,dia,horaInicio,medico,especialidad);
                    agregarSalaCita(nuevaCita);
                    listCitas.add(nuevaCita);
                    nuevaCita.setAutorizacion(listCitas.size()+1);
                    flag = true;
                }
            }
        } return flag;
    }



    public boolean cancelarCita(int autorizacion) {
        boolean flag = false;
        if(buscarCita(autorizacion) != null) {
            CitaMedica cita = buscarCita(autorizacion);
            listCitas.remove(cita);
            flag = true;
        }return flag;
    }




    public boolean medicoDisponible(Medico medico, LocalTime horaInicio, DayOfWeek dia) {
        boolean flag = false;
        ArrayList<CitaMedica> listCitasChoque = new ArrayList();
        for (CitaMedica citaMedica : listCitasChoque) {
            if (citaMedica.getProfesional().equals(medico) && horaInicio.equals(citaMedica.getHoraInicio()) && citaMedica.getDiaSemana().equals(dia)) {
                listCitasChoque.add(citaMedica);
            }
        }
        if (listCitasChoque.isEmpty()) {
            flag = true;
        }
        return flag;
    }


    public boolean horaDentroDeHorario (LocalTime hora, Medico medico, DayOfWeek dia) {
        boolean flag = false;
        Horario horarioTemp = medico.getHorarioDisponible().get(dia);
        if (hora.isAfter(horarioTemp.getInicio()) && hora.isBefore(horarioTemp.getFin())) {
            flag = true;
        }return flag;
    }


}

