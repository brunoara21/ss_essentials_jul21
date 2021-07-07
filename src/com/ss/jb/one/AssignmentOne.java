/**
 * 
 */
package com.ss.jb.one;

/**
 * This class is for Java Basics 1 : Assignment 1 
 * 
 * Prints out the following patterns
 * 1)
 * *
 * **
 * ***
 * ****
 * .........
 * 2)
 * ..........
 * ****
 * ***
 * **
 * *
 * 3)
 *     *
 *    ***
 *   *****
 *  *******
 * ...........
 * 4)
 * ............
 *  *******
 *   *****
 *    ***
 *     *
 * 
 * @author Bruno
 *
 */
public class AssignmentOne {

	public static Integer dots = 9;
	public static Integer numberPattern = 1;
	public StringBuilder str;

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AssignmentOne p1 = new AssignmentOne();
		AssignmentOne p2 = new AssignmentOne();
		p1.staircasePattern(4);
		p1.reverseStaircasePattern(4);
		p2.pyramidPattern(4);
		p2.reversePyramidPattern(4);
	}

	public void staircasePattern(Integer levels) {
		str = new StringBuilder();
		// Number
		str.append(numberPattern);
		str.append(")\n");
		// * Steps
		for (int i = 1; i <= levels; i++) {
			str.append("*".repeat(i));
			str.append("\n");
		}
		// "." Base
		str.append(".".repeat(dots));
		System.out.println(str);

		dots++;
		numberPattern++;
	}

	public void reverseStaircasePattern(Integer levels) {
		str = new StringBuilder();
		// Number
		str.append(numberPattern);
		str.append(")\n");
		// "." Base
		str.append(".".repeat(dots));
		str.append("\n");

		// * Steps
		for (int i = levels; i > 0; i--) {
			str.append("*".repeat(i));
			str.append("\n");
		}

		System.out.print(str);

		dots++;
		numberPattern++;
	}

	public void pyramidPattern(Integer levels) {
		str = new StringBuilder();
		// Number
		str.append(numberPattern);
		str.append(")\n");
		// * Steps
		int spaces = (dots - 1) / 2;
		for (int i = 1; i <= levels * 2; i += 2) {
			str.append(" ".repeat(spaces) + "*".repeat(i));
			str.append("\n");
			spaces--;
		}
		// "." Base
		str.append(".".repeat(dots));
		System.out.println(str);

		dots++;
		numberPattern++;
	}

	public void reversePyramidPattern(Integer levels) {
		str = new StringBuilder();
		// Number
		str.append(numberPattern);
		str.append(")\n");
		// "." Base
		str.append(".".repeat(dots) + "\n");
		// * Steps
		int spaces = 2;
		for (int i = levels * 2 - 1; i > 0; i -= 2) {
			str.append(" ".repeat(spaces) + "*".repeat(i));
			str.append("\n");
			spaces++;
		}

		System.out.print(str);
		
		dots++;
		numberPattern++;
	}
}
