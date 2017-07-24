package com.sky.javaexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* ExecutorService is a class that uses the callable interface and can create multiple threads and dynamically
 * reuse threads. Before starting a job, it checks whether there are any threads that have finished their jobs and 
 * reuse them. If there are no waiting threads, it will create another one. Overall, it increase the efficiency of
 * processor usage.
 * 
 * 3 ways to create threads: ExecutorService executorService = Executors.newFixedThreadPool(N)
 * ExecutorService executorService = Executors.newCachedThreadPool(N)
 * ExecutorService executorService = Executors.newSingleThreadExecutor(N)
 * 
 * In the ExecutorService, it can use execute() (that calls both the runnable and callable interface) and submit (that
 * calls only the runnable interface).
 */

class Worker implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}
	
}


public class Concurrency7Executors {
	
	public static void main(String[] args) {
		
		// instantiate executorService object.
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for(int i = 0; i < 5; i++ ) {
			executorService.submit(new Worker()); // submit() can only call the runnable.
		}
		
	}
	
	

}
