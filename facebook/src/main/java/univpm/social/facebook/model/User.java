package univpm.social.facebook.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User extends GeneralObject implements Model {
	
	private String id;
	private String name;
	private String birthday;
	private String email;
	private String numberFriends;
	private <ArrayList>Albums albums;
	
	
	public User(String id, String name, String birthday, String email, String numberFriends, ArrayList<Albums>albums ) 
	     {
		     super(id,name);
		     this.birthday = birthday;
		     this.email = email;
		     this.numberFriends = numberFriends;
		     this.albums = albums;
	     }
	
	
	
	public String getName() 
	{
		return this.name;
	}
	
	
	public String getId() 
	{
		return this.id;
	}
	
	
	public String getCreatedTime() 
	{
		return this.birthday;
	}
	
	
	public Date toDate() 
	{
		//String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+SSSS";
		 String DATE_FORMAT = "yyyy-MM-dd";
	     SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		    Date date = null;
		    try {
		        date = sdf.parse(this.birthday);
		    } catch(ParseException e) 
		       {
		    	  // TODO LUCA : FARE QUALCOSA QUI
		       }

		    
	}
	
	
	public ArrayList<Albums> getAlbums()
	{
		return this.albums;
	}

   
}
