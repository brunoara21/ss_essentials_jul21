/**
 * 
 */
package com.ss.jb.one;

import java.util.Random;
import java.util.Scanner;

/**
 * This class is for Java Basics 1 : Assignment 2
 * 
 * - User is asked to guess a number 1-100. (Program chooses randomly.) - If the
 * guess is within 10 of the correct answer, plus or minus, output the correct
 * answer and exit. (If the answer is 63, user must guess 53-73.) - If the
 * number is not within 10 of the correct answer, ask the user to keep guessing.
 * - If the user does not succeed within 5 attempts, display, "Sorry," along
 * with the answer and exit.
 * 
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
		Scanner userInput = null;
		try {
			userInput = new Scanner(System.in);

			System.out.println("Hello! Let's play a game. \nPlease input a number between 1-100");
			System.out.println("You have up to 5 attempts to get within 10 of my hidden number.");
			System.out.print("Give it a try: ");

			Random rn = new Random();
			int randomGenInt = rn.nextInt(100) + 1;
			int attemptNum = 1;
			while (attemptNum <= 5) {
				while (!userInput.hasNextInt()) {
					System.out.println("This is not a valid input. Try again: ");
					userInput.next();
				}
				int guess = userInput.nextInt();
				if (guess <= 0 || guess > 100) {
					System.out.print("Number out of range(1-100). Try again: ");
					continue;
				}

				if (randomGenInt - 10 <= guess && guess <= randomGenInt + 10) {
					System.out.printf("You have guessed within 10! Here is the number I was thinking of %d.\n",
							randomGenInt);
					return;
				} else if (attemptNum != 5) {
					System.out.print("Not quite within range of answer. Try again: ");
				} else {
					System.out.print("Not quite within range of answer. ");
				}

				attemptNum++;
			}

			System.out.printf("Sorry, I was thinking of %d.\n", randomGenInt);
		} finally {
			if(userInput != null)
				userInput.close();
		}
	}

}
