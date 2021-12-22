package univpm.social.model;

import java.util.ArrayList;
import java.util.Date;
import univpm.social.time.TimeConversion;

/**
 * Questa classe implementa i metodi e gli attributi
 * dell'utente
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public class User extends GeneralObject implements Model{
	
	private String email;
	private String birthday;
	private ArrayList<Albums> albums = new ArrayList<Albums>();
	
	/**
	 * Costruttorre della classe User
	 * 
	 * @param name per contenere il nome dell'utente
	 * @param id per contenere l'id dell'utente
	 * @param email per contenere l'email dell'utente
	 * @param birthday per contenere la data di nascita dell'utente
	 * @param albums per contenere la lista di albums dell'utente
	 */
	
	public User(String name, String id, String email ,String birthday, ArrayList<Albums> albums) {
		
		super(name,id);
		this.email = email;
		this.albums = albums;
		this.birthday = birthday;
	}
	
    /**
     * Metodo che restituisce la lista di albums dell'utente
     * 
     * @return albums array che contiene la lista di albums
     */
	
	public ArrayList<Albums> getAlbums() 
	{
		return albums;
	}
	
	/**
     * Metodo che restituisce il nome dell'utente chiamando il metodo
     * della superclasse
     * 
     * @return una chiamata ad un metodo
     */
	
	public String getName() {
		return super.getName();
	}
	
	/**
     * Metodo che restituisce l'id dell'utente chiamando il metodo
     * della superclasse
     * 
     * @return una chiamata ad un metodo
     */

	public String getId() {
		return super.getId();
	}
	
	/**
     * Metodo che restituisce l'email dell'utente
     * 
     * @return email per contenere l'email dell'utente
     */

	public String getEmail() {
		return email;
	}
	
	/**
	 * Metodo toString 
	 * 
	 * @return l'id, il nome e l'email dell'utente
	 * 
	 */

	
	public String toString() 
	{
		return super.getId() + " " + super.getName() + " " + email  ;
	}
	
	/**
	 * Metodo toDate che converte la stringa birthday in un
	 * elemento Date
	 * 
	 * @return la data di nascita dell'utente
	 * 
	 */
	
	public Date toDate() 
	{
	  return TimeConversion.fromStringToStandardDate(birthday);
	}
	
	/**
    * Metodo che restituisce la data di nascita dell'utente
    * 
    * @return birthday per contenere la data di nascita dell'utente
    */
	
	public String getCreatedTime() 
	{
		return birthday;
	}
	
	

}