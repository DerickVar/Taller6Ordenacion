package edu.unl.cc.taller6.generadores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generador de citas_100.csv
 * 100 citas médicas con id;apellido;fechaHora
 * En la semilla: 42
 */
public class GeneradorCitas100 {
    
    private static final String[] APELLIDOS = {
        "García", "Rodríguez", "Martínez", "López", "González",
        "Pérez", "Sánchez", "Ramírez", "Torres", "Flores",
        "Rivera", "Gómez", "Díaz", "Cruz", "Morales",
        "Reyes", "Gutiérrez", "Ortiz", "Chávez", "Ruiz",
        "Jiménez", "Hernández", "Mendoza", "Castillo", "Vargas",
        "Romero", "Guerrero", "Naranjo", "Cedeño", "Medina"
    };
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    
    public static void generar(String nombreArchivo) {
        Random random = new Random(42); // Esta e la semilla 42
        List<String> lineas = new ArrayList<>();
        
        // El encabezado osea el inicio del archivo
        lineas.add("id;apellido;fechaHora");
        
        // Generador de 100 citas
        for (int i = 1; i <= 100; i++) {
            String id = String.format("CITA-%03d", i);
            String apellido = APELLIDOS[random.nextInt(APELLIDOS.length)];
            LocalDateTime fechaHora = generarFechaHoraAleatoria(random);
            
            String linea = String.format("%s;%s;%s", 
                id, 
                apellido, 
                fechaHora.format(FORMATTER)
            );
            lineas.add(linea);
        }
        
        // Escribir archivo
        escribirArchivo(nombreArchivo, lineas);
        System.out.println("✓ Generado: " + nombreArchivo + " (100 registros)");
    }
    
    private static LocalDateTime generarFechaHoraAleatoria(Random random) {

        int dia = 1 + random.nextInt(31); // 1-31
        int hora = 8 + random.nextInt(11); // 8-18
        int minuto = random.nextInt(60); // 0-59
        
        return LocalDateTime.of(2025, 3, dia, hora, minuto);
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
