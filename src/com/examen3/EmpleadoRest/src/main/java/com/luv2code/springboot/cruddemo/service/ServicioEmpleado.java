/*	Becerril Becerril Daniel
 * 	Proyecto Api Rest Empleados
 * 	19/08/2022
 * 	Interfaz para los métodos a implementar por el servicio
 * */
package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Empleado;
//Interfaz que define los servicios que implementará la aplicación
public interface ServicioEmpleado {
	//Para recuperar los empleados
	public List<Empleado> findAll();
	//Buscar por id
	public Empleado findById(int id);
	//Guardar
	public void save(Empleado empleado);
	//Eliminar
	public void deleteById(int id);
	
}
