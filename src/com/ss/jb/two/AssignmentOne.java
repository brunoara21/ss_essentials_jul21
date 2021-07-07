/**
 * 
 */
package com.ss.jb.two;

import java.math.BigDecimal;

/**
 * Takes multiple values from the command line and shows the result of adding
 * all of them.
 * 
 * ex.
 * 35 4.25 -5225 10000 5.1825 -2.18
 * 
 * Sum: 4817.2525
 * 
 * @author Bruno
 *
 */
public class AssignmentOne {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting to add input from command line...\n");

		BigDecimal sum = new BigDecimal(0); // Using BigDecimal to get precision values in sum
		for (String arg : args) {
			Integer numI = 0;
			Float numF = 0.0f;
			try {
				numI = Integer.parseInt(arg);	// Checking if value is an Integer
				System.out.println("Input: " + numI);
			} catch (NumberFormatException e) {
				try {
					numF = Float.parseFloat(arg);	// Checking if value is a Float
					System.out.println("Input: " + numF);
				} catch (NumberFormatException er) {	// Not a valid input
					System.out.println("Sorry, you entered a value that is not considered to be a number.");
					return;
				}
			}
			
			sum = sum.add(new BigDecimal(numI).add(new BigDecimal(numF.toString())));

		}
		System.out.println("\nFinished");
		System.out.println("Sum: " + sum);
		return;
	}

}
