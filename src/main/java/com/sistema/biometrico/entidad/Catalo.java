package com.sistema.biometrico.entidad;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "catalogos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Catalo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre") 
    @NotNull(message = "La fecha_inicio es obligatoria")
    private String nombre;

    @NotNull(message = "El estado es obligatorio")
    private Boolean estado;

    @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private Set<Permiso> permisos;
}
