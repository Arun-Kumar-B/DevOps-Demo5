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
	public void testGeneratePrimeNum() {
		int [] expectedPrimeNumbers = {1,2,3,5,7,11,13,17,19,23};
		int numOfPrimeDig = expectedPrimeNumbers.length;
		int [] generatedPrimeNums = bl.generatePrimeNums(numOfPrimeDig);
		//System.out.println(" Expected Prime Numbers           is >>"+Arrays.toString(expectedPrimeNumbers));
		//System.out.println(" generatedPrimeNums Prime Numbers is >>"+Arrays.toString(generatedPrimeNums));
		assertArrayEquals(expectedPrimeNumbers, generatedPrimeNums);
	}
}
