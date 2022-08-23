<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!--/*	Becerril Becerril Daniel
 	* 	Proyecto Sistema de Empleados
 	* 	12/08/2022
 	* 	Vista lista de empleados-->
	<title>Sistema de Empleados</title>
	<!-- Recursos -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
	<div class="container d-flex flex-column justify-content-center text-center">
		<div>
			<div>
				<h2>Sistema de gestión de empleados</h2>
			</div>
		</div>
		<div id="container">	
			<div id="content">
				<!-- Boton de añadir -->
				<input class="btn btn-primary mb-3" type="button" value="Agregar nuevo"
					   onclick="window.location.href='showFormForAdd'; return false;"
					   class="add-button"
				/>
				<!--  Tabla -->
				<table class="table table-dark table-hover">
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Email</th>
						<th>Acción</th>
					</tr>
					
					<!-- Itera y muestra los empleados -->
					<c:forEach var="tempEmpleado" items="${empleados}">
						<!-- Actualizar -->
						<c:url var="updateLink" value="/empleado/showFormForUpdate">
							<c:param name="empleadoId" value="${tempEmpleado.id}" />
						</c:url>					
						<!-- Eliminar -->
						<c:url var="deleteLink" value="/empleado/delete">
							<c:param name="empleadoId" value="${tempEmpleado.id}" />
						</c:url>					
						
						<tr>
							<td> ${tempEmpleado.firstName} </td>
							<td> ${tempEmpleado.lastName} </td>
							<td> ${tempEmpleado.email} </td>
							
							<td>
								<!-- display the update link -->
								<a class="btn btn-success" href="${updateLink}">Actualizar</a>
								|
								<a class="btn btn-danger" href="${deleteLink}"
								   onclick="if (!(confirm('¿Está seguro de eliminar este empleado?'))) return false">Eliminar</a>
							</td>			
						</tr>		
					</c:forEach>				
				</table>			
			</div>
		</div>
	</div>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>

</html>









