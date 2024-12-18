package Tarea_Bases_de_datos_orientadas_a_objetos;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear autor y editorial
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Editorial editorial1 = new Editorial("Editorial Sudamericana", "Buenos Aires, Argentina");

        // Crear libro
        Libro libro1 = new Libro("Cien años de soledad", "978-3-16-148410-0", 1967, autor1, editorial1);

        // Crear préstamo
        LocalDate fechaPrestamo = LocalDate.of(2024, 12, 1);
        LocalDate fechaDevolucion = LocalDate.of(2024, 12, 15);
        Prestamo prestamo1 = new Prestamo(libro1, "Juan Pérez", fechaPrestamo, fechaDevolucion);

        // Mostrar información con formato más claro
        System.out.println("Información del Libro:\n" + libro1 + "\n");
        System.out.println("Información del Préstamo:\n" + prestamo1 + "\n");
        System.out.println("Duración del préstamo: " + prestamo1.calcularDuracion() + " días\n");
    }
}
