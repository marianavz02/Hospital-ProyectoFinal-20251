package co.edu.uniquindio.hospital.test;

import co.edu.uniquindio.hospital.model.Especialidad;
import co.edu.uniquindio.hospital.model.Hospital;
import co.edu.uniquindio.hospital.model.Medico;
import co.edu.uniquindio.hospital.model.Paciente;
import co.edu.uniquindio.hospital.model.CitaMedica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;


public class HospitalTest {
    /**
     * Instancia para el manejo de logs
     */

    private static final Logger LOG = Logger.getLogger(HospitalTest.class.getName());


    @Test
    @DisplayName("Prueba de funcionalidad metodo crear paciente")
    public void testCrearPaciente() {
        LOG.info("Inicio prueba de funcionalidad crear paciente");
        Hospital hospital = new Hospital("Hospital1");
        Boolean resultado = hospital.crearPaciente(1, "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        assertTrue(resultado);
        LOG.info("Fin prueba de funcionalidad crear paciente");
    }

    @Test
    @DisplayName("Prueba de funcionalidad del metodo crear Medico")
    public void testCrearMedico() {
        LOG.info("Inicio prueba de funcionalidad crear medico");
        Hospital hospital = new Hospital("Hospital1");
        Boolean resultado =  hospital.crearMedico(12,"lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        assertTrue(resultado);
        LOG.info("Fin prueba de funcionalidad crear medico");
    }

    @Test
    @DisplayName("Prueba de funcionalidad del metodo modificarHorario")
    public void testModificarHorario() {
        LOG.info("Inicio prueba de funcionalidad modificar horario");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearMedico(12,"lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        Boolean resultado = hospital.modificarHorario(12, DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));
        assertTrue(resultado);
        LOG.info("Fin prueba de funcionalidad modificar horario");
    }

    @Test
    @DisplayName("Prueba de funcionalidad del metodo mostrarHorario")
    public void testMostrarHorario() {
        LOG.info("Inicio prueba de funcionalidad mostrar horario");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente(1, "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico(12,"lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario(12, DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));

        Medico medicobuscar = hospital.buscarMedico(12);
        Map resultadoEsperado= medicobuscar.getHorarioDisponible();

        Map resultado = hospital.mostrarHorario(12);
        assertEquals(resultadoEsperado,resultado);
        LOG.info("Fin prueba de funcionalidad mostrar horario");
    }

    



    @Test
    @DisplayName("Prueba de funcionalidad metodo crearCita")
    public void testCrearCita() {
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente(1, "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico(12,"lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario(12, DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));

        boolean resultado= hospital.crearCita(1,Especialidad.GENERAL,DayOfWeek.MONDAY,LocalTime.of(7,10));

        assertTrue(resultado);

    }


    @Test
    @DisplayName("Prueba de funcionalidad metodo buscarUltimaCitaMedica")
    public void testBuscarUltimaCitaMedica() {
        LOG.info("Inicio prueba de funcionalidad buscarUltimaCitaMedica");
        LOG.info(" Inicio Prueba de funcionalidad crearCita");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente(1, "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico(12,"lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario(12, DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));

        hospital.crearCita(1,Especialidad.GENERAL,DayOfWeek.MONDAY,LocalTime.of(7,10));

        CitaMedica esperado = hospital.buscarCita(1);
        CitaMedica resultado = hospital.buscarUltimaCitaMedica();

        assertEquals(esperado,resultado);
        LOG.info("Fin prueba de funcionalidad buscarUltimaCitaMedica");
    }



}
