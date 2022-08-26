/*	Becerril Becerril Daniel
 * 	Proyecto Api Rest Empleados
 * 	19/08/2022
 * 	Implementación de JDBC para las operaciones en la BD
 * */
package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Empleado;

@Repository
public class EmpleadoDAOJdbcImpl implements EmpleadoDAO {
	//Fuente de datos
	@Autowired
	DataSource dataSource;
	//Método para recuperar la lista de empleados
	@Override
	public List<Empleado> findAll(){
		//Try With resource
		System.out.println("Implementación DAO con JDBC: "+ dataSource);
		//Lista de empleados
		List<Empleado> listaEmpleados = new ArrayList<>();
		try(//Abrir la conexión
			Connection myConn = dataSource.getConnection();
			//Preparar el query
			PreparedStatement myStmt = myConn.prepareStatement("select * from empleado"); 
		){
			try(//Ejecutar query
				ResultSet myRs = myStmt.executeQuery();
			){
				// process result set
				while (myRs.next()) {						
					// retrieve data from result set row
					int id = myRs.getInt("id");
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String email = myRs.getString("email");				
					// create new student object
					Empleado tempEmployee = new Empleado(id, firstName, lastName, email);			
					// add it to the list of students
					listaEmpleados.add(tempEmployee);
				}	
			}
		} catch (SQLException e) {
			System.out.println("Error with resource");
			e.printStackTrace();
		}
		return listaEmpleados;
	}
	
	//Método para buscar empleado con el id
	@Override
	public Empleado findById(int idRecibido) {
		Empleado empleado = null;
		try(//Abrir la conexión
			Connection myConn = dataSource.getConnection();
			//Preparar el query
			PreparedStatement myStmt = myConn.prepareStatement("select * from empleado where id=?");	
		){
			// enviar los datos
			myStmt.setInt(1, idRecibido);
			try(//Ejecutar query
				ResultSet myRs = myStmt.executeQuery();
			){
				// recuperar la información
				if (myRs.next()) {
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String email = myRs.getString("email");
					// usar el id para crear un nuevo empleado
					empleado = new Empleado(idRecibido, firstName, lastName, email);
				}
				else {
					throw new Exception("Could not find empleado id: " + idRecibido);
				}				
				return empleado;	
			}
			
		} catch (Exception e) {
			//En caso de excepción
			System.out.println("Error: "+idRecibido);
			e.printStackTrace();
		}
		return empleado;
	}

	//Método opara guardar o actualizar un empleado
	@Override
	public void save(Empleado empleadoRecibido) {

		try {
			if(empleadoRecibido.getId()!=0) {
				//Entra cuando es actualización
				try(//Abrir la conexión
					Connection myConn = dataSource.getConnection();
					//Preparar el query
					PreparedStatement myStmt = myConn.prepareStatement("update empleado "
							+ "set first_name=?, last_name=?, email=? "
							+ "where id=?");	
				){
					//Actualizar con los nuevos datos
					myStmt.setString(1, empleadoRecibido.getFirstName());
					myStmt.setString(2, empleadoRecibido.getLastName());
					myStmt.setString(3, empleadoRecibido.getEmail());
					myStmt.setInt(4, empleadoRecibido.getId());
					//Ejecuta sql
					myStmt.execute();
				}
			}else {
				try(//Abrir la conexión
					Connection myConn = dataSource.getConnection();
					//Preparar el query
					PreparedStatement myStmt = myConn.prepareStatement("insert into empleado " + "(first_name, last_name, email) " + "values (?, ?, ?)");	
				){
					//Ejecutar la insersión
					myStmt.setString(1, empleadoRecibido.getFirstName());
					myStmt.setString(2, empleadoRecibido.getLastName());
					myStmt.setString(3, empleadoRecibido.getEmail());
					//Ejecuta sql
					myStmt.execute();
				}	
			}
		} catch (SQLException e) {
			System.out.println("Error en el bloque save");
			e.printStackTrace();
		}
	}
	
	//Método para eliminar un empleado
	//Método para eliminar un empleado usando un id como parámetro
	@Override
	public void deleteById(int idRecibido) {				
		try(//Abrir la conexión
			Connection myConn = dataSource.getConnection();
			//Preparar el query
			PreparedStatement myStmt = myConn.prepareStatement("delete from empleado where id=?");	
		){
			//Enviar el id
			myStmt.setInt(1, idRecibido);
			//Ejecutar acción
			myStmt.execute();
		}catch (SQLException e) {
			System.out.println("No se encontró empleado con ese id");
			//e.printStackTrace();
		}
	}

}