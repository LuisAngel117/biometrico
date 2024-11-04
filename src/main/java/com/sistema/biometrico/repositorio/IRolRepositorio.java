package com.sistema.biometrico.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.biometrico.entidad.Empleado;
import com.sistema.biometrico.entidad.Rol;

@Repository
public interface IRolRepositorio extends JpaRepository<Rol, Integer> {
	@Query("SELECT r FROM Rol r WHERE nombre=:nombre")
	Optional<Rol> findByNombre(String nombre);
	
	@Query("SELECT r FROM Rol r WHERE r.estado = false")
	List<Rol>listarRolActivos();
}
