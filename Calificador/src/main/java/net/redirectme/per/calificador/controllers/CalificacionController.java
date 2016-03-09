package net.redirectme.per.calificador.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.redirectme.per.calificador.genXLS;
import net.redirectme.per.calificador.entities.Calificacion;
import net.redirectme.per.calificador.services.CalificacionService;

@Controller
public class CalificacionController {

	private CalificacionService calificacionService;

	@Autowired
	public void setCalificacionService(CalificacionService calificacionService) {
		this.calificacionService = calificacionService;
	}

	@RequestMapping(value = "/calificaciones", method = RequestMethod.GET)
	public String calificaciones(Model model) {
		model.addAttribute("calificaciones", calificacionService.listCalificacionesByRango(Date.valueOf("2016-02-01"),
				new Date(System.currentTimeMillis())));
		return "calificaciones";
	}

	@RequestMapping(value = "/calificacionesXLS", method = RequestMethod.GET)
	public void calificaciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Iterable<Calificacion> lc = calificacionService.listCalificacionesAll();

		String xls = new genXLS().getData(lc, Date.valueOf("2016-02-01"), new Date(System.currentTimeMillis()));

		response.setHeader("Content-Disposition", "attachment; filename=\"" + xls + "\"");
		response.setContentType("application/octet-stream"); // set content
																// attributes
																// for the
																// response

		FileInputStream inputStream = new FileInputStream(new File("/tmp/"+xls));

		OutputStream outputStream = response.getOutputStream(); // get output
																// stream of the
																// response

		byte[] buffer = new byte[1024];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) { // write bytes
																// read from the
																// input stream
																// into the
																// output stream
			outputStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outputStream.flush();

	}

	@RequestMapping("/calificar")
	public String newCalificacion(Model m) {
		return "calificacionform";
	}

	@RequestMapping(value = "/gracias")
	public String sayGracias() {
		return "redirect:/calificar";
	}

	@RequestMapping(value = "/bueno")
	public String saveBueno() {
		calificacionService.addBueno();
		return "graciasBueno";
	}

	@RequestMapping(value = "/regular")
	public String saveRegular() {
		calificacionService.addRegular();
		return "graciasRegular";
	}

	@RequestMapping(value = "/malo")
	public String saveMalo() {
		calificacionService.addMalo();
		return "graciasMalo";
	}

	@RequestMapping(value = "/excelente")
	public String saveExcelente() {
		calificacionService.addExcelente();
		return "graciasExcelente";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		return "index";
	}
}