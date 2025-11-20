package edu.unl.cc.taller6.modelos;

import java.time.LocalDateTime;

/**
 * Modelo para representar una cita médica
 */
public class Cita implements Comparable<Cita> {
    private String id;
    private String apellido;
    private LocalDateTime fechaHora;
    
    public Cita(String id, String apellido, LocalDateTime fechaHora) {
        this.id = id;
        this.apellido = apellido;
        this.fechaHora = fechaHora;
    }
    
    public String getId() { return id; }
    public String getApellido() { return apellido; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    
    @Override
    public int compareTo(Cita otra) {
        return this.fechaHora.compareTo(otra.fechaHora);
    }
    
    @Override
    public String toString() {
        return id + ";" + apellido + ";" + fechaHora;
    }
}
