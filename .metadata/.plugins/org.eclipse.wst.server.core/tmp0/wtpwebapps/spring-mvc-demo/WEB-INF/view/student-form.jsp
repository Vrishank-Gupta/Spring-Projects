<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
  
<!DOCTYPE html>
<html>

<head>
	<title>Welcome to Student Login</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name: <form:input path="lastName"/>
	
	
		<br><br>
		Country: 
		
		<form:select path="country">
	
			 
			 <form:options items="${student.countryOptions}"/>
		</form:select>
		
		<br><br>
		Operating System:
		
		MAC <form:checkbox path="operatingSystems" value="MAC"/>
		Linux<form:checkbox path="operatingSystems" value="Linux"/>
		Windows<form:checkbox path="operatingSystems" value="Windows"/>
		Others<form:checkbox path="operatingSystems" value="Others.."/>
		
		
		<input type="submit" value="Submit"/>	
	</form:form>

</body>
</html>