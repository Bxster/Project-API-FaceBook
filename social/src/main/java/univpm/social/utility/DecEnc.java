package univpm.social.utility;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import univpm.social.model.Albums;
import univpm.social.model.User;


public class DecEnc {
	
	
public static JSONObject encodeToJson(User user) 
{
	String userName = user.getName();
	String userId = user.getId();
	String userEmail = user.getEmail();
	ArrayList<Albums> album = user.getAlbums();
	
//  Ho copiato lo username , l'id e l'email nel jsonobject , ora tocca agli album
	JSONObject toGive = new JSONObject();
	toGive.put("name", userName);
	toGive.put("id",userId);
	toGive.put("email", userEmail);

	JSONArray jsonarray = new JSONArray(); 
    
	//JSONObject temp =  new JSONObject();
	for(int i=0 ; i<album.size() ; i++)
	{
		Albums singleAlbum = album.get(i);
		
		JSONObject temp =  new JSONObject();
		temp.put("name", singleAlbum.getName());
		temp.put("id", singleAlbum.getAlbumId());
		temp.put("created_time", singleAlbum.getCreatedTime());
		
	//	System.out.println("name: " +singleAlbum.getName() +" id: "+singleAlbum.getAlbumId() + " date: "+ singleAlbum.toDate());

		jsonarray.add(i, temp);
	}

	// STAMPE DI PROVA :
	for(int i=0 ; i<jsonarray.size();i++) System.out.println((JSONObject)jsonarray.get(i));
		
	// System.out.println(toGive.put("albums", jsonarray);
	
	toGive.put("albums", jsonarray);
	
	System.out.println(toGive.toJSONString());
	return toGive; 
}

}
