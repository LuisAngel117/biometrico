package com.sistema.biometrico.entidad;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "permisos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "empleado_id")
    @NotNull(message = "El empleado es obligatorio")
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "catalogo_id")
    @NotNull(message = "El tipo de permiso es obligatorio")
    private Catalo catalogo;

    @NotNull(message = "El estado es obligatorio")
    private Boolean estado;

    private String descripcion; 

    @Column(name = "fecha_inicio") 
    @Temporal(TemporalType.DATE) 
    @NotNull(message = "La fecha_inicio es obligatoria")
    private Date fechaInicio; 

    @Column(name = "fecha_fin") 
    @Temporal(TemporalType.DATE) 
    @NotNull(message = "La fecha_fin es obligatoria")
    private Date fechaFin;
}




