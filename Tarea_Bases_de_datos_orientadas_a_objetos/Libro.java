package Tarea_Bases_de_datos_orientadas_a_objetos;
public class Libro {
    private String titulo;
    private String isbn;
    private int añoPublicacion;
    private Autor autor;
    private Editorial editorial;

    public Libro(String titulo, String isbn, int añoPublicacion, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.añoPublicacion = añoPublicacion;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
               "Año de Publicación: " + añoPublicacion + "\n" +
               "ISBN: " + isbn + "\n" +
               autor + "\n" + editorial;
    }
}
