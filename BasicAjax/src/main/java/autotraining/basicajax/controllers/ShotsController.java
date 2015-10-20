package autotraining.basicajax.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import autotraining.basicajax.services.ShotService;
 
@Controller
public class ShotsController {

	private ShotService shotService;
	
	@Autowired
	public void setShotService(ShotService s) {
		this.shotService = s;
	}
	
	
    @RequestMapping("/shots")
    String shots(Model m){
    	m.addAttribute("shots", shotService.shot());
        return "shots";
    }
}
