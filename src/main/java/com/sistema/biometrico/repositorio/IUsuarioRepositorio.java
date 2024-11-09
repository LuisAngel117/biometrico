package com.sistema.biometrico.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.biometrico.entidad.Usuario;


@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	
	Usuario findByUsername(String username);
}
