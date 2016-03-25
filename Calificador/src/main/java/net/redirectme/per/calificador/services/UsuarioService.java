package net.redirectme.per.calificador.services;

import java.util.List;

import net.redirectme.per.calificador.entities.Usuario;

public interface UsuarioService {
 
    Usuario getUsuarioById(int id);
    Usuario getUsuarioByUsuario(String usuario);
    Usuario saveUsuario(Usuario usuario);
    void removeUsuario(int id);
    List<Usuario> listAllUsuarios();
     
}