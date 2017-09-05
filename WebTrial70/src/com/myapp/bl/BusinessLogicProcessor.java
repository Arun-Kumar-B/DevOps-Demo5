package com.myapp.bl;

public class BusinessLogicProcessor {

	public int[] generateFibSeries(int len) {
		// This is my second commit for BLP class only.
		int arr[] = new int[len];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2]; // this line is the correct logic
			// arr[i] = arr[i - 1] + arr[i - 1]; // this line is the wrong logic if this is
			// included unit test will fail
		}
		return arr;
	}

	public int[] generatePrimeNums(int numOfDigits) {
		int primeArr[] = new int[numOfDigits];
		int arrIncrementor = 2;

		if (numOfDigits == 1) {
			primeArr[0] = 1;
			return primeArr;
		} else if (numOfDigits == 2) {
			primeArr[0] = 1;
			primeArr[1] = 2;
			return primeArr;
		} else {
			primeArr[0] = 1;
			primeArr[1] = 2;
		}

		boolean isPrime;
		for (int counter = 3; arrIncrementor < numOfDigits; counter++) {
			isPrime = false;
			isPrime = isNumberPrime(counter);
			if (isPrime) {
				primeArr[arrIncrementor] = counter;
				arrIncrementor++;
			}
		}
		return primeArr;
	}

	private boolean isNumberPrime(int i) {
		// System.out.println("checking if i is prime "+i);
		boolean isPrime = true;
		for (int counter = 2; counter < i; counter++) {
			if (i % counter == 0) {
				isPrime = false; // this is the CORRECT logic uncomment this to pass the test case
				// isPrime = true; // this is the WRONG logic uncomment this to fail the test
				// case
				return isPrime;
			}
		}
		return isPrime;
	}

}
