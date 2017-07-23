package com.sky.javajoin;



// In Concurrency3 we aim to understand the usage of join() method in the Thread class.
// Note that in the application thread (a thread that creates other multiple threads), if we run 
// System.out.println("All threads work have now finished: ... "), this line of code will be executed before
// other thread work even begin. However if we use the join(), which is to wait the other thread to complete
// its job, then we will see the System.out.println("All threads work have now finished: ... ") will be 
// executed afterwards.

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


public class Concurrency3 {
	
public static void main(String[] args) {
		
		Runner1 t1 = new Runner1();
		Runner2 t2 = new Runner2();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All threads work have now finished: ... ");
		
	}

}
