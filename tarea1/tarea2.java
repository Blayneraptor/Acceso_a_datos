import java.io.*;

public class tarea2 {
    public static void main(String[] args) {
        // Cambia esta ruta según la ubicación de datos.txt
        String nombreFichero = "C:\\Users\\Blayne\\OneDrive\\DIGITECH\\2º Curso DAM\\ACCESO A DATOS\\Acceso_a_datos\\tarea1\\datos.txt"; 

        File archivo = new File(nombreFichero);

        // Verificar si el archivo existe
        if (!archivo.exists()) {
            System.out.println("El archivo no se encuentra: " + nombreFichero);
            return;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contadorPalabras = 0;

            while ((linea = lector.readLine()) != null) {
                // Dividimos la línea en palabras usando espacios en blanco como delimitadores
                String[] palabras = linea.split("\\s+");
                contadorPalabras += palabras.length;
            }

            System.out.println("El archivo tiene un total de " + contadorPalabras + " palabras.");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encuentra: " + nombreFichero);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }
    }
}
