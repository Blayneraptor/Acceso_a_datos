import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        
        System.out.println("Libros de Gabriel García Márquez:");
        for (Libro libro : biblioteca.buscarLibrosPorAutor("Gabriel García Márquez")) {
            System.out.println(libro.getTitulo());
        }
        
        System.out.println("\nLibros disponibles:");
        for (Libro libro : biblioteca.mostrarLibrosDisponibles()) {
            System.out.println(libro.getTitulo());
        }
        
        System.out.println("\nVerificando disponibilidad de 'El señor de los anillos': " + biblioteca.verificarDisponibilidadLibro(1));
    }
}
