/**
 * 
 */
package com.ss.jb.wk1;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Week One Assignments for Java features learned
 * @author Bruno
 *
 */
public class AssignmentWeekOne {

	/**
	 * Lambda Operations using a functional interface. Takes in condition number and number to be evaluated.
	 * Condition 1: Checks if number is Odd/Even
	 * Condition 2: Checks if number is Prime/Composite
	 * Condition 3: Checks if number is Palindrome/Not Palindrome
	 * @param condition
	 * @param num
	 * @return
	 */
	public String lambdaOperations(Integer condition, Integer num) {
		PerformOperation isOdd = (n) -> n % 2 == 0 ? "EVEN" : "ODD";
		PerformOperation isPrime = (n) -> {
			if (n <= 1)
				return "COMPOSITE";
			for (int i = 2; i < Math.sqrt(n); i++) {
				if (n % i == 0)
					return "COMPOSITE";
			}
			return "PRIME";
		};
		PerformOperation isPalindrome = (n) -> {
			Integer reversedNum = 0;
			Integer remainder = 0;
			Integer originalNum = n;
			while (n != 0) {
				remainder = n % 10;
				reversedNum = reversedNum * 10 + remainder;
				n /= 10;
			}
			return originalNum.equals(reversedNum) ? "PALINDROME" : "NOT PALINDROME";
		};

		switch (condition) {
		case 1:
			return isOdd.performOp(num);
		case 2:
			return isPrime.performOp(num);
		case 3:
			return isPalindrome.performOp(num);
		default:
			return "NO CONDITION";
		}

	}

	/**
	 * Given a list of non-negative integers, returns an integer list of the rightmost digits.
	 * @param arrInt
	 * @return
	 */
	public List<Integer> rightDigit(List<Integer> arrInt) {
		return arrInt.stream().map(i -> i % 10).toList();

	}

	/**
	 * Given a list of integers, returns a list where each integer is multiplied by 2.
	 * @param arrInt
	 * @return
	 */
	public List<Integer> doubling(List<Integer> arrInt) {
		return arrInt.stream().map(i -> i * 2).collect(Collectors.toList());

	}

	/**
	 * Given a list of strings, returns a list where each string has all its "x" removed.
	 * @param arrStr
	 * @return
	 */
	public List<String> noX(List<String> arrStr) {
		return arrStr.stream().map((s) -> {
			StringBuilder noX = new StringBuilder();
			for (Character c : s.toCharArray()) {
				if (c != 'x') {
					noX.append(c);
				}
			}
			return noX.toString();
		}).collect(Collectors.toList());

	}

	/**
	 * Recursive function that returns true if you can get target sum from list of Integers. Additional
	 * constraint of using consecutive same numbers as clumps of numbers to sum.
	 * @param sum
	 * @param arrInt
	 * @param target
	 * @return
	 */
	public boolean groupSumClump(Integer sum, List<Integer> arrInt, int target) {
		if (sum == target)
			return true;
		if (sum > target)
			return false;

		for (int i = 0; i < arrInt.size();) {
			Integer clumpSum = arrInt.get(i);
			while (i + 1 < arrInt.size() && arrInt.get(i + 1) == arrInt.get(i)) {
				i++;
				clumpSum += arrInt.get(i);
			}
			return groupSumClump(sum + clumpSum, arrInt.subList(i + 1, arrInt.size()), target)
					|| groupSumClump(sum, arrInt.subList(i + 1, arrInt.size()), target);
		}

		return false;
	}

	/**
	 * Singleton implementation using Connection as a synchronized Object and making sure it is thread-safe
	 * by double-checking lock
	 * @author Bruno
	 *
	 */
	public static class SampleSingleton {
		private static Connection conn = null;

		private volatile static SampleSingleton instance = null;

		private SampleSingleton() {
		}

		public static SampleSingleton getInstance() {
			if (instance != null) {
				return instance;
			}
			synchronized (conn) {
				if (instance != null) {
					instance = new SampleSingleton();
				}
			}

			return instance;
		}
	}
}
