import java.sql.*;
import java.util.ArrayList;

class Biblioteca {
    private Connection conexion;
    
    public Biblioteca() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Libro> buscarLibrosPorAutor(String autor) {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Libros WHERE autor = ?");
            stmt.setString(1, autor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                libros.add(new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("genero")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
    
    public ArrayList<Libro> mostrarLibrosDisponibles() {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Libros WHERE id NOT IN (SELECT id_libro FROM Prestamos WHERE fecha_devolucion IS NULL)");
            while (rs.next()) {
                libros.add(new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("genero")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
    
    public boolean verificarDisponibilidadLibro(int idLibro) {
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT COUNT(*) FROM Prestamos WHERE id_libro = ? AND fecha_devolucion IS NULL");
            stmt.setInt(1, idLibro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}