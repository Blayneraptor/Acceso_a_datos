
public class Main {
    public static void main(String[] args) {
        // Insertar autor
        InsertarDB.insertarAutor("Gabriel García Márquez", "1927-03-06");

        // Insertar libro
        InsertarDB.insertarLibro("Cien años de soledad", 1, 1967);

        // Consultar libros de un autor
        ConsultarDB.consultarLibrosPorAutor("Gabriel García Márquez");

        // Actualizar año de publicación de un libro
        ActualizarDB.actualizarAnoPublicacion(1, 1968);

        // Eliminar un libro
        EliminarDB.eliminarLibro(1);
    }
}
