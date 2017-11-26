package com.ubs.opsit.interviews.timeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.util.BerlinClockConstant;

public class SecondsConverter implements TimeUnitToLampsConverter {
	
	private static final Logger LOG = LoggerFactory.getLogger(SecondsConverter.class);

	@Override
	public String getLampsPerUnit(int seconds) {
		if(seconds%2 == 0) {
			return BerlinClockConstant.LIGHT_YELLOW;
		}
		return BerlinClockConstant.LIGHT_NO;
	}
}
