package com.midominio.evaluable2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.midominio.evaluable2.entity.Usuario;
import com.midominio.evaluable2.service.UsuarioService;


@Controller
public class UsuarioController {

		
		@Autowired
		private UsuarioService usuarioService;
		
		@ModelAttribute(name="titulo")
		private String dameusuario() {
			return "usuarios";
		
		}

		@GetMapping("/usuarios/all")
		public String listarTodosLosUsuarios(Model model) {
			
			
			model.addAttribute("cabecera", "Listado de usuarios");
			model.addAttribute("cantidad",usuarioService.count());
			model.addAttribute("usuarios", usuarioService.todosLosUsuarios());
			return "usuarios/usuarios";
		
		}
		
		
		@GetMapping("usuarios/borrar/{id}")
		public String borrarPorId(@PathVariable Long id) {
			usuarioService.deleteById(id);
			return "redirect:/usuarios/all";
		}
		
		
		 @GetMapping("/usuarios/form")
		    public  String muestraFormularioVacio(Model model) {
		    	model.addAttribute("usuario", new Usuario());
		    	model.addAttribute("cabecera", "Formulario");
		    	return "/usuarios/form";
		    	
		    }
		
		
		 @PostMapping("/usuarios/form")
		    public String guardaFormulario (Usuario usuario) {
			 usuarioService.save(usuario);
		    	return "redirect:/usuarios/all";
		    	
		    	
		    }
		 
		 @GetMapping("usuarios/form/{id}")
			public String muestraEditar(@PathVariable Long id, Model model) {
				model.addAttribute("usuario",usuarioService.findById(id).orElse(null));
				model.addAttribute("cabecera", "Formulario de edición de un usuario");
				return "usuarios/form";
			}
		 
		
	}
		