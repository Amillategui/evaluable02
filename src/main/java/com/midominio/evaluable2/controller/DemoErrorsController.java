package com.midominio.evaluable2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class DemoErrorsController {
	
	private String s;

	@GetMapping("/template-no-existe")
	public String m1() {
		return "template-no-existe";
	}
	
	@GetMapping("/null-pointer")
	public String m3() {
		s = null;
		s.length();
	
		return "template-no existe";
	}
}
	
	
