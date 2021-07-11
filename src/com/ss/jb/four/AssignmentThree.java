/**
 * 
 */
package com.ss.jb.four;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Creates a producer which produces ints. A consumer that consumes items. Both
 * Threads have access to a bounded buffer array.
 * 
 * @author Bruno
 *
 */
public class AssignmentThree {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		final int PROD_COUNT = 3;
		final int CONS_COUNT = 8;

		BoundedBuffer boundedBuf = new BoundedBuffer();
		
		for (int i = 0; i < PROD_COUNT; i++) {
			new Thread(new Producer(boundedBuf)).start();
			System.out.println(Thread.currentThread().getName() + " has been created as a Producer.");
		}

		for (int i = 0; i < CONS_COUNT; i++) {
			new Thread(new Consumer(boundedBuf)).start();
			System.out.println(Thread.currentThread().getName() + " has been created as a Consumer.");
		}
		
		try {
			Thread.sleep(3000);
			System.out.println("Total Produced: " + Producer.getProduced());
			System.out.println("Total Consumed: " + Consumer.getConsumed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Producer class that implements Runnable. Class produces a random number from 1-100 and inserts it into
	 * a shared Bounded Buffer.
	 * @author Bruno
	 *
	 */
	public static class Producer implements Runnable {
		private volatile BoundedBuffer boundedBuf;
		private Random rand;
		private int numProduce = 10;
		private static Integer totalProduced = 0;

		public Producer(BoundedBuffer buffer) {
			super();
			this.boundedBuf = buffer;
			this.rand = new Random();
		}

		@Override
		public void run() {
			while (numProduce >= 0) {
				int num = rand.nextInt(100);
				System.out.println(Thread.currentThread().getName() + " produced " + num + ".");
				boundedBuf.push(num);
				numProduce--;
				totalProduced++;
			}
		}
		
		public static Integer getProduced() {
			return totalProduced;
		}
	}

	/**
	 * Consumer class that implements Runnable. Class consumes a number from a shared Bounded Buffer.
	 * @author Bruno
	 *
	 */
	public static class Consumer implements Runnable {
		private volatile BoundedBuffer boundedBuf;
		private int numConsume = 10;
		private static Integer totalConsumed = 0;

		public Consumer(BoundedBuffer buffer) {
			super();
			this.boundedBuf = buffer;
		}

		@Override
		public void run() {
			while (numConsume >= 0) {

				Integer num = boundedBuf.pull();
				System.out.println(Thread.currentThread().getName() + " consumed " + num + ".");
				totalConsumed++;
			}
		}
		
		public static Integer getConsumed() {
			return totalConsumed;
		}
	}

	/**
	 * A Bounded Buffer implementation using a Queue of Integers. Max bound of 10 to illustrate
	 * race condition with Threads. Pull and Push methods for Producer and Consumer to call.
	 * @author Bruno
	 *
	 */
	public static class BoundedBuffer {
		private Object sync = new Object();
		private Queue<Integer> buffer;
		private int bound = 10;

		public BoundedBuffer() {
			buffer = new LinkedList<Integer>();
		}

		public void push(Integer i) {
			synchronized (sync) {
				while (buffer.size() == bound) {
					try {
						sync.wait(2000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						
						e.printStackTrace();
					}
				}

				sync.notifyAll();
				buffer.add(i);
			}
		}

		public Integer pull() {
			synchronized (sync) {
				while (buffer.size() == 0) {
					try {
						sync.wait(2000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
				}
				sync.notifyAll();
				return buffer.remove();
			}
		}
	}
}
