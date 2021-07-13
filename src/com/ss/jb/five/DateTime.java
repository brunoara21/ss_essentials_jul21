/**
 * 
 */
package com.ss.jb.five;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * Methods that demonstrate Jave 8 Date and Time API to manipulate Date and Time
 * @author Bruno
 *
 */
public class DateTime {

	/**
	 * Stores a date to a LocalDateTime which takes in year,month, day, seconds, and nanoseconds
	 * @param year
	 * @param month
	 * @param day
	 * @param seconds
	 * @param nanoSec
	 * @return
	 */
	public LocalDateTime getBirthday(Integer year, Integer month, Integer day, Integer seconds, Integer nanoSec) {
		return LocalDateTime.of(year, month, day, 00, 00, seconds, nanoSec);
	}
	
	/**
	 * Takes a LocalDate argument and returns a LocalDate of Last Thursday
	 * @param d
	 * @return Date for Previous Thursday
	 */
	public LocalDate getLastThurs(LocalDate d) {
		return d.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
	}
	
	
	/**
	 * Zone offset is the time-zone offset in hours to the UTC time zone which is 00:00
	 * ZoneId is an identifier used to describe Zone Rules and converts between Instant and LocalDateTime
	 * @return
	 */
	public ZoneOffset getZoneOffsetFromZoneId(String zid) {
		LocalDateTime ldt = LocalDateTime.now();
		ZoneId myZone = ZoneId.of(zid);
		return myZone.getRules().getOffset(ldt);
	}
	
	/**
	 * Converts an Instant to ZonedDateTime
	 */
	public ZonedDateTime instantToZonedDateTime() {
		Instant ins = Instant.now();
		return ins.atZone(ZoneId.of("America/New_York"));
		

	}
	
	/**
	 * Converts ZonedDateTime to an Instant
	 */
	public Instant zonedDateTimeToInstant() {
		LocalDateTime dt = LocalDateTime.now();
		ZonedDateTime myTime = dt.atZone(ZoneId.of("America/New_York"));		
		return myTime.toInstant();
		
		
	}

	/**
	 * Takes any Year as input and returns a List of Integers for the lenght of each month of that year
	 * @param y
	 * @return
	 */
	public List<Integer> getLengthOfMonths(Year y) {
		List<Integer> lenMonths = new ArrayList<Integer>();
		YearMonth m = y.atMonth(1);
		while(m.isBefore(y.plusYears(1).atMonth(1))) {
			lenMonths.add(m.lengthOfMonth());
			m = m.plusMonths(1);
		}
		return lenMonths;
	}
	
	/**
	 * Takes a YearMonth as input and returns a List of Dates that corresponds to the Monday of that month
	 * @param m
	 * @return
	 */
	public List<LocalDate> getAllMondaysInMonth(YearMonth m) {
		LocalDate d = m.atDay(1).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)); // Find first Monday of month
		List<LocalDate> dd = new ArrayList<LocalDate>();
		while(d.isBefore(m.plusMonths(1).atDay(1))) { // Before the first of next month
			dd.add(d);
			d = d.plusWeeks(1);	// Next Monday
		}
		return dd;
	}
	
	/**
	 * Takes in a LocalDate and evaluates if the Date is a Friday the 13th.
	 * @param d
	 * @return
	 */
	public boolean isFridayThirteenth(LocalDate d) {
		return d.getDayOfWeek() == DayOfWeek.FRIDAY && d.getDayOfMonth() == 13 ? true : false;
	}
}
