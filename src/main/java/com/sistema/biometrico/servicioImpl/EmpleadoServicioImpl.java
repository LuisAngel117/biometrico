package com.sistema.biometrico.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biometrico.entidad.Empleado;
import com.sistema.biometrico.repositorio.IEmpleadoRepositorio;
import com.sistema.biometrico.servicio.IEmpleadoServicio;

@Service
public class EmpleadoServicioImpl implements IEmpleadoServicio {

	@Autowired
	private IEmpleadoRepositorio repositorio;

	@Override
	public Empleado crear(Empleado empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public Empleado actualizar(Integer id, Empleado empleado) {
		Empleado existencia = repositorio.findById(id).get();
		existencia.setId(id);
		existencia.setCedula(empleado.getCedula());
		existencia.setNombre(empleado.getNombre());
		existencia.setApellido(empleado.getApellido());
		existencia.setDireccion(empleado.getDireccion());
		existencia.setTelefono(empleado.getTelefono());
		existencia.setCorreo(empleado.getCorreo());
		return repositorio.save(existencia);
	}

	@Override
	public List<Empleado> listarEmpleadosActivos() {
		return repositorio.listarEmpleadosActivos();
	}

	@Override
	public boolean eliminar(Integer id) {	
		Empleado existencia = repositorio.findById(id).get();
		existencia.setId(id);
		existencia.setEstado(true);
		repositorio.save(existencia);
		return true;
	}



}
