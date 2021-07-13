/**
 * 
 */
package com.ss.jb.five;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Methods that demonstrate Java 8 Lambdas, Functional Interfaces and Streams to
 * Sort, Map and Filter Objects from Arrays.
 * 
 * @author Bruno
 *
 */
public class LambdasStreamsFuncInterface {
	/**
	 * Sort the words in ascending order of length using static helper method from
	 * functional interface. Prints result.
	 * 
	 * @param strArr
	 */
	public void sortByLength(List<String> strArr) {
		StringManipulate str = (a, b) -> Integer.compare(a.length(), b.length());
		Collections.sort(strArr, (a, b) -> str.stringFunctional(a, b));
		strArr.forEach((s) -> System.out.println(s));
	}

	/**
	 * Sort the words in descending order of length using static helper method from
	 * functional interface. Prints result.
	 * 
	 * @param strArr
	 */
	public void sortByLengthReverse(List<String> strArr) {
		StringManipulate str = (a, b) -> Integer.compare(b.length(), a.length());
		Collections.sort(strArr, (a, b) -> str.stringFunctional(a, b));
		strArr.forEach((s) -> System.out.println(s));
	}

	/**
	 * Sort the words by first character ASCII alphabetically using lambda
	 * expression. Prints result.
	 * 
	 * @param strArr
	 */
	public void sortAlphabetically(List<String> strArr) {
		Collections.sort(strArr, (a, b) -> Character.compare(a.charAt(0), b.charAt(0)));
		strArr.forEach((s) -> System.out.println(s));
	}

	/**
	 * Sort the words that contain the e character first and all other words second
	 * using lambda expression. Prints result.
	 * 
	 * @param strArr
	 */
	public void sortByLetterE(List<String> strArr) {
		Collections.sort(strArr, (a, b) -> {
			for (Character c : a.toCharArray()) {
				if (c.equals('e')) {
					return -1;
				}
			}
			return 1;
		});
		strArr.forEach((s) -> System.out.println(s));
	}

	/**
	 * Sort the words that contain the e character first and all other words second
	 * using static helper method from functional interface. Prints result.
	 * 
	 * @param strArr
	 */
	public void sortByLetterEStatic(List<String> strArr) {
		StringManipulate str = (a, b) -> {
			for (Character c : a.toCharArray()) {
				if (c.equals('e')) {
					return -1;
				}
			}
			return 1;
		};

		Collections.sort(strArr, (a, b) -> str.stringFunctional(a, b));
		strArr.forEach((s) -> System.out.println(s));
	}

	/**
	 * Prepends either e or o for odd or even number in intArr and joins each value
	 * with a comma
	 * 
	 * @param intArr
	 * @return String
	 */
	public String intArrayToString(List<Integer> intArr) {
		return intArr.stream().map(x -> x % 2 == 0 ? "e" + x.toString() : "o" + x.toString())
				.collect(Collectors.joining(","));
	}

	/**
	 * Filter a list of Strings to return a List of Strings that start with the lowercase letter 'a'
	 * and have a length of exactly three letters.
	 * 
	 * @param intArr
	 * @return List<String>
	 */
	public List<String> filterWords(List<String> strArr) {
		List<String> resArr = strArr.stream().filter(s -> s.length() == 3 && s.charAt(0) == 'a')
				.collect(Collectors.toList());
		return resArr;
	}

}
