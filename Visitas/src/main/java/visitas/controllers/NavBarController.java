package visitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import visitas.model.Familia;
import visitas.services.FamiliaService;

@Controller
public class NavBarController {

	@RequestMapping(value = "/saavedra", method = RequestMethod.GET)
	public String showSaavedra() {
		return "saavedraFragment :: iglesias";
	}
	
	@RequestMapping(value = "/villaMartelli", method = RequestMethod.GET)
	public String showVillaMartelli() {
		return "villaMartelliFragment :: iglesias";
	}
	
	@RequestMapping(value = "/villaPueyrredon", method = RequestMethod.GET)
	public String showVillaPueyrredon() {
		return "villaPueyrredonFragment :: iglesias";
	}
	
	@RequestMapping(value = "/belgrano", method = RequestMethod.GET)
	public String showBelgrano() {
		return "belgranoFragment :: iglesias";
	}
	
	@RequestMapping(value = "/villaUrquiza", method = RequestMethod.GET)
	public String showVillaUrquiza() {
		return "villaUrquizaFragment :: iglesias";
	}
	
	@RequestMapping(value = "/siervos", method = RequestMethod.GET)
	public String showSiervos() {
		return "siervosFragment :: objetos";
	}
	
	@RequestMapping(value = "/familias", method = RequestMethod.GET)
	public String showFamilias() {
		return "familiasFragment :: objetos";
	}
	
}
