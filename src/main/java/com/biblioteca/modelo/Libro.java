package com.biblioteca.modelo;

import com.biblioteca.enums.Estado;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Libro {

    private final String isbn;
    private String titulo;
    private String autor;
    private Estado estado;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = Estado.DISPONIBLE;
    }
}