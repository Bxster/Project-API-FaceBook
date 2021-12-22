package univpm.social.statistics;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;
import univpm.social.filters.FilterImpl;
import univpm.social.filters.FilterName;
import univpm.social.time.TimeConversion;

/**
 * Questa classe permette di fare le dovute statistiche
 * sugli albums dell'utente in base alla rotta che viene
 * scelta, quindi in base al tempo, al nome o per i nomi volgari
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public class Statistic {
	
	private FilterImpl filter ;

	/**
	 * Questo metodo fa le statistiche sugli albums
	 * dell'utente in base al tempo indicato nella chiamata
	 * 
	 * @param year per contenere l'anno inserito
	 * @param month per contenere il mese inserito
	 * @param day per contenere il giorno inserito
	 * @return l'oggetto filtrato in base al tempo
	 * @throws ParseException
	 * @throws BadParameterException se il valore inserito nel parametro è inaccettabile
	 * @throws IOException se non viene passato nessun parametro
	 * @throws FileException se viene inserito il parametro senza nessun valore
	 * @throws NoAlbumsException se non ci sono albums presenti
	 */
	
	public  JSONObject getStatistics(String year , String month , String day) throws ParseException, BadParameterException, IOException, FileException, NoAlbumsException 
	{
	    
		filter = new FilterImpl();
		
	    JSONObject objFiltered = filter.filter(year , month ,  day);
	    

	    if(objFiltered.get("ERROR") != null) return objFiltered;
		
	    JSONArray arrayFiltered = (JSONArray) objFiltered.get("albums");
	
	    String toPut = Integer.toString(arrayFiltered.size()) + " Album catturato/i dal filtro";
	    objFiltered.put("statistica per il filtro corrente", toPut);
			
	     return objFiltered;
	}
	
	/**
	 * Questo metodo fa le statistiche sugli albums
	 * dell'utente in base al nome indicato nella chiamata
	 * 
	 * @param name per contenere il nome dell'album
	 * @return l'oggetto filtrato in base al nome
	 * @throws IOException se non viene passato nessun parametro
	 * @throws FileException se viene inserito il parametro senza nessun valore
	 * @throws NoAlbumsException se non ci sono albums presenti
	 */
	
	public  JSONObject getNameStatistic(String name) throws IOException, FileException, NoAlbumsException 
	{
		
		filter = new FilterName();
		
		JSONObject jsonFiltered = ((FilterName) filter).filterForName(name);
		
		if(jsonFiltered.get("ERROR") != null) return jsonFiltered;
		
	    JSONArray arrayFiltered = (JSONArray) jsonFiltered.get("albums");
		
	    String toPut = Integer.toString(arrayFiltered.size()) + " Album catturato/i dal filtro name: " + name;
	    jsonFiltered.put("statistica per il filtro corrente", toPut);
			
	     return jsonFiltered;
	}
	
	
	
	// Nome/path file dove sono contenute le parole da confrontare ! 
	
	/**
	 * Questo metodo fa le statistiche sugli albums
	 * dell'utente in base ai nomi vietati per gli albums 
	 * indicati nel file di testo VOLGAR_NAME.txt; inoltre vengono
	 * segnalati a schermo dei link
	 * 
	 * @param fileName per contenere il nome del file da leggere
	 * @return l'oggetto filtrato in base ai nomi vietati
	 * @throws IOException
	 * @throws FileException
	 * @throws NoAlbumsException se non ci sono albums presenti
	 */
	
	public  JSONObject getVolgarNameStatistic(String fileName) throws IOException, FileException, NoAlbumsException 
	{
		filter = new FilterName();
		
		JSONObject jsonFiltered = ((FilterName) filter).checkBadName(fileName);
		
		if(jsonFiltered.get("ERROR") != null) return jsonFiltered;
		
	    JSONArray arrayFiltered = (JSONArray) jsonFiltered.get("albums");
		
	    String toPut = Integer.toString(arrayFiltered.size()) + " Album con nome/i volgare/i catturato/i dal filtro";
	    jsonFiltered.put("statistica per il filtro corrente", toPut);
		jsonFiltered.put("INOLTRO SEGNALAZIONE ", "https://www.commissariatodips.it/segnalazioni/segnala-online/index.html");	
	    
		
		/*
		    Aggiunto semplice algoritmo per vedere se l'utente è minorenne oppure no
		    se è minorenne aggiunge in output nel jsonobject di ritorno un messaggio
		    extra 
		 */
		
		String dateString = jsonFiltered.get("birthday").toString();
		String[] userBirt = dateString.split("/");
		//Date date = TimeConversion.fromStringToStandardDate(dateString);

		LocalDate now = LocalDate.now();
		
        if((now.getYear() - Integer.parseInt(userBirt[2])) < 18)
        	jsonFiltered.put("ATTENZIONE UTENTE MINORENNE", "https://www.comune.ancona.gov.it/ankonline/servizi-sociali-orari-e-contatti-telefonici/");
        else if((now.getYear() - Integer.parseInt(userBirt[2])) == 18 &&
        		now.getMonthValue() == Integer.parseInt(userBirt[1]) &&
        		now.getDayOfMonth() == Integer.parseInt(userBirt[0]))
           jsonFiltered.put("ATTENZIONE UTENTE MINORENNE", "https://www.comune.ancona.gov.it/ankonline/servizi-sociali-orari-e-contatti-telefonici/");
           
		return jsonFiltered;
	}
	

}
