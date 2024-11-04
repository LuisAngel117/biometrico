package com.sistema.biometrico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.sistema.biometrico.servicioImpl.UsuarioServicioImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfiguracionSeguridad {
	
	@Autowired
	private UsuarioServicioImpl servicio;
	
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder(); 
	  }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests((requests) -> requests
	                .requestMatchers("/", "/home").permitAll()
	                .requestMatchers("/administrador/**").hasRole("Administrador")
	                .anyRequest().authenticated()
	            )
	            .formLogin((form) -> form
	                .loginPage("/login")
	                .permitAll()
	            )
	            .logout((logout) -> logout.permitAll());

	        return http.build();
	    }
	    
	    @Bean
	    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
	        AuthenticationManagerBuilder authenticationManagerBuilder = 
	            http.getSharedObject(AuthenticationManagerBuilder.class);
	        authenticationManagerBuilder.userDetailsService(servicio).passwordEncoder(passwordEncoder());
	        return authenticationManagerBuilder.build();
	    }
	    
	  
}