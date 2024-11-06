import java.io.*;

public class Tarea_1_2forma {
    public static void main(String[] args) throws IOException {
        File file = new File("datos.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("Nombre de la asignatura: Acceso a Datos\n");
        fw.write("Nombre del estudiante: Jose Couso\n");
        fw.close();
        FileReader fr = new FileReader(file);
        int c;
        while ((c = fr.read()) != -1) {
            System.out.print((char) c);
        }
        fr.close();

    }
}
