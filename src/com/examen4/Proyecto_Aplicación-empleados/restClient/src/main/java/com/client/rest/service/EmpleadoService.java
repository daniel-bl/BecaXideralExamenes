/*	Becerril Becerril Daniel
 * 	Proyecto Sistema de empleados
 * 	19/08/2022
 * 	Interfaz de los metodos que necesitará el servicio
 * */
package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Empleado;

public interface EmpleadoService {
	//Obtener la lista de empleados
	public List<Empleado> getEmpleados();
	//Guardar un empleado
	public void saveEmpleado(Empleado empleado);
	//Obtener un empleado
	public Empleado getEmpleado(int theId);
	//Eliminar un empleado
	public void deleteEmpleado(int theId);
	
}
