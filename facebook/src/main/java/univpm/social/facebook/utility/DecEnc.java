package univpm.social.facebook.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public final class DecEnc {
	
    public static JSONObject readJsonObject(String URL) 
    {
	       JSONObject dati = null;
          
	       try {
	           URLConnection openConnection = new URL(URL).openConnection();
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

	       return dati;

}
    
}
