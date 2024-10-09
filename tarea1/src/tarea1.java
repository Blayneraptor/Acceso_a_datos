import java.io.*;

public class tarea1 {
    public static void main(String[] args) {
        // Cambia esto a la ruta deseada
        File archivo = new File("../datos.txt"); // Crear el archivo en la raíz del proyecto

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }

            FileWriter escritor = new FileWriter(archivo);
            escritor.write("Nombre de la asignatura: Acceso a datos\n");
            escritor.write("Nombre del estudiante: Jose Couso\n");
            escritor.close();
            System.out.println("Se ha escrito en el archivo.");

            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
}
