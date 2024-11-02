package com.sistema.biometrico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sistema.biometrico.entidad.Empleado;

import jakarta.transaction.Transactional;

public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
	@Query("SELECT e FROM Empleado e WHERE e.estado = true")
	List<Empleado>listarEmpleadosActivos();

}
