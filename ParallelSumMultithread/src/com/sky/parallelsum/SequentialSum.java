package com.sky.parallelsum;

public class SequentialSum {
	
	public int Sum(int[] numberArray) {
		
		int cumSum = 0;
		int N = numberArray.length;
		
		for(int i = 0; i < N; i++) {
			cumSum = cumSum + numberArray[i];
		}
		
		return cumSum;		
		
	}

}
