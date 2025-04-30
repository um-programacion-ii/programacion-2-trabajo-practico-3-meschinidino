package com.biblioteca.modelo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SistemaPrestamosTest {

    @Test
    void testRegistrarPrestamoConLibroNulo() {
        // Arrange
        SistemaPrestamos sistemaPrestamos = new SistemaPrestamos();

        // Act
        boolean resultado = sistemaPrestamos.registrarPrestamo(null);

        // Assert
        assertFalse(resultado);
        assertTrue(sistemaPrestamos.obtenerPrestamos().isEmpty());
    }

    @Test
    void testObtenerPrestamosSinPrestamos() {
        // Arrange
        SistemaPrestamos sistemaPrestamos = new SistemaPrestamos();

        // Act
        List<Prestamo> prestamos = sistemaPrestamos.obtenerPrestamos();

        // Assert
        assertNotNull(prestamos);
        assertTrue(prestamos.isEmpty());
    }

    @Test
    void testRegistrarMultiplesPrestamos() {
        // Arrange
        SistemaPrestamos sistemaPrestamos = new SistemaPrestamos();
        Libro libro1 = new Libro("111", "Libro Uno", "Autor A");
        Libro libro2 = new Libro("222", "Libro Dos", "Autor B");

        // Act
        boolean resultado1 = sistemaPrestamos.registrarPrestamo(libro1);
        boolean resultado2 = sistemaPrestamos.registrarPrestamo(libro2);
        List<Prestamo> prestamos = sistemaPrestamos.obtenerPrestamos();

        // Assert
        assertTrue(resultado1);
        assertTrue(resultado2);
        assertEquals(2, prestamos.size());
        assertEquals(libro1, prestamos.get(0).getLibro());
        assertEquals(libro2, prestamos.get(1).getLibro());
    }
}