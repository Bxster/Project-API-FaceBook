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



public class FilterName extends FilterImpl{
	
	
	/*
    Gli passo un parametro, un nome e lui controlla se è presente
    qualche album con quel nome , se non è presente non lancia un eccezione 
    ma bensì ritorna un jsobject con un messaggio di avvertimento,
    il ritorno di questo metodo è una chiamata ad un altro metodo(protected) eridato
    da FilterImpl , esso consente di ritornare il jsonobject filtrato oppure il jsonobject
    con il messaggio di avvertimento
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
