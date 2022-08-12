<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<!--/*	Becerril Becerril Daniel
 	* 	Proyecto Sistema de Empleados
 	* 	12/08/2022
 	* 	Lista-->
	<title>Empleados</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
p

	// get the students from the request object (sent by servlet)
	List<Empleado> theStudents = 
			(List<Empleado>) request.getAttribute("STUDENT_LIST")
%>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Sistema de Empleado</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
				</tr>		
				<%
								p
								 for (Empleado tempStudent : theStudents)
								%>
					<tr>
						<td> <%= tempStudent.getFirstName() %> </td>
						<td> <%= tempStudent.getLastName() %> </td>
						<td> <%= tempStudent.getEmail() %> </td>
					</tr>
				<% } %>	
			</table>
		</div>
	</div>
</body>

</html>








