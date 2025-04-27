package com.biblioteca.modelo;

import com.biblioteca.enums.Estado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void crearLibroConDatosValidos() {
        // Arrange
        String isbn = "9788498387087";
        String titulo = "Cien años de soledad";
        String autor = "Gabriel García Márquez";

        // Act
        Libro libro = new Libro(isbn, titulo, autor);

        // Assert
        assertEquals(isbn, libro.getIsbn());
        assertEquals(titulo, libro.getTitulo());
        assertEquals(autor, libro.getAutor());
        assertEquals(Estado.DISPONIBLE, libro.getEstado());
    }

    @Test
    void cambiarEstadoDelLibro() {
        // Arrange
        Libro libro = new Libro("9788498387087", "Cien años de soledad", "Gabriel García Márquez");

        // Act
        libro.setEstado(Estado.PRESTADO);

        // Assert
        assertEquals(Estado.PRESTADO, libro.getEstado());

        // Act - volver al estado original
        libro.setEstado(Estado.DISPONIBLE);

        // Assert
        assertEquals(Estado.DISPONIBLE, libro.getEstado());
    }
}