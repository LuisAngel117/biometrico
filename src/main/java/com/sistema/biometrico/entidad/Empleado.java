package com.sistema.biometrico.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="empleados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empleado_id")
	private Integer id;
	
	/*
	@NotBlank(message = "El número de cédula no puede estar vacío")
	@Size(min = 1, max=10, message="Debe contener 10 números")
	@Pattern(regexp = "^[0-9]*$", message = "Solo se permiten números")
	*/
	@Column(name="cedula", nullable = false, length = 10)
	private String cedula;
	
	/*
	@NotBlank(message = "El número de cédula no puede estar vacío")
	@Size(min = 1, max=10, message="Debe contener máximo 100 caracteres")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Solo se permiten letras")
	*/
	@Column(name="nombre", nullable = false, length = 50)
	private String nombre;
	
	/*
	@NotBlank(message = "El número de cédula no puede estar vacío")
	@Size(min = 1, max=10, message="Debe contener 50 números")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Solo se permiten letras")
	*/
	@Column(name="apellido", nullable = false, length = 50)
	private String apellido;
	
	/*
	@NotBlank(message = "No puede estar vacío este campo")
	@Size(min = 1, max=10, message="Debe contener máximo 100 caracteres")
	*/
	@Column(name="direccion", nullable = false, length = 100)
	private String direccion;
	
	/*
	@NotBlank(message = "No puede estar vacío este campo")
	@Size(min = 1, max=10, message="Debe contener máximo 13 números")
	@Pattern(regexp = "^[0-9]+$", message = "Solo se permiten números")
	*/
	@Column(name="telefono", nullable = false, length = 13)
	private String telefono;
	
	/*
	@NotBlank(message = "No puede estar vacío este campo")
	@Size(min = 1, max=50, message="Debe contener máximo 50 caracteres")
	@Email(message = "El correo debe ser válido")
	*/
	@Column(name="correo", nullable = false, length = 50)
	private String correo;
	
	@Column(name="estado", nullable = false)
	private boolean estado;
	
	 @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Usuario usuario;	
	 
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RegistroAsistencia> pedido = new ArrayList<>();

	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private Set<Permiso> permisos;
}
