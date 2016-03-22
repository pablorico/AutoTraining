package net.redirectme.per.calificador.security;
 
public interface UsuarioService {
 
    Usuario findById(int id);
     
    Usuario findByUsuario(String usuario);
     
}