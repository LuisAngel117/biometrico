package com.sistema.biometrico.servicio;

import java.util.List;

import com.sistema.biometrico.entidad.Permiso;

public interface IPermisoServicio {
    Permiso crear(Permiso permiso);
	Permiso actualizar(Integer id, Permiso permiso);
	boolean eliminar(Integer id);
	List<Permiso> listarPermisosActivos();

}
