package mock.webapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mock.webapp.entities.*;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findByUsuarioId(String u);
	Usuario findById(int id);
	List<Usuario> findAll();
}
