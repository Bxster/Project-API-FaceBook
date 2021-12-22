package univpm.social.model;

/**
 * Questa classe astratta prepara alcuni metodi e gli
 * attributi degli oggetti del nostro modello
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public abstract class GeneralObject {
	
	
	private String id;
	private String name;
	
	/**
	 * Costruttore della classe astratta GeneralObject
	 * 
	 * @param name per contenere il nome dell'utente
	 * @param id per contenere l'id dell'utente
	 */
	
	public GeneralObject(String name, String id) 
	{
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Metodo che restituisce l'id dell'utente
	 * 
	 * @return id che contiene l'id dell'utente
	 */
	
	
	public String getId() 
	{
		return id;
	}
	
	/**
	 * Metodo che restituisce il nome dell'utente
	 * 
	 * @return name che contiene il nome dell'utente
	 */
	
	public String getName() 
	{
		return name;
	}

}
