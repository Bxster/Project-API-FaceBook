package univpm.social.errorscheck;

import java.time.LocalDate;

import univpm.social.exceptions.BadParameterException;

public class ErrorsCheck {
	
	
	private final static  String commonMessage = "VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE ";
	
	private static boolean isNumber(String day , String month , String year) throws BadParameterException 
	{
		
	try {	
		  if(Integer.parseInt(year) < Integer.MAX_VALUE &&
		     Integer.parseInt(month) < Integer.MAX_VALUE &&
		     Integer.parseInt(year) < Integer.MAX_VALUE )
			  return true;
	    }    
		catch(NumberFormatException e) 
	    {
			throw new NumberFormatException("PUOI INSERIRE SOLO NUMERI");
	    }
	return false;
	}
	
	
	private static boolean correctYear(String number) throws BadParameterException 
	{
		LocalDate now = LocalDate.now();
		
		if(Integer.parseInt(number) <= now.getYear()  && Integer.parseInt(number)>= 2005) 
			return true;
	
		  throw new BadParameterException("ANNO NON VALIDO ! " +   commonMessage);
		                              
                               
	}
	
	
	
	private static boolean correctMonth(String number) throws BadParameterException 
	{		
			if(Integer.parseInt(number)<=12&&Integer.parseInt(number)>=1) 
			   return true;
			else if(Integer.parseInt(number)==0) 
				return true;
			
			  throw new BadParameterException("MESE NON VALIDO ! " + commonMessage);
                                             
	}

}
