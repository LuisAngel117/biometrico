package com.sistema.biometrico.entidad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "permisos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permiso {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //referencia a empleado 
	@JoinColumn(name = "empleadoId")
	private Empleado empleado;
    private boolean estado;
}
