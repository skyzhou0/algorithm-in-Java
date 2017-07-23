package com.sky.javawaitnotify;

// Wait and Notify: in multithreading, suppose multiple threads are all locking on the intrinsic class, we can use
// wait() method in one of the thread to tell other thread that now they can use the intrinsic class; once other
// threads have done with the intrinsic class, they will use the notify() method to inform previous thread.

class Processor {
	
	public void produce() throws InterruptedException {
		
		// produce threads is asking for the locking of the intrinsic class via the "this" keyword.
		synchronized(this) {
			System.out.println("begin to produce ...");
			wait();  //note that we can specify the waiting time i.e. wait(1000).
			System.out.println("producing again once thread 2 gives the notification ...");
		}
	}
	
	public void consumer() throws InterruptedException {
		
		// sleep() allow the produce thread to start first.
		Thread.sleep(1000);
		
		synchronized(this) {
			System.out.println("begin to consume ...");
			// if we have more than two threads, we can use notifyall(). In the meantime, although we have given
			// out the notify, the consume thread will run all line after the notify() method before giving up the locking 
			// of intrinsic class (in this case the Processor class).
			notify();  
			Thread.sleep(3000);
			System.out.println("consume thread giving up the locking ...");
		}
		
	}
	
}

public class Concurrency5WaitNotify {

	// main method.
	public static void main(String[] args) {
		
		Processor processor = new Processor();
		
		// create two threads with the Thread class.
		
		Thread t1 = new Thread( new Runnable() {

			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
		
		Thread t2 = new Thread( new Runnable() {

			@Override
			public void run() {
				try {
					processor.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
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
}
