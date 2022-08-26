/*	Becerril Becerril Daniel
 * 	Proyecto Api Rest Empleados
 * 	19/08/2022
 * 	Interfaz para los métodos a impementar en la capa de persistencia
 * */
package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Empleado;
//Interfaz que define los métodos que hibernate manejará
public interface EmpleadoDAO {
	//Para recuperar los empleados
	public List<Empleado> findAll();
	//Buscar por id
	public Empleado findById(int theId);
	//Guardar
	public void save(Empleado theEmployee);
	//Eliminar
	public void deleteById(int theId);
	
}
