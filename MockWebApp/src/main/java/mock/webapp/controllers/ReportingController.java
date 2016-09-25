package mock.webapp.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mock.webapp.entities.Usuario;
import mock.webapp.services.UsuarioService;
import mock.webapp.util.genXLS;

@Controller
public class ReportingController {

	private UsuarioService usuarioService;

	@Autowired
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(value = "/usuariosPAN", method = RequestMethod.GET)
	public String usuariosPAN(Model model) {
		model.addAttribute("usuarios", usuarioService.listAllUsuarios());
		return "usuariosPAN";
	}

	@RequestMapping(value = "/usuariosXLS", method = RequestMethod.GET)
	public void usuariosXLS(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Iterable<Usuario> usuarios = usuarioService.listAllUsuarios();

		String xls = new genXLS().getData(usuarios);

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
	
	
}
