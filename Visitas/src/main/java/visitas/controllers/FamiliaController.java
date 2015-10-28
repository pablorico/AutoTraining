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
public class FamiliaController {

	@Autowired
	private FamiliaService familiaService;

	public void setFamiliaService(FamiliaService familiaService) {
		this.familiaService = familiaService;
	}

	@RequestMapping("/familia/{id}")
	String showFamilia(@PathVariable Integer id, Model model) {
		model.addAttribute("familia", familiaService.getFamilia(id));
		return "familia";
	}

	@RequestMapping(value = "/familias", method = RequestMethod.GET)
	String showAll(Model model) {
		return "familias";
	}

	@RequestMapping(value = "/familia/new")
	String newFamilia(Model model) {
		model.addAttribute("familia", new Familia());
		return "familia";
	}

	@RequestMapping(value = "/familia", method = RequestMethod.POST)
	public String saveFamilia(Familia familia) {
		familiaService.saveFamilia(familia);
		return "redirect:/familia/" + familia.getId();
	}

	@RequestMapping("familia/edit/{id}")
	public String editFamilia(@PathVariable Integer id, Model model) {
		model.addAttribute("familia", familiaService.getFamilia(id));
		return "familia";
	}

	@RequestMapping("familia/delete/{id}")
	public String delete(@PathVariable Integer id) {
		familiaService.deleteFamilia(id);
		return "redirect:/familias";
	}

}
