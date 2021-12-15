package univpm.social.facebook.service;

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

import univpm.social.facebook.utility.DecEnc;

public class ServiceImpl implements Service {

// TODO luca : implementare una funzione per leggere da file queste due string
 	 private String userToken = "";
 	 private String userId = "";
	 
 	 
 	 
 	 
 	 
 	// id,name,birthday,email,friends,albums + parametro a scelta 
     public JSONObject getGeneralInformation(String param) 
     {
    	 String URL ="https://graph.facebook.com/v12.0/"+userId+"?fields=id%2Cname%2Cbirthday%2Cemail%2Cfriends%2Calbums"+"%2C"+ param +"&access_token="+userToken;
    	 
    	 return DecEnc.readJsonObject(URL);
     }
     
     
     
     
     
     
     // Stampa le foto di ogni album 
     public JSONArray getAlbumInformation() 
     {
    	 ArrayList<String> albumsId = DecEnc.getAlbumId();
    	 
 //     Ora eseguo un ciclo di for e concateno le stringhe , per avere
//      le foto di ciascun album
    	 
    	 JSONObject jsonobject = null;
    	 JSONArray toGive = new JSONArray();
    	 for(int i=0 ; i<albumsId.size() ; i++) 
    	 {
    		String URL = "https://graph.facebook.com/v12.0/"+ albumsId.get(i) +"?fields=photos&access_token="+ userToken;
    		jsonobject =  DecEnc.readJsonObject(URL);
    		toGive.add(i, jsonobject);
    	 }
		return toGive;
    	
     }

     
//   Stampo le foto di un album con la possibilita di visualizzare ove presenti i tags del album
     public JSONArray getMultimediaElementInformation(String photoId) 
     {
    	 ArrayList<String> photosId = DecEnc.getPhotosId(photoId);
    	 
    	 JSONObject jobj = null;
    	 JSONArray toGive = new JSONArray();
    	 for(int i=0 ; i<photosId.size() ; i++) 
    	 {
    		String URL = "https://graph.facebook.com/v12.0/"+ photosId.get(i) +"?fields=photos&access_token="+ userToken;
    		jobj = (JSONObject) DecEnc.readJsonObject(URL); 
    		toGive.add(i, jobj);
    	 }
    	 
    	 return toGive;
     }
     
     
     
     
     public String getUserId() 
     {
    	 return userId;
     }
     
     
     
     public String getUserToken() 
     {
    	 return userToken;
     }

     }


