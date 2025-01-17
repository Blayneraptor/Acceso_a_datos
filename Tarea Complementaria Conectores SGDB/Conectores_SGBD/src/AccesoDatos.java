import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoDatos {
    // Configuración de la conexión a MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos"; 
    private static final String USUARIO = "root"; 
    private static final String CONTRASEÑA = ""; 

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            // Paso 1: Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 2: Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);

            // Ejemplo 1: Insertar datos
            insertarDatos(conexion, 4, "Blayne");

            // Ejemplo 2: Consultar datos
            consultarDatos(conexion);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión en el bloque finally para asegurarse de que siempre se cierre
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
    private static void insertarDatos(Connection conexion, int id, String nombre) throws SQLException {
        String sql = "INSERT INTO mi_tabla (id, nombre) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, nombre);
            statement.executeUpdate();
            System.out.println("Datos insertados correctamente.");
        }
    }

    // Método para consultar datos en la tabla
    private static void consultarDatos(Connection conexion) throws SQLException {
        String sql = "SELECT * FROM mi_tabla";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }
        }
    }
}
