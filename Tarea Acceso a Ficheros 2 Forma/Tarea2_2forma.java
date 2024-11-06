import java.io.*;

public class Tarea2_2forma {

    public static void main(String[] args) {
        try {
            // Usar un nombre de archivo fijo
            File file = new File("datos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count += line.split(" ").length;
            }
            System.out.println("El número de palabras es: " + count + "\n");
            br.close();
        } catch (IOException e) {
            System.err.println("Error al abrir el fichero");
        }
    }
}
