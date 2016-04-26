package net.redirectme.per.calificador.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import net.redirectme.per.calificador.entities.PerfilDeUsuario;
import net.redirectme.per.calificador.entities.Usuario;
//import net.redirectme.per.calificador.repositories.PerfilDeUsuarioRepository;
import net.redirectme.per.calificador.repositories.UsuarioRepository;

@Component
public class UsuarioLoader implements ApplicationListener<ContextRefreshedEvent> {

	private UsuarioRepository usuarioRepository;
	//private PerfilDeUsuarioRepository perfilDeUsuarioRepository;

	private Logger log = Logger.getLogger(UsuarioLoader.class);

	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
/**
	@Autowired
	public void setPerfildeUsuarioRepository(PerfilDeUsuarioRepository perfilDeUsuarioRepository) {
		this.perfilDeUsuarioRepository = perfilDeUsuarioRepository;
	}
*/
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		PerfilDeUsuario perfilAdmin = new PerfilDeUsuario();
		perfilAdmin.setTipo("ADMIN");
		PerfilDeUsuario perfilSupervisor = new PerfilDeUsuario();
		perfilSupervisor.setTipo("SUPERVISOR");
		PerfilDeUsuario perfilOperador = new PerfilDeUsuario();
		perfilOperador.setTipo("OPERADOR");
		/**
		 * 
		 * perfilDeUsuarioRepository.save(perfilOperador); log.info("Saved
		 * PERFIL OPERADOR - id: " + perfilOperador.getId());
		 * perfilDeUsuarioRepository.save(perfilSupervisor); log.info("Saved
		 * PERFIL SUPERVISOR - id: " + perfilSupervisor.getId());
		 * perfilDeUsuarioRepository.save(perfilAdmin); log.info("Saved PERFIL
		 * ADMIN - id: " + perfilAdmin.getId());
		 */
		Usuario admin = new Usuario();
		admin.setUsuarioId("jperez");
		admin.setNombre("Jorge");
		admin.setApellido("Perez");
		admin.setPassword("jperez123");
		admin.getPerfilesDeUsuario().add(perfilAdmin);
		usuarioRepository.save(admin);

		log.info("Saved Administrador - id: " + admin.getId() + " / Pass:" + admin.getPassword() + " Perfiles: "
				+ admin.getPerfilesDeUsuario());

		Usuario supervisor = new Usuario();
		supervisor.setUsuarioId("plopez");
		supervisor.setNombre("Pablo");
		supervisor.setApellido("Lopez");
		supervisor.setPassword("plopez123");
		supervisor.getPerfilesDeUsuario().add(perfilSupervisor);

		usuarioRepository.save(supervisor);
		log.info("Saved Supervisor - id: " + supervisor.getId() + " / Pass:" + supervisor.getPassword() + " Perfiles: "
				+ supervisor.getPerfilesDeUsuario());

		Usuario operador = new Usuario();
		operador.setUsuarioId("cgonzalez");
		operador.setNombre("Carlos");
		operador.setApellido("Gonzalez");
		operador.setPassword("cgonza123");
		operador.getPerfilesDeUsuario().add(perfilOperador);

		usuarioRepository.save(operador);
		log.info("Saved Administrador - id: " + operador.getId() + " / Pass:" + operador.getPassword() + " Perfiles: "
				+ operador.getPerfilesDeUsuario());

	}
}