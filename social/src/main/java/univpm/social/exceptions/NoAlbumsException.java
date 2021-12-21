package univpm.social.exceptions;


/**
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 * 
 * Questa classe serve per gestire l'eccezione personalizzata
 * NoAlbumsException
 *
 */

public class NoAlbumsException extends Exception{
	
	public NoAlbumsException() 
	{
		super();
	}
	
	
	public NoAlbumsException(String msg) 
	{
		super(msg);
	}


}