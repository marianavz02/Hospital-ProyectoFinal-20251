package co.edu.uniquindio.hospital.model;

public class Sala {
    private int numeroSala;
    private Medico medico;

    public Sala(int numeroSala, Medico medico) {
        this.numeroSala = numeroSala;
        this.medico = medico;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "numeroSala=" + numeroSala +
                ", medico=" + medico +
                '}';
    }
}
