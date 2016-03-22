package net.redirectme.per.calificador.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	private UsuarioRepository usuarioRepository;

	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario findById(int id) {
		Usuario u = usuarioRepository.findById(id);
		return u;
	}

	@Override
	public Usuario findByUsuario(String usuario) {
		Usuario u = usuarioRepository.findByUsuario(usuario);
		return u;
	}

}
