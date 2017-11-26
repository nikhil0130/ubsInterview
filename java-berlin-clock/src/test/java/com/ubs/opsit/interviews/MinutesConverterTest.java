package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.timeUnit.MinutesConverter;

public class MinutesConverterTest {
	
	private MinutesConverter minutesConverter;
	private String expectedResultFor17 = "YYROOOOOOOO" + "\n" + "YYOO";
	private String expectedResultFor59 = "YYRYYRYYRYY" + "\n" + "YYYY";
	private String expectedResultFor00 = "OOOOOOOOOOO" + "\n" + "OOOO";

	private static final Logger LOG = LoggerFactory.getLogger(MinutesConverterTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		minutesConverter = new MinutesConverter();
	}

	@Test
	public void testGetLampsPerUnit1() {
		String minLamps = minutesConverter.getLampsPerUnit(17);
		LOG.debug("Minute lamps for 17: \n"+minLamps);
		assertEquals(expectedResultFor17, minLamps);
	}
	
	@Test
	public void testGetLampsPerUnit2() {
		String minLamps = minutesConverter.getLampsPerUnit(59);
		LOG.debug("Minute lamps for 59: \n"+minLamps);
		assertEquals(expectedResultFor59, minLamps);
	}
	
	@Test
	public void testGetLampsPerUnit3() {
		String minLamps = minutesConverter.getLampsPerUnit(00);
		LOG.debug("Minute lamps for 00: \n"+minLamps);
		assertEquals(expectedResultFor00, minLamps);
	}
}
