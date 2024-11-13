package com.sistema.biometrico.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biometrico.entidad.Empleado;
import com.sistema.biometrico.entidad.Permiso;
import com.sistema.biometrico.repositorio.IPermisoRepositorio;
import com.sistema.biometrico.servicio.IPermisoServicio;

@Service
public class PermisoServicioImpl implements IPermisoServicio{

    @Autowired
	private IPermisoRepositorio repositorio;

    @Override
    public Permiso crear(Permiso permiso) {
        return repositorio.save(permiso);
    }

    @Override
    public Permiso actualizar(Integer id, Permiso permiso) {
        Permiso existencia = repositorio.findById(id).get();
		existencia.setId(id);
		existencia.setEmpleado(permiso.getEmpleado());
        return repositorio.save(existencia);
    }

    @Override
    public boolean eliminar(Integer id) {
        Permiso existencia = repositorio.findById(id).get();
		existencia.setId(id);
		existencia.setEstado(true);
		repositorio.save(existencia);
		return true;
    }

    @Override
    public List<Permiso> listarPermisosActivos() {
        return repositorio.listarPermisoActivos();
    }


}
