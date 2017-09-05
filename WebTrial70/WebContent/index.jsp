<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Trials</title>
</head>
<body>Welcome
</body>
<form method="post" action="MyServlet">
	<table>
		<tr>
			<td>User Name</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td><input type="Submit" value="Login"></td>
			<td><input type="hidden" value="Login" name="Action"></td>
		</tr>
	</table>
</form>
</html>