package com.sky.javamulti;

class Runner1 {
	
	public void startRun() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Runner1 starts: " + i);
		}
	}
}

class Runner2 {
	
	public void startRun() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Runner2 starts: " + i);
		}
	}
}

// Note that in this sequential execution, the runObj2 started after the completion of runObj1.

public class SequentialProcessing {
	
	public static void main(String args[]) {
		
		//Instantiate objects.
		Runner1 runObj1 = new Runner1();
		Runner2 runObj2 = new Runner2();
		
		runObj1.startRun();
		runObj2.startRun();
		
		
	}

}
