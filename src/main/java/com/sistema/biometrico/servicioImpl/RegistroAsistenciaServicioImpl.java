package com.sistema.biometrico.servicioImpl;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biometrico.DTO.RegistroAsistenciaDTO;
import com.sistema.biometrico.entidad.RegistroAsistencia;
import com.sistema.biometrico.repositorio.IRegistroAsistenciaRepositorio;
import com.sistema.biometrico.servicio.IRegistroAsistenciaServicio;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class RegistroAsistenciaServicioImpl implements IRegistroAsistenciaServicio {

	@Autowired
	private IRegistroAsistenciaRepositorio repositorio;
	
	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
/*public List<RegistroAsistencia> obtenerRegistrosPorEmpleado(Long empleadoId) { 
 * Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow(() -> new RuntimeException("Empleado no encontrado")); 
 * return empleado.getRegistros(); }
 * 
 * */

	@Override
	public RegistroAsistencia crear(RegistroAsistenciaDTO registroAsistenciaDTO, HttpServletRequest request) {
		
		RegistroAsistencia registroAsistencia=new RegistroAsistencia();
		
		String ip= request.getRemoteAddr();
		registroAsistencia.setEmpleado(registroAsistenciaDTO.getEmpleado());
		registroAsistencia.setIp(ip);
		
		return repositorio.save(registroAsistencia);
	}

	@Override
	public RegistroAsistencia actualizar(Integer id, RegistroAsistenciaDTO registroAsistenciaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
