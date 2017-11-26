package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.timeUnit.SecondsConverter;

public class SecondsConverterTest {
	
	private SecondsConverter secondsConverter;
	private String expectedResultFor01 = "O";
	private String expectedResultFor59 = "O";
	private String expectedResultFor00 = "Y";
	
	private static final Logger LOG = LoggerFactory.getLogger(SecondsConverterTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		secondsConverter = new SecondsConverter();
	}

	@Test
	public void testGetLampsPerUnit1() {
		String secLamps = secondsConverter.getLampsPerUnit(17);
		LOG.debug("Second lamps for 01: \n"+secLamps);
		assertEquals(expectedResultFor01, secLamps);
	}
	
	@Test
	public void testGetLampsPerUnit2() {
		String secLamps = secondsConverter.getLampsPerUnit(59);
		LOG.debug("Second lamps for 59: \n"+secLamps);
		assertEquals(expectedResultFor59, secLamps);
	}
	
	@Test
	public void testGetLampsPerUnit3() {
		String secLamps = secondsConverter.getLampsPerUnit(00);
		LOG.debug("Second lamps for 00: \n"+secLamps);
		assertEquals(expectedResultFor00, secLamps);
	}
}
