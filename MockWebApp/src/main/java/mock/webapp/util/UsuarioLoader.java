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
		RolDeUsuario rolADMIN=new RolDeUsuario();
		rolADMIN.setTipo(TipoDeRolDeUsuario.ADMIN.getTipoDeRolDeUsuario());
		RolDeUsuario rolSUPERVISOR=new RolDeUsuario();
		rolSUPERVISOR.setTipo(TipoDeRolDeUsuario.SUPERVISOR.getTipoDeRolDeUsuario());
		admin.addRolDeUsuario(rolADMIN);
		admin.addRolDeUsuario(rolSUPERVISOR);
		usuarioService.saveUsuario(admin);
		log.info("Saved Administrador - id: " + admin.getId() + " / Pass:" + admin.getPassword() + " Perfiles: "
				+ admin.getRolesDeUsuario());


		Usuario operador = new Usuario();
		operador.setUsuarioId("cgonzalez");
		operador.setNombre("Carlos");
		operador.setApellido("Gonzalez");
		operador.setPassword("cgonza123");
		RolDeUsuario rolOPERADOR=new RolDeUsuario();
		rolOPERADOR.setTipo(TipoDeRolDeUsuario.USUARIO.getTipoDeRolDeUsuario());
		operador.addRolDeUsuario(rolOPERADOR);
		usuarioService.saveUsuario(operador);
		log.info("Saved Operador - id: " + operador.getId() + " / Pass:" + operador.getPassword() + " Perfiles: "
				+ operador.getRolesDeUsuario());

		Usuario supervisor = new Usuario();
		supervisor.setUsuarioId("plopez");
		supervisor.setNombre("Pablo");
		supervisor.setApellido("Lopez");
		supervisor.setPassword("plopez123");
		rolSUPERVISOR=new RolDeUsuario();
		rolSUPERVISOR.setTipo(TipoDeRolDeUsuario.SUPERVISOR.getTipoDeRolDeUsuario());
		
		supervisor.addRolDeUsuario(rolSUPERVISOR);
		usuarioService.saveUsuario(supervisor);
		log.info("Saved Supervisor - id: " + supervisor.getId() + " / Pass:" + supervisor.getPassword() + " Perfiles: "
				+ supervisor.getRolesDeUsuario());


		for (int i = 1;i<50;i++) {
			Usuario u = new Usuario();
			u.setUsuarioId("U-"+i);
			u.setNombre("Usuario");
			u.setApellido("U"+i);
			u.setPassword("x");
			RolDeUsuario ru=new RolDeUsuario();
			ru.setTipo(TipoDeRolDeUsuario.SUPERVISOR.getTipoDeRolDeUsuario());
			u.addRolDeUsuario(ru);
			usuarioService.saveUsuario(u);
			log.info("Saved Usuario - id: " + u.getId() + " / Pass:" + u.getPassword() + " Perfiles: "
				+ u.getRolesDeUsuario());
		}
	}
}