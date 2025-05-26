package co.edu.uniquindio.hospital.controller;

import co.edu.uniquindio.hospital.model.Hospital;

public class LoginController {

    Hospital hospital;

    public LoginController(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean iniciarCesionGeneral(String id, String email) {
        return hospital.iniciarCesionGeneral(id, email);
    }

    public boolean iniciarCesionAdmin(String id, String email) {
        return hospital.iniciarCesionAdmin(id, email);
    }



}


