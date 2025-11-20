# README - Datasets del Taller 6

## Información de Generación

**Semilla Aleatoria:** 42

Todos los datasets fueron generados usando la semilla 42 para garantizar reproducibilidad.

## Datasets Generados

### 1. citas_100.csv
- **Registros:** 100
- **Formato:** id;apellido;fechaHora
- **Pool de apellidos:** ~30 apellidos comunes
- **Rango de fechas:** 2025-03-01 08:00 a 2025-03-31 18:00
- **Distribución:** Aleatoria con duplicados permitidos

### 2. citas_100_casi_ordenadas.csv
- **Registros:** 100
- **Formato:** id;apellido;fechaHora
- **Base:** Ordenado por fechaHora ascendente
- **Perturbación:** Exactamente 5 swaps (5% del total)
- **Objetivo:** Ideal para observar rendimiento de Inserción

### 3. pacientes_500.csv
- **Registros:** 500
- **Formato:** id;apellido;prioridad
- **Pool de apellidos:** ~50 apellidos
- **Distribución sesgada:** 60% frecuentes / 30% medios / 10% raros
- **Prioridad:** 1 (alta), 2 (media), 3 (baja) - aleatorio
- **Objetivo:** Observar estabilidad de algoritmos

### 4. inventario_500_inverso.csv
- **Registros:** 500
- **Formato:** id;insumo;stock
- **Orden:** Stock descendente estricto (500, 499, ..., 1)
- **Objetivo:** Peor caso para algunos algoritmos

## Validación

✓ Todos los archivos son CSV UTF-8 con separador `;`  
✓ Todos tienen encabezado  
✓ Semilla documentada = 42  
✓ citas_100_casi_ordenadas.csv tiene exactamente 5 swaps  
✓ pacientes_500.csv tiene muchos duplicados de apellido  
✓ inventario_500_inverso.csv está en orden descendente estricto  
✓ No hay filas vacías ni celdas con `;` extra
