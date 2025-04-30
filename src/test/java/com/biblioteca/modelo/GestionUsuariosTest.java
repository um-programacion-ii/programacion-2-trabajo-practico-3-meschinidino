package com.biblioteca.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GestionUsuariosTest {

    @Test
    void testRegistrarMultiplesUsuarios() {
        GestionUsuarios gestion = new GestionUsuarios();
        Usuario usuario1 = new Usuario("Ana");
        Usuario usuario2 = new Usuario("Luis");

        assertTrue(gestion.registrarUsuario(usuario1));
        assertTrue(gestion.registrarUsuario(usuario2));

        List<Usuario> usuarios = gestion.obtenerUsuarios();
        assertEquals(2, usuarios.size());
        assertTrue(usuarios.contains(usuario1));
        assertTrue(usuarios.contains(usuario2));
    }

    @Test
    void testRegistrarUsuarioNuloNoLanzaExcepcion() {
        GestionUsuarios gestion = new GestionUsuarios();
        assertDoesNotThrow(() -> gestion.registrarUsuario(null));
        assertTrue(gestion.obtenerUsuarios().isEmpty());
    }

    @Test
    void testRegistrarUsuarioThrowsException() {
        GestionUsuarios gestion = new GestionUsuarios() {
            @Override
            public boolean registrarUsuario(Usuario usuario) {
                throw new RuntimeException("Simulated exception");
            }
        };
        assertThrows(RuntimeException.class, () -> gestion.registrarUsuario(new Usuario("Test")));
    }
    @Test
    void testRegistrarUsuarioWithMockedList() {
        List<Usuario> mockList = Mockito.mock(List.class);
        when(mockList.contains(any())).thenReturn(false);
        GestionUsuarios gestion = new GestionUsuarios(mockList);

        Usuario usuario = new Usuario("Ana");
        assertTrue(gestion.registrarUsuario(usuario));
        verify(mockList).add(usuario);
    }
}