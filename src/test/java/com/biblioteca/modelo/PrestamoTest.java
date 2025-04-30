package com.biblioteca.modelo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        Libro libro = new Libro("111", "Libro Test", "Autor");
        LocalDate fecha = LocalDate.of(2024, 6, 1);
        Prestamo prestamo = new Prestamo(fecha, libro);

        assertEquals(fecha, prestamo.getFechaPrestamo());
        assertEquals(libro, prestamo.getLibro());
    }

    @Test
    void testSetters() {
        Prestamo prestamo = new Prestamo();
        Libro libro = new Libro("222", "Otro Libro", "Otro Autor");
        LocalDate fecha = LocalDate.of(2024, 6, 2);

        prestamo.setFechaPrestamo(fecha);
        prestamo.setLibro(libro);

        assertEquals(fecha, prestamo.getFechaPrestamo());
        assertEquals(libro, prestamo.getLibro());
    }
}