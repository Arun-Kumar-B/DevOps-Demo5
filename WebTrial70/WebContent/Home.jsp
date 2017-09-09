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
					String fibSeries = Arrays.toString(arr);
					if (fibSeries.equals("null")) {
						fibSeries = "";
					}
					session.removeAttribute("Fibseries");
				%>
				<td><label><%=fibSeries%></label></td>
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
					String primeNumbers = Arrays.toString(arr1);
					if (primeNumbers.equals("null")) {
						primeNumbers = "";
					}
					session.removeAttribute("PrimeNumbers");
				%>
				<td><label><%=primeNumbers%></label></td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td>Commas Separated numbers</td>
				<td><input type="text" name="sortNumbers"></td>
				<td><input type="hidden" name="Action" value="SortNumbers"></td>
				<td><input type="Submit" value="Sort the numbers"></td>
				<%
					Object obj2 = request.getSession().getAttribute("SortedNumbers");
					int arr2[] = (int[]) obj2;
					String sortedNumbers = Arrays.toString(arr2);
					if (sortedNumbers.equals("null")) {
						sortedNumbers = "";
					}
					session.removeAttribute("SortedNumbers");
				%>
				<td><label><%=sortedNumbers%></label></td>
			</tr>
		</table>
	</form>
</body>
</html>