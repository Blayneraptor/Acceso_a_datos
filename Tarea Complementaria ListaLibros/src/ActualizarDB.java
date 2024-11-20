import java.sql.*;

public class ActualizarDB {
    
        public static void actualizarAnoPublicacion(int idLibro, int nuevoAno) {
            String query = "UPDATE libros SET ano_publicacion = ? WHERE id = ?";
            try (Connection con = ConexionDB.obtenerConexion(); 
                 PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, nuevoAno);
                ps.setInt(2, idLibro);
                ps.executeUpdate();
                System.out.println("Año de publicación actualizado correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    