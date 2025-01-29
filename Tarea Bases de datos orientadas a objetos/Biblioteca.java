import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Cliente> clientes;

    public Biblioteca() {
        libros = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    // Método para agregar libros
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Método para agregar clientes
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Buscar libros por autor
    public ArrayList<Libro> buscarPorAutor(String autor) {
        ArrayList<Libro> librosAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosAutor.add(libro);
            }
        }
        return librosAutor;
    }

    // Mostrar todos los libros disponibles
    public void mostrarLibrosDisponibles() {
        for (Libro libro : libros) {
            if (libroEstaDisponible(libro.getId())) {
                System.out.println(libro.getTitulo() + " de " + libro.getAutor());
            }
        }
    }

    // Verificar disponibilidad de un libro
    public boolean libroEstaDisponible(int idLibro) {
        for (Cliente cliente : clientes) {
            for (Libro libro : cliente.getLibrosPrestados()) {
                if (libro.getId() == idLibro) {
                    return false; // El libro está prestado
                }
            }
        }
        return true; // El libro está disponible
    }

    // Mostrar libros prestados por un cliente específico
    public void mostrarLibrosPrestadosCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                System.out.println(cliente.getNombre() + " tiene los siguientes libros prestados:");
                for (Libro libro : cliente.getLibrosPrestados()) {
                    System.out.println(libro.getTitulo());
                }
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    // Mostrar todos los clientes con libros prestados
    public void mostrarClientesConLibrosPrestados() {
        for (Cliente cliente : clientes) {
            if (!cliente.getLibrosPrestados().isEmpty()) {
                System.out.println(cliente.getNombre() + " tiene los siguientes libros prestados:");
                for (Libro libro : cliente.getLibrosPrestados()) {
                    System.out.println(libro.getTitulo());
                }
            }
        }
    }

    // Devolver un libro
    public void devolverLibro(int idCliente, int idLibro) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                for (Libro libro : cliente.getLibrosPrestados()) {
                    if (libro.getId() == idLibro) {
                        cliente.devolverLibro(libro);
                        System.out.println("El libro " + libro.getTitulo() + " ha sido devuelto.");
                        return;
                    }
                }
                System.out.println("El cliente no tiene ese libro.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    // Gestión de multas (simplificado con fecha de devolución)
    public void gestionarMultas(int idCliente, int idLibro, Date fechaDevolucionEsperada) {
        // Suponiendo que tenemos la fecha actual
        Date fechaActual = new Date();
        if (fechaActual.after(fechaDevolucionEsperada)) {
            System.out.println("El cliente tiene una multa por devolver el libro tarde.");
        } else {
            System.out.println("El cliente ha devuelto el libro a tiempo.");
        }
    }

    // Clasificación de libros por género
    public void clasificarLibrosPorGenero(String genero) {
        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                System.out.println(libro.getTitulo() + " de " + libro.getAutor());
            }
        }
    }
}
