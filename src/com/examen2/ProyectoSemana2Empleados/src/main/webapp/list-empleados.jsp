<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<!--/*	Becerril Becerril Daniel
 	* 	Proyecto Sistema de Empleados
 	* 	12/08/2022
 	* 	Vista lista de empleados-->
	<title>Sistema de Empleados</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

	<div class="container d-flex flex-column justify-content-center text-center">
		<div id=>
			<div id=>
				<h2>Sistema de Empleados</h2>
			</div>
		</div>
		<div id="container">
			<div >
				<!-- Boton de añadir -->
				<input class="btn btn-primary mb-3" type="button" value="Agregar nuevo" 
					   onclick="window.location.href='add-student-form.jsp'; return false;"
					   class="add-student-button"
				/>
				<!--Tabla con la lista de empleados-->
				<table class="table table-dark table-hover">	
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Email</th>
						<th>Acción</th>
					</tr>
					<!--Ejecuta código java-->
					<c:forEach var="tempStudent" items="${EMPLEADO_LIST}">
						<!-- For each cada empleado -->
						<c:url var="tempLink" value="EmpleadoControllerServlet">
							<c:param name="command" value="LOAD" />
							<c:param name="studentId" value="${tempEmpleado.id}" />
						</c:url>
						<!-- Borrar empleado -->
						<c:url var="deleteLink" value="EmpleadoControllerServlet">
							<c:param name="command" value="DELETE" />
							<c:param name="studentId" value="${tempEmpleado.id}" />
						</c:url>													
						<tr>
							<td> ${tempEmpleado.firstName} </td>
							<td> ${tempEmpleado.lastName} </td>
							<td> ${tempEmpleado.email} </td>
							<td> 
								<a class="btn btn-success" href="${tempLink}">Actualizar</a> 
								 | 
								<a class="btn btn-danger" href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								Eliminar</a>	
							</td>
						</tr>
					</c:forEach>
					<!-- Termina código java -->
				</table>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>

</html>








