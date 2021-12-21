package univpm.social.utility;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import univpm.social.exceptions.FileException;
import univpm.social.model.Albums;
import univpm.social.model.Photo;
import univpm.social.model.User;
import univpm.social.service.ServiceImpl;


public class DecEnc {
	
	
public static JSONObject encodeToJson(User user) 
{
	String userName = user.getName();
	String userId = user.getId();
	String userEmail = user.getEmail();
	String userBirthday = user.getCreatedTime();
	ArrayList<Albums> album = user.getAlbums();
	
//  Ho copiato lo username , l'id e l'email nel jsonobject , ora tocca agli album
	JSONObject toGive = new JSONObject();
	toGive.put("name", userName);
	toGive.put("id",userId);
	toGive.put("email", userEmail);
    toGive.put("birthday", userBirthday);
	
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
	for(int i=0 ; i<jsonarray.size();i++) 
		
	// System.out.println(toGive.put("albums", jsonarray);
	
	toGive.put("albums", jsonarray);
	
	System.out.println(toGive.toJSONString());
	return toGive; 
	
	
   }


   public static User decodeToUser() throws IOException, FileException 
     {
       ServiceImpl service = new ServiceImpl();
       JSONObject jsonobject = service.getGeneralInformation();
       User user;
       ArrayList<Albums> albums = new ArrayList() ;
       ArrayList<Photo> photo = new ArrayList();



      //ORA ACCEDO AL ALBUMS E PRENDO IL JSONARRAY : "data"
      JSONObject Albums =  (JSONObject) jsonobject.get("albums");
      JSONArray data = (JSONArray) Albums.get("data");


      for(int i = 0 ; i<data.size() ; i++) 
        {
           Object obj = data.get(i);
           JSONObject jobj = (JSONObject) obj; 

           String albumName = jobj.get("name").toString();
           String createdTime = jobj.get("created_time").toString();
           String albumId = jobj.get("id").toString();
           Albums album = new Albums(albumName,createdTime,albumId,null);	
           albums.add(album);
        }


       user = new User(jsonobject.get("name").toString() , jsonobject.get("id").toString() , jsonobject.get("email").toString() ,jsonobject.get("birthday").toString(), albums);

       
      return user;
}


}
