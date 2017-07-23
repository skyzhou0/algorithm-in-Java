package com.sky.javasynchronized;

// Suppose two threads are accessing the same variable, there is bounded to have problem with the update of 
// this variable. However, we can use the key in synchronized keyword from synchronized class to reslove this
// problem. However, the cost will be that this synchronized operation will increase the multithread overhead as
// one thread will have to wait for another thread to complete before update the variable. In other words, it 
// will take longer time to run.

public class Concurrency4Synchronized {
	
	private static int counter = 0;
	
	// with synchronized, the counter varialbe will oftentimes not be 2000;
	
	public static synchronized void increment() {		
		counter = counter + 1;
	}
	
	public static void processor() {
		
		// let create to threads to increment the counter variable 1000 times.
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++)
					increment();
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++)
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
	}
	
	public static void main(String[] args) {
		
		// let run the process() method and print out the value of the variable.
		processor();
		
		System.out.println(counter);
		
		
	}

}
