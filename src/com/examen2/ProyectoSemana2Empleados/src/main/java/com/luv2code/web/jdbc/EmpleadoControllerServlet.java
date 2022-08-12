/*	Becerril Becerril Daniel
 * 	Proyecto Sistema de Empleados
 * 	12/08/2022
 * 	Controlador Servlet
 * */
package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/EmpleadoControllerServlet")
public class EmpleadoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Instancia de la BD
	private EmpleadotDbUtil empleadoDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		// crear instancia del dbempleado util
		try {
			empleadoDbUtil = new EmpleadotDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	//Menu que evalua un comando para ejecutar una acción crud
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// Lee el comando recibido
			String theCommand = request.getParameter("command");
			// si el comando es null le asigna list para que muestre la lista de empleados
			if (theCommand == null) {
				theCommand = "LIST";
			}
			//Evalua el comando para asignarlo al método correspondiente
			switch (theCommand) {
			
			case "LIST":
				listEmpleado(request, response);
				break;
				
			case "ADD":
				addEmpleado(request, response);
				break;
				
			case "LOAD":
				loadEmpleado(request, response);
				break;
				
			case "UPDATE":
				updateEmpleado(request, response);
				break;
			
			case "DELETE":
				deleteEmpleado(request, response);
				break;
				
			default:
				listEmpleado(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}
	//---CRUD---
	//Borrar empleado
	private void deleteEmpleado(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		//recupera el id
		String theEmpleadoId = request.getParameter("empleadoId");
		//Elimina el empleado
		empleadoDbUtil.deleteEmpleado(theEmpleadoId);
		//Regresa a mostrar la lista de empleados
		listEmpleado(request, response);
	}
	//Actualizar empleado
	private void updateEmpleado(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		// Recupera la información del empleado
		int id = Integer.parseInt(request.getParameter("empleadoId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		//Crea un nuevo empleado y le asigna los datos
		Empleado theEmpleado = new Empleado(id, firstName, lastName, email);
		//Realiza la actualización al nuevo empleado
		empleadoDbUtil.updateEmpleado(theEmpleado);
		//Regresa a la lista de empleados
		listEmpleado(request, response);
		
	}
	//Cargar empleado
	private void loadEmpleado(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		//Recupera el empleado
		String theEmpleadoId = request.getParameter("empleadoId");
		//Toma al empleado de la bd(db util)
		Empleado theEmpleado = empleadoDbUtil.getEmpleado(theEmpleadoId);
		//Envia el empleado
		request.setAttribute("THE_EMPLEADO", theEmpleado);
		//Envia al jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-empleado-form.jsp");
		dispatcher.forward(request, response);		
	}
	//Añadir un empleado
	private void addEmpleado(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Recupera la información
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");		
		//Crea un nuevo empleado
		Empleado theEmpleado = new Empleado(firstName, lastName, email);
		//Lo añade a la bd
		empleadoDbUtil.addEmpleado(theEmpleado);		
		//Regresa a la lista de empleados
		listEmpleado(request, response);
	}
	//Ver lista de empleados
	private void listEmpleado(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		//Recupera la lista de empleados
		List<Empleado> empleados = empleadoDbUtil.getEmpleados();
		//Añade los empleados al request
		request.setAttribute("EMPLEADO_LIST", empleados);	
		//Envia a la JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-empleados.jsp");
		dispatcher.forward(request, response);
	}

}
