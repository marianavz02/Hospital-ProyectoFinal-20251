package co.edu.uniquindio.hospital.test;

import co.edu.uniquindio.hospital.model.Especialidad;
import co.edu.uniquindio.hospital.model.Hospital;
import co.edu.uniquindio.hospital.model.Medico;
import co.edu.uniquindio.hospital.model.Paciente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;


public class HospitalTest {
    /**
     * Instancia para el manejo de logs
     */

    private static final Logger LOG = Logger.getLogger(HospitalTest.class.getName());



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


}
