package univpm.social.exceptions;


import org.json.simple.JSONObject;

/**
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 * 
 * Questa classe serve per gestire l'eccezione personalizzata
 * BadParameterException
 *
 */

public class BadParameterException extends Exception{
	
	public BadParameterException() 
	{
		super();
	}
	
	public BadParameterException(String msg) 
	{
		super(msg);
	}

}