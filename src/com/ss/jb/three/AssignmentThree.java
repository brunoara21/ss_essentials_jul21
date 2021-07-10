/**
 * 
 */
package com.ss.jb.three;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

/**
 * Counts number of times a particular character, such as 'e', appears in a
 * file. The character is specified at the command line.
 * 
 * ex. Lorem ipsum , consectetur adipiscing elit. Donec id sapien ullamcorper,
 * est. 'e' = 8 ',' = 2 'a' = 3
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
		AssignmentThree countChar = new AssignmentThree();
		countChar.countCharacters(args[0], "countFile.txt");
	}

	/**
	 * Counts the number of times the character has appeared in file.
	 * 
	 * @param c character to look for in the file
	 * @param file name of the file in resources folder
	 * @return number of times character c has appeared in the file
	 */
	public Integer countCharacters(String c, String file) {
		Integer count = -1;
		if (c.length() == 1) {
			try (InputStream fIn = new FileInputStream("src/com/ss/jb/three/resources/" + file);
					Scanner in = new Scanner(fIn)) {
				CharacterIterator it = null;
				String currLine = null;
				System.out.println("Reading " + file + " :");
				while (in.hasNext()) {
					currLine = in.nextLine();
					System.out.println(currLine);
					it = new StringCharacterIterator(currLine);
					while (it.current() != CharacterIterator.DONE) {
						if (Character.compare(c.toCharArray()[0], it.current()) == 0) {
							count++;
						}
						it.next();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("\nFound character '" + c + "' " + count + " time(s)");
		} else {
			System.out.println("Incorrect input in command line");
		}
		
		return count;

	}
}
