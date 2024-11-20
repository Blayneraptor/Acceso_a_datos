import java.sql.*;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/listaLibros";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
