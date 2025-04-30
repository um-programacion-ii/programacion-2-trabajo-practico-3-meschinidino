package com.biblioteca.modelo;

import com.biblioteca.enums.Estado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoTest {

    private Catalogo catalogo;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
    }

    @Test
    void agregarMultiplesLibros() {
        Libro libro1 = new Libro("111", "Libro Uno", "Autor A");
        Libro libro2 = new Libro("222", "Libro Dos", "Autor B");
        Libro libro3 = new Libro("333", "Libro Tres", "Autor C");

        assertTrue(catalogo.agregarLibro(libro1));
        assertTrue(catalogo.agregarLibro(libro2));
        assertTrue(catalogo.agregarLibro(libro3));
        assertEquals(3, catalogo.getLibros().size());
    }

    @Test
    void noAgregarLibroConIsbnDuplicado() {
        Libro libro1 = new Libro("111", "Libro Uno", "Autor A");
        Libro libro2 = new Libro("111", "Libro Duplicado", "Autor B");

        assertTrue(catalogo.agregarLibro(libro1));
        assertFalse(catalogo.agregarLibro(libro2));
        assertEquals(1, catalogo.getLibros().size());
    }

    @Test
    void buscarLibroPorIsbnExistente() {
        Libro libro = new Libro("123", "Libro Existente", "Autor X");
        catalogo.agregarLibro(libro);

        Optional<Libro> resultado = catalogo.buscarLibroPorIsbn("123");
        assertTrue(resultado.isPresent());
        assertEquals("Libro Existente", resultado.get().getTitulo());
    }

    @Test
    void buscarLibroPorIsbnInexistente() {
        Optional<Libro> resultado = catalogo.buscarLibroPorIsbn("999");
        assertFalse(resultado.isPresent());
    }

    @Test
    void obtenerLibrosDisponibles() {
        Libro libro1 = new Libro("111", "Libro Uno", "Autor A");
        Libro libro2 = new Libro("222", "Libro Dos", "Autor B");
        libro2.setEstado(Estado.PRESTADO);

        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);

        List<Libro> disponibles = catalogo.obtenerLibrosDisponibles();
        assertEquals(1, disponibles.size());
        assertEquals("111", disponibles.get(0).getIsbn());
    }
}