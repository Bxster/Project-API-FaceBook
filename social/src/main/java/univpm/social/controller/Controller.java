package univpm.social.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;
import univpm.social.filters.FilterImpl;
import univpm.social.service.ServiceImpl;
import univpm.social.statistics.Statistic;
import univpm.social.utility.FileExtern;

/*
    esempio differenza tra param e value
    param -> year
    value -> 2021
 */

/**
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 * 
 * Questa classe gestisce tutte le varie rotte disponibili
 * 
 */


@RestController
public class Controller {
	

	private ServiceImpl service = new ServiceImpl() ;
	private FilterImpl filter = new FilterImpl();
	private Statistic statistic = new Statistic();
	private String msg = "ERRORE ! VALORE PARAMETRO/I MANCANTE/I";
    private String msgNew = "ERRORE ! VALUE IMMESSO NON CORRETTO O MANCANTE";
   
    
    /*
        
        1) Se il parametro è sbagliato o manca, verrà lanciato il messaggio di errore 
           400 , vedere msg400
        2) Se il parametro è presente ed è corretto, ma manca la key, quindi la value
           del parametro, allora il programma lancerà il messaggio di errore msg error
           409
        3) Se se il parametro è corretto ed è presente un valore che è diverso però
           da quelli presenti nella lista, verra lanciata un eccezione del tipo
           BadParameterException -> ATTENZIONE VALUE IMMESSO NON VALIDO !
        
     */
        
    /**
     * 
     * Questa rotta di tipo GET consente di avere generiche info quali: nome,id,email con
     * la possibilità di scegliere un parametro extra da visualizzare(es. age_range)
     * 
     * @param param tramite questo parametro si può inserire un parametro a scelta
     * @return un JSONObject con le varie informazioni dell'utente
     * @throws IOException se non viene passato nessun parametro
     * @throws FileException se viene inserito il parametro ma senza nulla dentro
     * @throws BadParameterException se ciò che viene inserito nel parametro non è accettabile
     */
    
	@GetMapping(value = "/userInfo")
	public ResponseEntity<Object> getInfo(@RequestParam(value="param" , required=false)String param) throws IOException, FileException, BadParameterException{
		
		
		if(param == null)
			return ResponseEntity.status(400).body(msgNew + " : Prestare attenzione");
		
		
		ArrayList<String> list = FileExtern.readFromFile("GOOD_REQUEST.txt", false);
		
		if(param.isEmpty())
			return ResponseEntity.status(400).body(msg);
		
		for(String word : list) 
		   {
			 if(param.equals(word))
				 return new ResponseEntity<>(service.getWhatYouWant(param) , HttpStatus.OK);
		   }
		
		throw new BadParameterException("ATTENZIONE VALORE PARAMETRO IMMESSO NON VALIDO ! CONTROLLARE LISTA VALORI PARAMETRI: GOOD_REQUEST.txt");
	}
	
	
	
	/*
	     Questa rotta consente di filtrare per anno , anno-mese , anno-mese-giorno
	     gli albums di un utente di Facebook. Ora vediamo le eccezioni/errori
	     che si potrebbero generare:
	     
	     1) Se il parametro(anno o mese o giorno) è sbagliato o manca, verrà 
	        lanciato il messaggio di errore  400 , vedere msg400
	        
	     2) 
 	 */
	
	/**
	 * Questa rotta di tipo GET consente di filtrare per anno , anno-mese , 
	 * anno-mese-giorno gli albums di un utente di Facebook 
	 * 
	 * @param year per inserire l'anno su cui fare statistiche
	 * @param month per inserire il mese su cuiu fare statistiche
	 * @param day per inserire il giorno su cui fare statistiche
	 * @return un JSONObject con le info primarie dell'utente e quelle degli album trovati nel lasso di tempo inserito
	 * @throws ParseException
	 * @throws BadParameterException
	 * @throws IOException
	 * @throws FileException
	 * @throws MissingServletRequestParameterException
	 * @throws NoAlbumsException
	 */

	
	@GetMapping("/filter")
	public ResponseEntity<Object> filter(@RequestParam(value="year",required=false) String year,
			@RequestParam(value="month" , defaultValue="0" , required=false) String month , @RequestParam(value="day", defaultValue="0", required=false) String day) throws ParseException, BadParameterException, IOException, FileException, MissingServletRequestParameterException, NoAlbumsException{
          

		  if(year==null || day==null || month==null)
			  return ResponseEntity.status(400).body(msgNew + " : Prestare attenzione");

		  if((year.isEmpty())) 
			return ResponseEntity.status(400).body(msg);
		
		  return new ResponseEntity<>(statistic.getStatistics(year ,month , day),HttpStatus.OK);
	}
	
	/**
	 * Questa rotta di tipo GET consente di filtrare in base al loro 
	 * nome gli albums di un utente di Facebook
	 * 
	 * @param name per inserire il nome dell'album da cercare
	 * @return un JSONObject con le informazioni primarie dell'utente e quelle degli album trovati con il nome inserito
	 * @throws IOException se non viene passato nessun parametro
	 * @throws FileException se viene inserito il parametro senza nessun valore
	 * @throws BadParameterException se il valore inserito nel parametro è inaccettabile
	 * @throws NoAlbumsException se non ci sono albums presenti
	 */
	
	
	@GetMapping("/filter/name")
	public ResponseEntity<Object> filterName(@RequestParam(value="name", required=false) String name) throws IOException, FileException, BadParameterException, NoAlbumsException{
		//throw new BadParameterException("ATTENZIONE , DEVI PASSARMI UN NOME DA FILTRARE");
		
		if(name == null)
			return ResponseEntity.status(400).body(msgNew);
		
		if(name.isEmpty())   return ResponseEntity.status(400).body(msg);
		
		  return new ResponseEntity<>(statistic.getNameStatistic(name), HttpStatus.OK);
	}
	
	
	/**
	 * Questa rotta di tipo GET consente di filtrare , in base a dei nomi
	 * non accettabili scritti nel file VOLGAR_NAME.txt gli albums
	 * di un utente di Facebook
	 * 
	 * @return un JSONObject con le informazioni primarie dell'utente e quelle degli album trovati che si chiamano con un nome non accettabile
	 * @throws IOException
	 * @throws FileException
	 * @throws BadParameterException
	 * @throws NoAlbumsException se non ci sono albmus presenti
	 */
	
	@GetMapping("/filter/volgar-word")
	public ResponseEntity<Object> filterVolgarName() throws IOException, FileException, BadParameterException, NoAlbumsException{
				  return new ResponseEntity<>(statistic.getVolgarNameStatistic("VOLGAR_NAME.txt"), HttpStatus.OK);	
        }
	
	

}
