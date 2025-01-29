import java.util.Date;

public class Libro {
    private String titulo;
    private String autor;
    private int id;
    private String genero;
    private Date fechaDevolucionEsperada;

    public Libro(String titulo, String autor, int id, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.genero = genero;
        this.fechaDevolucionEsperada = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }

    public String getGenero() {
        return genero;
    }

    public Date getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(Date fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }
}
