package com.sky.parallelsum;

public class ParralelSum {
	
	private ParallelWork[] sums;
	private int numOfThreads;
	
	public ParralelSum(int numOfThreads) {
		this.numOfThreads = numOfThreads;
		this.sums = new ParallelWork[numOfThreads];
	}
	
	public int sum(int[] nums) {
		
		int steps = (int) Math.ceil(nums.length * 1.0 /numOfThreads);
		
		for(int i= 0; i < numOfThreads; i++) {
			sums[i] = new ParallelWork(nums, i*steps, (i+1)*steps);
			sums[i].start();
		}
		
		try {
			for(ParallelWork worker: sums)
				worker.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int total = 0;
		for(ParallelWork worker: sums)
			total = total + worker.getPartialSum();
		
		return total;
	}

}
