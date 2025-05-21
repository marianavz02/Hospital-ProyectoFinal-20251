package co.edu.uniquindio.hospital.model;

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
}
