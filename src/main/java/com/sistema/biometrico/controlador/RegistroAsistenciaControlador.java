package com.sistema.biometrico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.biometrico.DTO.RegistroAsistenciaDTO;
import com.sistema.biometrico.servicioImpl.RegistroAsistenciaServicioImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/home/registro_asistencia")
public class RegistroAsistenciaControlador {

	@Autowired
	private RegistroAsistenciaServicioImpl servicioImpl;

	@GetMapping("/capturar-ip")
	public String capturarIP(HttpServletRequest request, Model model, RegistroAsistenciaDTO registroAsistenciaDTO) {
		servicioImpl.crear(registroAsistenciaDTO, request);
		return "redirect:/admin/home";
	}
}
