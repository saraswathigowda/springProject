<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>User Account</title>
</head>
<body bgcolor="lightblue">
<form action="updateUser" method="post" enctype="multipart/form-data">

	<input type="hidden" value="${userbean.id}" name="userid"/>

	<table align="center" bgcolor="#E8E8EF">
		<tr>
			<td>First Name: <input type="text" name="first_name" value="${userbean.first_name}"/> </td>
		</tr>
		
		<tr>
			<td>Last Name: <input type="text" name="last_name" value="${userbean.last_name}"/> </td>
		</tr>
		
		<tr>
			<td>Phone: <input type="text" name="phone" value="${userbean.phone}"/> </td>
		</tr>
		
		<tr>
			<td>House Address: <input type="text" name="house_address" value="${userbean.house_address}"/> </td>
		</tr>
		
		<tr>
			<td>School: <input type="text" name="school" value="${userbean.school}"/> </td>
		</tr>
		
		<tr>
			<td>School Address: <input type="text" name="school_address" value="${userbean.school_address}"/> </td>
		</tr>
		
		<tr>
			<td>Father's Name: <input type="text" name="father_name" value="${userbean.father_name}"/> </td>
		</tr>
		
		<tr>
			<td>Mother's Name: <input type="text" name="mother_name" value="${userbean.mother_name}"/> </td>
		</tr>
		
		<tr>
			<td>Date Of Birth: <input type="text" name="dob" value="${userbean.dob}"/> </td>
		</tr>
		
		<tr>
			<td>Gender: <input type="text" name="gender" value="${userbean.gender}"/> </td>
		</tr>
		
		<tr>
			<td>Upload Photo:<input type="file"  name="ImageFile" id="ImageFile"/> </td>
		</tr>
		
		<tr>
			<td><br><input type="submit" value="Update"/> </td>
			
			<td><a href="ChooseOption.jsp" style="text-decoration:none;">Back</a> </td>
		</tr>
		
	</table>
</form>
</body>
</html>