/**
 * 
 */
package com.ss.jb.four;

/**
 * Creates and runs five threads in parallel and calls the getSingleton() method in order to test for 
 * double-check locking in the Singleton class.
 * 
 * @author Bruno
 *
 */
public class AssignmentOne implements Runnable{

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable r1 = new AssignmentOne();
		
		Thread t1 = new Thread(r1, "Thread 1");
		Thread t2 = new Thread(r1, "Thread 2");
		Thread t3 = new Thread(r1, "Thread 3");
		Thread t4 = new Thread(r1, "Thread 4");
		Thread t5 = new Thread(r1, "Thread 5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

	@Override
	public void run() {
		System.out.println("Initiated thread : " + Thread.currentThread().getName());
		Singleton.getSingleton();
	}

}
