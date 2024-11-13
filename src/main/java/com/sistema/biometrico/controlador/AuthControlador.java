package com.sistema.biometrico.controlador;

import javax.swing.SpinnerNumberModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sistema.biometrico.DTO.FormularioRegistroDTO;
import com.sistema.biometrico.servicioImpl.FormularioRegistroServicioImpl;
import com.sistema.biometrico.servicioImpl.UsuarioServicioImpl;


@Controller
public class AuthControlador {
	
	@Autowired
	private FormularioRegistroServicioImpl formularioRegistroServicio;
	
	@Autowired
	private UsuarioServicioImpl usuarioServicio;

	@GetMapping({ "/", "/home" })
	public String handleWelcome() {
		return "home";
	}
	
	@GetMapping("/home/registro")
	public String handleRegistro(Model model) {
		model.addAttribute("formularioRegistroDTO", new FormularioRegistroDTO());
		return "log/log_registro";
	}

	@PostMapping("/home/guardar")
	public String handleGuardarRegistro(@ModelAttribute FormularioRegistroDTO formularioRegistroDTO, Model model) {
		formularioRegistroServicio.guardarFormulario(formularioRegistroDTO);
		model.addAttribute("mensaje", "Datos guardados exitosamente!");
		return "redirect:/login";
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
	public String handleLogin(Model model) {
		boolean isDatabaseEmpty = usuarioServicio.isDatabaseEmpty();
		model.addAttribute("isDatabaseEmpty", isDatabaseEmpty);
		return "log/login";
	}
}
