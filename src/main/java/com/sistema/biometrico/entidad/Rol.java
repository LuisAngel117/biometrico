package com.sistema.biometrico.entidad;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Rol {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @NotBlank(message = "No se permite el campo en blanco")
	 @Size(min = 1, max=10, message="Debe contener 10 números")
	 private String nombre;

	 private boolean estado;
	 @ManyToMany(mappedBy = "rol")
	    private Set<Usuario> usuario = new HashSet<>();

}
