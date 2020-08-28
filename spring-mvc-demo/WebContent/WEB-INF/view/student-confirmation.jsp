<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Student Confirmation</title>
	
</head>

<body>

<!-- spring will call student.getFirstName() here -->

The student is confirmed : ${student.firstName}  ${student.lastName}

<br><br>

<!-- spring will call student.getCountry() here -->

Country: ${student.country}

<br><br>

<!-- spring will call student.getFavoriteLanguage() here -->

Favorite Language: ${student.favoriteLanguage}

<br><br>

Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
	
	<li>${temp}</li>
	
	</c:forEach>
</ul>

<br><br>

</body>

</html>