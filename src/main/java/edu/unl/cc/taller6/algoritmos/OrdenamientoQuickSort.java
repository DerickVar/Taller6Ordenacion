package edu.unl.cc.taller6.algoritmos;

import java.util.List;

/**
 * Algoritmo de ordenamiento QuickSort
 * Complejidad: O(n log n) promedio, O(n²) peor caso
 * Estable: NO
 */
public class OrdenamientoQuickSort {
    
    public static <T extends Comparable<T>> void ordenar(List<T> lista) {
        if (lista.size() <= 1) return;
        quickSort(lista, 0, lista.size() - 1);
    }
    
    private static <T extends Comparable<T>> void quickSort(List<T> lista, int bajo, int alto) {
        if (bajo < alto) {
            int pi = particionar(lista, bajo, alto);
            quickSort(lista, bajo, pi - 1);
            quickSort(lista, pi + 1, alto);
        }
    }
    
    private static <T extends Comparable<T>> int particionar(List<T> lista, int bajo, int alto) {
        T pivote = lista.get(alto);
        int i = bajo - 1;
        
        for (int j = bajo; j < alto; j++) {
            if (lista.get(j).compareTo(pivote) <= 0) {
                i++;
                intercambiar(lista, i, j);
            }
        }
        intercambiar(lista, i + 1, alto);
        return i + 1;
    }
    
    private static <T> void intercambiar(List<T> lista, int i, int j) {
        T temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}
