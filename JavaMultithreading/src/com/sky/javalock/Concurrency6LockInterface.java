package com.sky.javalock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Reentrantlock is a class that implements the lock interface. 
// we use lock() and unlock() to manage thread stavations. 


public class Concurrency6LockInterface {
	
	private static int counter = 0;
	private static Lock lock = new ReentrantLock();
	
	public static void increment() {
		
		lock.lock();
		
		// normally a try/finally statement is included with ReentrantLock. Because we don't want any exception to cause 
		// a thread to be permanent locked.
		
		try {
			for(int i = 0; i < 10000; i++) {
				counter = counter + 1;
			}
		} finally {
			lock.unlock();
		}				
		
	}
	
	// Note that the lock can be unlock at other locations such as:
	
	public void add() {
		lock.unlock();
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				increment();
			}						
		});
		
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				increment();
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
		
		System.out.println("counter = " + counter);
	}

}
