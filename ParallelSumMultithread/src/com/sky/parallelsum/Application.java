package com.sky.parallelsum;

import java.util.Random;

public class Application {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		SequentialSum SequentialSumObj = new SequentialSum();
		
		int numOfProcessors = Runtime.getRuntime().availableProcessors();
		
		System.out.println("Number of Processer: " + numOfProcessors);
		
		ParralelSum parallelSumObj = new ParralelSum(numOfProcessors);
		
		// create an int array.
		int N = 100000000;
		int[] numberArray = new int[N];
		
		// initialise the integer array with random integers.
		for(int i = 0; i < N; i++) { numberArray[i] = random.nextInt(); }
		
		int total = SequentialSumObj.Sum( numberArray);
		
		long start = System.currentTimeMillis();
		
		System.out.println("Total is: " + total);
		System.out.println("Sequential Summing N elements array takes: " + (System.currentTimeMillis() - start) +" miliseconds.");
		
		start = System.currentTimeMillis();

		System.out.println("Total is: " + parallelSumObj.sum(numberArray));
		System.out.println("Parallel Summing N elements array takes: " + (System.currentTimeMillis() - start) +" miliseconds.");
		
		
	
	}

}
