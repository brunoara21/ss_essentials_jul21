/**
 * 
 */
package com.ss.jb.tests;


import java.util.Arrays;

import org.junit.Test;

import com.ss.jb.wk1.AssignmentWeekOne;

import org.junit.Assert;

/**
 * JUnit Test for LambdaStreamsFuncInterface Class
 * @author Bruno
 *
 */
public class AssignmentWeekOneTest {

	AssignmentWeekOne wk1 = new AssignmentWeekOne();

	@Test
	public void testLambdas() {
		Assert.assertEquals("EVEN", wk1.lambdaOperations(1, 4));
		Assert.assertEquals("PRIME", wk1.lambdaOperations(2, 5));
		Assert.assertEquals("PALINDROME", wk1.lambdaOperations(3, 898));
		Assert.assertEquals("NOT PALINDROME", wk1.lambdaOperations(3, 897));
		Assert.assertEquals("ODD", wk1.lambdaOperations(1, 3));
		Assert.assertEquals("COMPOSITE", wk1.lambdaOperations(2, 12));
		Assert.assertEquals("NO CONDITION", wk1.lambdaOperations(5, 12));
		Assert.assertEquals("COMPOSITE", wk1.lambdaOperations(2, 1));
	}

	@Test
	public void testRightDigit() {
		Assert.assertEquals(Arrays.asList(1, 2, 3), wk1.rightDigit(Arrays.asList(1, 22, 93)));
		Assert.assertEquals(Arrays.asList(6, 8, 6, 8, 1), wk1.rightDigit(Arrays.asList(16, 8, 886, 8, 1)));
		Assert.assertEquals(Arrays.asList(0, 0), wk1.rightDigit(Arrays.asList(10, 0)));
	}

	@Test
	public void testDoubling() {
		Assert.assertEquals(Arrays.asList(2, 4, 6), wk1.doubling(Arrays.asList(1, 2, 3)));
		Assert.assertEquals(Arrays.asList(12, 16, 12, 16, -2), wk1.doubling(Arrays.asList(6, 8, 6, 8, -1)));
		Assert.assertEquals(Arrays.asList(), wk1.doubling(Arrays.asList()));
	}

	@Test
	public void testNoX() {
		Assert.assertEquals(Arrays.asList("a", "bb", "c"), wk1.noX(Arrays.asList("ax", "bb", "cx")));
		Assert.assertEquals(Arrays.asList("a", "bb", "c"), wk1.noX(Arrays.asList("xxax", "xbxbx", "xxcx")));
		Assert.assertEquals(Arrays.asList(""), wk1.noX(Arrays.asList("x")));

	}

	@Test
	public void testRecursion() {
		Assert.assertEquals(false, wk1.groupSumClump(0, Arrays.asList(2, 4, 4, 8), 14));
		Assert.assertEquals(true, wk1.groupSumClump(0, Arrays.asList(2, 4, 8), 10));
		Assert.assertEquals(true, wk1.groupSumClump(0, Arrays.asList(1, 2, 4, 8, 1), 14));
		Assert.assertEquals(true, wk1.groupSumClump(0, Arrays.asList(1, 2, 2, 2, 5, 2), 11));
		Assert.assertEquals(true, wk1.groupSumClump(0, Arrays.asList(1, 2, 2, 2, 5, 2), 2));
		Assert.assertEquals(true, wk1.groupSumClump(0, Arrays.asList(1, 2, 2, 2, 5, 2), 9));
		Assert.assertEquals(false, wk1.groupSumClump(0, Arrays.asList(1, 2, 2, 2, 5, 2), 10));
	}

}
