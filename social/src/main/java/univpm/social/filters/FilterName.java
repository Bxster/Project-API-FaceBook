package univpm.social.filters;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;


import univpm.social.exceptions.FileException;
import univpm.social.model.Albums;
import univpm.social.model.User;
import univpm.social.utility.DecEnc;



public class FilterName extends FilterImpl{
	
	
	/*
    Gli passo un parametro, un nome e lui controlla se è presente
    qualche album con quel nome , se non è presente non lancia un eccezione 
    ma bensì ritorna un jsobject con un messaggio di avvertimento,
    il ritorno di questo metodo è una chiamata ad un altro metodo(protected) eridato
    da FilterImpl , esso consente di ritornare il jsonobject filtrato oppure il jsonobject
    con il messaggio di avvertimento
    */
	
	
	
	public JSONObject filterForName(String name) throws IOException, FileException 
	{
		User user = DecEnc.decodeToUser();
		
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
    

}
