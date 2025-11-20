package edu.unl.cc.taller6.generadores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Generador de inventario_500_inverso.csv
 * 500 items con id;insumo;stock
 */
public class GeneradorInventario500 {
    
    private static final String[] INSUMOS = {
        "Guante Nitrilo Talla M", "Guante Nitrilo Talla S", "Guante Nitrilo Talla L",
        "Alcohol 70% 1L", "Alcohol 70% 500ml", "Alcohol Gel 1L",
        "Gasas 10x10", "Gasas 5x5", "Vendas Elásticas 10cm",
        "Jeringa 5ml", "Jeringa 10ml", "Jeringa 20ml",
        "Aguja 21G", "Aguja 23G", "Aguja 25G",
        "Mascarilla N95", "Mascarilla Quirúrgica", "Mascarilla KN95",
        "Termómetro Digital", "Estetoscopio", "Tensiómetro",
        "Suero Fisiológico 500ml", "Suero Fisiológico 1000ml", "Suero Glucosado 5%",
        "Catéter IV 18G", "Catéter IV 20G", "Catéter IV 22G",
        "Apósito Adhesivo 10x10", "Apósito Hidrocoloide", "Cinta Micropore",
        "Bata Quirúrgica", "Gorro Quirúrgico", "Cubre Zapatos",
        "Algodón 500g", "Hisopos Estériles", "Lancetas",
        "Guantes Látex M", "Guantes Látex S", "Guantes Látex L",
        "Bisturí Desechable", "Pinza Kelly", "Pinza Kocher",
        "Sonda Foley 16F", "Sonda Foley 18F", "Sonda Nasogástrica",
        "Oxímetro de Pulso", "Nebulizador", "Glucómetro"
    };
    
    public static void generar(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();
        
        // Encabezado
        lineas.add("id;insumo;stock");
        
        // Generar 500 items con stock descendente
        for (int i = 1; i <= 500; i++) {
            String id = String.format("ITEM-%04d", i);
            String insumo = INSUMOS[(i - 1) % INSUMOS.length];
            int stock = 500 - (i - 1); // 500, 499, 498, ..., 1
            
            String linea = String.format("%s;%s;%d", id, insumo, stock);
            lineas.add(linea);
        }
        
        // Escribir archivo
        escribirArchivo(nombreArchivo, lineas);
        System.out.println("✓ Generado: " + nombreArchivo + " (500 registros en orden descendente)");
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
