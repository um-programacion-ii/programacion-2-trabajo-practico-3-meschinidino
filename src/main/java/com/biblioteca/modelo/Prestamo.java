package com.biblioteca.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {
    private LocalDate fechaPrestamo;
    private Libro libro;
}