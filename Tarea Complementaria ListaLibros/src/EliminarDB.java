import java.sql.*;

public class EliminarDB {

    public static void eliminarLibro(int idLibro) {
        String query = "DELETE FROM libros WHERE id = 1";
        try (Connection con = ConexionDB.obtenerConexion();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idLibro);
            ps.executeUpdate();
            System.out.println("Libro eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

