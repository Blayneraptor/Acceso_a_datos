import java.sql.*;

public class EliminarDB {

    public static void eliminarLibro(int idLibro) {
        // Query para eliminar el libro
        String queryEliminar = "DELETE FROM libros WHERE id = ?";
        
        // Query para restablecer el contador de AUTO_INCREMENT
        String queryResetAutoIncrement = "ALTER TABLE libros AUTO_INCREMENT = 1";
        
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement psEliminar = con.prepareStatement(queryEliminar);
             PreparedStatement psReset = con.prepareStatement(queryResetAutoIncrement)) {

            // Establecemos el id del libro a eliminar
            psEliminar.setInt(1, idLibro);
            psEliminar.executeUpdate();
            System.out.println("Libro eliminado correctamente.");
            
            // Reiniciamos el contador de AUTO_INCREMENT
            psReset.executeUpdate();
            System.out.println("Contador AUTO_INCREMENT restablecido.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
