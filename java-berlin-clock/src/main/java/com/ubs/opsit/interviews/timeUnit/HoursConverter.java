package com.ubs.opsit.interviews.timeUnit;

import com.ubs.opsit.interviews.util.BerlinClockConstant;

public class HoursConverter implements TimeUnitToLampsConverter {

	@Override
	public String getLampsPerUnit(int hrs) {
		
		return getLampsForPerFiveHours(hrs) + "\r\n" + getLampsForPerOneHour(hrs);
	}
	
	private String getLampsForPerFiveHours(int hrs) {
		StringBuilder fiveHourLamps = new StringBuilder(BerlinClockConstant.ALL_FOUR_LIGHTS_OFF);
		
		for(int i=0; i < (hrs/5); i++) {
			fiveHourLamps.replace(i, i+1, BerlinClockConstant.LIGHT_RED);
		}
		
		return fiveHourLamps.toString();
	}
	
	private String getLampsForPerOneHour(int hrs) {
		StringBuilder oneHourLamps = new StringBuilder(BerlinClockConstant.ALL_FOUR_LIGHTS_OFF);
		
		for(int i=0; i < (hrs%5); i++) {
			oneHourLamps.replace(i, i+1, BerlinClockConstant.LIGHT_RED);
		}
		
		return oneHourLamps.toString();
	}

}
