/**
 * 
 */
package com.ss.jb.three;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Program that appends text to an existing file
 * 
 * @author Bruno
 *
 */
public class AssignmentTwo {

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		AssignmentTwo readWrite = new AssignmentTwo();
		readWrite.appendToFile("\nHELLO", "LoremIpsum.txt");
	}

	/**
	 * Appends a String to the end of the specified file and printing out the result using FileInputStream,
	 * FileOutputStream, Scanner and PrintWriter.
	 * @param txt String to be appended to file
	 * @param file name of the file in resources folder
	 */
	public void appendToFile(String txt, String file) {
		try (InputStream fIn = new FileInputStream("src/com/ss/jb/three/resources/" + file);
				FileOutputStream fOut = new FileOutputStream("src/com/ss/jb/three/resources/" + file, true)) {
			Scanner in = new Scanner(fIn);
			PrintWriter out = new PrintWriter(fOut);

			
			System.out.println("Appending to " + file + " :");
			out.write(txt);
			out.close();
			
			System.out.println("Reading " + file + " :");
			while (in.hasNext()) {
				System.out.println(in.nextLine());
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
