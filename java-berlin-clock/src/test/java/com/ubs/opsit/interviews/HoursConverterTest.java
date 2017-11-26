package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.timeUnit.HoursConverter;

public class HoursConverterTest {
	
	private HoursConverter hoursConverter;
	private String expectedResultFor13 = "RROO" + "\n" + "RRRO";  
	private String expectedResultFor23 = "RRRR" + "\n" + "RRRO";
	private String expectedResultFor24 = "RRRR" + "\n" + "RRRR";
	
	private static final Logger LOG = LoggerFactory.getLogger(HoursConverterTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hoursConverter = new HoursConverter();
	}

	@Test
	// Test 13 hours
	public void testGetLampsPerUnit1() {
		String hoursLamps = hoursConverter.getLampsPerUnit(13);
		LOG.debug("Hour lamps for 13: \n"+hoursLamps);
		assertEquals(expectedResultFor13, hoursLamps);
	}
	
	@Test
	// Test 23 hours
	public void testGetLampsPerUnit2() {
		String hoursLamps = hoursConverter.getLampsPerUnit(23);
		LOG.debug("Hour lamps for 23: \n"+hoursLamps);
		assertEquals(expectedResultFor23, hoursLamps);
	}
	
	@Test
	// Test 24 hours
	public void testGetLampsPerUnit3() {
		String hoursLamps = hoursConverter.getLampsPerUnit(24);
		LOG.debug("Hour lamps for 24: \n"+hoursLamps);
		assertEquals(expectedResultFor24, hoursLamps);
	}
}
