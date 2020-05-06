<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      

<!DOCTYPE html>
<html>
<head>
<title>Customer Registration Form</title>

<style>
	.error{color:red} 
</style>

</head>
<body>
<i>Fill out the form</i>

	<form:form action="processForm" modelAttribute="customer">
		
		Enter First Name: <form:input path="firstName"/>
		<br> <br>	
		
		Enter Last Name: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		
		<br> <br>
		
		Enter Free Passes: <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/>
		
		<br> <br>
		
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>