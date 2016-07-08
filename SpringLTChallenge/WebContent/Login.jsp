<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="lightblue">
<center>
<div id="body">
<form action="login" method="post">
<br><br><br>
<table>

	<tr>
		<th>User Name</th> <td><input type="text" name="usr"/></td>
	</tr>
	
	<tr>
		<th>Password</th> <td><input type="password" name="pass"/></td>
	</tr>
	
	<tr>
		<td><p align="center"><input type="submit" value="Submit"/></p></td>
	</tr>
	
	<tr>
		<td><b>New User? Click here to Register</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a href="UserDetails.jsp" style="text-decoration:none;">Register</a></td>
	</tr> 

</table>
</form>	
</div>	
</center>
</body>
</html>