package mock.webapp.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import mock.webapp.entities.*;
import mock.webapp.services.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationListener<ContextRefreshedEvent> {

	private UsuarioService usuarioService;

	private Logger log = Logger.getLogger(UsuarioLoader.class);

	@Autowired
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Usuario admin = new Usuario();
		admin.setUsuarioId("jperez");
		admin.setNombre("Jorge");
		admin.setApellido("Perez");
		admin.setPassword("jperez123");
		PerfilDeUsuario perfilADMIN=new PerfilDeUsuario();
		perfilADMIN.setTipo(TipoDePerfilDeUsuario.ADMIN.getTipoDePerfilDeUsuario());
		PerfilDeUsuario perfilSUPERVISOR=new PerfilDeUsuario();
		perfilSUPERVISOR.setTipo(TipoDePerfilDeUsuario.SUPERVISOR.getTipoDePerfilDeUsuario());
		admin.addPerfilDeUsuario(perfilADMIN);
		admin.addPerfilDeUsuario(perfilSUPERVISOR);
		usuarioService.saveUsuario(admin);
		log.info("Saved Administrador - id: " + admin.getId() + " / Pass:" + admin.getPassword() + " Perfiles: "
				+ admin.getPerfilesDeUsuario());


		Usuario operador = new Usuario();
		operador.setUsuarioId("cgonzalez");
		operador.setNombre("Carlos");
		operador.setApellido("Gonzalez");
		operador.setPassword("cgonza123");
		PerfilDeUsuario perfilOPERADOR=new PerfilDeUsuario();
		perfilOPERADOR.setTipo(TipoDePerfilDeUsuario.USUARIO.getTipoDePerfilDeUsuario());
		operador.addPerfilDeUsuario(perfilOPERADOR);
		usuarioService.saveUsuario(operador);
		log.info("Saved Operador - id: " + operador.getId() + " / Pass:" + operador.getPassword() + " Perfiles: "
				+ operador.getPerfilesDeUsuario());

		Usuario supervisor = new Usuario();
		supervisor.setUsuarioId("plopez");
		supervisor.setNombre("Pablo");
		supervisor.setApellido("Lopez");
		supervisor.setPassword("plopez123");
		perfilSUPERVISOR=new PerfilDeUsuario();
		perfilSUPERVISOR.setTipo(TipoDePerfilDeUsuario.SUPERVISOR.getTipoDePerfilDeUsuario());
		
		supervisor.addPerfilDeUsuario(perfilSUPERVISOR);
		usuarioService.saveUsuario(supervisor);
		log.info("Saved Supervisor - id: " + supervisor.getId() + " / Pass:" + supervisor.getPassword() + " Perfiles: "
				+ supervisor.getPerfilesDeUsuario());

		
	}
}