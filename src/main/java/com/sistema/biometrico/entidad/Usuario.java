package com.sistema.biometrico.entidad;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private Integer id;
	
	@NotBlank(message = "El nombre de usuario no puede estar vacío")
	@Size(min = 1, max=50, message="Debe contener máximo 50 carácteres")
	@Column(name="usuario", nullable=false, unique=true)
	private String usuario;
	

	@NotBlank(message = "El número de cédula no puede estar vacío")
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="estado", nullable = false)
	private boolean estado;
	
	@OneToOne
	    @JoinColumn(name = "empleado_id", unique = true, nullable = false)
	    private Empleado empleado;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="usuarios_roles", 
	joinColumns=@JoinColumn(name="usuario_id"),
	inverseJoinColumns = @JoinColumn(name="rol_id"))
 	private Set<Rol> rol = new HashSet<>();

}
