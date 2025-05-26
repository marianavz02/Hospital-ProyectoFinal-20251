package co.edu.uniquindio.hospital.viewController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.hospital.App;
import co.edu.uniquindio.hospital.controller.LoginController;
import co.edu.uniquindio.hospital.model.Hospital;
import co.edu.uniquindio.hospital.controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.testng.reporters.jq.Main;

import javax.swing.*;


public class LoginViewController {
    App app;
    LoginController loginController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtEmail;

    @FXML
    void click(ActionEvent event) {
        Object clicked = event.getSource();

        if (clicked == btnIngresar) {
            if(!txtEmail.getText().isEmpty() && !txtContraseña.getText().isEmpty()) {
                String email = txtEmail.getText();
                String contraseña = txtContraseña.getText();
                if(loginController.iniciarCesionGeneral(email,contraseña) == true){
                    //app.Open
                }

            }else{
                JOptionPane.showMessageDialog(null, "Los datos son incorrectos", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        } else if (clicked == btnVolver) {
            app.openHospital();

        }

    }


    @FXML
    void escribir(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnVolver != null : "fx:id=\"btnVolver\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtContraseña != null : "fx:id=\"txtContraseña\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Login.fxml'.";

    }

    public void setApp(App app) {
        this.app = app;
    }



}


