package mock.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mock.webapp.entities.*;
import mock.webapp.repositories.*;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	private UsuarioRepository usuarioRepository;

	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario getUsuarioById(int id) {
		Usuario u = usuarioRepository.findById(id);
		return u;
	}

	@Override
	public Usuario getUsuarioByUsuario(String usuario) {
		Usuario u = usuarioRepository.findByUsuarioId(usuario);
		return u;
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		Usuario u = usuarioRepository.save(usuario);
		return u;
	}

	@Override
	public List<Usuario> listAllUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}

	@Override
	public void removeUsuario(int id) {
		usuarioRepository.delete(id);		
	}
	
   

}
