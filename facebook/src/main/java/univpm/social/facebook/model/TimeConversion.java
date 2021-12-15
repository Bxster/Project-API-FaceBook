package univpm.social.facebook.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimeConversion {
	
	public static Date toIso8601(String time) 
	{
    	String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+SSSS";
	     SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		    Date date = null;
		    try {
		        date = sdf.parse(time);
		    } catch(ParseException e) 
		       {
		    	  // TODO LUCA : FARE QUALCOSA QUI
		       }
		    
		    return date;
	}
	
	
	public static Date toStandardDate(String time) 
	{
		//String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+SSSS";
		 String DATE_FORMAT = "yyyy-MM-dd";
	     SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		    Date date = null;
		    try {
		        date = sdf.parse(time);
		    } catch(ParseException e) 
		       {
		    	  // TODO LUCA : FARE QUALCOSA QUI
		       }

		   return date; 
	}

}
