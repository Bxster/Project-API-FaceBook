package univpm.social.filters;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;



import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;
import univpm.social.model.Albums;
import univpm.social.model.User;
import univpm.social.utility.DecEnc;
import univpm.social.utility.FileExtern;

/**
 * Questa classe implementa il filtro per il nome
 * degli albums dell'utente
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */


public class FilterName extends FilterImpl{
	
	
	
	/**
	 * Questo metodo filtra, tramite il nome inserito, gli albums di un
	 * utente
	 * 
	 * @param name per contenere il nome dell'albums da filtrare
	 * @return un metodo che è una chiamata ad un altro metodo ereditato da FilterImpl, che consente di ritornare il jsonobject filtrato/il jsonobject con il messaggio di avvertimento
	 * @throws IOException se non viene passato nessun parametro
	 * @throws FileException se viene inserito il parametro ma senza nulla dentro
	 * @throws NoAlbumsException se non ci sono albums presenti
	 */
	
	public JSONObject filterForName(String name) throws IOException, FileException, NoAlbumsException 
	{
		User user = DecEnc.decodeToUser();
		if(user.getAlbums().isEmpty()) throw new NoAlbumsException("NON E' PRESENTE ALCUN ALBUM");
		boolean check = false;
		
	   ArrayList<Albums> albums = new ArrayList();
	   Albums singleAlbum;
	   
	   for(Albums a : user.getAlbums()) 
	   {

		   if(a.getName().equals(name)) 
		     {
			   albums.add(a);
			   check = true;
		     }
	   }
	   
	   return this.getJsonObject(check, user, albums, "NESSUN ALBUM TROVATO CON IL NOME " + name);
	}
	
	
	
	
	
	/*
	     Questo metodo ritorna un Jsonobject che corrispende al o agli albums
	     trovati che corrispondono con i nomi degli albums presenti nel file 
	     VOLGAR_NAME.txt il quale viene passato come parametro alla funzione.
	     Se nessuno degli albums metcha con i nomi presenti nel file .txt , verrà 
	     ritornato un JsonObject contente un messaggio di anomalia. Il tutto 
	     viene fatto richiamando il metodo getJsonObject(...) della super-classe
	     FilterImpl
	
	*/
	
	/**
	 * Questo metodo serve per fare il check per la quarta rotta, cioè
	 * capire se c'èe qualche albums con un nome vietato; se non vengon trovati albums con
	 * quel nome, verrà mostrato un errore
	 * 
	 * @param fileName nome del file da leggere
	 * @return Jsonobject che corrispende al o agli albums trovati che corrispondono con i nomi degli albums presenti nel file VOLGAR_NAME.txt
	 * @throws IOException se non viene passato nessun parametro
	 * @throws FileException se viene inserito il parametro ma senza nulla dentro
	 * @throws NoAlbumsException se non ci sono albums presenti
	 */
	
	public JSONObject checkBadName(String fileName) throws IOException, FileException, NoAlbumsException 
	{
		ArrayList<String> volgarNameList = FileExtern.readFromFile(fileName, false);
		User user = DecEnc.decodeToUser();
		if(user.getAlbums().isEmpty()) throw new NoAlbumsException("NON E' PRESENTE ALCUN ALBUM");  
	    ArrayList<Albums> albums = user.getAlbums();
	    
	    boolean check = false;
	    ArrayList<Albums> albumsFiltered = new ArrayList();
		for(Albums a : albums) 
		{
           for(String s : volgarNameList) 
              {
        	   
        	     if(a.getName().equals(s)) 
        	       {
        	    	  albumsFiltered.add(a);
        	    	  check = true;
        	       }
              }
		}
		
		
		return this.getJsonObject(check, user, albumsFiltered, 
			   "NESSUN ALBUM PRESENTA NOMI VOLGARI E/O MOLESTI !");
		
	}

    

}
