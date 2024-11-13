package com.sistema.biometrico.servicioImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.biometrico.entidad.Usuario;
import com.sistema.biometrico.repositorio.IUsuarioRepositorio;
import com.sistema.biometrico.servicio.IUsuarioServicio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{
	@Autowired
	private IUsuarioRepositorio repositorio;

	@Override
	public Usuario crear(Usuario usuario) {
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return repositorio.save(usuario);
	}

	@Override
	public Usuario actualizar(Integer id, Usuario usuario) {
		Usuario existencia = repositorio.findById(id)
	            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
	        
	        existencia.setUsername(usuario.getUsername());
	        existencia.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
	        existencia.setRol(usuario.getRol());
	        
	        return repositorio.save(existencia);
	}

	@Override
	public boolean eliminar(Integer id) {
		 Usuario existente = repositorio.findById(id)
		            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
		        
		        existente.setEstado(true);    
		        repositorio.save(existente);
		        return true;
	}

	@Override
	public List<Usuario> listarUsuarioActivos() {
		return repositorio.findAll();
	}

	@Override
	public boolean isDatabaseEmpty() {
		return repositorio.count()==0;
	}

	

}
