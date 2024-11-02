package com.sistema.biometrico;

import static org.assertj.core.api.Assertions.as;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.x509;

import java.security.PrivateKey;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistema.biometrico.entidad.Empleado;
import com.sistema.biometrico.repositorio.IEmpleadoRepositorio;
import com.sistema.biometrico.servicio.IEmpleadoServicio;
import com.sistema.biometrico.servicioImpl.EmpleadoServicioImpl;



@SpringBootTest
class BiometricoApplicationTests {

	//@Autowired
	//private EmpleadoServicioImpl servicio;
	
	@Test
	void contextLoads() {
	
		//List<Empleado> emp=servicio.listarEmpleadosActivos();
		
		//for(Empleado empleado : emp){
			//System.out.println(empleado.getId());
		//}
		
		
		//emp.setCedula("1234567890");
		//emp.setNombre("Vizzñay");
		//emp.setApellido("Julio");
		//emp.setDireccion("Cutuglagua");
		//emp.setTelefono("123344");
		//emp.setCorreo("julio@gmaila.com");
		//emp.setEstado(false);
		//servicio.eliminar(1, emp);
		
		
	}

}
