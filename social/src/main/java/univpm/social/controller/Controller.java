package univpm.social.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.filters.FilterImpl;
import univpm.social.service.ServiceImpl;
import univpm.social.statistics.Statistic;
import univpm.social.utility.FileExtern;



public class Controller {
	

	private ServiceImpl service = new ServiceImpl() ;
	private FilterImpl filter = new FilterImpl();
	private Statistic statistic = new Statistic();
	private String msg = "ERRORE ! VALORE PARAMETRO/I MANCANTE/I";
    private String msg400 = "ERRORE ! VALUE IMMESSO NON CORRETTO O MANCANTE";
   
        
	@GetMapping(value = "/userInfo")
	public ResponseEntity<Object> getInfo(@RequestParam(value="param" , required=false)String param) throws IOException, FileException, BadParameterException{
		
		
		if(param == null)
			return ResponseEntity.status(400).body(msg400 + " : Prestare attenzione");
		
		
		ArrayList<String> list = FileExtern.readFromFile("GOOD_REQUEST.txt", false);
		
		if(param.isEmpty())
			return ResponseEntity.status(409).body(msg);
		
		for(String word : list) 
		   {
			 if(param.equals(word))
				 return new ResponseEntity<>(service.getWhatYouWant(param) , HttpStatus.OK);
		   }
		
		throw new BadParameterException("ATTENZIONE VALUE IMMESSO NON VALIDO !");
	}
	

}
