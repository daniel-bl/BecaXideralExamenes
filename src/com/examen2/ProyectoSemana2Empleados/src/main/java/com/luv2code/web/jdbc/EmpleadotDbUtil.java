/*	Becerril Becerril Daniel
 * 	Proyecto Sistema de Empleados
 * 	12/08/2022
 * 	Conexión BD
 * */
package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmpleadotDbUtil {
	//Fuente de datos
	private DataSource dataSource;
	//Constructor
	public EmpleadotDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	//Lista de los empleados
	public List<Empleado> getEmpleados() throws Exception {
		
		List<Empleado> empleados = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// abrir la conexión
			myConn = dataSource.getConnection();
			
			// create el statement
			String sql = "select * from empleado order by last_name";
			
			myStmt = myConn.createStatement();
			
			// guardar el query
			myRs = myStmt.executeQuery(sql);
			
			// obtener datos
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// Crear un nuevo empleado
				Empleado tempEmpleado = new Empleado(id, firstName, lastName, email);
				// Añadirlo a la lista de empleados
				empleados.add(tempEmpleado);				
			}
			
			return empleados;		
		}
		finally {
			// Cerrar la conexión
			close(myConn, myStmt, myRs);
		}		
	}
	//Método para cerrar la conexión
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // regresa la conexión
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	//Query añadir empleado
	public void addEmpleado(Empleado theEmpleado) throws Exception {
		//Objetos para la conexión
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// hace la conexión
			myConn = dataSource.getConnection();
			// insert
			String sql = "insert into empleado "
					   + "(first_name, last_name, email) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theEmpleado.getFirstName());
			myStmt.setString(2, theEmpleado.getLastName());
			myStmt.setString(3, theEmpleado.getEmail());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
	//Query consultar empleado
	public Empleado getEmpleado(String theEmpleadoId) throws Exception {

		Empleado theEmpleado = null;
		//Objetos para la conexión
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int empleadoId;
		
		try {
			// convertir el entero del id
			empleadoId = Integer.parseInt(theEmpleadoId);
			// hacer conexión
			myConn = dataSource.getConnection();
			// obtener el empleado con el id
			String sql = "select * from empleado where id=?";
			// crear el statement
			myStmt = myConn.prepareStatement(sql);
			// enviar los datos
			myStmt.setInt(1, empleadoId);
			// statement
			myRs = myStmt.executeQuery();
			// recuperar la información
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				// usar el id para crear un nuevo empleado
				theEmpleado = new Empleado(empleadoId, firstName, lastName, email);
			}
			else {
				throw new Exception("Could not find empleado id: " + empleadoId);
			}				
			return theEmpleado;
		}
		finally {
			// cerrar conexiones
			close(myConn, myStmt, myRs);
		}
	}
	//Query actualizar empleado
	public void updateEmpleado(Empleado theEmpleado) throws Exception {
		//objetos para la conexión
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			//hacer conexión
			myConn = dataSource.getConnection();
			// query para actualizar
			String sql = "update empleado "
						+ "set first_name=?, last_name=?, email=? "
						+ "where id=?";
			//statement
			myStmt = myConn.prepareStatement(sql);
			//Actualizar con los nuevos datos
			myStmt.setString(1, theEmpleado.getFirstName());
			myStmt.setString(2, theEmpleado.getLastName());
			myStmt.setString(3, theEmpleado.getEmail());
			myStmt.setInt(4, theEmpleado.getId());
			//ejecuta statement
			myStmt.execute();
		}
		finally {
			// cierra conexión
			close(myConn, myStmt, null);
		}
	}
	//Query borrar empleado
	public void deleteEmpleado(String theEmpleadoId) throws Exception {
		//Objetos para la conexión
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// castear id a entero
			int studentId = Integer.parseInt(theEmpleadoId);
			//hacer la conexión
			myConn = dataSource.getConnection();
			//Sentencia para borrar al empleado con el id
			String sql = "delete from empleado where id=?";
			//statement
			myStmt = myConn.prepareStatement(sql);
			//Enviar el id
			myStmt.setInt(1, studentId);
			//Ejecutar acción
			myStmt.execute();
		}
		finally {
			//Cerrar la conexión
			close(myConn, myStmt, null);
		}	
	}
}
