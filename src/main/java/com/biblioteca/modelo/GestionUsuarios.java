package com.biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    private List<Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<>();
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