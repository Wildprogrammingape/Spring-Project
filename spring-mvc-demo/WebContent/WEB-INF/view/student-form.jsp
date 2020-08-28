<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<title>Student Registration Form</title>
	
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	First name:<form:input path="firstName"/>
	
	<br><br>
	
	Last name:<form:input path="lastName"/>
	
	<br><br>
	
	Country:
	<form:select path="country">
	
		<!-- spring will call student.getCountryOptions() -->
		
		<form:options items="${student.countryOptions}" />
	
		<!-- 
		<form:option value="Brazil" label="Brazil"/>
		<form:option value="France" label="France"/>
		<form:option value="Canada" label="Canada"/>
		<form:option value="India" label="India"/> 
		-->
		
		
	</form:select>
	
	<br><br>
	
	Favorite Language:
	
	 <!-- spring will call  student.setFavoriteLanguage() method-->
	 
	Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	C# <form:radiobutton path="favoriteLanguage" value="C#"/>
	Python <form:radiobutton path="favoriteLanguage" value="Python"/>
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
	
	<br><br>
	
	Operation Systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
	MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
	
	
	<br><br>
	
	<input type="submit" value="Submit"/>
	
	</form:form>



</body>




</html>