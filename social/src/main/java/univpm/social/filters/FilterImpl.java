package univpm.social.filters;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;

import univpm.social.errorscheck.ErrorsCheck;
import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;

import univpm.social.model.*;
import univpm.social.time.TimeConversion;
import univpm.social.utility.DecEnc;


/**
 * Questa classe implementa i metodi dell'interfaccia Filter
 * per fare le statistiche sugli album negli anni, mesi e giorni
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public class FilterImpl implements Filter {

    /**
	 * Questo metodo serve per prende ilJSONObejct contente le informazioni
	 * 
	 * @param check variabile booleana per poi fare il controllo nell'if
	 * @param user che contiene l'utente
	 * @param albums array che contiene gli albums
	 * @param error stringa di errore
	 * @return se true il JSONObecjt a schermo, se false l'errore
     */
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
	
	
	/**
	 * Questo metodo implementa il filtro per l'anno
	 * 
	 * @param year serve per contenere l'anno inserito
	 * @throws IOException se non viene passato nessun parametro
     * @throws FileException se viene inserito il parametro ma senza nulla dentro
	 * @throws NoAlbumsException se non ci sono albums presenti
	 */
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
	
	
	/**
	 * Questo metodo implementa il filtro per l'anno e il mese
	 * 
	 * @param year serve per contenere l'anno inserito
	 * @param month serve per contenere il mese inserito
	 * @throws ParseException 
	 * @throws IOException se non viene passato nessun parametro
     * @throws FileException se viene inserito il parametro ma senza nulla dentro
	 * @throws NoAlbumsException se non ci sono albums presenti 
	 */
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
	
	/**
	 * Questo metodo implementa il filtro per l'anno, il mese
	 * e il giorno
	 * 
	 * @param year serve per contenere l'anno inserito
	 * @param month serve per contenere il mese inserito
	 * @param day serve per contenere il giorno inserito
	 * @throws ParseException 
	 * @throws IOException se non viene passato nessun parametro
     * @throws FileException se viene inserito il parametro ma senza nulla dentro
	 * @throws NoAlbumsException se non ci sono albums presenti 
	 */
	public JSONObject filterForDay(String year , String month , String day) throws ParseException, IOException, FileException, NoAlbumsException 
	{
		
		// Do per scontato che l'utente mi ha fornito corretamente anno , mese e giorno
		// Si potrebbe pensare di implementare classi che gestiscanno questa tipologia di 
		// errori
		
		User user = DecEnc.decodeToUser();
		User toGet;
		
		ArrayList<Albums> albums = new ArrayList();
		Albums singleAlbum;
		boolean check = false;
	  
		Date date = TimeConversion.fromStringToStandardDate(month+"-"+day+"-"+year);
		LocalDate localDateToCompare = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if(user.getAlbums().isEmpty()) throw new NoAlbumsException("NON E' PRESENTE ALCUN ALBUM");
		for(Albums album : user.getAlbums()) 
		   {
			
			 LocalDate localDate = album.toDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


			if(localDate.getYear()==localDateToCompare.getYear() &&
			   localDate.getMonthValue()==localDateToCompare.getMonthValue()&&
			   localDate.getDayOfMonth()==localDateToCompare.getDayOfMonth()) 
			    {
				 
				   singleAlbum = new Albums(album.getName(),album.getCreatedTime(),album.getAlbumId(),null);
				   check  = true;
				   albums.add(singleAlbum);
			    }
		   }
		
		
       return this.getJsonObject(check, user, albums, 
         "NESSUN ALBUM PRESENTE NEL ANNO E MESE E GIORNO RICHIESTO");
		     		
	}
	
	/**
	 * Questo metodo gestisce i vari filtri e tramite degli
	 * if a cascata fa controlli
	 * 
	 * @param year serve per contenere l'anno inserito
	 * @param month serve contenere il mese inserito
	 * @param day serve per contenere il giorno inserito
	 * @throws ParseException 
	 * @throws BadParameterException nel caso in cui i valori siano inaccettabili
	 * @throws IOException se non viene passato nessun parametro
     * @throws FileException se viene inserito il parametro ma senza nulla dentro
	 * @throws NoAlbumsException se non ci sono albums presenti 
	 */
	public JSONObject filter(String year , String month , String day) throws ParseException, BadParameterException, IOException, FileException, NoAlbumsException 
	{
		ErrorsCheck errorsCheck = new ErrorsCheck();
	    // Controllo se tutti i paremtri sono ok
		if(errorsCheck.errorsCheck(day, month, year))   
	  
			// !year.equals("0")
		// filtro per anno , anno-mese , anno-mese-giorno
		if(!month.equals("0") && !day.equals("0"))
			return this.filterForDay(year, month, day);
		else if(!month.equals("0") && day.equals("0"))
			 return this.filterForMonth(year, month);
		else if(month.equals("0") && day.equals("0"))
		    return this.filterForYears(year);
		
		// TODO LUCA : NON CREDO CHE ENTRERA' PERO' DOVEVO METTERE PER FORZA 
		//             QUALCOSA , MODIFICARE !
    	throw new BadParameterException("GENERAL ERROR ! QUALCOSA E' ANDATO STORTO CON I FILTRI");
		 
				
	}
	
	
	
	
	 
	
}
