package univpm.social.errorscheck;

import java.time.LocalDate;


import univpm.social.exceptions.BadParameterException;
import univpm.social.time.TimeConversion;

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
	
	
	
	
	private static boolean correctDay(String day , String year , String month) throws BadParameterException 
	{
		
		String time = month + "-" + day + "-" + year;
        
		if(Integer.parseInt(day)==0) 
			 return true;
		/* In questo caso l'anno non puo essere uguale a zero , ma questo controllo
		   viene interecettato dalla chiamata nel if della chiamata al metodo filter
		   della classe FilterImpl, ora però se passo una data devo verificare che il 
		   mese sia corretto altrimenti devo lanciare un eccezione specifica per il mese		   
	    */
		else if(Integer.parseInt(month)==0) 
			  throw new BadParameterException("MESE NON VALIDO ! " + commonMessage);
		else if(TimeConversion.isLegalDate(time)) 
			 return true;
		 	
	   throw new BadParameterException("GIORNO NON VALIDO ! " +  commonMessage);
	  		                          
	}
	
	
	
	private static boolean allZero(String day , String year , String month) throws BadParameterException 
	  {
		 if(day.equals("0") && year.equals("0") && month.equals("0"))
			throw new BadParameterException("NON POSSO FILTRARE SE TUTTI I PARAMETRI SONO NULLI");
		 
		 else return true;
	  }
	
	
	
	public  boolean errorsCheck(String day , String month , String year) throws BadParameterException 
	  {
		
		if(ErrorsCheck.allZero(day, year, month))
		
		if(ErrorsCheck.isNumber(day,month,year) &&
		   ErrorsCheck.allZero(day, year, month) &&
		   ErrorsCheck.correctYear(year) &&
		   ErrorsCheck.correctMonth(month)  && 
		   ErrorsCheck.correctDay(day,year,month))
		   return true;  
		
		return true;
	  }

}
