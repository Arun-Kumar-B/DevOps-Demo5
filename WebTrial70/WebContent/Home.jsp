<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<form action="MyServlet" method="post">
		<table>
			<tr>
				<td>Number of Fib elements</td>
				<td><input type="text" name="numOfFibElements"></td>
				<td><input type="hidden" name="Action" value="businesslogic"></td>
				<td><input type="Submit" value="Generate Fib Series"></td>
				<%
					Object obj = request.getSession().getAttribute("Fibseries");
					int arr[] = (int[]) obj;
					String str = Arrays.toString(arr);
					if (str.equals("null")) {
						str = "";
					}
					session.removeAttribute("Fibseries");
				%>
				<td><label><%=str%></label></td>
			</tr>

		</table>
	
		<table>
			<tr>
				<td>Number of Prime numbers</td>
				<td><input type="text" name="numOfPrimeNumbers"></td>
				<td><input type="hidden" name="Action" value="GeneratePrimeNumbers"></td>
				<td><input type="Submit" value="Generate Prime numbers"></td>
				<%
					Object obj1 = request.getSession().getAttribute("PrimeNumbers");
					int arr1[] = (int[]) obj1;
					String str1 = Arrays.toString(arr1);
					if (str1.equals("null")) {
						str1 = "";
					}
					session.removeAttribute("PrimeNumbers");
				%>
				<td><label><%=str1%></label></td>
			</tr>
		</table>
	</form>
</body>
</html>