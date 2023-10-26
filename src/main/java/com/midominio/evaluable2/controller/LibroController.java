package com.midominio.evaluable2.controller;



import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.midominio.evaluable2.dao.LibroRepository;
import com.midominio.evaluable2.entity.Libro;
import com.midominio.evaluable2.service.LibroService;

import jakarta.persistence.Id;

@Controller
public class LibroController {



	
	@Autowired
	private LibroService libroService;
	
	@ModelAttribute(name="titulo")
	private String damelibro() {
		return "libros";
	
	}

	@GetMapping("/libros/all")
	public String listarTodosLosLibros(Model model) {
		
		
		model.addAttribute("cabecera", "Listado de libros");
		model.addAttribute("cantidad",libroService.count());
		model.addAttribute("libros", libroService.todosLosLibros());
		return "libros/libros";
	
	}
	
	
	@GetMapping("libros/borrar/{id}")
	public String borrarPorId(@PathVariable Long id) {
		libroService.deleteById(id);
		return "redirect:/libros/all";
	}
	
	
	 @GetMapping("/libros/form")
	    public  String muestraFormularioVacio(Model model) {
	    	model.addAttribute("libro", new Libro());
	    	model.addAttribute("cabecera", "Formulario");
	    	return "/libros/form";
	    	
	    }
	
	 @PostMapping("/libros/form")
	    public String guardaFormulario (Libro libro) {
		 libroService.save(libro);
	    	return "redirect:/libros/all";
	    	
	    	
	    }
	 
	 @GetMapping("libros/form/{id}")
		public String muestraEditar(@PathVariable Long id, Model model) {
			model.addAttribute("libro",libroService.findById(id).orElse(null));
			model.addAttribute("cabecera", "Formulario de edición de libro");
			return "/libros/form";
		}
	 
	
}

	