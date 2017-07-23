package com.sky.javasynchornizedblock;

// Synchronized block allows thread to run independently. 
// we should instantiate lock objects so that thread is not locking on the class application(main), which
// should be more efficient.

public class Concurrency5SynchBlock {

	private static int count1 = 0;
	private static int count2 = 0;
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public static void add() {
		//synchronized (Concurrency5SynchBlock.class) {
		synchronized (lock1) {
			count1++;
		};
			
	}
	
	public static void addAgain() {
		//synchronized (Concurrency5SynchBlock.class) {
		synchronized (lock2)  {
			count2++;
		};
			
	}
	
	public static void compute() {
		for(int i = 0; i < 100; i++) {
			add();
			addAgain();
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				compute();
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				compute();
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count1 = " + count1 + " Count2 = " + count2);
	}
	
	
}
