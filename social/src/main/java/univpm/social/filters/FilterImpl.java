package univpm.social.filters;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;

import com.example.demo.model.Albums;
import com.example.demo.model.User;

import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;

import univpm.social.model.*;
import univpm.social.utility.DecEnc;

public class FilterImpl implements Filter {

	
	// TODO LUCA : MIGLIORARE QUESTO ASPETTO 
	protected JSONObject getJsonObject(boolean check , User user, ArrayList<Albums> albums, String error) 
	{
		User toGet;
		
		if(check) 
		{
			toGet = new User(user.getName(),user.getId(),user.getEmail(),user.getCreatedTime(),albums);
		    
//        Ora ricodifico l'oggetto user in JSONobject e lo ritorno al controllore
		   
			JSONObject ret = DecEnc.encodeToJson(toGet);

			return ret;
		}
	  	
		
	   else {
		
		     JSONObject jsonobject = new JSONObject();
		     jsonobject.put("ERROR", error);
		
		     return jsonobject;
		     
	        }
	}
	
	
	
	
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
				
     return  this.getJsonObject(check, user, albums, 
                        "NESSUN ALBUM PRESENTE NEL ANNO RICHIESTO");			
	}
	
	
	
	// yyyy-mm
	public JSONObject filterForMonth(String year , String month) throws ParseException, IOException, FileException, NoAlbumsException 
	  {
	//  Mi prendo il mio JSONObject
		User user = DecEnc.decodeToUser();
		
	
		
    //  Mi serviranno per il rilascio del JSONObject
		ArrayList<Albums>albums = new ArrayList();
		Albums singleAlbum;
		boolean check = false;
		User toGet;
		        
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date date = dateFormat.parse(year + "-" + month );
        System.out.println(date);
		
        if(user.getAlbums().isEmpty()) throw new NoAlbumsException("NON E' PRESENTE ALCUN ALBUM");
		for(Albums album : user.getAlbums()) 
		{
			
			if( date.getYear()==album.toDate().getYear() &&
			    date.getMonth()==album.toDate().getMonth()) 
			  {
				   singleAlbum = new Albums(album.getName(),album.getCreatedTime(),album.getAlbumId(),null);
				   check  = true;
				   albums.add(singleAlbum);
			   }
		 }
						
	       return  this.getJsonObject(check, user, albums, 
                         "NESSUN ALBUM PRESENTE NEL ANNO E MESE RICHIESTO");			
		}
	
	
	 
	
}
