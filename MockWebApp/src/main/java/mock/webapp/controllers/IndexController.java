package mock.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
    @RequestMapping("/")
    String index(Model m){
        return "index";
    }
    
    @RequestMapping("/working")
    String working(Model m){
        return "working";
    }
    
    
}