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
			<div class="col-6 p-3">
			<a class="btn btn-primary" href="/login">Return to login page</a>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-12">
				<h1 class="text-info">Welcome!</h1>
				<h4>Join our growing community.</h4>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-6 p-5">
				<h3 class="text-danger">NOTE: only the first user became an ADMIN USER</h3>
				<p><form:errors path="user.*"/></p>
			    <form:form method="POST" action="/registration" modelAttribute="user">
			        <p>
			            <form:label path="username">Username:</form:label>
			            <form:input path="username"/>
			        </p>
			        <p>
			            <form:label path="password">Password:</form:label>
			            <form:password path="password"/>
			        </p>
			        <p>
			            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
			            <form:password path="passwordConfirmation"/>
			        </p>
			        <input type="submit" value="Register!"/>
			    </form:form>
			</div>
		</div>
	</div>
</body>
</html>