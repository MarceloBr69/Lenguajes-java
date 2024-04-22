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
		<div>
		<h1>Editar lenguaje</h1>
			<form:form action="/editar/${lenguajeActual.id}" method="Post" modelAttribute="modelolenguaje"> <!-- El modelAttribute debe coincidir con el nombre del controlador(su modelatribute) -->
				<input type="hidden" name="_method" value="PUT"> <!-- Valor PUT permite la modificacion -->
				<form:label path="nombre" for="nombre">Nombre:</form:label>
				<form:errors path="nombre"/>
				<form:input type="text" path="nombre" id="nombre" name="nombre" value="${lenguajeActual.nombre}"/>
				
				<form:label path="creador" for="creador">Creador:</form:label>
				<form:input type="text" path="creador" id="creador" name="creador" value="${lenguajeActual.creador}"/>
				
				<form:label path="version" for="version">Version:</form:label>
				<form:input type="text" path="version" id="version" name="version" value="${lenguajeActual.version}"/>
				
				<input type="submit" value="submit">
			</form:form>
		</div>
		<div>
			<form:form action="/lenguaje/eliminar/${lenguajeActual.id}" method="POST" modelAttribute="modelolenguaje">
				<form:label path="id">Eliminar lenguaje</form:label>
				<input type="hidden" name="_method" value="DELETE">
				<input type="submit" value="eliminar"/>
			</form:form>
		</div>
	</body>
</html>