package net.redirectme.per.calificador.security;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findByUsuario(String u);
	Usuario findById(int id);
}
