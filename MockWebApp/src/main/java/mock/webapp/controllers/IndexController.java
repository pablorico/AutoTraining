package mock.webapp.controllers;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import net.redirectme.per.calificador.entities.Usuario;
//import net.redirectme.per.calificador.services.UsuarioService;

@Controller
public class IndexController {
	
	//private UsuarioService usuarioService;

	//@Autowired
	//public void setUsuarioService(UsuarioService usuarioService) {
	//	this.usuarioService = usuarioService;
	//}
	
    @RequestMapping("/")
    String index(Model m){
    	/*
    	String usuarioId = SecurityContextHolder.getContext().getAuthentication().getName();
    	Usuario usuario = usuarioService.getUsuarioByUsuario(usuarioId);
    	if(usuario==null) {
    		usuario = new Usuario();
    	}
    	System.out.println("Usuario: "+usuario);
    	m.addAttribute("usuario", usuario);
        */
        return "index";
    }
}