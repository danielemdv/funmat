# funmat

_Porque nos fascinan los autómatas, las cosas bonitas y la vida._

## Cómo correr el código:

### Compilar:

Correr el script para Compilar

    bash compileAll.sh

Esto debería compilar el código fuente en la carpeta code.
(Este script se debe de ir actualizando)


### Depurar o limpiar código compilado

Es importante limpiar el código compilado para no agregarlo al repositorio,
como son archivos binarios y además pueden ser de distinitas versiones, no es algo
que nos conviene tener.

Esto se hace con el script para Depurar

    bash cleanUp.sh

Este script borra todos los archivos .class del directorio code.


### Correr el código

En el directorio code se debe ejecutar

    java nombreDelArchivo

para poder ejecutar el _main method_ de esa clase.
