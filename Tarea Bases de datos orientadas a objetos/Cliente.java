import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private int id;
    private ArrayList<Libro> librosPrestados;

    public Cliente(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
    }

    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
}
