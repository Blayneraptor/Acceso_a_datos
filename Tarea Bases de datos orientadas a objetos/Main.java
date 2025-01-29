import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Crear libros
        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", 1, "Fantasía");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 2, "Realismo mágico");

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Crear clientes
        Cliente cliente1 = new Cliente("Juan", 101);
        Cliente cliente2 = new Cliente("María", 102);

        // Agregar clientes a la biblioteca
        biblioteca.agregarCliente(cliente1);
        biblioteca.agregarCliente(cliente2);

        // Prestar libros
        cliente1.prestarLibro(libro1);
        cliente2.prestarLibro(libro2);

        // Mostrar libros prestados por cliente
        biblioteca.mostrarLibrosPrestadosCliente(101);

        // Mostrar todos los libros disponibles
        biblioteca.mostrarLibrosDisponibles();

        // Devolver libro
        biblioteca.devolverLibro(101, 1);

        // Buscar libros por autor
        ArrayList<Libro> librosPorAutor = biblioteca.buscarPorAutor("Gabriel García Márquez");
        for (Libro libro : librosPorAutor) {
            System.out.println(libro.getTitulo());
        }
    }
}
