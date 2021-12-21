package univpm.social.filter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;
import univpm.social.filters.FilterImpl;

class testFilterTime {

	/*
	     Mi preparo un jsonobject manualmente, ponendo i segunti dati
	     anno = 2021 , mese = 12 , giorno =09. Quello che andrò a fare
	     sarà filtrare manualmente gli albums e creare un jsonobject, se 
	     poi il jsonobject da me creato è uguale a quello restituito dal
	     filtro allorà il test avrà esito positivo
	 */
	


	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFilterMonthDayYear() throws IOException, ParseException, java.text.ParseException, BadParameterException, FileException, NoAlbumsException {
		
		FilterImpl filter = new FilterImpl();
		
		
		FileReader fileReader = new FileReader("src\\test\\java\\univpm\\social\\filter\\filter.json");
	    BufferedReader buffReader = new BufferedReader(fileReader);
	    
	    Object obj = new JSONParser().parse(buffReader);
	    JSONObject jsonobject = (JSONObject) obj;
		
		Assertions.assertEquals(jsonobject,filter.filter("2021", "12", "09"));
		
	}
	
	/*
	     Adesso, siccome il profilo è nuovo, non ci sono albums prima di dicembre
	     quindi ora prova filtrare per anno e mese sapendo gia che mi dovrebbe
	     restituire un jsonobject con un messaggio di anomalia del tipo:
	     "ERROR": NESSUN ALBUM PRESENTE NEL ANNO E MESE RICHIESTO
	 */
	
	@Test
	void filterForYearMonth() throws IOException, ParseException, java.text.ParseException, FileException, NoAlbumsException 
	{
		FilterImpl filter = new FilterImpl();
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("ERROR", "NESSUN ALBUM PRESENTE NEL ANNO E MESE RICHIESTO");
		
		Assertions.assertEquals(jsonobject,filter.filterForMonth("2012", "10"));
		
	}

}
