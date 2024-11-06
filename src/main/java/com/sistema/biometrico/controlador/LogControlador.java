package com.sistema.biometrico.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogControlador {

	@GetMapping("/login")
	public String inicioSesion() {
		return "log/login";
	}
	
	@GetMapping("/home") 
	public String home() { 
		return "home"; 
	}

}
