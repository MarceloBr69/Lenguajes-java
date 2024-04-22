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
			<form:form action="/lenguaje/eliminar/${id}" method="GET">
				<h5>Deseas borrar este lenguaje? </h5>
				<input type="hidden" name="_method" value="DELETE">
				<button>Eliminar</button>
			</form:form>
			<form:form action="/lenguajes" method="GET">
				<input type="submit" value="No">
			</form:form>
		</div>
	</body>
</html>