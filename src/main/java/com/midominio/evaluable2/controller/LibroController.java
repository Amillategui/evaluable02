package com.midominio.evaluable2.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.midominio.evaluable2.dao.LibroRepository;
import com.midominio.evaluable2.service.LibroService;

import jakarta.persistence.Id;

@Controller
public class LibroController {



	
	@Autowired
	LibroRepository libroRepository;
	
	@Autowired
	com.midominio.evaluable2.service.MultiService multiService;

	
	@GetMapping("/libros1")
	public String contadordelibros(Model model) {
		model.addAttribute("numLibros", libroRepository.count());
		return "libros/libros";
	}
	
	@GetMapping("/libros2")
	public String borradordeTodoslosLibros(Model model) {
		libroRepository.deleteAll();
		model.addAttribute("numLibros", libroRepository.count());
		return "libros/libros";
	}
	
	@GetMapping("/libros3")
	public String iddeLibro(@RequestParam Long id, Model model) {
		model.addAttribute("tituloH1", "Test request param id");
		if(libroRepository.existsById(id)) {
			model.addAttribute("resultado", "El id = " + id + " si existe");
		} else {
			model.addAttribute("resultado", "El id = " + id + " no existe");
		}
		return "libros/libros";
	}
	
	@GetMapping("/libros/{id}")
	public String comprobaciondeLibro(@PathVariable Long id, Model model) {
		model.addAttribute("tituloH1", "Test request param id");
		if(libroRepository.existsById(id)) {
			model.addAttribute("resultado", "El id = " + id + " si existe");
		} else {
			model.addAttribute("resultado", "El id = " + id + " no existe");
		}
		return "libros/libros";
	}
	
	@GetMapping("/libros5")
	public String lstadodeLibros(Model model) {
		model.addAttribute("tituloH1", "Test lista de libros");
		model.addAttribute("articulos", libroRepository.findAll());
		return "libros/libros";
	}
	
	
	@GetMapping("/libros6")
	public String borradoyMuestra(@RequestParam Long id, Model model) {
		model.addAttribute("tituloH1", "Test borra libro");
		libroRepository.deleteById(id);
		model.addAttribute("libros", libroRepository.findAll());
		return "libros/libros";
	}
	
	@GetMapping("/libros")
	public String encontrarporid(@RequestParam Long id, Model model) {
		model.addAttribute("tituloH1", "Test encuentra un libro");
		model.addAttribute("libro", libroRepository.findById(id).orElse(null));
		model.addAttribute("idSolicitado", id);
		return "libros/libros";
	}
	
	

	
}