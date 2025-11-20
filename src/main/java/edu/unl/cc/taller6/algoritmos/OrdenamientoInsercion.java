package edu.unl.cc.taller6.algoritmos;

import java.util.List;

/**
 * Algoritmo de ordenamiento por Inserción
 * Complejidad: O(n²) peor caso, O(n) mejor caso (casi ordenado)
 * Estable: SÍ
 */
public class OrdenamientoInsercion {
    
    public static <T extends Comparable<T>> void ordenar(List<T> lista) {
        for (int i = 1; i < lista.size(); i++) {
            T clave = lista.get(i);
            int j = i - 1;
            
            while (j >= 0 && lista.get(j).compareTo(clave) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, clave);
        }
    }
}
