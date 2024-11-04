package com.sistema.biometrico.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.biometrico.entidad.Usuario;

@Repository
public interface IUsuarioReposositorio extends JpaRepository<Usuario, Integer> {
	@Query("SELECT u FROM Usuario u WHERE usuario=:username")
	Optional<Usuario> findByUsername(String username);

}
