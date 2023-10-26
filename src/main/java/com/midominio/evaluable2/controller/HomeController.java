package com.midominio.evaluable2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.midominio.evaluable2.service.LibroService;

@Controller
public class HomeController {
	@Autowired
	private LibroService libroService;
	
	
	@GetMapping({"/","/home"})
	public String homeHandeler (Model model) {
	 model.addAttribute("titulo", "Inicio")	;
	 model.addAttribute("tituloH1", "Biblioteca");
	 model.addAttribute("libros", libroService.todosLosLibros());
		return "home";
	   
	   
	   
   } 
	
	
}
