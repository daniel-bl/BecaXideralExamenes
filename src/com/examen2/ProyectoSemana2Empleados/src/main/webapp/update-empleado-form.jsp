<!DOCTYPE html>
<html>

<head>
	<!--/*	Becerril Becerril Daniel
 	* 	Proyecto Sistema de Empleados
 	* 	12/08/2022
 	* 	Vista formulario para actualizar empleados-->
	<title>Actualizar Empleado</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
	<div class="container d-flex flex-column justify-content-center text-center">
		<div >
			<div>
				<h2>Sistema de Empleados</h2>
			</div>
		</div>
		<div id="container">
			<h3>Actualizar Empleado</h3>
			<form action="EmpleadoControllerServlet" method="GET">
				<input type="hidden" name="command" value="UPDATE" />
				<input type="hidden" name="studentId" value="${THE_EMPLEADO.id}" />
				<!-- Tabla con los datos -->
				<table>
					<tbody>
						<tr>
							<td><label class="form-label">Nombre:</label></td>
							<td><input class="form-control" type="text" name="firstName" 
									   value="${THE_EMPLEADO.firstName}" /></td>
						</tr>
						<tr>
							<td><label class="form-label">Apellido:</label></td>
							<td><input class="form-control" type="text" name="lastName" 
									   value="${THE_EMPLEADO.lastName}" /></td>
						</tr>
						<tr>
							<td><label class="form-label">Email:</label></td>
							<td><input class="form-control" type="text" name="email" 
									   value="${THE_EMPLEADO.email}" /></td>
						</tr>		
						<tr>
							<td><label></label></td>
							<td><input class="btn btn-primary" type="submit" value="Guardar" class="save" /></td>
						</tr>		
					</tbody>
				</table>
			</form>
			
			<div style="clear: both;"></div>
			<p>
				<a class="btn btn-warning" href="EmpleadoControllerServlet">Regresar</a>
			</p>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>

</html>











