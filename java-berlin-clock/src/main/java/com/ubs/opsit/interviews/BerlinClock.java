package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ubs.opsit.interviews.timeUnit.*;

public class BerlinClock implements TimeConverter {
	
	private static final Logger LOG = LoggerFactory.getLogger(BerlinClock.class);
	
	private List<TimeUnitToLampsConverter> timeUnitToLampsConverters = new ArrayList<TimeUnitToLampsConverter>();

	public BerlinClock() {
		timeUnitToLampsConverters.add(new SecondsConverter());
		timeUnitToLampsConverters.add(new MinutesConverter());
		timeUnitToLampsConverters.add(new HoursConverter());	
	}

	@Override
	public String convertTime(String aTime) {
		StringBuilder berlinTimeString = new StringBuilder();
		List<String> berlinClockLamps = new ArrayList<String>();
		
		try {
			LOG.debug("Process started to convert time: "+aTime);
			
			String[] timeComponents = aTime.split(":");
			LOG.debug("Time Components: "+ Arrays.toString(timeComponents) );
			
			int i = 2;
			for(TimeUnitToLampsConverter lampsConverter : timeUnitToLampsConverters) {
				while(i >= 0) {
					berlinClockLamps.add( lampsConverter.getLampsPerUnit(Integer.parseInt(timeComponents[i])) );
					i--;
					break;
				}				
			}
			
			berlinTimeString.append(berlinClockLamps.get(0)).append("\r\n")
							.append(berlinClockLamps.get(2)).append("\r\n")
							.append(berlinClockLamps.get(1));
			
			LOG.debug("Process completed to convert time"+berlinTimeString.toString());			
		}
		catch(Exception e) {
			LOG.error("Exception occurred while conveting time", e);
		}
		
		return berlinTimeString.toString();
	}

}
