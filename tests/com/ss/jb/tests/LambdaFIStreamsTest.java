/**
 * 
 */
package com.ss.jb.tests;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ss.jb.five.LambdasStreamsFuncInterface;

/**
 * JUnit Test for LambdaStreamsFuncInterface Class
 * @author Bruno
 *
 */
public class LambdaFIStreamsTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); 
	
	List<String> randStr = Arrays.asList("Hello", "yes","Tony", "albert", "TONYA", "no","alphAbet", "hannah", "lock");
	List<Integer> randNum = Arrays.asList(3, 1, 14, 44, 23, 100, 123, 2134);
	List<String> randStr2 = Arrays.asList("ant", "animal", "", "dog", "cat", "nope", "air", "Ate", "ate", "123",
			" a2");
	LambdasStreamsFuncInterface lsfi = new LambdasStreamsFuncInterface();
	
	@Before
	public void setUp(){
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	public void testSortByLength() {
		lsfi.sortByLength(randStr);
		Assert.assertEquals("no\r\n"
				+ "yes\r\n"
				+ "Tony\r\n"
				+ "lock\r\n"
				+ "Hello\r\n"
				+ "TONYA\r\n"
				+ "albert\r\n"
				+ "hannah\r\n"
				+ "alphAbet", outputStreamCaptor.toString().trim());
	}
	@Test
	public void testSortByLengthRev() {
		lsfi.sortByLengthReverse(randStr);
		Assert.assertEquals("alphAbet\r\n"
				+ "albert\r\n"
				+ "hannah\r\n"
				+ "Hello\r\n"
				+ "TONYA\r\n"
				+ "Tony\r\n"
				+ "lock\r\n"
				+ "yes\r\n"
				+ "no", outputStreamCaptor.toString().trim());
	}
	@Test
	public void testSortAlphabetically() {
		lsfi.sortAlphabetically(randStr);
		Assert.assertEquals("Hello\r\n"
				+ "Tony\r\n"
				+ "TONYA\r\n"
				+ "albert\r\n"
				+ "alphAbet\r\n"
				+ "hannah\r\n"
				+ "lock\r\n"
				+ "no\r\n"
				+ "yes", outputStreamCaptor.toString().trim());
	}
	@Test
	public void testSortByLetterE() {
		lsfi.sortByLetterE(randStr);
		Assert.assertEquals("alphAbet\r\n"
				+ "albert\r\n"
				+ "yes\r\n"
				+ "Hello\r\n"
				+ "Tony\r\n"
				+ "TONYA\r\n"
				+ "no\r\n"
				+ "hannah\r\n"
				+ "lock", outputStreamCaptor.toString().trim());
	}
	@Test
	public void testSortByLetterEStatic() {
		lsfi.sortByLetterEStatic(randStr);
		Assert.assertEquals("alphAbet\r\n"
				+ "albert\r\n"
				+ "yes\r\n"
				+ "Hello\r\n"
				+ "Tony\r\n"
				+ "TONYA\r\n"
				+ "no\r\n"
				+ "hannah\r\n"
				+ "lock", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testIntArrToString() {
		Assert.assertEquals("o3,o1,e14,e44,o23,e100,o123,e2134",lsfi.intArrayToString(randNum));
	}
	
	@Test
	public void testFilterWords() {
		Assert.assertEquals(Arrays.asList("ant","air","ate"), lsfi.filterWords(randStr2));
	}
	
	@After
	public void tearDown(){
		System.setOut(standardOut);
	}

}
