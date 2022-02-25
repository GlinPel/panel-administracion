<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-6 p-3">
				<h1>Welcome Page <c:out value="${currentUser.username}"></c:out></h1>
				<h3>you are a normal user, create an admin account to access the users info</h3>
			    <form id="logoutForm" method="POST" action="/logout">
			        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        <input type="submit" value="Logout!" />
			    </form>
			</div>
		</div>
	</div>
</body>
</html>