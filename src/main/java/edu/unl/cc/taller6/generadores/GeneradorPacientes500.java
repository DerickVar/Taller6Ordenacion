package edu.unl.cc.taller6.generadores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generador de pacientes_500.csv
 * 500 pacientes con id;apellido;prioridad
 * Muchos apellidos duplicados, prioridad 1-3
 * Semilla: 42
 */
public class GeneradorPacientes500 {
    
    // Pool de ~50 apellidos con distribución sesgada (60/30/10)
    private static final String[] APELLIDOS_FRECUENTES = {
        "Ramírez", "García", "Rodríguez", "López", "González",
        "Martínez", "Pérez", "Sánchez", "Torres", "Flores",
        "Gómez", "Díaz", "Cruz", "Morales", "Reyes",
        "Gutiérrez", "Ortiz", "Chávez", "Ruiz", "Jiménez"
    };
    
    private static final String[] APELLIDOS_MEDIOS = {
        "Hernández", "Mendoza", "Castillo", "Vargas", "Romero",
        "Guerrero", "Naranjo", "Cedeño", "Medina", "Vega",
        "Silva", "Campos", "Aguilar", "Rojas", "Mora"
    };
    
    private static final String[] APELLIDOS_RAROS = {
        "Zambrano", "Palacios", "Salazar", "Montero", "Paredes",
        "Delgado", "Espinoza", "Bravo", "Herrera", "Carrillo",
        "Arias", "Núñez", "Velasco", "Cárdenas", "Valencia"
    };
    
    public static void generar(String nombreArchivo) {
        Random random = new Random(42); // Semilla 42
        List<String> lineas = new ArrayList<>();
        
        // Encabezado
        lineas.add("id;apellido;prioridad");
        
        // Generar 500 pacientes
        for (int i = 1; i <= 500; i++) {
            String id = String.format("PAC-%04d", i);
            String apellido = seleccionarApellidoSesgado(random);
            int prioridad = 1 + random.nextInt(3); // 1, 2 o 3
            
            String linea = String.format("%s;%s;%d", id, apellido, prioridad);
            lineas.add(linea);
        }
        
        // Escribir archivo
        escribirArchivo(nombreArchivo, lineas);
        System.out.println("✓ Generado: " + nombreArchivo + " (500 registros con apellidos duplicados)");
    }
    
    private static String seleccionarApellidoSesgado(Random random) {
        int grupo = random.nextInt(100);
        
        if (grupo < 60) {
            // 60% de frecuentes
            return APELLIDOS_FRECUENTES[random.nextInt(APELLIDOS_FRECUENTES.length)];
        } else if (grupo < 90) {
            // 30% de medios
            return APELLIDOS_MEDIOS[random.nextInt(APELLIDOS_MEDIOS.length)];
        } else {
            // 10% de raros
            return APELLIDOS_RAROS[random.nextInt(APELLIDOS_RAROS.length)];
        }
    }
    
    private static void escribirArchivo(String nombreArchivo, List<String> lineas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir " + nombreArchivo + ": " + e.getMessage());
        }
    }
}
