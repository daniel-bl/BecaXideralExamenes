/*	Becerril Becerril Daniel
 * 	Proyecto Api Rest Empleados
 * 	19/08/2022
 * 	Controlador de la api
 * */
package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Empleado;
import com.luv2code.springboot.cruddemo.service.ServicioEmpleado;
//Controlador para el servicio rest
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {
	//Instancia del servicio y atributo de la clase
	private ServicioEmpleado servicioEmpleado;
	//Constructor(Recibe un objeto del servicio)
	@Autowired
	public EmpleadoRestController(ServicioEmpleado servicioEmpleado) {
		this.servicioEmpleado = servicioEmpleado;
	}
	//Directorio de la aplicación que devolverá la lista de empleados
	@GetMapping("/empleados")
	public List<Empleado> findAll() {
		return servicioEmpleado.findAll();
	}
	
	//Directorio que recuperará unicamente al empleado con el id el la dirección	
	@GetMapping("/empleados/{empleadoId}")
	public Empleado getEmpleado(@PathVariable int empleadoId) {
		//Busca el empleado con el id recuperado
		Empleado empleado = servicioEmpleado.findById(empleadoId);
		//Si no encuentra el empleado arroja la excepción
		if (empleado == null) {
			throw new RuntimeException("Empleado id not found - " + empleadoId);
		}
		return empleado;
	}
	
	//Directorio para el método Post
	@PostMapping("/empleados")
	public Empleado agregarEmpleado(@RequestBody Empleado empleadoRecibido) {
		//Actualiza el id a 0 para guardar el empleado y no actualizarlo
		empleadoRecibido.setId(0);
		//Guarda el empleado
		servicioEmpleado.save(empleadoRecibido);
		return empleadoRecibido;
	}
	
	//Directorio con Put	
	@PutMapping("/empleados")
	public Empleado actualizarEmpleado(@RequestBody Empleado empleadoRecibido) {
		//Guarga el empleado
		servicioEmpleado.save(empleadoRecibido);
		return empleadoRecibido;
	}
	
	//Directorio para Delete	
	@DeleteMapping("/empleados/{idRecibido}")
	public String eliminarEmpleado(@PathVariable int idRecibido) {
		Empleado tempEmployee = servicioEmpleado.findById(idRecibido);
		//Si no se encuentra arroja la excepción
		if (tempEmployee == null) {
			throw new RuntimeException("Empleado id not found - " + idRecibido);
		}
		//elimina
		servicioEmpleado.deleteById(idRecibido);
		//Confirma
		return "Deleted employee id - " + idRecibido;
	}
	
}










