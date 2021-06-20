package org.belmon.timecalculation.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class TimeCalculationService {
	public long getDiffMinutes(String time1, String time2) throws ParseException{
			long diffInMinutes = 0;
	        String pattern = "EEE, dd MMM yyyy HH:mm:ss Z";
	        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
	        Date date1 =  format.parse(time1);
	        Date date2 =  format.parse(time2);
	        

	        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(date1.toInstant(),
                    ZoneId.systemDefault());
	        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date2.toInstant(),
                    ZoneId.systemDefault());
	        
	       if(localDateTime2.isAfter(localDateTime1)) {	                
	        	diffInMinutes = java.time.Duration.between(localDateTime1, localDateTime2).toMinutes();
	        } else {
	        	diffInMinutes = java.time.Duration.between(localDateTime2, localDateTime1).toMinutes();
	        }
	        return diffInMinutes;
	    }
}
