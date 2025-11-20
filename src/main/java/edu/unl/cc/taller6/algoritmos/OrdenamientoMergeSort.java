package edu.unl.cc.taller6.algoritmos;

import java.util.List;

/**
 * Algoritmo de ordenamiento MergeSort
 * Estable: SÍ
 */
public class OrdenamientoMergeSort {
    
    public static <T extends Comparable<T>> void ordenar(List<T> lista) {
        if (lista.size() <= 1) return;
        mergeSort(lista, 0, lista.size() - 1);
    }
    
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void mergeSort(List<T> lista, int izq, int der) {
        if (izq < der) {
            int medio = izq + (der - izq) / 2;
            mergeSort(lista, izq, medio);
            mergeSort(lista, medio + 1, der);
            merge(lista, izq, medio, der);
        }
    }
    
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(List<T> lista, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;
        
        Object[] izqArray = new Object[n1];
        Object[] derArray = new Object[n2];
        
        for (int i = 0; i < n1; i++) {
            izqArray[i] = lista.get(izq + i);
        }
        for (int j = 0; j < n2; j++) {
            derArray[j] = lista.get(medio + 1 + j);
        }
        
        int i = 0, j = 0, k = izq;
        
        while (i < n1 && j < n2) {
            T elem1 = (T) izqArray[i];
            T elem2 = (T) derArray[j];
            
            if (elem1.compareTo(elem2) <= 0) {
                lista.set(k, elem1);
                i++;
            } else {
                lista.set(k, elem2);
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            lista.set(k, (T) izqArray[i]);
            i++;
            k++;
        }
        
        while (j < n2) {
            lista.set(k, (T) derArray[j]);
            j++;
            k++;
        }
    }
}
