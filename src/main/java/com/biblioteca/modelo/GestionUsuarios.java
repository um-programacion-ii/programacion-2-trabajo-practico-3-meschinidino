package com.biblioteca.modelo;

import java.util.List;

public class GestionUsuarios {
    private final List<Usuario> usuarios;

    public GestionUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public GestionUsuarios() {
        this(new java.util.ArrayList<>());
    }

    public boolean registrarUsuario(Usuario usuario) {
        if (usuario == null || usuarios.contains(usuario)) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}