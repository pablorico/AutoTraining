package autotraining.basicajax.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class StartController {
 
    @RequestMapping("/")
    String start(){
        return "start";
    }
}
