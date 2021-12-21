package univpm.social.exceptions;


/**
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 * 
 * Questa classe serve per gestire l'eccezione personalizzata
 * FileException
 *
 */

public class FileException extends Exception{
	
	public FileException() 
	{
		super();
	}
	
	public FileException(String msg) 
	{
		super(msg);
	}

}