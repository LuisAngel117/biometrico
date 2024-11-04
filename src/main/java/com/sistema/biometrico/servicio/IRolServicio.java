package com.sistema.biometrico.servicio;

import java.util.List;

import com.sistema.biometrico.entidad.Rol;

public interface IRolServicio {
	Rol crear(Rol rol);
	Rol actualizar(Integer id, Rol rol);
	boolean eliminar(Integer id);
	List<Rol> listarRolActivos();
}
