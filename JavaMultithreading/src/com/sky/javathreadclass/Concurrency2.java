package com.sky.javathreadclass;

// Instead of using the runnerable interface, we will use the Thread class to create multiple treads.

class Runner1 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("Runner1 starts: " + i);
			
			try {
				//Causes the currently executing thread to sleep (temporarily cease execution) for the specified 
				//number of milliseconds, subject to the precision and accuracy of system timers and schedulers. 
				//The thread does not lose ownership of any monitors.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class Runner2 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("Runner2 starts: " + i);
			
			try {
				//Causes the currently executing thread to sleep (temporarily cease execution) for the specified 
				//number of milliseconds, subject to the precision and accuracy of system timers and schedulers. 
				//The thread does not lose ownership of any monitors.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}


public class Concurrency2 {
	
	public static void main(String[] args) {
		
		Runner1 t1 = new Runner1();
		Runner2 t2 = new Runner2();
		
		t1.start();
		t2.start();
		
	}
	

}
