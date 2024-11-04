package com.sistema.biometrico.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biometrico.entidad.Rol;
import com.sistema.biometrico.repositorio.IRolRepositorio;
import com.sistema.biometrico.servicio.IRolServicio;

@Service
public class RolServicioImpl implements IRolServicio {

	@Autowired
	private IRolRepositorio repositorio;
	@Override
	public Rol crear(Rol rol) {
		// TODO Auto-generated method stub
		return repositorio.save(rol);
	}

	@Override
	public Rol actualizar(Integer id, Rol rol) {
		Rol existencia = repositorio.findById(id).get();
		existencia.setId(id);
		existencia.setNombre(rol.getNombre());
		
		return repositorio.save(existencia);
	}

	@Override
	public boolean eliminar(Integer id) {
		Rol existencia = repositorio.findById(id).get();
		existencia.setId(id);
		existencia.setEstado(true);
	    repositorio.save(existencia);
		return false;
	}

	@Override
	public List<Rol> listarRolActivos() {
		return repositorio.listarRolActivos();
	}

}
