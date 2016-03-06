package net.redirectme.per.calificador.controllers;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.redirectme.per.calificador.entities.Calificacion;
import net.redirectme.per.calificador.services.CalificacionService;

@Controller
public class CalificacionController {

	private CalificacionService calificacionService;

	@Autowired
	public void setCalificacionService(CalificacionService calificacionService) {
		this.calificacionService = calificacionService;
	}

	@RequestMapping(value = "/calificacionesAnt", method = RequestMethod.GET)
	public String calificaciones(Model model) {
		model.addAttribute("calificaciones", calificacionService.listCalificacionesByRango(Date.valueOf("2016-02-01"),
				new Date(System.currentTimeMillis())));
		return "calificaciones";
	}

	@RequestMapping(value = "/calificaciones", method = RequestMethod.GET)
	public void calificaciones(HttpServletRequest request, HttpServletResponse response) {
		// 1. Fetch your data
		Iterable<Calificacion> lc = calificacionService.listCalificacionesByRango(Date.valueOf("2016-02-01"),
				new Date(System.currentTimeMillis()));

		
		// 2. Create your excel
		// 3. write excel file to your response.
	}

	@RequestMapping("/calificar")
	public String newCalificacion(Model m) {
		return "calificacionform";
	}

	@RequestMapping(value = "gracias")
	public String sayGracias() {
		return "redirect:/calificar";
	}

	@RequestMapping(value = "bueno")
	public String saveBueno() {
		calificacionService.addBueno();
		return "graciasBueno";
	}

	@RequestMapping(value = "regular")
	public String saveRegular() {
		calificacionService.addRegular();
		return "graciasRegular";
	}

	@RequestMapping(value = "malo")
	public String saveMalo() {
		calificacionService.addMalo();
		return "graciasMalo";
	}

	@RequestMapping(value = "excelente")
	public String saveExcelente() {
		calificacionService.addExcelente();
		return "graciasExcelente";
	}

}