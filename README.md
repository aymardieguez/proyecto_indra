# Portal de eventos sostenibles

Este es un documento en el que explicaré brevemente cada parte del proyecto.

## Lenguaje de marcas

Contamos con una página web con un carrusel de imágenes en el que hay un link para cada evento por si quieres más información del mismo.
En la parte superior izquierda se encuentra el logo de nuestro portal (que en las demás páginas servirá como un link a la página principal) y a la derecha contamos con un link que nos lleva directamente 
al listado de todos los eventos.

En esa página tenemos un buscador y una lista con los eventos y una breve descripción, acompañada de un botón "Ver más" el cuál ampliará la cantidad de información por cada evento.

Cada evento cuenta con un carrusel de imágenes temáticas del mismo y varias cajas de texto "Descripción", "Ubicación" (con un link a la ubicación exacta), "Organizador" y "Contacto".

Además todas las páginas cuentan en la parte inferior izquierda con un botón de retroceso a la página padre.

Puedes consultar la página [aqui](/html/index.html).


## Bases de datos

La creación del diseño de base de datos se encuentra en la carpeta doc ([diseño](/doc/dbdesign/dbdesign.pdf)) y las especificaciones de las tablas con sus atributos también ([tablas](/doc/dbdesign/dbtables.pdf)).

En cuánto al código, ha sido realizado con Transact-SQL; se han requerido las tablas: organizadores, ubicaciones, categorías, eventos, usuarios e inscriben.

## Programación

En programación he usado Java y he decidido crear las clases Categoría, Evento, Organizador, Ubicación y Usuario.

Además, he añadido un main (que no contiene todos los métodos de todas las clases) para probar algunas funcionalidades de las clases y comprobar su correcto funcionamiento.

He utilizado mapas para guardar y almacenar los datos, también he realizado unos cuántos tests para verificar el comportamiento del programa.
## Doc

En esta carpeta he subido diferente documentación como la instalación de la Máquina Virtual Windows 10, el diseño de la base de datos, el grafo de ramas...

