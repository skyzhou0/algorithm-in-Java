package com.sky.javaexecutorsubmit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// With ExecutorService submit() method uses the Callable interface, it require try/catch during its implementation.
// Moreover, we need to use the Future class while trying to store information.

class Processor implements Callable<String> {
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Id: " + id;
	}
	
}

public class Concurrency7ExecutorSubmit {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<Future<String>> list = new ArrayList<>();
		
		// use for loop to create a list of threads. However, this depends on how many threads in the pool that we have defined.
		for(int i=0; i < 5; i++) {
			Future<String> future = executorService.submit(new Processor(i+1));
			list.add(future);
		}
		
		// let's look what's in the future list.
		for(Future<String> future : list) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
