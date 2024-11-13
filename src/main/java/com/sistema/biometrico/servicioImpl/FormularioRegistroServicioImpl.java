package com.sistema.biometrico.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.biometrico.DTO.FormularioRegistroDTO;
import com.sistema.biometrico.entidad.Empleado;
import com.sistema.biometrico.entidad.Rol;
import com.sistema.biometrico.entidad.Usuario;
import com.sistema.biometrico.repositorio.IEmpleadoRepositorio;
import com.sistema.biometrico.repositorio.IRolRepositorio;
import com.sistema.biometrico.repositorio.IUsuarioRepositorio;
import com.sistema.biometrico.servicio.IFormularioRegistroServicio;

@Service
public class FormularioRegistroServicioImpl implements IFormularioRegistroServicio{

	@Autowired
	private IEmpleadoRepositorio empleadoRepositorio;

	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;

	@Autowired
	private IRolRepositorio rolRepositorio;
	
	@Override
	public void guardarFormulario(FormularioRegistroDTO formularioRegistroDTO) {
		 
		Empleado empleado = new Empleado();
		empleado.setCedula(formularioRegistroDTO.getCedula());
		empleado.setNombre(formularioRegistroDTO.getNombre());
		empleado.setApellido(formularioRegistroDTO.getApellido());
		empleado.setDireccion(formularioRegistroDTO.getDireccion());
		empleado.setTelefono(formularioRegistroDTO.getTelefono());
		empleado.setCorreo(formularioRegistroDTO.getCorreo());
		empleadoRepositorio.save(empleado);
		
		Rol rol1=new Rol();
		rol1.setNombre("Admin");
		rol1.setEstado(false);
		
		Rol rol2=new Rol();
		rol2.setNombre("Usuario");
		rol2.setEstado(false);
	
		Usuario usuario = new Usuario();
		usuario.setEmpleado(empleado);
		usuario.setUsername(formularioRegistroDTO.getUsername());
		usuario.setPassword(new BCryptPasswordEncoder().encode(formularioRegistroDTO.getPassword()));
		
		usuario.getRol().add(rol1);
		usuario.getRol().add(rol2);
		
		usuarioRepositorio.save(usuario);
	}

	
	
}
