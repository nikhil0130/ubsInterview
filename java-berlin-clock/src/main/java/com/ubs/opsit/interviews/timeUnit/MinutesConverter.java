package com.ubs.opsit.interviews.timeUnit;

import com.ubs.opsit.interviews.util.BerlinClockConstant;

public class MinutesConverter implements TimeUnitToLampsConverter {

	@Override
	public String getLampsPerUnit(int min) {
		int minuteQtr = min / 5;
		int minRemainingAftrQtr = min % 5;

		return getLampsForPerFiveMinutes(minuteQtr) + "\r\n" +getLampsForPerOneMinute(minRemainingAftrQtr);
	}
	
	private String getLampsForPerFiveMinutes(int min) {
		StringBuilder fiveMinuteLamps = new StringBuilder(BerlinClockConstant.ALL_ELEVEN_LIGHTS_OFF);
		for(int i=0; i<min ; i++) {
			if( (i+1) % 3 == 0 ) {
				fiveMinuteLamps.replace(i, i+1, BerlinClockConstant.LIGHT_RED);
			} else {
				fiveMinuteLamps.replace(i, i+1, BerlinClockConstant.LIGHT_YELLOW);
			}
		}
		return fiveMinuteLamps.toString();
	}
	
	private String getLampsForPerOneMinute(int min) {
		StringBuilder oneMinuteLamps = new StringBuilder(BerlinClockConstant.ALL_FOUR_LIGHTS_OFF);
		for(int i=0; i<min; i++) {
			oneMinuteLamps.replace(i, i+1, BerlinClockConstant.LIGHT_YELLOW);
		}
		return oneMinuteLamps.toString();
	}

}
