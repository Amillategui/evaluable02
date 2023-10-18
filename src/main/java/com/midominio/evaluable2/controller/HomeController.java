package com.midominio.evaluable2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
   
	
	@GetMapping({"/","/home"})
	public String homeHandeler (Model model) {
	 model.addAttribute("titulo", "Inicio")	;
	 model.addAttribute("tituloH1", "Biblioteca");
		return "home";
	   
	   
	   
   } 
	
	
}
