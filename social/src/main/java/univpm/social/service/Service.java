package univpm.social.service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import univpm.social.exceptions.FileException;

/**
 * Questa interfaccia dichiara i metodi da usare per
 * implementare i service
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public interface Service {
	
	/**
	 * Questo metodo , dopo aver letto dal file l'id e l'access token,
   	 * prepara l'url per chiamare l'API di Facebook 
	 */
	public JSONObject getGeneralInformation() throws IOException, FileException;
	/**
	 * Questo metodo legge il parametro richiesto dall'utente e 
	 * tramite l'url richiama l'API di Facebook per ottenere
	 * quella specifica informazione dell'utente
	 */
	public JSONObject getWhatYouWant(String param) throws IOException, FileException; 
   // public JSONObject filterForYears(String years);
	
}