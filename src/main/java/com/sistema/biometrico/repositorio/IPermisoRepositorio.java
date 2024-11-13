package com.sistema.biometrico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.biometrico.entidad.Permiso;

public interface IPermisoRepositorio extends JpaRepository<Permiso, Integer> {
    @Query("SELECT p FROM Permiso p WHERE p.estado = false")
	List<Permiso>listarPermisoActivos();
}
