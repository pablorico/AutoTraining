package net.redirectme.per.calificador.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.redirectme.per.calificador.entities.Usuario;
import net.redirectme.per.calificador.services.UsuarioService;

@Controller
public class UsuarioController {
	private UsuarioService usuarioService;

	@Autowired
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(value = "/acceso_invalido", method = RequestMethod.GET)
	public String acceso_invalido(ModelMap model) {
		model.addAttribute("username", getPrincipal());
		return "acceso_invalido";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}
    
	@RequestMapping("/usuario/new")
    public String newUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarioform";
    }
    
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public String saveUsuario(Usuario usuario){
        usuarioService.saveUsuario(usuario);
        return "redirect:/usuarios";
    }
    
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	 @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("usuarios", usuarioService.listAllUsuarios());
	        return "usuarios";
	    }
	 
	 @RequestMapping("usuario/edit/{id}")
	 public String edit(@PathVariable Integer id, Model model){
	     model.addAttribute("usuario", usuarioService.getUsuarioById(id));
	     return "usuarioform";
	 }
	 
	 @RequestMapping("usuario/delete/{id}")
	 public String delete(@PathVariable Integer id){
	     usuarioService.removeUsuario(id);
	     return "redirect:/usuarios";
	 }
}
