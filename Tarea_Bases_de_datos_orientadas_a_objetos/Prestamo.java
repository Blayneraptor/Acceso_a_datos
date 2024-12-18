package Tarea_Bases_de_datos_orientadas_a_objetos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro;
    private String usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, String usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public long calcularDuracion() {
        return ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);
    }

    public String getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    @Override
    public String toString() {
        return "Préstamo de \"" + libro.getTitulo() + "\" a " + usuario + "\n" +
               "Fecha de Préstamo: " + fechaPrestamo + "\n" +
               "Fecha de Devolución: " + fechaDevolucion;
    }
}
