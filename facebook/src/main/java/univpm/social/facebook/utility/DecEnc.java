package univpm.social.facebook.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import univpm.social.facebook.service.ServiceImpl;

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
    
    
// Mi copio in un arrayList tutti gli id degli album da richiamare succesivamente
// accedere internamente alle loro foto
   public static ArrayList<String> getAlbumId()
   {
	   ServiceImpl service = new ServiceImpl();
	   String URL = "https://graph.facebook.com/v12.0/"+service.getUserId()+"?fields=id%2Cname%2Cbirthday%2Cemail%2Cfriends%2Calbums&access_token="+service.getUserToken();
	   JSONObject jsonobject = DecEnc.readJsonObject(URL);
	   
//    Ora ho ottenuto l'oggetto albums 
	  JSONObject albums = (JSONObject) jsonobject.get("albums");
	  
//    Ora acceddo al array data degli albums e ne copio tutti gli id
	  JSONArray data = (JSONArray) albums.get("data");
	  
	  ArrayList<String> albumsId = new ArrayList();
	  
      for(int i=0 ; i<data.size() ; i++) 
      {
    	  JSONObject temp = (JSONObject) data.get(i);
    	  String id = (String) temp.get("id");
    	  albumsId.add(id);
      }
      
      return albumsId;
   }
   
   
   
// Questo metodo accede al singolo album e ne prende informazioni quali l'id della foto
// che servirà in seguito per comporre l'oggetto foto. Prende in input l'id del album
   public static ArrayList<String> getPhotosId(String albumId) 
   {
//     Prima faccio una chiamata al api per stremmarmi il json delle foto con nome
//     data di creazione e id , dopo senza entrare nella foto prendo l'id e lo 
//     inserisco in un arrayList String che restituisco al utente
	   
	   ServiceImpl service = new ServiceImpl();
	   String URL = "https://graph.facebook.com/v12.0/"+ albumId +"?fields=photos&access_token="+service.getUserToken();
	   JSONObject jsonobject = DecEnc.readJsonObject(URL);
	   
//     Ora eseguo in maniera analoga i passaggi precedenti facendo attenzione al 
//     parsing del jsonObject per andare a prendere gli id , le keys sono diverse !
	   
	   JSONObject photos = (JSONObject) jsonobject.get("photos");
	   JSONArray data = (JSONArray) photos.get("data");
	   
	   ArrayList<String> photosId = new ArrayList();
	   
	   for(int i=0 ; i<data.size() ; i++) 
	   {
		   JSONObject temp = (JSONObject) data.get(i);
	       String photoId = (String) temp.get("id");
	       photosId.add(photoId);
		   
	   }
	   
	   return photosId;
   }
   
   
   
   
    
}
