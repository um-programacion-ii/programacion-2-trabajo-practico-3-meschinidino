package com.biblioteca.modelo;

import com.biblioteca.enums.Estado;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class Catalogo {

    private final List<Libro> libros;

    public Catalogo() {
        this.libros = new ArrayList<>();
    }

    /**
     * Agrega un libro al catálogo
     *
     * @param libro El libro a agregar
     * @return true si el libro fue agregado, false si ya existía un libro con el mismo ISBN
     */
    public boolean agregarLibro(Libro libro) {
        // Verificar que el libro no exista ya en el catálogo
        if (buscarLibroPorIsbn(libro.getIsbn()).isPresent()) {
            return false;
        }

        return libros.add(libro);
    }

    /**
     * Busca un libro por su ISBN
     *
     * @param isbn El ISBN del libro a buscar
     * @return Optional con el libro si fue encontrado, empty si no existe
     */
    public Optional<Libro> buscarLibroPorIsbn(String isbn) {
        return libros.stream()
                .filter(libro -> libro.getIsbn().equals(isbn))
                .findFirst();
    }

    /**
     * Devuelve todos los libros con estado DISPONIBLE
     *
     * @return Lista de libros disponibles
     */
    public List<Libro> obtenerLibrosDisponibles() {
        return libros.stream()
                .filter(libro -> libro.getEstado() == Estado.DISPONIBLE)
                .collect(Collectors.toList());
    }
}