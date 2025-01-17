import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mi_base_de_datos";
        String usuario = "root";
        String contraseña = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa.");
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
