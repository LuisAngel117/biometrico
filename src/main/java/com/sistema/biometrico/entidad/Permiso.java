package com.sistema.biometrico.entidad;

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

    @NotNull(message = "El estado es obligatorio")
    private Boolean estado;
}




