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
import com.sistema.biometrico.entidad.Rol;
import com.sistema.biometrico.entidad.Usuario;
import com.sistema.biometrico.repositorio.IEmpleadoRepositorio;
import com.sistema.biometrico.servicio.IEmpleadoServicio;
import com.sistema.biometrico.servicioImpl.EmpleadoServicioImpl;
import com.sistema.biometrico.servicioImpl.RolServicioImpl;
import com.sistema.biometrico.servicioImpl.UsuarioServicioImpl;



@SpringBootTest
class BiometricoApplicationTests {

	//@Autowired
	//private EmpleadoServicioImpl servicio;
	
	//@Autowired
	//private UsuarioServicioImpl servicio;
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
		
	
		//Empleado emp=new Empleado();
        //emp.setCedula("1234567890");
		//emp.setNombre("Maria");
		//emp.setApellido("Benavidez");
		//emp.setDireccion("Guamani");
		//emp.setTelefono("4564344556");
		//emp.setCorreo("maria@gmaila.com");
		//servicio.crear(emp);
		
		//Empleado empleado=new Empleado();
		//empleado.setId(1);
		
		//Usuario u=new Usuario();
		//u.setNombreUsuario("Pedro");
		//u.setPassword("123");
		//u.setEmpleado(empleado);
		//servicio.crear(u);
	}
	
	@Autowired
		private UsuarioServicioImpl servicioUsuario;
	
	@Autowired
		private RolServicioImpl servicioRol;
	
	@Autowired
	private EmpleadoServicioImpl servicioEmpleado;
	/*
	@Test
	void contextLoads2() {
		
		Empleado emp=new Empleado();
        emp.setCedula("1234567890");
		emp.setNombre("Maria");
		emp.setApellido("Benavidez");
		emp.setDireccion("Guamani");
		emp.setTelefono("4564344556");
		emp.setCorreo("maria@gmaila.com");
		servicioEmpleado.crear(emp);
		
		Rol rol1=new Rol();
		rol1.setNombre("Admin");
		rol1.setEstado(false);
		
		Rol rol2=new Rol();
		rol2.setNombre("Usuario");
		rol2.setEstado(false);
		
		Usuario u=new Usuario();
		u.setUsuario("Pedro");
		u.setPassword("123");
		u.setEmpleado(emp);
		
		
		u.getRol().add(rol1);
		u.getRol().add(rol2);
		servicioUsuario.crear(u);
	}
	*/


}
