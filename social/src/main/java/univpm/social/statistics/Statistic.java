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



public class Statistic {
	
	private FilterImpl filter ;

	
	public  JSONObject getStatistics(String year , String month , String day) throws ParseException, BadParameterException, IOException, FileException, NoAlbumsException 
	{
	    
		filter = new FilterImpl();
		
	    JSONObject objFiltered = filter.filter(year , month ,  day);
	    

	    if(objFiltered.get("ERROR") != null) return objFiltered;
		
	    JSONArray arrayFiltered = (JSONArray) objFiltered.get("albums");
	
	    String toPut = Integer.toString(arrayFiltered.size()) + "Album catturato/i dal filtro";
	    objFiltered.put("statistica per il filtro corrente", toPut);
			
	     return objFiltered;
	}
	
	
	public  JSONObject getNameStatistic(String name) throws IOException, FileException 
	{
		
		filter = new FilterName();
		
		JSONObject jsonFiltered = ((FilterName) filter).filterForName(name);
		
		if(jsonFiltered.get("ERROR") != null) return jsonFiltered;
		
	    JSONArray arrayFiltered = (JSONArray) jsonFiltered.get("albums");
		
	    String toPut = Integer.toString(arrayFiltered.size()) + "Album catturato/i dal filtro name: " + name;
	    jsonFiltered.put("statistica per il filtro corrente", toPut);
			
	     return jsonFiltered;
	}
	
	
	
	// Nome/path file dove sono contenute le parole da confrontare ! 
	public  JSONObject getVolgarNameStatistic(String fileName) throws IOException, FileException 
	{
		filter = new FilterName();
		
		JSONObject jsonFiltered = ((FilterName) filter).checkBadName(fileName);
		
		if(jsonFiltered.get("ERROR") != null) return jsonFiltered;
		
	    JSONArray arrayFiltered = (JSONArray) jsonFiltered.get("albums");
		
	    String toPut = Integer.toString(arrayFiltered.size()) + "Album con nome/i volgare/i catturato/i dal filtro";
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
