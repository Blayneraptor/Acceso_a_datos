import java.io.*;

public class tarea2 {
    public static void main(String[] args) {
        // Verifica si el nombre del archivo se pasó como argumento
        if (args.length != 1) {
            System.out.println("Por favor, proporcione el nombre del archivo como argumento.");
            return;
        }

        String nombreFichero = args[0];
        File archivo = new File(nombreFichero);

        // Verifica si el archivo existe
        if (!archivo.exists()) {
            System.out.println("El archivo no existe: " + nombreFichero);
            return;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contadorPalabras = 0;

            // Lee el archivo línea por línea
            while ((linea = lector.readLine()) != null) {
                // Divide cada línea en palabras utilizando espacios en blanco
                String[] palabras = linea.split("\\s+");
                contadorPalabras += palabras.length;
            }

            // Muestra el número total de palabras
            System.out.println("El archivo tiene un total de " + contadorPalabras + " palabras.");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encuentra: " + nombreFichero);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }
    }
}
