package com.biblioteca.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaPrestamos {
    private final List<Prestamo> prestamos = new ArrayList<>();

    public boolean registrarPrestamo(Libro libro) {
        if (libro == null) return false;
        Prestamo prestamo = new Prestamo(LocalDate.now(), libro);
        prestamos.add(prestamo);
        return true;
    }

    public List<Prestamo> obtenerPrestamos() {
        return new ArrayList<>(prestamos);
    }
}