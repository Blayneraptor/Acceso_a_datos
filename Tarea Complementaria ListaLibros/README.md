# Tarea complementaria: Herramientas de mapeo Objeto-Relacional. JPA 💻


## Descripción (MÁS ABAJO ESTÁ LA CREACIÓN DE LA TABLA DESDE SHELL SI FUERA NECESARIO...)

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


```sql

CREATE DATABASE listaLibros;
USE listaLibros;

CREATE TABLE autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_autor VARCHAR(255),
    fecha VARCHAR(50)
);

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    autor_id INT,
    ano_publicacion INT,
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);
```

