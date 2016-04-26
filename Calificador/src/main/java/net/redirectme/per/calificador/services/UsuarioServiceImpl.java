package net.redirectme.per.calificador.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.redirectme.per.calificador.entities.Usuario;
//import net.redirectme.per.calificador.repositories.PerfilDeUsuarioRepository;
import net.redirectme.per.calificador.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	private UsuarioRepository usuarioRepository;
	//private PerfilDeUsuarioRepository perfilDeUsuarioRepository;
	
	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	/**
	@Autowired
	public void setPerfilDeUsuarioRepository(PerfilDeUsuarioRepository perfilDeUsuarioRepository) {
		this.perfilDeUsuarioRepository = perfilDeUsuarioRepository;
	}
	*/
	
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
