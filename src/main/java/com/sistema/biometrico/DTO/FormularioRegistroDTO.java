package com.sistema.biometrico.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormularioRegistroDTO {

	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String correo;
	
	private String username;
	private String password;
	
}
