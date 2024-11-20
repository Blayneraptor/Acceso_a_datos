import java.sql.*;

public class ConsultarDB {
    

    public static void consultarLibrosPorAutor(String nombreAutor) {
        String query = "SELECT libros.titulo, libros.ano_publicacion FROM libros JOIN autor ON libros.autor_id = autor.id WHERE autor.nombre_autor = ?";
        try (Connection con = ConexionDB.obtenerConexion(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombreAutor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                int anoPublicacion = rs.getInt("ano_publicacion");
                System.out.println("Título: " + titulo + ", Año de publicación: " + anoPublicacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
