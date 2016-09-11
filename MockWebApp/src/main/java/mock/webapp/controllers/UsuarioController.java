package mock.webapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mock.webapp.entities.Usuario;
import mock.webapp.services.UsuarioService;

@Controller
public class UsuarioController {

	private UsuarioService usuarioService;

	@Autowired
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping("/usuario/new")
	public String newUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarioform";
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String saveUsuario(Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "redirect:/usuarios";
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("usuarios", usuarioService.listAllUsuarios());
		return "usuarios";
	}

	@RequestMapping("usuario/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("usuario", usuarioService.getUsuarioById(id));
		return "usuarioform";
	}

	@RequestMapping("usuario/delete/{id}")
	public String delete(@PathVariable Integer id) {
		usuarioService.removeUsuario(id);
		return "redirect:/usuarios";
	}
}
