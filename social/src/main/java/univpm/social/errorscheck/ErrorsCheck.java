package univpm.social.errorscheck;

import univpm.social.exceptions.BadParameterException;

public class ErrorsCheck {
	
	
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

}
