
# Ejercicio práctico guiado: Acceso a datos con Java utilizando MySQL

En este ejercicio aprenderás cómo realizar acceso a datos en Java utilizando MySQL y JDBC (Java Database Connectivity). Utilizaremos JDBC para conectarnos a una base de datos MySQL y ejecutar operaciones básicas como insertar y consultar datos.

## Requisitos previos

1. **JDK**: Asegúrate de tener instalado el JDK de Java. Si no lo tienes, puedes descargarlo desde el sitio web oficial de Oracle.
2. **MySQL**: Debes tener MySQL instalado y en funcionamiento. Si aún no lo tienes, puedes descargarlo desde el sitio oficial de MySQL.
3. **MySQL Connector/J**: Necesitarás el controlador JDBC de MySQL. Puedes descargarlo desde el siguiente enlace: [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/). Agrega el archivo `.jar` a tu proyecto para poder usarlo.

## Crear base de datos y tabla

Primero, debes crear una base de datos y una tabla en MySQL. Puedes utilizar el siguiente script SQL para configurarlo:

```sql
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS mi_base_de_datos;

-- Usar la base de datos recién creada
USE mi_base_de_datos;

-- Crear la tabla
CREATE TABLE IF NOT EXISTS mi_tabla (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Insertar algunos datos de ejemplo
INSERT INTO mi_tabla (id, nombre) VALUES (1, 'EjemploNombre1');
INSERT INTO mi_tabla (id, nombre) VALUES (2, 'EjemploNombre2');
INSERT INTO mi_tabla (id, nombre) VALUES (3, 'EjemploNombre3');

Y ahora os dejo el ejemplo para replicar:


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AccesoDatosEjemplo {
// Configuración de la conexión a MySQL
private static final String URL =
"jdbc:mysql://localhost:3306/mi_base_de_datos";
private static final String USUARIO = "tu_usuario";
private static final String CONTRASEÑA = "tu_contraseña";
public static void main(String[] args) {
Connection conexion = null;
try {
// Paso 1: Cargar el controlador JDBC
Class.forName("com.mysql.cj.jdbc.Driver");
// Paso 2: Establecer la conexión con la base de datos
conexion = DriverManager.getConnection(URL, USUARIO,
CONTRASEÑA);
// Ejemplo 1: Insertar datos
insertarDatos(conexion, 1, "EjemploNombre");
// Ejemplo 2: Consultar datos
consultarDatos(conexion);
} catch (ClassNotFoundException | SQLException e) {
e.printStackTrace();
} finally {
// Cerrar la conexión en el bloque finally para
asegurarse de que siempre se cierre
if (conexion != null) {
try {
conexion.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}
}
// Método para insertar datos en la tabla
private static void insertarDatos(Connection conexion, int id,
String nombre) throws SQLException {
String sql = "INSERT INTO mi_tabla (id, nombre) VALUES (?,
?)";
try (PreparedStatement statement =
conexion.prepareStatement(sql)) {
statement.setInt(1, id);
statement.setString(2, nombre);
statement.executeUpdate();
System.out.println("Datos insertados correctamente.");
}
}
// Método para consultar datos en la tabla
private static void consultarDatos(Connection conexion) throws
SQLException {
String sql = "SELECT * FROM mi_tabla";
try (PreparedStatement statement =
conexion.prepareStatement(sql);
ResultSet resultSet = statement.executeQuery()) {
while (resultSet.next()) {
int id = resultSet.getInt("id");
String nombre = resultSet.getString("nombre");
System.out.println("ID: " + id + ", Nombre: " +
nombre);
}
}
}
}

Aseguraros de reemplazar "tu_usuario" y "tu_contraseña" con las credenciales de tu base
de datos
```
