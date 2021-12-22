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
	
	public JSONObject getGeneralInformation() throws IOException, FileException;
	public JSONObject getWhatYouWant(String param) throws IOException, FileException; 
   // public JSONObject filterForYears(String years);
	
}