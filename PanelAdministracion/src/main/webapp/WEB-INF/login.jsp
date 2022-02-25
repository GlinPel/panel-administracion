<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registro / Login</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-6 p-5">
			<a class="btn btn-primary" href="/registration">Go to Register Page!</a>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-6 p-5">
				<c:if test="${logoutMessage != null}">
			        <c:out value="${logoutMessage}"></c:out>
			    </c:if>
			    <h1>Login</h1>
			    <c:if test="${errorMessage != null}">
			        <c:out value="${errorMessage}"></c:out>
			    </c:if>
			    <form method="POST" action="/login">
			        <p>
			            <label for="username">Username</label>
			            <input type="text" id="username" name="username"/>
			        </p>
			        <p>
			            <label for="password">Password</label>
			            <input type="password" id="password" name="password"/>
			        </p>
			        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        <input type="submit" value="Login!"/>
			    </form>
			</div>
		</div>
	</div>
</body>
</html>