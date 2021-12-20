package univpm.social.statistics;

import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;
import univpm.social.filters.FilterImpl;
import univpm.social.filters.FilterName;



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
	

}
