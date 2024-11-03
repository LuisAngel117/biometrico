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

import com.sistema.biometrico.entidad.Empleado;
import com.sistema.biometrico.servicioImpl.EmpleadoServicioImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/empleados")
public class EmpleadoControlador {
	@Autowired
	private EmpleadoServicioImpl servicio;
	
	@GetMapping
	public String listarEmpleado(Model model) {
		List<Empleado> empleado = servicio.listarEmpleadosActivos();
		model.addAttribute("listarEmpleado", empleado);
		return "FrmListarEmpleado";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormularioDeNuevo(Model model) {
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("accion", "/empleados/nuevo");
		return "FrmEmpleado";
	}
	
	@PostMapping("/nuevo")
	public String guardarNuevoEmpleado(@Valid @ModelAttribute Empleado empleado, BindingResult result) {
		if (result.hasErrors()) {
			return "FrmEmpleado";
		}
		servicio.crear(empleado);
		return"redirect:/empleados";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditarEmpleado(@PathVariable Integer id,@ModelAttribute Empleado empleado, Model model) {
		model.addAttribute("empleado", empleado);
		model.addAttribute("accion", "/empleados/editar/"+id);
		return "FrmEmpleado";
	}
	@PostMapping("editar/{id}")
	public String actualizarEmpleado(@PathVariable Integer id, @ModelAttribute Empleado empleado) {
		servicio.actualizar(id, empleado);
		return "redirect:/empleados";
	}
	
	@GetMapping ("/eliminar/{id}")
	public String eliminarCliente(@PathVariable Integer id) {
		servicio.eliminar(id);
		return "redirect:/empleados";
	}

}
