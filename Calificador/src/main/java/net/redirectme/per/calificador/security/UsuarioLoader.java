package net.redirectme.per.calificador.security;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UsuarioRepository usuarioRepository;
	private PerfilDeUsuarioRepository perfilDeUsuarioRepository;

    private Logger log = Logger.getLogger(UsuarioLoader.class);

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setPerfildeUsuarioRepository(PerfilDeUsuarioRepository perfilDeUsuarioRepository) {
        this.perfilDeUsuarioRepository = perfilDeUsuarioRepository;
    }

    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    	PerfilDeUsuario perfilAdmin = new PerfilDeUsuario();
        perfilAdmin.setTipo("ADMIN");
        
        PerfilDeUsuario perfilSupervisor = new PerfilDeUsuario();
        perfilSupervisor.setTipo("SUPERVISOR");
        
        PerfilDeUsuario perfilOperador = new PerfilDeUsuario();
        perfilOperador.setTipo("OPERADOR");

        perfilDeUsuarioRepository.save(perfilOperador);
        log.info("Saved PERFIL OPERADOR - id: " + perfilOperador.getId());
        perfilDeUsuarioRepository.save(perfilSupervisor);
        log.info("Saved PERFIL SUPERVISOR - id: " + perfilSupervisor.getId());
        perfilDeUsuarioRepository.save(perfilAdmin);
        log.info("Saved PERFIL ADMIN - id: " + perfilAdmin.getId());
        
        Usuario admin = new Usuario();
        admin.setUsuario("Administrador");
        admin.setNombre("Usuario");
        admin.setApellido("Administrador");
        admin.setPassword("admin123");
        HashSet<PerfilDeUsuario> perfilesDeUsuarioAdmin=new HashSet<PerfilDeUsuario>();
        perfilesDeUsuarioAdmin.add(perfilAdmin);
        admin.setPerfilesDeUsuario(perfilesDeUsuarioAdmin);
        usuarioRepository.save(admin);

        log.info("Saved ADMIN - id: " + admin.getId()+" Perfiles: "+admin.getPerfilesDeUsuario());

        Usuario supervisor = new Usuario();
        supervisor.setUsuario("Supervisor");
        supervisor.setNombre("Usuario");
        supervisor.setApellido("Supervisor");
        supervisor.setPassword("supervisor123");
        HashSet<PerfilDeUsuario> perfilesDeUsuarioSupervisor=new HashSet<PerfilDeUsuario>();
        perfilesDeUsuarioSupervisor.add(perfilSupervisor);
        supervisor.setPerfilesDeUsuario(perfilesDeUsuarioSupervisor);
        
        usuarioRepository.save(supervisor);
        log.info("Saved SUPERVISOR - id: " + supervisor.getId()+" Perfiles: "+supervisor.getPerfilesDeUsuario());

        Usuario operador = new Usuario();
        operador.setUsuario("Operador");
        operador.setNombre("Usuario");
        operador.setApellido("Operador");
        operador.setPassword("operador123");
        HashSet<PerfilDeUsuario> perfilesDeUsuarioOperador=new HashSet<PerfilDeUsuario>();
        perfilesDeUsuarioOperador.add(perfilOperador);
        operador.setPerfilesDeUsuario(perfilesDeUsuarioOperador);
        
        usuarioRepository.save(operador);
        log.info("Saved OPERADOR - id: " + operador.getId()+" Perfiles: "+operador.getPerfilesDeUsuario());
        
    }
}