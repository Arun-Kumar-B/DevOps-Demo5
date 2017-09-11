package com.myapp.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.myapp.bl.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("Action");
		System.out.println(">>>>>>>>>>>>>>>>>> in do Post Action is>>" + action);
		if (action.equals("Login")) {
			String userName = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			LoginValidation lv = new LoginValidation();
			boolean validUser = lv.validateLogin(userName, pwd);
			if (validUser) {
				response.sendRedirect("Home.jsp");
			} else {
				response.sendRedirect("Error.jsp");
			}
		}

		if (action.equals("businesslogic")) {
			String strFibElements = request.getParameter("numOfFibElements");
			String strPrimeElements = request.getParameter("numOfPrimeNumbers");
			String strNumbersToBeSorted = request.getParameter("sortNumbers");
			
			//System.out.println("strFibElements >>"+strFibElements);
			//System.out.println("strPrimeElements >>"+strPrimeElements);
			
			BusinessLogicProcessor bp = new BusinessLogicProcessor();

			if(!strFibElements.equalsIgnoreCase("")) {
				//int numOfElements = Integer.parseInt(strFibElements);
				//int[] arr = bp.generateFibSeries(numOfElements);
				
				String strFibSeries = bp.generateFibSeries(strFibElements);
				//System.out.println("In side Myservlet Generated Fib servies>>"+Arrays.toString(arr));
				request.getSession().setAttribute("Fibseries", strFibSeries);
				response.sendRedirect("Home.jsp");
			}
			if(!strPrimeElements.equalsIgnoreCase("")) {
				
				// check if strFibElements is a valid number if true set the result in string in Fibseries if false set the error message in the string. 
				// In BP write method to validate if the num is correct, in BP write a method to convert int arr to str, change the method generateFibseries
				// to return string.
				
				 //int numOfPrimeElem = Integer.parseInt(strPrimeElements); - old logic
				 //int[] arr = bp.generatePrimeNums(numOfPrimeElem); - old logic
				
				String primeNumberStr = bp.generatePrimeNums(strPrimeElements);
				//System.out.println("In side Myservlet Generated Prime Numbers >>"+Arrays.toString(arr));
				//request.getSession().setAttribute("PrimeNumbers", arr); - old logic
				
				request.getSession().setAttribute("PrimeNumbers", primeNumberStr);
				response.sendRedirect("Home.jsp");
			}
			
			if(!strNumbersToBeSorted.equalsIgnoreCase("")) {
				int[] numbers = Arrays.asList(strNumbersToBeSorted.split(","))
	                      .stream()
	                      .map(String::trim)
	                      .mapToInt(Integer::parseInt).toArray();
				int [] sortedNumbersArray = bp.sortArrayInAscnOrder(numbers);
				request.getSession().setAttribute("SortedNumbers", sortedNumbersArray);
				response.sendRedirect("Home.jsp");
			}
			
		}
		

	}

}
