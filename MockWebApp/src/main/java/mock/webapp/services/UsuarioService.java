package mock.webapp.services;

import java.util.List;

import mock.webapp.entities.Usuario;

public interface UsuarioService {
 
    Usuario getUsuarioById(int id);
    Usuario getUsuarioByUsuario(String usuario);
    Usuario saveUsuario(Usuario usuario);
    void removeUsuario(int id);
    List<Usuario> listAllUsuarios();
     
}