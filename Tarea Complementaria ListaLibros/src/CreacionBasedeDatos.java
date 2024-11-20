import java.sql.*;

public class CreacionBasedeDatos {

    public static void main(String[] args) {
        // URL de conexión para MySQL
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root"; // Asegúrate de usar el usuario correcto
        String contraseña = ""; // Asegúrate de usar la contraseña correcta
        
        // El código para crear la base de datos y las tablas
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conn.createStatement()) {

            // Crear la base de datos
            String sqlCrearBaseDeDatos = "CREATE DATABASE IF NOT EXISTS listaLibros";
            stmt.executeUpdate(sqlCrearBaseDeDatos);
            System.out.println("Base de datos 'listaLibros' creada o ya existente.");

            // Usar la base de datos
            stmt.executeUpdate("USE listaLibros");

            // Crear la tabla 'autor'
            String sqlCrearAutor = "CREATE TABLE IF NOT EXISTS autor ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre_autor VARCHAR(255), "
                    + "fecha VARCHAR(50)"
                    + ")";
            stmt.executeUpdate(sqlCrearAutor);
            System.out.println("Tabla 'autor' creada.");

            // Crear la tabla 'libros'
            String sqlCrearLibros = "CREATE TABLE IF NOT EXISTS libros ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "titulo VARCHAR(255), "
                    + "autor_id INT, "
                    + "ano_publicacion INT, "
                    + "FOREIGN KEY (autor_id) REFERENCES autor(id)"
                    + ")";
            stmt.executeUpdate(sqlCrearLibros);
            System.out.println("Tabla 'libros' creada.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
