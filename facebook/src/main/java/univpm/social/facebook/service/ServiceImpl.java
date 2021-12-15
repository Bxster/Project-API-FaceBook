package univpm.social.facebook.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import univpm.social.facebook.utility.DecEnc;

public class ServiceImpl implements Service {

// TODO luca : implementare una funzione per leggere da file queste due string
 	 private String userToken = "";
 	 private String userId = "";
	 
 	// id,name,birthday,email,friends,albums
     public JSONObject getGeneralInformation() 
     {
    	 String URL ="https://graph.facebook.com/v12.0/"+userId+"?fields=id%2Cname%2Cbirthday%2Cemail%2Cfriends%2Calbums&access_token="+userToken;
    	 
    	 return DecEnc.readJsonObject(URL);
     }
     
     public JSONObject getAlbumInformation() 
     {
    	 
     }
     
     public JSONObject getPhotoInformation() 
     {
    	 
     }
     

     }

}
