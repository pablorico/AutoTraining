package net.redirectme.per.calificador.controllers;
import java.sql.Date;

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

    @RequestMapping(value = "/calificaciones", method = RequestMethod.GET)
    public String calificaciones(Model model){
    	model.addAttribute("calificaciones", calificacionService.listCalificacionesByRango(Date.valueOf("2016-02-01"), new Date(System.currentTimeMillis())));
        return "calificaciones";
    }

    @RequestMapping("/calificar")
    public String newCalificacion(Model model){
        model.addAttribute("calificacion", new Calificacion());
        return "calificacionform";
    }
    
    @RequestMapping(value = "bueno")
    public String saveBueno(){
        calificacionService.addBueno();
        return "redirect:/calificar";
    }
    @RequestMapping(value = "regular")
    public String saveRegular(){
        calificacionService.addRegular();
        return "redirect:/calificar";
    }
    
    @RequestMapping(value = "malo")
    public String saveMalo(){
        calificacionService.addMalo();
        return "redirect:/calificar";
    }
    
    @RequestMapping(value = "excelente")
    public String saveExcelente(){
        calificacionService.addExcelente();
        return "redirect:/calificar";
    }
    /**
    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }

    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
*/
}