package univpm.social.filters;

import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;

import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;

/**
 * Questa interfaccia permette di controllare i vari filtri per
 * anno, mese e giorno per fare le statistiche
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public interface Filter {
   
	
	/**
	 * Questo metodo implementa il filtro per l'anno
	 */
	public JSONObject filterForYears(String year) throws IOException, FileException, NoAlbumsException;
	/**
	 * Questo metodo implementa il filtro per l'anno e il mese
	 */
	public JSONObject filterForMonth(String year , String month) throws ParseException, IOException, FileException, NoAlbumsException;
	/**
	 * Questo metodo implementa il filtro per l'anno, il mese
	 * e il giorno
	 */
	public JSONObject filterForDay(String year , String Month ,String day) throws ParseException, IOException, FileException, NoAlbumsException;
	/**
	 * Questo metodo gestisce i vari filtri e tramite degli
	 * if a cascata fa controlli
	 */
	public JSONObject filter(String year , String Month ,String day) throws ParseException, BadParameterException, IOException, FileException, NoAlbumsException;

}