<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset=ISO-8859-1">
<title>Sign Up Page</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#dob" ).datepicker(
    		{
    			 dateFormat: "yy-mm-dd"
    		});
  });
  </script>
</head>
<body bgcolor="lightblue"><center>

<form action="create" method="post" enctype="multipart/form-data">
<center><h3>Register</h3></center>
<table align="center" bgcolor="#E8E8EF">
	
	<tr>
		<th align="left">User Name</th> <td><input type="text" name="username"/></td>
	</tr>
	
	<tr>
		<th align="left">Password</th> <td><input type="text" name="pass"/></td>
	</tr>
	
	<tr>
		<th align="left">First Name</th> <td><input type="text" name="fname"/></td>
	</tr>
	
	<tr>
		<th align="left">Last Name</th> <td><input type="text" name="lname"/></td>
	</tr>
	
	<tr>
		<th align="left">Phone</td> <td><input type="text" name="phone"/></th>
	</tr>
	
	<tr>
		<th align="left">Email</th> <td><input type="text" name="email"/></td>
	</tr>
	
	<tr>
		<th align="left">House Address</th> <td><input type="text" name="houseaddress"/></td>
	</tr>
	
	<tr>
		<th align="left">School</th> <td><input type="text" name="school"/></td>
	</tr>
	
	<tr>
		<th align="left">School Address</th> <td><input type="text" name="schooladdress"/></td>
	</tr>
	
	<tr>
		<th align="left">Father's Name</th> <td><input type="text" name="fathername"/></td>
	</tr>
	
	<tr>
		<th align="left">Mother's Name</th> <td><input type="text" name="mothername"/></td>
	</tr>
	
	<tr>
		<th align="left">Date Of Birth</th> <td><input type="date" name="dob" id="dob"/><label><b>Enter date in yyyy-mm-dd</b></label></td>
	<br/>
	</tr>
	
	<tr>
		<th align="left">Gender</th> 
		<td>
			<select name="gender">
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select>
		</td>
   </tr>
	
	<tr>
		<th align="left">Upload Photo:</th><td><input type="file"  name="ImageFile" id="ImageFile"/> </td>
	</tr>
	
	<br>
	<tr>
		<td><p align="center"><input type="submit" value="Submit"></p></td>
	</tr>
	
	<tr>
		<td><b>If you already have an account</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a href="Login.jsp" style="text-decoration:none;">Login</a></td>
	</tr> 
	
</table>
</form>
</center>
</body>
</html>