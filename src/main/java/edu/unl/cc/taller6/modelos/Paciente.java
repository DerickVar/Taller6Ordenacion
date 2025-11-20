package edu.unl.cc.taller6.modelos;

/**
 * Modelo para representar un paciente
 */
public class Paciente implements Comparable<Paciente> {
    private String id;
    private String apellido;
    private int prioridad;
    
    public Paciente(String id, String apellido, int prioridad) {
        this.id = id;
        this.apellido = apellido;
        this.prioridad = prioridad;
    }
    
    public String getId() { return id; }
    public String getApellido() { return apellido; }
    public int getPrioridad() { return prioridad; }
    
    @Override
    public int compareTo(Paciente otro) {
        // Comparamos por el apellido
        return this.apellido.compareTo(otro.apellido);
    }
    
    @Override
    public String toString() {
        return id + ";" + apellido + ";" + prioridad;
    }
}
