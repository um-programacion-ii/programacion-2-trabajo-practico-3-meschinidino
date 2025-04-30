package com.biblioteca.modelo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testAgregarMultiplesPrestamos() {
        Usuario usuario = new Usuario("Ana");
        Prestamo prestamo1 = new Prestamo(); // Use real instances
        Prestamo prestamo2 = new Prestamo();

        usuario.agregarPrestamo(prestamo1);
        usuario.agregarPrestamo(prestamo2);

        List<Prestamo> historial = usuario.getHistorialPrestamos();
        assertEquals(2, historial.size());
        assertTrue(historial.contains(prestamo1));
        assertTrue(historial.contains(prestamo2));
    }

    @Test
    void testAgregarPrestamoNuloNoLanzaExcepcion() {
        Usuario usuario = new Usuario("Luis");
        assertDoesNotThrow(() -> usuario.agregarPrestamo(null));
        assertTrue(usuario.getHistorialPrestamos().isEmpty());
    }

    @Test
    void testAgregarPrestamoThrowsException() {
        Usuario usuario = new Usuario("Test") {
            @Override
            public void agregarPrestamo(Prestamo prestamo) {
                throw new RuntimeException("Simulated exception");
            }
        };
        assertThrows(RuntimeException.class, () -> usuario.agregarPrestamo(new Prestamo()));
    }
}