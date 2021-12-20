package univpm.social.filters;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;

import com.example.demo.model.Albums;
import com.example.demo.model.User;
import com.example.demo.utility.DecEnc;

import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;

import univpm.social.model.*;

public class FilterImpl implements Filter {

	
	
	public JSONObject filterForYears(String year) throws IOException, FileException, NoAlbumsException 
	{
		// PRIMA MI PRENDO IL MIO JSON OBJECT FACENDO UNA CHIAMATA AL API DI FB
		//  e lo inserisco nel oggetto utente 
		User user = DecEnc.decodeToUser();
		
		// Se rimane false automaticamente resituisce il jsonObject con l'errore
		boolean check = false;
		
		// Ora creo un utente dove risedono solo gli attributi che hanno passato il 
		// filtro
		User toGet;
		ArrayList<Albums> albums = new ArrayList() ;
		Albums singleAlbum;
		
        if(user.getAlbums().isEmpty()) throw new NoAlbumsException("NON E' PRESENTE ALCUN ALBUM");  
		int toCompare = Integer.valueOf(year);
		for(Albums album : user.getAlbums()) 
		{		   
			Date date = album.toDate();
		
			if(date.getYear() == (toCompare - 1900)) 
			  {
			   singleAlbum = new Albums(album.getName(),album.getCreatedTime(),album.getAlbumId(),null);
			   check  = true;
			   albums.add(singleAlbum);
			  }
		}

}
