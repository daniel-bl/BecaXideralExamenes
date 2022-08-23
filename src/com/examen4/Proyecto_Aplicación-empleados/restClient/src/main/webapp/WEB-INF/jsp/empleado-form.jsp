<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<!--/*	Becerril Becerril Daniel
 	* 	Proyecto Sistema de Empleados
 	* 	12/08/2022
 	* 	Vista formulario para añadir empleados-->
	<title>Guardar Empleado</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-customer-style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

	<div  class="container d-flex flex-column justify-content-center text-center">
		<div>
			<div>
				<h2>Sistema de gestión de empleados</h2>
			</div>
		</div>

		<div id="container text-center">
			<h3>Guardar Empleado</h3>
			<form:form action="saveEmpleado" modelAttribute="empleado" method="POST">
				<!-- Asociar con el id -->
				<form:hidden path="id" />	
				<table>
					<tbody>
						<tr>
							<td><label class="form-label">Nombre:</label></td>
							<td><form:input class="form-control" path="firstName" /></td>
						</tr>
					
						<tr>
							<td><label class="form-label">Apellido:</label></td>
							<td><form:input class="form-control" path="lastName" /></td>
						</tr>
	
						<tr>
							<td><label class="form-label">Email:</label></td>
							<td><form:input class="form-control" path="email" /></td>
						</tr>
	
						<tr>
							<td><label class="form-label"></label></td>
							<td><input type="submit" value="Guardar" class="btn btn-primary" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear; both;"></div>	
			<p>
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/empleado/list">Regresar</a>
			</p>	
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>

</html>










