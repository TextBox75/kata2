# IS2 Kata 2

### Objetivo
El objetivo de esta kata es el de estudiar el sistema de entrada y salida de Java mediante el uso de `InputStream` y `OutputStream`, trabajando con flujos de datos procedentes tanto de URLs como de ficheros locales.

### Como compilar y ejecutar
Clonar el repositorio con `git clone https://github.com/TextBox75/kata2.git` y abrir la carpeta con IntelliJ IDEA y OpenJDK 25.
Finalmente ejecutar la clase Main. El repositorio no tiene ninguna dependencia externa.

### Estructura de la entrega
El proyecto se divide en 3 branches principales:

- Master branch: El primer microproyecto, encargado de procesar datos para contar vehículos con transmisión manual leyendo desde la fuente de datos correspondiente. La clase principal es Car.

- Titanic branch: El segundo microproyecto, encargado de leer y analizar el dataset del Titanic para calcular el número total de pasajeros que sobrevivieron. La clase principal es Passenger.

- Wine branch: El tercer microproyecto, enfocado en el análisis de datos vinícolas para contabilizar cuántos vinos cumplen con los criterios de calidad para ser considerados legítimos. La clase principal es Wine.

Todas las branches siguen una misma estructura de una definición básica de un modelo bajo el paquete software.ulpgc.katas.model
y un lector/escritor de datos a partir de URLs/ficheros que se encuentra en el paquete software.ulpgc.katas.io. Cabe mencionar que la clase principal de cada modelo solo
contiene una parte de la totalidad de los atributos que se cargan desde las fuentes de datos. Esto se hace con el propósito de simplificar el trabajo.

El main se encarga de unir todos los componentes de los microproyectos. Cada componente tiene una única responsabilidad que llevan
al cabo, ya sea la de leer datos, escribir datos o calcular atributos derivados.

Los escritores que se han implementado para cada microproyecto son dos. Un escritor de ficheros y un escritor de consola.

### Enlace al vídeo
Pendiente

### Verificación
La clase Main de cada branch instancia dos lectores, un analizador de metricas y dos escritores en ese orden.
El motivo de que hayan pares de lectores y escritores es por el hecho de que se prueba a leer datos tanto desde ficheros como URLs.
Al final del main se imprime a consola la métrica calculada a partir de las dos fuentes y también se escribe en un fichero.
El hecho de que todos los escritores escriban el mismo dato con independencia del destino de escritura significa que 
se está leyendo y procesando correctamente los datos.
