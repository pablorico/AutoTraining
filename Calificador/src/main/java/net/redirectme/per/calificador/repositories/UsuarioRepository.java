package net.redirectme.per.calificador.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.redirectme.per.calificador.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findByUsuarioId(String u);
	Usuario findById(int id);
	List<Usuario> findAll();
}
