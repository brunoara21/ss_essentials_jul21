/**
 * 
 */
package com.ss.jb.four;

/**
 * Creates a deadlock between two threads
 * @author Bruno
 *
 */
public class AssignmentTwo {

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hey There";
		
		Thread t1 = new Thread() {
			public void run() {
				try {
					synchronized (s1) {
						System.out.println("Thread one is going to sleep");
						Thread.sleep(2000);
						System.out.println("Thread one is awake");
						synchronized (s2) {
							System.out.println("Thread one is running");
						}
					}
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					synchronized (s2) {
						System.out.println("Thread two is going to sleep");
						Thread.sleep(2000);
						System.out.println("Thread two is awake");
						synchronized (s1) {
							System.out.println("Thread two is running");
						}
					}
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		
		
		t1.start();
		t2.start();
	}

}
