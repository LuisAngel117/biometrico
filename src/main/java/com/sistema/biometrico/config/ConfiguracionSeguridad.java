package com.sistema.biometrico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class ConfiguracionSeguridad {
	
	
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder(); 
	  }
	  
	  @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	        	.csrf(csfg->csfg.disable())
	            .authorizeHttpRequests(requests -> requests
	                .requestMatchers("/","/home","/css/**", "/js/**", "/images/**").permitAll()
	                .requestMatchers("/admin/**").hasRole("Admin")
	                .requestMatchers("/user/**").hasRole("Usuario")
	                .anyRequest().authenticated()
	            )
	            .formLogin(
	            	form ->{form
	                .loginPage("/login")
	                .successHandler(new AuthenticationSuccessHandler())
	                .permitAll();
	            	})
	            .logout(logout -> logout
	            		.permitAll());
	        return http.build();
	    }
	   
	    /*
	    @Bean
	    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
	        AuthenticationManagerBuilder authenticationManagerBuilder = 
	            http.getSharedObject(AuthenticationManagerBuilder.class);
	        authenticationManagerBuilder.userDetailsService(servicio).passwordEncoder(passwordEncoder());
	        return authenticationManagerBuilder.build();
	    }
	    */
	  
}
