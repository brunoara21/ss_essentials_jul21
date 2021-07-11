/**
 * 
 */
package com.ss.jb.tests;

import org.junit.Assert;

import org.junit.Test;

import com.ss.jb.four.Line;

/**
 * JUnit Test for Line Class
 * @author Bruno
 *
 */
public class LineTest {
	
	Line l1 = new Line(0,5,1,1);
	Line l2 = new Line(0,4,1,0);
	Line l3 = new Line(0,0,3,4);
	Line l4 = new Line(0,0,0,4);
	
	
	@Test
	public void testSlope() {
		Assert.assertEquals(-4, l1.getSlope(), 0.0001);
		Assert.assertEquals(-4, l2.getSlope(), 0.0001);
		Assert.assertEquals(1.3333, l3.getSlope(), 0.0001);
		
	}
	
	@Test(expected = ArithmeticException.class)
	public void whenExceptionThrown_testNoSlope() {
		l4.getSlope();
		l3.parallelTo(l4);
		l4.parallelTo(l3);

	}
	
	@Test
	public void testDistance() {
		Assert.assertEquals(4.1231, l1.getDistance(), 0.0001);
		Assert.assertEquals(4.1231, l2.getDistance(), 0.0001);
		Assert.assertEquals(5, l3.getDistance(), 0.0001);
		Assert.assertEquals(4, l4.getDistance(), 0.0001);
	}
	
	@Test
	public void testParallelTo() {
		Assert.assertEquals(true, l1.parallelTo(l2));
		Assert.assertEquals(true, l2.parallelTo(l1));
		Assert.assertEquals(false, l1.parallelTo(l3));
		Assert.assertEquals(false, l3.parallelTo(l1));


	}
}
