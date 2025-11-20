package edu.unl.cc.taller6.generadores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Generador de citas_100_casi_ordenadas.csv
 * Parte del archivo ordenado por fechaHora y realiza exactamente 5 swaps 
 * En la semilla: 42
 */
public class GeneradorCitasCasiOrdenadas {
    
    public static void generar(String archivoOrigenOrdenado, String archivoDestino) {
        List<String> lineas = new ArrayList<>();
        
        // Leer archivo origen
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoOrigenOrdenado))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer " + archivoOrigenOrdenado + ": " + e.getMessage());
            return;
        }
        
        if (lineas.isEmpty()) {
            System.err.println("El archivo está vacío");
            return;
        }
        
        // Separamos el encabezado
        String encabezado = lineas.get(0);
        List<String> datos = lineas.subList(1, lineas.size());
        
        // ordenamos por fechaHora
        datos.sort(Comparator.comparing(linea -> {
            String[] partes = linea.split(";");
            return partes.length >= 3 ? partes[2] : "";
        }));
        
        // Realizar exactamente 5 swaps con semilla 42
        Random random = new Random(42);
        int swaps = 5;
        
        for (int i = 0; i < swaps; i++) {
            int pos1 = random.nextInt(datos.size());
            int pos2 = random.nextInt(datos.size());
            
            // Aseguramos que no sean la misma posición
            while (pos1 == pos2) {
                pos2 = random.nextInt(datos.size());
            }
            
            // Intercambiamos
            String temp = datos.get(pos1);
            datos.set(pos1, datos.get(pos2));
            datos.set(pos2, temp);
        }
        
        // Escribir archivo
        List<String> resultado = new ArrayList<>();
        resultado.add(encabezado);
        resultado.addAll(datos);
        
        escribirArchivo(archivoDestino, resultado);
        System.out.println("✓ Generado: " + archivoDestino + " (100 registros con 5 swaps)");
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
