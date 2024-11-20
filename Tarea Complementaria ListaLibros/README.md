# Ejercicio: Creación de base de datos con Java

## Descripción

Usando Java, se pide crear una base de datos llamada `listaLibros` que contenga una tabla `libros` con los siguientes atributos:

- **id**: de tipo `serial` y será la clave primaria.
- **titulo**: de tipo `cadena de texto`.
- **autor**: de tipo `Autor`.
- **año_publicacion**: de tipo `entero`.

Además, se deberá crear un tipo `Autor` con la siguiente estructura:

- **nombre_autor**: de tipo `cadena de texto`.
- **fecha**: de tipo `varchar`.

Se utilizará Java para la creación de dicha tabla.

## Funcionalidades

El programa debe permitir las siguientes operaciones:

1. **Insertar datos**: Insertar un libro con los detalles requeridos en la tabla `libros`.
2. **Consultar datos**: Consultar todos los libros registrados en la base de datos.
3. **Actualizar datos**: Actualizar los detalles de un libro específico por su `id`.
4. **Eliminar datos**: Eliminar un libro de la tabla `libros` por su `id`.

