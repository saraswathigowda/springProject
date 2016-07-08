<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>All Friends</title>
</head>
<body bgcolor="lightblue">
<h3><p align="right"><a href="logout" style="text-decoration:none;">Logout</a></p></h3>

<form action="listfriends" method="post">
	<table>
		<tr>
			<td>First Name</td><td></td>
			<td>Last Name</td> <td></td>
			<td>Email</td> 
			<td></td>
			<!-- <td>Username</td> -->
			<td></td>
		</tr>
		
	<c:forEach var="i" items="${userbean}">
		 
		<tr>
		<td> <c:out value="${i.first_name}"/> </td><td></td>
		<td> <c:out value="${i.last_name}"/> </td><td></td>
		<td> <c:out value="${i.email}"/> </td><td></td>
		<%-- <td> <a href='profile?username=${i.username}' style="text-decoration:none;">
		 	 <c:out value="${i.username}"/></a> </td>  --%>
		</tr>
		
		</c:forEach>
	</table>
	<br>
	<a href="ChooseOption.jsp" style="text-decoration:none;">Back</a> 
</form>
</body>
</html>