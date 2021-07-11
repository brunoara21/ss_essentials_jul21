/**
 * 
 */
package com.ss.jb.four;

/**
 * Singleton class using Double-Checked Locking
 * 
 * @author Bruno
 *
 */
public class Singleton {
	private static final Object obj = new Object();
	private static volatile Singleton instance = null; // volatile is needed to prevent partially created instances

	private Singleton() {
	};

	public static Singleton getSingleton() {
		
		Singleton localSingleton = instance; // local Singleton instance is useful for performance gains when returning
												// the instance due to accessing the volatile field once
		try {
			if (localSingleton == null) { // first check if singleton instance exists, if so return it
				synchronized (obj) { // Thread grabs lock
					if (localSingleton == null) { // second check if instance exists for current thread
						instance = localSingleton = new Singleton();
						System.out.println("Created singleton instance on thread: " + Thread.currentThread().getName());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localSingleton;
	}
}
