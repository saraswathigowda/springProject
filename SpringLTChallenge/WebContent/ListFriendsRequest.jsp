<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>All Friends Request</title>
</head>
<body bgcolor="lightblue">

	<table>
		<tr>
			<td>First Name</td><td></td>
			<td>Last Name</td> <td></td>
			<td>Email</td> 
			<td></td>
			<td>Username</td>
			<td></td>
		</tr>
		
	<c:forEach var="i" items="${userbean}">
		 
		<tr>
		<td> <c:out value="${i.first_name}"/> </td><td></td>
		<td> <c:out value="${i.last_name}"/> </td><td></td>
		<td> <c:out value="${i.email}"/> </td><td></td>
		<td> <a href='profile?username=${i.username}' style="text-decoration:none;">
		 <c:out value="${i.username}"/></a> </td> 
		 
		 <td><a href='profile?username=${i.username}' style="text-decoration:none;">
	 
        <img src="${i.image_url}" width="40%" height="40%"/>
        </a></td>
		
		
		
		<td><a href="acceptrequest?status_Id=${i.friend_id}"> <input type="submit" value="Accept"/></a> </td>
		<td><a href="rejectrequest?status_Id=${i.friend_id}"> <input type="submit" value="Reject"/></a> </td>
		
		</tr>
		</c:forEach>
	</table>
	<a href="ChooseOption.jsp" style="text-decoration:none;">Back</a>

</body>
</html>