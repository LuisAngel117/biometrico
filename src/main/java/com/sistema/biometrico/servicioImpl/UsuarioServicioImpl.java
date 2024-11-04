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
import com.sistema.biometrico.repositorio.IUsuarioReposositorio;
import com.sistema.biometrico.servicio.IUsuarioServicio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{
	@Autowired
	private IUsuarioReposositorio repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
	        
	        return new org.springframework.security.core.userdetails.User(usuario.getUsuario(), usuario.getPassword(), getAuthorities(usuario));
	   
		/*
		Usuario usuario = repositorio.findByUsername(username);
	        if (usuario == null) {
	            throw new UsernameNotFoundException("Usuario no encontrado");
	        }
	        return User.withUsername(usuario.getUsuario())
	                .password(usuario.getPassword())
	                .roles(usuario.getRol().stream().map(Rol::getNombre).toArray(String[]::new))
	                .build();
	    */
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
        return usuario.getRol().stream()
            .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
            .collect(Collectors.toList());
    }

	@Override
	public Usuario crear(Usuario usuario) {
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return repositorio.save(usuario);
	}

	@Override
	public Usuario actualizar(Integer id, Usuario usuario) {
		Usuario existencia = repositorio.findById(id)
	            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
	        
	        existencia.setUsuario(usuario.getUsuario());
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

	

}
