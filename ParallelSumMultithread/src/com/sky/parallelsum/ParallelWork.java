package com.sky.parallelsum;

public class ParallelWork extends Thread {
	
	private int[] nums;
	private int low;
	private int high;
	private int partialSum;
	
	public ParallelWork(int[] nums, int low, int high) {
		
		this.nums = nums;
		this.low = low;
		this.high = high;
	}

	public int getPartialSum() {
		return this.partialSum;
	}
	
	@Override
	public void run() {
		partialSum = 0;
		
		for(int i = low; i < high; i++) {
			partialSum = partialSum + nums[i];
		}
	}	

}
