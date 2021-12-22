package univpm.social.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Questa classe implementa il cambio del formato
 * dell'ora
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public class TimeConversion {
	
	/**
	 * Questo metodo trasforma la data in un Iso
	 * 
	 * @param time per contenere la data
	 * @return la data
	 */
	
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
	
	/**
	 * Questo metodo trasforma la data in un Date
	 * 
	 * @param time per contenere la data
	 * @return la data
	 */
	
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
	
	
	  /**
	   * Questo metodo booleano ritorna true se e solo se la data è ammisibile,
	     false in ogni altro caso
	   * 
	   * @param s per contenere la data
	   * @return true se la data è accettabile
	   */
	
	  public static boolean isLegalDate(String s)
	    {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			 dateFormat.setLenient(false);
			 return dateFormat.parse(s, new ParsePosition(0)) != null;
		 }
	  
	  
	
	  

}
