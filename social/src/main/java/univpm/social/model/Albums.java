package univpm.social.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import univpm.social.time.TimeConversion;

/**
 * Questa classe implementa i metodi e gli attributi
 * per gli albums
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 */       

public class Albums extends GeneralObject {
	
	private String createdTime;
	private ArrayList<Photo>photo = new ArrayList();

	//                                             ArrayList<Photo>photo
	
	/**
	 * Costruttore della classe Albums
	 * 
	 * @param name per contenere il nome dell'album
	 * @param createdTime per contenere la data di creazione dell'album
	 * @param albumId per contenere l'id dell'album
	 * @param photo array per contenere le foto dell'album
	 */
	
	public Albums(String name , String createdTime ,String albumId, ArrayList<Photo>photo) 
	{
	   super(name,albumId);
	   this.createdTime  = createdTime;
	   this.photo = photo;
	}
	
	/**
	 * Metodo che restituisce la data di creazione dell'album
	 * 
	 * @return createdTime che contiene la data di creazione dell'album
	 */
	
	public String getCreatedTime() 
	{
		return createdTime;
	}
	
	/**
     * Metodo che restituisce il nome dell'album chiamando il metodo
     * della superclasse
     * 
     * @return una chiamata ad un metodo
     */
	
	public String getName() 
	{
		return super.getName();
	}
	
	/**
     * Metodo che restituisce l'id dell'album chiamando il metodo
     * della superclasse
     * 
     * @return una chiamata ad un metodo
     */
	
	public String getAlbumId() 
	{
		return super.getId();
	}
	
	/**
	 * Metodo toDate che converte la stringa createdTime in un
	 * elemento Iso
	 * 
	 * @return la data di creazione dell'album
	 * 
	 */
	
	public Date toDate() 
	{
       return TimeConversion.toIso8601(createdTime);	
	}
	
	// Si potrebbe decidere dove inserire l'add photo 
	public void addPhoto(Photo p) 
	{
	   photo.add(p);	
	}
	
	/**
	 * Metodo toString 
	 * 
	 * @return il nome, la data della creazione e l'id dell'album
	 * 
	 */
	
	public String toString() 
	{
	  return this.getName() + " " + this.getCreatedTime() + " " + this.getId() ;
	}
	
	/**
     * Metodo che restituisce la lista delle foto di un album
     * 
     * @return photo array che contiene la lista di foto
     */
	
	public ArrayList<Photo> getPhotos()
	{
		return photo;
	}
	
	

}
