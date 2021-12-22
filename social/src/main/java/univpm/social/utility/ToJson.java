package univpm.social.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Questa classe trasforma i vari dati e stringe in file JSON
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public final class ToJson {
	
	
	/**
	 * Questo metodo codifica l'url per connettersi all'API e lo
	 * trasforma in un JSONObject
	 * 
	 * @param url per contenere l'url della chiamata
	 * @return dati 
	 */
	
	public static JSONObject getJson(String url) 
	{
	       JSONObject dati = null;
	          
	       try {
	           URLConnection openConnection = new URL(url).openConnection();
	           InputStream in = openConnection.getInputStream();

	           String data = "";
	           String line = "";
	           try {
	               InputStreamReader inR = new InputStreamReader( in );
	               BufferedReader buf = new BufferedReader( inR );

	               while (( line = buf.readLine() ) != null ) {
	                  data+= line;
	               }
	           } finally {
	               in.close();
	           }
	         
	           dati = (JSONObject) JSONValue.parseWithException(data);  //parse JSON Object


	       } catch (IOException e ) {
	           e.printStackTrace();
	       } catch (Exception e) {
	           e.printStackTrace();
	       } 
	       
	       // PROVE
	       
	       //User u = DecEnc.decodeToUser();
	       //System.out.println(u.toString());
        
	       // FINE PROVE
	       return dati;
	}

}
