package univpm.social.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import univpm.social.time.TimeConversion;


/**
 * Questa classe implementa i metodi e gli attributi
 * per le foto
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 */

public class Photo  extends GeneralObject implements Model {

	 private String createdTime;
     
	 
	 /**
	  * Costruttore della classe Photo
	  * 
	  * @param name per contenere il nome della foto
	  * @param createdTime per contenere la data di aggiunta della foto
	  * @param id per contenere l'id della foto
	  */
	 
	 public Photo(String name, String createdTime, String id) {       
		 
		 super(name,id);
		 this.createdTime = createdTime;
	}

	 /**
	  * Metodo che restituisce il nome della foto chiamando il metodo
      * della superclasse
      * 
	  * @return una chiamata ad un metodo
	  */

	public String getName() {
		return super.getName();
	}

	/**
     * Metodo che restituisce la data di aggiunta della foto
     * 
     * @return createdTime che contiene la data di aggiunta della foto
     */
	
	public String getCreatedTime() {
		return createdTime;
	}

	/**
     * Metodo che restituisce l'id della foto chiamando il metodo
     * della superclasse
     * 
     * @return una chiamata ad un metodo
     */
	
	 public String getId() 
	 {
		 return super.getId();
	 }
	
	 /**
	  * Metodo toDate che converte la stringa createdTime in un
  	  * elemento Iso
	  * 
	  * @return la data di aggiunta della foto
	  * 
	  */
 
	public Date toDate() 
	{
       return TimeConversion.toIso8601(createdTime);
	}
	
	/**
	 * Metodo toString 
	 * 
	 * @return il nome, l'id e la data di aggiunta della foto
	 * 
	 */
	
	public String toString() 
	{
		return "NOME FOTO: "+ this.getName() + " ID: " + this.getId() + " DATA DI PUBBLICAZIONE: " +createdTime;
	}
	 
	 
	 
	 
	 
	 
	 

}
