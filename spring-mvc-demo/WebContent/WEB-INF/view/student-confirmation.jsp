<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Confirmation</title>
</head>
<body>

	The Student is confirmed ${student.firstName} ${student.lastName} ${student.country}
	
	<br> <br>
	Operating Systems
	
	<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
	<li> ${temp} </li>
	</c:forEach>
	</ul>
</body>
</html>