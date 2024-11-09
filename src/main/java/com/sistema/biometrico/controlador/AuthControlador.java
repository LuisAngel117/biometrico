package com.sistema.biometrico.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthControlador {

	  @GetMapping("/home")
	    public String handleWelcome() {
	        return "home";
	    }

	    @GetMapping("/admin/home")
	    public String handleAdminHome() {
	        return "menu/menu_admin";
	    }
	
	    @GetMapping("/user/home")
	    public String handleUserHome() {
	        return "menu/menu_usuario";
	    }
	    
	    @GetMapping("/login")
	    public String handleLogin() {
	        return "log/login";
	    }
}
