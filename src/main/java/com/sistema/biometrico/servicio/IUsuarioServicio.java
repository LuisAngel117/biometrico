package com.sistema.biometrico.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sistema.biometrico.entidad.Usuario;

public interface IUsuarioServicio {
	Usuario crear(Usuario usuario);
	Usuario actualizar(Integer id, Usuario usuario);
	boolean eliminar(Integer id);
	List<Usuario> listarUsuarioActivos();
	boolean isDatabaseEmpty();
}
