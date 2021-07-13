package com.ss.jb.tests;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.Arrays;

import org.junit.Test;

import com.ss.jb.five.DateTime;

import org.junit.Assert;

/**
 * JUnit Test for DateTime Class
 * @author Bruno
 *
 */
public class DateTimeTest {

	DateTime dt = new DateTime();

	@Test
	public void testGetBirthday() {
		Assert.assertEquals("1997-07-29T00:00:55.000000123", dt.getBirthday(1997, 07, 29, 55, 123).toString());
	}

	@Test
	public void testGetLastThurs() {
		Assert.assertEquals(LocalDate.of(2021, 07, 8), dt.getLastThurs(LocalDate.of(2021, 07, 13)));
		Assert.assertEquals(LocalDate.of(1995, 05, 4), dt.getLastThurs(LocalDate.of(1995, 05, 06)));
		Assert.assertEquals(LocalDate.of(2023, 11, 23), dt.getLastThurs(LocalDate.of(2023, 11, 27)));

	}

	@Test
	public void testGetZoneOffsetFromZoneId() {
		Assert.assertEquals(ZoneOffset.ofHours(-4), dt.getZoneOffsetFromZoneId("America/New_York"));
		Assert.assertEquals(ZoneOffset.ofHours(-8), dt.getZoneOffsetFromZoneId("US/Alaska"));
		Assert.assertEquals(ZoneOffset.ofHours(12), dt.getZoneOffsetFromZoneId("Asia/Kamchatka"));

	}


	@Test
	public void testGetLengthOfMonths() {
		Assert.assertEquals(Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),
				dt.getLengthOfMonths(Year.of(2021))); // Current Year 2021
		Assert.assertEquals(Arrays.asList(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),
				dt.getLengthOfMonths(Year.of(2020))); // Leap Year - Feb should be 29

	}

	@Test
	public void testGetAllMondaysInMonth() {
		Assert.assertEquals(Arrays.asList(LocalDate.of(2021, 07, 5), LocalDate.of(2021, 07, 12),
				LocalDate.of(2021, 07, 19), LocalDate.of(2021, 07, 26)),
				dt.getAllMondaysInMonth(YearMonth.of(2021, 7))); // July 2021
		Assert.assertEquals(
				Arrays.asList(LocalDate.of(2021, 11, 1), LocalDate.of(2021, 11, 8), LocalDate.of(2021, 11, 15),
						LocalDate.of(2021, 11, 22), LocalDate.of(2021, 11, 29)),
				dt.getAllMondaysInMonth(YearMonth.of(2021, 11))); // Nov 2021 - Monday Starts on 1st
		Assert.assertEquals(Arrays.asList(LocalDate.of(2023, 12, 4), LocalDate.of(2023, 12, 11),
				LocalDate.of(2023, 12, 18), LocalDate.of(2023, 12, 25)),
				dt.getAllMondaysInMonth(YearMonth.of(2023, 12))); // Dec 2023 - Last Month of Year
		Assert.assertEquals(
				Arrays.asList(LocalDate.of(2022, 1, 3), LocalDate.of(2022, 1, 10), LocalDate.of(2022, 1, 17),
						LocalDate.of(2022, 1, 24), LocalDate.of(2022, 1, 31)),
				dt.getAllMondaysInMonth(YearMonth.of(2022, 1))); // Jan 2022 - First Month of Year

	}

	@Test
	public void testIsFridayThirteenth() {
		Assert.assertEquals(true, dt.isFridayThirteenth(LocalDate.of(2021, 8, 13))); // 2021 Aug 13 Fri
		Assert.assertEquals(false, dt.isFridayThirteenth(LocalDate.of(2021, 8, 14))); // 2021 Aug 14 Sat
		Assert.assertEquals(true, dt.isFridayThirteenth(LocalDate.of(2015, 02, 13))); // 2015 Feb 13 Fri
		Assert.assertEquals(false, dt.isFridayThirteenth(LocalDate.of(1997, 07, 29))); // 1997 Jul 29 Tue
		Assert.assertEquals(true, dt.isFridayThirteenth(LocalDate.of(2025, 06, 13))); // 2025 Jun 13 Fri
		Assert.assertEquals(false, dt.isFridayThirteenth(LocalDate.of(2022, 4, 22))); // 2022 Apr 22 Fri

	}

}
