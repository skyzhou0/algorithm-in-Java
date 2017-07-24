package com.sky.javaconditionallock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Conditional lock with await() and signal() are similar to wait() and notify() in Synchronized. 
// condition.await() in producer allows the consumer thread to run, once the consumer thread completes the task, 
// it uses condition.signal() and lock.unlock() to give the producer thread the indication and unlock the intrinsic 
// class to run their jobs.

class Worker {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("Producer method ....");
		condition.await();
		System.out.println("Producer again ....");
		lock.unlock();
	}
	
	public void consumer() throws InterruptedException {
		lock.lock();
		Thread.sleep(2000);
		System.out.println("Consumer method ....");
		condition.signal();
		lock.unlock();
	}
}

public class Concurrency6ConditionLock {
	
	
	public static void main(String[] args) {
		
		Worker worker = new Worker();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					worker.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}						
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					worker.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
