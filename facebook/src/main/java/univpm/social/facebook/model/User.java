package univpm.social.facebook.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User extends GeneralObject implements Model {
	
	private String id;
	private String name;
	private String birthday;
	private String email;
	private String numberFriends;
	private ArrayList<Albums> albums;
	
	// id,name,birthday,email,friends,albums
	public User(String id, String name, String birthday, String email, String numberFriends, ArrayList<Albums>albums ) 
	     {
		     super(id,name,birthday);
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
		return TimeConversion.toStandardDate(this.birthday);
	}
	
	
	public ArrayList<Albums> getAlbums()
	{
		return this.albums;
	}

   
}
