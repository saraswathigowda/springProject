<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body bgcolor="lightblue">
<h3><p align="right"><a href="logout" style="text-decoration:none;">Logout</a></p></h3>

<c:forEach var="i" items="${userbean}">
	 <a href='profile?username=${i.username}' style="text-decoration:none;">
	 <c:out value="${i.username}"/>
	 </a>
	 
 	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <c:out value="${i.email}"/>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <c:out value="${i.first_name}"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <c:out value="${i.last_name}"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href='profile?username=${i.username}' style="text-decoration:none;">
	 
        <img src="${i.image_url}" width="10%" height="10%">
        </a>
      <%--   <c:out value="${i.image_url}"/>  --%>
        
     <br/>
</c:forEach>

</body>
</html>