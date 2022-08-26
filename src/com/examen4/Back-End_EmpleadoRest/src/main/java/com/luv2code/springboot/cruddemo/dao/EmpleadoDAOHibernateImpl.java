/*	Becerril Becerril Daniel
 * 	Proyecto Api Rest Empleados
 * 	19/08/2022
 * 	Implementación de Hibernate para las operaciones en la BD
 * */
package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Empleado;
//Clase que implementará los métodos para hibernate
@Repository
public class EmpleadoDAOHibernateImpl implements EmpleadoDAO {
	//Objeto que establece la sesión a hb	
	private EntityManager entityManager;
		
	//Inyecta el manejador
	@Autowired
	public EmpleadoDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	//Método para recuperar a los empleados
	@Override
	public List<Empleado> findAll() {
		//Recupera la sesión hb
		Session currentSession = entityManager.unwrap(Session.class);
		//Query
		Query<Empleado> theQuery =
				currentSession.createQuery("from Empleado", Empleado.class);
		//Ejecuta
		List<Empleado> empleados = theQuery.getResultList();
		//Regresa la lista		
		return empleados;
	}

	//Método para buscar a un empleado recibiendo el id
	@Override
	public Empleado findById(int id) {
		//Recupera la sesión hb
		Session currentSession = entityManager.unwrap(Session.class);
		//Obtiene el empleado
		Empleado theEmployee =
				currentSession.get(Empleado.class, id);
		//Regresa el empleado
		return theEmployee;
	}

	//Método para guardar que recibe un empleado
	@Override
	public void save(Empleado empleado) {
		System.out.println(empleado);
		//Recupera la sesión hb
		Session currentSession = entityManager.unwrap(Session.class);
		//Guarda el objeto
		currentSession.saveOrUpdate(empleado);
	}

	//Método para eliminar un empleado de la bd usando el id como parámetro
	@Override
	public void deleteById(int id) {
		//Recupera la sesión hb
		Session currentSession = entityManager.unwrap(Session.class);				
		//elimina el objeto donde el id coincide
		Query theQuery = 
				currentSession.createQuery(
						"delete from Empleado where id=:id");
		theQuery.setParameter("id", id);
		//Ejecuta
		theQuery.executeUpdate();
	}

}







