import java.sql.*;

public class InsertarDB {
    public static void insertarAutor(String nombreAutor, String fecha) {
        String query = "INSERT INTO autor (nombre_autor, fecha) VALUES (?, ?)";
        try (Connection con = ConexionDB.obtenerConexion(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombreAutor);
            ps.setString(2, fecha);
            ps.executeUpdate();
            System.out.println("Autor insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarLibro(String titulo, int autorId, int anoPublicacion) {
        String query = "INSERT INTO libros (titulo, autor_id, ano_publicacion) VALUES (?, ?, ?)";
        try (Connection con = ConexionDB.obtenerConexion(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, titulo);
            ps.setInt(2, autorId);
            ps.setInt(3, anoPublicacion);
            ps.executeUpdate();
            System.out.println("Libro insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
