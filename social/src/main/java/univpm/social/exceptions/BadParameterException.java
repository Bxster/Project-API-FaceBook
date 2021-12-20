package univpm.social.exceptions;


import org.json.simple.JSONObject;

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