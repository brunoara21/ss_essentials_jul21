/**
 * 
 */
package com.ss.jb.three;

import java.io.File;
import java.io.IOException;

/**
 * A program that lists all file/directory names including all file/directory
 * names of the first level of directories.
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
		getFileNames(new File("."), 1);
	}

	/**
	 * Prints out names of files of given directory and all sub-directories within given levels limit
	 * 
	 * @param dir path string to top directory to be checked
	 * @param levels number of levels deep to be checked
	 */
	public static void getFileNames(File dir, Integer levels) {
		getFileNames(dir, levels, 0);
		return;
	}

	/**
	 * 
	 * Function helper for indentation formatting.
	 * 
	 * @param dir
	 * @param levels
	 * @param indents
	 * @see #getFileNames(File, Integer)
	 */
	private static void getFileNames(File dir, Integer levels, Integer indents) {
		try {
			for (int i = 0; i < indents; i++) {
				System.out.print("\t");
			}
			System.out.println("Current Directory: '" + dir.getCanonicalPath() + "' ~ ");
			File[] curDirFiles = dir.listFiles();
			for (File f : curDirFiles) {
				if (f.isDirectory()) {	// Directory Handling
					for (int i = 0; i < indents; i++) {
						System.out.print("\t");
					}
					System.out.println(" <DIR>\t" + f.getName() );

					if (levels > 0) {
						getFileNames(f, levels - 1, indents + 1);
					}

				} else {				// File Handling
					for (int i = 0; i < indents; i++) {
						System.out.print("\t");
					}
					System.out.println(" <FILE>\t" + f.getName());
				}
			}
			return;
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

}
