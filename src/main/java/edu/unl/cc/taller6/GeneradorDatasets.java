package edu.unl.cc.taller6;

import edu.unl.cc.taller6.generadores.*;

/**
 * Clase principal para generar todos los datasets del Taller 6
 * Ejecuta todos los generadores con semilla 42
 */
public class GeneradorDatasets {
    
    public static void main(String[] args) {
        System.out.println("=== GENERADOR DE DATASETS - TALLER 6 ===");
        System.out.println("Semilla aleatoria: 42\n");
        
        // 1. Generar citas_100.csv
        System.out.println("[1/4] Generando citas_100.csv...");
        GeneradorCitas100.generar("citas_100.csv");
        
        // 2. Generar citas_100_casi_ordenadas.csv
        System.out.println("\n[2/4] Generando citas_100_casi_ordenadas.csv...");
        GeneradorCitasCasiOrdenadas.generar("citas_100.csv", "citas_100_casi_ordenadas.csv");
        
        // 3. Generar pacientes_500.csv
        System.out.println("\n[3/4] Generando pacientes_500.csv...");
        GeneradorPacientes500.generar("pacientes_500.csv");
        
        // 4. Generar inventario_500_inverso.csv
        System.out.println("\n[4/4] Generando inventario_500_inverso.csv...");
        GeneradorInventario500.generar("inventario_500_inverso.csv");
        
        System.out.println("\n=== DATASETS GENERADOS EXITOSAMENTE ===");
        System.out.println("Archivos creados:");
        System.out.println("  ✓ citas_100.csv");
        System.out.println("  ✓ citas_100_casi_ordenadas.csv");
        System.out.println("  ✓ pacientes_500.csv");
        System.out.println("  ✓ inventario_500_inverso.csv");
    }
}
