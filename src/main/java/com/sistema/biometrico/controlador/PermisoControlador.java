package com.sistema.biometrico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.biometrico.entidad.Permiso;
import com.sistema.biometrico.entidad.Permiso;
import com.sistema.biometrico.servicioImpl.PermisoServicioImpl;
import com.sistema.biometrico.servicioImpl.PermisoServicioImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/permisos")
public class PermisoControlador {
    @Autowired
	private PermisoServicioImpl servicio;
	
	@GetMapping
	public String listarPermiso(Model model) {
		List<Permiso> permiso = servicio.listarPermisosActivos();
		model.addAttribute("listarPermiso", permiso);
		return "FrmListarPermiso";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormularioDeNuevo(Model model) {
		model.addAttribute("permiso", new Permiso());
		model.addAttribute("accion", "/permisos/nuevo");
		return "FrmPermiso";
	}
	
	@PostMapping("/nuevo")
	public String guardarNuevoPermiso(@Valid @ModelAttribute Permiso permiso, BindingResult result) {
		if (result.hasErrors()) {
			return "FrmPermiso";
		}
		servicio.crear(permiso);
		return"redirect:/permisos";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditarPermiso(@PathVariable Integer id,@ModelAttribute Permiso permiso, Model model) {
		model.addAttribute("permiso", permiso);
		model.addAttribute("accion", "/permisos/editar/"+id);
		return "editar_permiso.html";
	}
	@PostMapping("editar/{id}")
	public String actualizarPermiso(@PathVariable Integer id, @ModelAttribute Permiso permiso) {
		servicio.actualizar(id, permiso);
		return "redirect:/permisos";
	}
	
	@GetMapping ("/eliminar/{id}")
	public String eliminarPermiso(@PathVariable Integer id) {
		servicio.eliminar(id);
		return "redirect:/permisos";
	}
}
