package com.sistema.biometrico.entidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="registro_asistencias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistroAsistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="registro_id")
	private Integer id;
	
	@Column(name="fecha")
	private LocalDate fecha;
	
	@Column(name="hora_entrada")
	private LocalDateTime horaEntrada;
	
	@Column(name="hora_salida_almuerzo")
	private LocalDateTime horaSalidaAlmuerzo;
	
	@Column(name="hora_regreso_almuerzo")
	private LocalDateTime horaRegresoAlmuerzo;
	
	@Column(name="hora_salida_final")
	private LocalDateTime horaSalidaFinal;
	
	@Column(name="total_horas")
	private String totalHoras;
	
	@Column(name="condicion")
	private String condicion;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "empleado_id")
	private Empleado empleado;
	
	
}
