# Taller 6 - Comparación de Algoritmos de Ordenación

Proyecto Java 21 para generar datasets y comparar algoritmos de ordenamiento.

## Datasets Generados

### 1. citas_100.csv
- **Tamaño:** 100 registros
- **Formato:** id;apellido;fechaHora
- **Semilla:** 42
- **Descripción:** Citas médicas aleatorias

### 2. citas_100_casi_ordenadas.csv
- **Tamaño:** 100 registros
- **Formato:** id;apellido;fechaHora
- **Semilla:** 42
- **Descripción:** Ordenado por fechaHora con exactamente 5 swaps (5%)

### 3. pacientes_500.csv
- **Tamaño:** 500 registros
- **Formato:** id;apellido;prioridad
- **Semilla:** 42
- **Descripción:** Muchos apellidos duplicados, prioridad 1-3

### 4. inventario_500_inverso.csv
- **Tamaño:** 500 registros
- **Formato:** id;insumo;stock
- **Descripción:** Stock en orden descendente estricto (500 a 1)

## Ejecución

```bash
# Generar todos los datasets
java -cp target/classes edu.unl.cc.taller6.GeneradorDatasets

# Ejecutar benchmarks
java -cp target/classes edu.unl.cc.taller6.BenchmarkOrdenamiento
```

## Semilla Aleatoria

Todos los datasets usan **semilla = 42** para reproducibilidad.
