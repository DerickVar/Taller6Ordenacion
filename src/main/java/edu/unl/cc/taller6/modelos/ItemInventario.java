package edu.unl.cc.taller6.modelos;

/**
 * Modelo para representar un item de inventario
 */
public class ItemInventario implements Comparable<ItemInventario> {
    private String id;
    private String insumo;
    private int stock;
    
    public ItemInventario(String id, String insumo, int stock) {
        this.id = id;
        this.insumo = insumo;
        this.stock = stock;
    }
    
    public String getId() { return id; }
    public String getInsumo() { return insumo; }
    public int getStock() { return stock; }
    
    @Override
    public int compareTo(ItemInventario otro) {
        // Comparar por stock ascendente
        return Integer.compare(this.stock, otro.stock);
    }
    
    @Override
    public String toString() {
        return id + ";" + insumo + ";" + stock;
    }
}
