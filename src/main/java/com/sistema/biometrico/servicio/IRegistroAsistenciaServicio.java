package com.sistema.biometrico.servicio;


import com.sistema.biometrico.DTO.RegistroAsistenciaDTO;
import com.sistema.biometrico.entidad.RegistroAsistencia;

import jakarta.servlet.http.HttpServletRequest;

public interface IRegistroAsistenciaServicio {
	RegistroAsistencia crear(RegistroAsistenciaDTO registroAsistenciaDTO, HttpServletRequest request);
	RegistroAsistencia actualizar(Integer id, RegistroAsistenciaDTO registroAsistenciaDTO);
	boolean eliminar(Integer id);
}
