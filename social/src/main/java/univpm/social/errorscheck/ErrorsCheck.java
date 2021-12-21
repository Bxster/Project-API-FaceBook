package univpm.social.errorscheck;

import java.time.LocalDate;


import univpm.social.exceptions.BadParameterException;
import univpm.social.time.TimeConversion;


/**
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 * 
 * Questa classe gestisce gli errori per la data inserita nel filtro
 * e per l'anno minimo di ricerca
 */

public class ErrorsCheck {
	
	
	private final static  String commonMessage = "VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE ";
	
	/**
	 * Questo metodo controlla i valori inseriti nei campi anno, mese e giorno 
	 * per la rotta filter
	 * 
	 * @param day per controllare il giorno
	 * @param month per controllare il mese
	 * @param year per controllare l'anno
	 * @return true se i valori inseriti sono accettabili, sennò darà un errore a schermo
	 * @throws BadParameterException nel caso in cui i valori siano inaccettabili
	 */
	
	private static boolean isNumber(String day , String month , String year) throws BadParameterException 
	{
		
	try {	
		  if(Integer.parseInt(year) < Integer.MAX_VALUE &&
		     Integer.parseInt(month) < Integer.MAX_VALUE &&
		     Integer.parseInt(day) < Integer.MAX_VALUE )
			  return true;
	    }    
		catch(NumberFormatException e) 
	    {
			throw new NumberFormatException("PUOI INSERIRE SOLO NUMERI");
	    }
	return false;
	}
	
	/**
	 * Questa classe controlla il valore dell'anno inserito
	 * 
	 * @param number per controllare l'anno
	 * @return true se il valore inserito è accettabile, sennò darà un errore a schermo
	 * @throws BadParameterException nel caso in cui il valore inserito è inaccettabile
	 */
	
	
	private static boolean correctYear(String number) throws BadParameterException 
	{
		LocalDate now = LocalDate.now();
		
		if(Integer.parseInt(number) <= now.getYear()  && Integer.parseInt(number)>= 2005) 
			return true;
	
		  throw new BadParameterException("ANNO NON VALIDO ! " +   commonMessage);
		                              
                               
	}
	
	/**
	 * Questa classe controlla il valore del mese inserito
	 * 
	 * @param number per controllare il mese
	 * @return true se il valore inserito è accettabile, sennò darà un errore a schermo
	 * @throws BadParameterException nel caso in cui il valore inserito è inaccettabile
	 */
	
	private static boolean correctMonth(String number) throws BadParameterException 
	{		
			if(Integer.parseInt(number)<=12&&Integer.parseInt(number)>=1) 
			   return true;
			else if(Integer.parseInt(number)==0) 
				return true;
			
			  throw new BadParameterException("MESE NON VALIDO ! " + commonMessage);
                                             
	}
	
	/**
	 * Questa classe controlla il valore del giorno inserito
	 * 
	 * @param day per il valore del giorno
	 * @param year per il valore dell'anno
	 * @param month per il valore del mese
	 * @return true se i valori sono accettabili e la data è reale
	 * @throws BadParameterException se il giorno inserito non è valido
	 */
	
	
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
	
	
	/**
	 * Questa classe controlla che i valori inseriti non siano
	 * uguali allo 0
	 * 
	 * @param day per il valore del giorno
	 * @param year per il valore dell'anno
	 * @param month per il valore del mese
	 * @return true se i valori inseriti sono accettabili
	 * @throws BadParameterException se almeno uno dei parametri passati è uguale a 0 
	 */
	
	private static boolean allZero(String day , String year , String month) throws BadParameterException 
	  {
		 if(day.equals("0") && year.equals("0") && month.equals("0"))
			throw new BadParameterException("NON POSSO FILTRARE SE TUTTI I PARAMETRI SONO NULLI");
		 
		 else return true;
	  }
	
	/**
	 * Questa classe unisce tutti i vari check precedenti per fare 
	 * un controllo generale ai valori inseriti
	 * 
	 * @param day per il valore del giorno
	 * @param month per il valore del mese
	 * @param year per il valore dell'anno
	 * @return true se i valori inseriti sono accettabili
	 * @throws BadParameterException se qualche  valore inserito è inaccettabile
	 */
	
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
