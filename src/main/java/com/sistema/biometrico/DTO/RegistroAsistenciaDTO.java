package com.sistema.biometrico.DTO;

import com.sistema.biometrico.entidad.Empleado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegistroAsistenciaDTO {
	
	private String ip;
	private Empleado empleado;

}
