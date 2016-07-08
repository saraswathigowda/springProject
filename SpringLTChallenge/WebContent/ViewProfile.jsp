<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>View Details</title>
</head>
<body bgcolor="lightblue">
<h3><p align="right"><a href="logout" style="text-decoration:none;">Logout</a></p></h3>
<table>
 	<tr>
 		<td>First Name : <c:out value="${userbean.first_name}"/></td>
 	</tr>
 	<tr>
 		<td>Last Name :<c:out value="${userbean.last_name}"/></td>
 	</tr>
 	<tr>
 		<td>Email :<c:out value="${userbean.email}"/></td>
 	</tr>
 	<tr>
 		<td>School :<c:out value="${userbean.school}"/></td>
 	</tr>
 	<tr>
 		<td>School Address :<c:out value="${userbean.school_address}"/></td>
 	</tr>
	<tr>
 		<td>Father Name :<c:out value="${userbean.father_name}"/></td>
 	</tr>
 	<tr>
 		<td>Mother Name :<c:out value="${userbean.mother_name}"/></td>
 	</tr>
 	<tr>
 		<td>Phone :<c:out value="${userbean.phone}"/></td>
 	</tr>
 	<tr>
 		<td>Gender :<c:out value="${userbean.gender}"/></td>
 	</tr> 
 	
 	<tr>
 		<td><a href ="sendrequest?username=${userbean.username}"/><input type="submit" value="Send Request"/></a></td>
 	</tr>
 		
 </table>
</body>
</html>