package co.edu.uniquindio.hospital.test;

import co.edu.uniquindio.hospital.model.Especialidad;
import co.edu.uniquindio.hospital.model.Hospital;
import co.edu.uniquindio.hospital.model.Medico;
import co.edu.uniquindio.hospital.model.Paciente;
import co.edu.uniquindio.hospital.model.CitaMedica;
import co.edu.uniquindio.hospital.model.Sala;
import co.edu.uniquindio.hospital.model.TipoProcedimiento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
        Boolean resultado = hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        assertTrue(resultado);
        LOG.info("Fin prueba de funcionalidad crear paciente");
    }

    @Test
    @DisplayName("Prueba de funcionalidad del metodo crear Medico")
    public void testCrearMedico() {
        LOG.info("Inicio prueba de funcionalidad crear medico");
        Hospital hospital = new Hospital("Hospital1");
        Boolean resultado =  hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        assertTrue(resultado);
        LOG.info("Fin prueba de funcionalidad crear medico");
    }

    @Test
    @DisplayName("Prueba de funcionalidad del metodo modificarHorario")
    public void testModificarHorario() {
        LOG.info("Inicio prueba de funcionalidad modificar horario");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        Boolean resultado = hospital.modificarHorario("12", DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));
        assertTrue(resultado);
        LOG.info("Fin prueba de funcionalidad modificar horario");
    }

    @Test
    @DisplayName("Prueba de funcionalidad del metodo mostrarHorario")
    public void testMostrarHorario() {
        LOG.info("Inicio prueba de funcionalidad mostrar horario");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario("12", DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));

        Medico medicobuscar = hospital.buscarMedico("12");
        Map resultadoEsperado= medicobuscar.getHorarioDisponible();

        Map resultado = hospital.mostrarHorario("12");
        assertEquals(resultadoEsperado,resultado);
        LOG.info("Fin prueba de funcionalidad mostrar horario");
    }


    @Test
    @DisplayName("Prueba de funcionalidad metodo crearCita")
    public void testCrearCita() {
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario("12", DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));

        boolean resultado= hospital.crearCita("1",Especialidad.GENERAL,DayOfWeek.MONDAY,LocalTime.of(7,10));

        assertTrue(resultado);

    }


    @Test
    @DisplayName("Prueba de funcionalidad metodo buscarUltimaCitaMedica")
    public void testBuscarUltimaCitaMedica() {
        LOG.info("Inicio prueba de funcionalidad buscarUltimaCitaMedica");
        LOG.info(" Inicio Prueba de funcionalidad crearCita");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario("12", DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));

        hospital.crearCita("1",Especialidad.GENERAL,DayOfWeek.MONDAY,LocalTime.of(7,10));

        CitaMedica esperado = hospital.buscarCita(1);
        CitaMedica resultado = hospital.buscarUltimaCitaMedica();

        assertEquals(esperado,resultado);
        LOG.info("Fin prueba de funcionalidad buscarUltimaCitaMedica");
    }

    @Test
    @DisplayName("Prueba de funcionalidad metodo buscarCita")
    public void testBuscarCita() {
        LOG.info("Inicio prueba de funcionalidad buscarCita");
        LOG.info(" Inicio Prueba de funcionalidad crearCita");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario("12", DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));

        hospital.crearCita("1",Especialidad.GENERAL,DayOfWeek.MONDAY,LocalTime.of(7,10));

        CitaMedica resultado = hospital.buscarCita(1);
        CitaMedica resultadoEsperado = hospital.buscarUltimaCitaMedica();

        assertEquals(resultado,resultadoEsperado);
        LOG.info("Fin prueba de funcionalidad buscarCita");
    }

    @Test
    @DisplayName("Prueba de funcionalidad buscarMedico")
    public void testBuscarMedico() {
        LOG.info("Inicio prueba de funcionalidad buscarMedico");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        Medico medicoEsperado = null;
        ArrayList<Medico> listTemp= hospital.getListMedicos();
        for(Medico medico: listTemp){
            if(medico.getNombre().equalsIgnoreCase("lina")){
                medicoEsperado = medico;
                break;
            }
        }
        Medico resultado = hospital.buscarMedico("12");
        assertEquals(medicoEsperado,resultado);
        LOG.info("Fin Prueba de funcionalidad buscarMedico|");
    }

    @Test
    @DisplayName("Prueba de funcionalidad buscarPaciente")
    public void testBuscarPaciente() {
        LOG.info("Inicio prueba buscarPaciente");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        Paciente pacienteEsperado = null;
        ArrayList<Paciente> listTemp= hospital.getListPacientes();
        for(Paciente paciente: listTemp){
            if(paciente.getNombre().equalsIgnoreCase("luis")){
                pacienteEsperado = paciente;
                break;
            }
        }
        Paciente resultado = hospital.buscarPaciente("1");
        assertEquals(pacienteEsperado,resultado);
        LOG.info("Fin prueba de buscarPaciente");
    }

    @Test
    @DisplayName("Prueba de fucncionalidad crearSala")
    public void testCrearSala() {
        LOG.info("Inicio prueba de fucncionalidad crearSala");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        Boolean resultado = hospital.crearSala(1,"12");
        assertTrue(resultado);
        LOG.info("Fin prueba de fucncionalidad crearSala");
    }

    @Test
    @DisplayName("Prueba de funcionalidad buscarSala")
    public void testBuscarSala() {
        LOG.info("Inicio prueba de funcionalidad buscarSala");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.crearSala(1,"12");
        Sala salaEsperado=null;
        Sala resultado = hospital.buscarSala(1);
        ArrayList<Sala> listTemp= hospital.getListSalas();
        for(Sala sala: listTemp){
            if(sala.getNumeroSala() == 1){
                salaEsperado = sala;
                break;
            }
        }
        assertEquals(salaEsperado,resultado);
        LOG.info("Fin prueba de funcionalidad buscarSala");
    }

    @Test
    @DisplayName("Prueba de funcionalidad cancelarCita")
    public void testCancelarCita() {
        LOG.info("Inicio prueba de funcionalidad cancelarCita");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        hospital.modificarHorario("12", DayOfWeek.MONDAY, LocalTime.of(7,00), LocalTime.of(12,00));
        hospital.crearCita("1",Especialidad.GENERAL,DayOfWeek.MONDAY,LocalTime.of(7,10));
        CitaMedica cita = hospital.buscarUltimaCitaMedica();
        int citaAutorizacio = cita.getAutorizacion();

        Boolean resultado = hospital.cancelarCita(citaAutorizacio);
        assertTrue(resultado);
        LOG.info("Fin prueba de funcionalidad cancelarCita");
    }

    @Test
    @DisplayName("Prueba de funcionalidad crearProcediminto")
    public void testCrearProcediminto() {
        LOG.info("Inicio prueba crearProcediminto");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        Boolean resultado = hospital.crearProcedimiento("1",TipoProcedimiento.DIAGNOSTICO,"Fiebre","12");
        assertTrue(resultado);
        LOG.info("Fin prueba crearProcediminto");
    }

    @Test
    @DisplayName("Prueba de funcionalidad eliminarPaciente")
    public void testEliminarPaciente() {
        LOG.info("Inicio prueba eliminarPaciente");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearPaciente("1", "Luis", "314288", "luis@", "cra18",LocalDate.of(2000,02,5));
        Boolean resultado = hospital.eliminarPaciente("1");
        assertTrue(resultado);
        LOG.info("Fin prueba eliminarPaciente");
    }

    @Test
    @DisplayName("Prueba de funcionalidad eliminarMedico")
    public void testEliminarMedico() {
        LOG.info("Inicio prueba eliminarMedico");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        Boolean resultado = hospital.eliminarMedico("12");
        LOG.info("Fin prueba eliminarMedico");
    }

    @Test
    @DisplayName("Prueba funcionalidad iniciarCesionGeneral")
    public void testIniciarCesionGeneral() {
        LOG.info("Inicio prueba iniciarCesionGeneral");
        Hospital hospital = new Hospital("Hospital1");
        hospital.crearMedico("12","lina", "314555", "lina@", "cra 16", LocalDate.of(2000,02,04), Especialidad.GENERAL);
        Boolean resultado = hospital.iniciarCesionGeneral("12","lina@");
        assertTrue(resultado);
    }


}
