package com.myapp.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.myapp.bl.*;

public class TestBusinessLogic {

	private BusinessLogicProcessor bl;
	//private Logger myLogger;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Do nothing for now 
		// Testing commit to Github

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Do nothing for now
	}

	@Before
	public void setUp() throws Exception {
		bl = new BusinessLogicProcessor();
		//myLogger = Logger.getLogger("InfoLogging");
	}

	@After
	public void tearDown() throws Exception {
		// Do nothing for now
	}

	@Test
	public void testGenerateFibSeries() {
		int[] expectedSeries = { 0, 1, 1, 2, 3, 5, 8, 13 };
		int len = expectedSeries.length;
		int[] generatedSeries = bl.generateFibSeries(len);
		//myLogger.log(Level.FINE, "Testing Logger **************");
		//System.out.println(" >>> expected Fib Series >>" + Arrays.toString(expectedSeries));
		//System.out.println(" >>> generated Fib Series>>" + Arrays.toString(generatedSeries));
		assertArrayEquals(expectedSeries, generatedSeries);
	}
	
	@Test
	public void testStrGeneratedFibSeries() {
		String input = "-1";
		String returnedStr = bl.generateFibSeries(input);
		String expectedStr = "Enter a valid number";
		assertEquals(expectedStr, returnedStr);
		assertEquals(expectedStr, bl.generateFibSeries("nfe"));
	}
	@Test
	public void testStrGeneratedFibSeries1() {
		String input = "10";
		String expectedStr = "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]";
		String returnedStr = bl.generateFibSeries(input);
		assertEquals(expectedStr, returnedStr);
	}
	
	
	@Test
	public void testGeneratePrimeNum() {
		int [] expectedPrimeNumbers = {1,2,3,5,7,11,13,17,19,23};
		int numOfPrimeDig = expectedPrimeNumbers.length;
		int [] generatedPrimeNums = bl.generatePrimeNums(numOfPrimeDig);
		//System.out.println(" Expected Prime Numbers           is >>"+Arrays.toString(expectedPrimeNumbers));
		//System.out.println(" generatedPrimeNums Prime Numbers is >>"+Arrays.toString(generatedPrimeNums));
		assertArrayEquals(expectedPrimeNumbers, generatedPrimeNums);
	}
	
	@Test
	public void testStrGeneratePrimeNum() {
		String input = "-1";
		String returnedStr = bl.generatePrimeNums(input);
		String expectedStr = "Enter a valid number";
		//System.out.println("returnedStr >>"+returnedStr);
		//System.out.println("expectedStr >>"+expectedStr);
		assertEquals(expectedStr, returnedStr);
		assertEquals(expectedStr, bl.generatePrimeNums("nfe"));
	}
	
	@Test
	public void testStrGeneratePrimeNum1() {
		String input = "8";
		String returnedStr = bl.generatePrimeNums(input);
		String expectedStr = "[1, 2, 3, 5, 7, 11, 13, 17]";
		//System.out.println("returnedStr >>"+returnedStr);
		//System.out.println("expectedStr >>"+expectedStr);
		assertEquals(expectedStr, returnedStr);
		
	}
	
	
	
	@Test
	public void testIsEven() {
		int num = 2;
		boolean even = bl.isEven(num);
		assertTrue(even);
		assertFalse(bl.isEven(3));
	}
	@Test 
	public void testIsPalindrome() {
		String str = "aba";
		boolean yesPalindrome = bl.isPalindrome(str);
		assertTrue(yesPalindrome);
		assertFalse(bl.isPalindrome("NOTPAL"));
	}
	
	@Test
	public void testSorting() {
		
		//int [] inArr = {3,4,5,6,7,1,2,10};
		
		String strNumbersToBeSorted = "15,3,4,5,6,7,1,2,10";
		int[] inArr = Arrays.asList(strNumbersToBeSorted.split(","))
                .stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt).toArray();
		//System.out.println("inArr Arr >>>" + Arrays.toString(inArr));
		
		int [] expectedArr = {1,2,3,4,5,6,7,10,15}; // give sorted array of the above inArr here
		int [] returnArr = bl.sortArrayInAscnOrder(inArr);
		//System.out.println("expectedArr Arr >>>" + Arrays.toString(expectedArr));
		//System.out.println("returned Arr >>>" + Arrays.toString(returnArr));
		assertArrayEquals(expectedArr, returnArr);
		
		//System.out.println("********In side testSorting");
	}
}
