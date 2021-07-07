/**
 * 
 */
package com.ss.jb.two;

import java.math.BigDecimal;

/**
 * Finds the max number of a 2D array and show its position in the array. 
 * [[ 1, 2, 3, 4, 5], 
 * [ 100, -100, 3.5, 1, 0], 
 * [ 331, 4123, 2, -512.13, 10000], 
 * [-5, -4, -3, -2, -1], 
 * [ 412, 2311, 52131, 2314, 51211] ]
 * 
 * ex. max number
 * arr[4][2] = 52131 
 * @author Bruno
 *
 */
public class AssignmentTwo {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal[][] fiveByFiveArray = {
				{ new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("4"),
						new BigDecimal("5") },
				{ new BigDecimal("100"), new BigDecimal("-100"), new BigDecimal("3.5"), new BigDecimal("1"),
						new BigDecimal("0") },
				{ new BigDecimal("331"), new BigDecimal("4123"), new BigDecimal("2"), new BigDecimal("-512.13"),
						new BigDecimal("10000") },
				{ new BigDecimal("-5"), new BigDecimal("-4"), new BigDecimal("-3"), new BigDecimal("-2"),
						new BigDecimal("-1") },
				{ new BigDecimal("412"), new BigDecimal("2311"), new BigDecimal("52131"), new BigDecimal("2314"),
						new BigDecimal("51211") } };

		BigDecimal maxNumber = new BigDecimal("0");
		Integer indexMaxX = -1;
		Integer indexMaxY = -1;

		for (int i = 0; i < fiveByFiveArray.length; i++) {
			for (int j = 0; j < fiveByFiveArray[i].length; j++) {
				if (fiveByFiveArray[i][j].compareTo(maxNumber) > 0) {
					maxNumber = fiveByFiveArray[i][j];
					indexMaxX = i;
					indexMaxY = j;
				}
				System.out.print(fiveByFiveArray[i][j] + "\t\t");
			}
			System.out.println("\n");
		}
		
		System.out.println("Largest number in array is : " + maxNumber);
		System.out.println("Position of largest num is ( " + indexMaxX + ", " + indexMaxY + " )");
	}
}
