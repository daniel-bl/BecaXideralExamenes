/*	Becerril Becerril Daniel
 * 	Proyecto Api Rest Empleados
 * 	19/08/2022
 * 	Implementación del servicio
 * */
package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmpleadoDAO;
import com.luv2code.springboot.cruddemo.entity.Empleado;
//Implementación de la interfaz de servicio
@Service
public class ServicioEmpleadoImpl implements ServicioEmpleado {
	//Objeto para la instancia de los métodos con la bd
	private EmpleadoDAO empleadoDAO;
	//Constructor
	@Autowired
	public ServicioEmpleadoImpl(@Qualifier("empleadoDAOJdbcImpl")EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}
	//Método que llamara al método de hb para hacer la consuta de los empleados
	@Override
	@Transactional
	public List<Empleado> findAll() {
		return empleadoDAO.findAll();
	}
	//Método que llamara al método de hb para buscar por id
	@Override
	@Transactional
	public Empleado findById(int id) {
		return empleadoDAO.findById(id);
	}
	//Método que llamara al método de hb para guardar en la bd
	@Override
	@Transactional
	public void save(Empleado empleadoGuardar) {
		empleadoDAO.save(empleadoGuardar);
	}
	//Método que llamara al método de hb para eliminar recibiendo un id
	@Override
	@Transactional
	public void deleteById(int idEliminar) {
		empleadoDAO.deleteById(idEliminar);
	}

}






