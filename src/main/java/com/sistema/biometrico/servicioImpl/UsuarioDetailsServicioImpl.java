package com.sistema.biometrico.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistema.biometrico.entidad.Usuario;
import com.sistema.biometrico.entidad.UsuarioSeguridad;
import com.sistema.biometrico.repositorio.IUsuarioRepositorio;

@Service
public class UsuarioDetailsServicioImpl implements UserDetailsService{

	@Autowired
	private IUsuarioRepositorio repositorio;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Usuario user = repositorio.findByUsername(username);
	        if(user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new UsuarioSeguridad(user);
	}

}
