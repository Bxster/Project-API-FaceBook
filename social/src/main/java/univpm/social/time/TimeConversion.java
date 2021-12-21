package univpm.social.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {
	
	
	public static Date toIso8601(String time) 
	{//yyyy-MM-dd'T'HH:mm:ss+SSSS
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
	
	
	
	public static Date fromStringToStandardDate(String time)  
	{
		//String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+SSSS";
		 String DATE_FORMAT = "MM-dd-yyyy";
	     SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		    Date date = null;
		    try {
		        date = sdf.parse(time);
		    } catch(ParseException e) 
		       {
		    	  e.printStackTrace();
		       }

		   return date; 
	}   
	
	
	
	
	  /*
	     Questo metodo booleano ritorna true se e solo se la data è ammisibile,
	     false in ogni altro caso
	   */
	
	  public static boolean isLegalDate(String s)
	    {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			 dateFormat.setLenient(false);
			 return dateFormat.parse(s, new ParsePosition(0)) != null;
		 }
	  
	  
	
	  

}
