package com.sistema.biometrico.servicio;

import java.util.List;

import com.sistema.biometrico.entidad.Empleado;

public interface IEmpleadoServicio {
	
	Empleado crear(Empleado empleado);
	Empleado actualizar(Integer id, Empleado empleado);
	boolean eliminar(Integer id);
	List<Empleado> listarEmpleadosActivos();
}
