package edu.unl.cc.taller6;

import edu.unl.cc.taller6.algoritmos.*;
import edu.unl.cc.taller6.modelos.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para ejecutar benchmarks de algoritmos de ordenamiento
 */
public class BenchmarkOrdenamiento {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    
    public static void main(String[] args) {
        System.out.println("=== BENCHMARK DE ALGORITMOS DE ORDENAMIENTO ===\n");
        
        // Benchmark 1: citas_100.csv (aleatorio)
        System.out.println("[1] Dataset: citas_100.csv (aleatorio)");
        benchmarkCitas("citas_100.csv");
        
        // Benchmark 2: citas_100_casi_ordenadas.csv (casi ordenado)
        System.out.println("\n[2] Dataset: citas_100_casi_ordenadas.csv (casi ordenado)");
        benchmarkCitas("citas_100_casi_ordenadas.csv");
        
        // Benchmark 3: pacientes_500.csv (muchos duplicados)
        System.out.println("\n[3] Dataset: pacientes_500.csv (muchos duplicados)");
        benchmarkPacientes("pacientes_500.csv");
        
        // Benchmark 4: inventario_500_inverso.csv (orden inverso)
        System.out.println("\n[4] Dataset: inventario_500_inverso.csv (orden inverso)");
        benchmarkInventario("inventario_500_inverso.csv");
        
        System.out.println("\n=== BENCHMARK COMPLETADO ===");
    }
    
    private static void benchmarkCitas(String archivo) {
        List<Cita> citas = cargarCitas(archivo);
        
        // Inserción
        List<Cita> copiaInsercion = new ArrayList<>(citas);
        long inicioInsercion = System.nanoTime();
        OrdenamientoInsercion.ordenar(copiaInsercion);
        long tiempoInsercion = System.nanoTime() - inicioInsercion;
        
        // QuickSort
        List<Cita> copiaQuick = new ArrayList<>(citas);
        long inicioQuick = System.nanoTime();
        OrdenamientoQuickSort.ordenar(copiaQuick);
        long tiempoQuick = System.nanoTime() - inicioQuick;
        
        // MergeSort
        List<Cita> copiaMerge = new ArrayList<>(citas);
        long inicioMerge = System.nanoTime();
        OrdenamientoMergeSort.ordenar(copiaMerge);
        long tiempoMerge = System.nanoTime() - inicioMerge;
        
        imprimirResultados(citas.size(), tiempoInsercion, tiempoQuick, tiempoMerge);
    }
    
    private static void benchmarkPacientes(String archivo) {
        List<Paciente> pacientes = cargarPacientes(archivo);
        
        // Inserción
        List<Paciente> copiaInsercion = new ArrayList<>(pacientes);
        long inicioInsercion = System.nanoTime();
        OrdenamientoInsercion.ordenar(copiaInsercion);
        long tiempoInsercion = System.nanoTime() - inicioInsercion;
        
        // QuickSort
        List<Paciente> copiaQuick = new ArrayList<>(pacientes);
        long inicioQuick = System.nanoTime();
        OrdenamientoQuickSort.ordenar(copiaQuick);
        long tiempoQuick = System.nanoTime() - inicioQuick;
        
        // MergeSort
        List<Paciente> copiaMerge = new ArrayList<>(pacientes);
        long inicioMerge = System.nanoTime();
        OrdenamientoMergeSort.ordenar(copiaMerge);
        long tiempoMerge = System.nanoTime() - inicioMerge;
        
        imprimirResultados(pacientes.size(), tiempoInsercion, tiempoQuick, tiempoMerge);
    }
    
    private static void benchmarkInventario(String archivo) {
        List<ItemInventario> items = cargarInventario(archivo);
        
        // Inserción
        List<ItemInventario> copiaInsercion = new ArrayList<>(items);
        long inicioInsercion = System.nanoTime();
        OrdenamientoInsercion.ordenar(copiaInsercion);
        long tiempoInsercion = System.nanoTime() - inicioInsercion;
        
        // QuickSort
        List<ItemInventario> copiaQuick = new ArrayList<>(items);
        long inicioQuick = System.nanoTime();
        OrdenamientoQuickSort.ordenar(copiaQuick);
        long tiempoQuick = System.nanoTime() - inicioQuick;
        
        // MergeSort
        List<ItemInventario> copiaMerge = new ArrayList<>(items);
        long inicioMerge = System.nanoTime();
        OrdenamientoMergeSort.ordenar(copiaMerge);
        long tiempoMerge = System.nanoTime() - inicioMerge;
        
        imprimirResultados(items.size(), tiempoInsercion, tiempoQuick, tiempoMerge);
    }
    
    private static void imprimirResultados(int tamaño, long insercion, long quick, long merge) {
        System.out.printf("  Tamaño: %d registros\n", tamaño);
        System.out.printf("  Inserción:  %10.3f ms\n", insercion / 1_000_000.0);
        System.out.printf("  QuickSort:  %10.3f ms\n", quick / 1_000_000.0);
        System.out.printf("  MergeSort:  %10.3f ms\n", merge / 1_000_000.0);
    }
    
    private static List<Cita> cargarCitas(String archivo) {
        List<Cita> citas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine(); // Skip header
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                LocalDateTime fechaHora = LocalDateTime.parse(partes[2], FORMATTER);
                citas.add(new Cita(partes[0], partes[1], fechaHora));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar " + archivo + ": " + e.getMessage());
        }
        return citas;
    }
    
    private static List<Paciente> cargarPacientes(String archivo) {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine(); // Skip header
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                pacientes.add(new Paciente(partes[0], partes[1], Integer.parseInt(partes[2])));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar " + archivo + ": " + e.getMessage());
        }
        return pacientes;
    }
    
    private static List<ItemInventario> cargarInventario(String archivo) {
        List<ItemInventario> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine(); // Skip header
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                items.add(new ItemInventario(partes[0], partes[1], Integer.parseInt(partes[2])));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar " + archivo + ": " + e.getMessage());
        }
        return items;
    }
}
