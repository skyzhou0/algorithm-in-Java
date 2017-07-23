package com.sky.java;

// We implements the Runable interface from Thread in Java to create multithreads. So we can initialise and run on 
// multiple threads.

class Runner1 implements Runnable {
	

	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("Runner1 starts: " + i);
		}
		
	}
}

class Runner2 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("Runner2 starts: " + i);
		}
		
	}
}

public class Concurrency1 {
	public static void main(String args[]) {
		
		//Instantiate objects. Note that we create a thread object, where the the argument be the class,
		//which allow to call the run() method in the class. 
		//we call the start() method to start the thread to run.
		Thread thread1 = new Thread(new Runner1());
		Thread thread2 = new Thread(new Runner2());
		
		thread1.start();
		thread2.start();
		
		
	}

}
