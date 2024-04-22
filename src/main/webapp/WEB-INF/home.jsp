<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>HelloWorld!</h1>
		<div>
			<table>
				<tr>
					<th>Nombre lenguaje</th>
					<th>Creador</th>
					<th>Version</th>
					<th>Accion</th>
				</tr>
				
				<c:forEach var="lenguaje" items="${lenguajesProgramacion}" >
					<tr>
						<td><c:out value="${lenguaje.nombre}"></c:out></td>	
						<td><c:out value="${lenguaje.creador}"></c:out></td>	
						<td><c:out value="${lenguaje.version}"></c:out></td>	
						<td>   <a href="/lenguaje/modificar/${lenguaje.id}">Modificar</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="formulario">
			<form:form action="/crearLenguaje" method="Post" modelAttribute="modelolenguaje"> <!-- El modelAttribute debe coincidir con el nombre del controlador(su modelatribute) -->
				<form:label path="nombre" for="nombre">Nombre:</form:label>
				<form:input type="text" path="nombre" id="nombre" name="nombre"/>
				
				<form:label path="creador" for="creador">Creador:</form:label>
				<form:input type="text" path="creador" id="creador" name="creador"/>
				
				<form:label path="version" for="version">Version:</form:label>
				<form:input type="text" path="version" id="version" name="version"/>
				
				<input type="submit" value="submit">
			</form:form>
			
		</div>
	</body>
</html>