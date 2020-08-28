<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>My Company Home Page</title>
</head>

<body>

	<h2>Company Home Page</h2>
	<hr>
	
	<p>
	Welcome to my Company Home Page
	</p>
	
	<!-- add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
			  
		<input type="submit" value="logout" />

	</form:form>


</body>

</html>