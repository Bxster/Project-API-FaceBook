package univpm.social.model;

import java.util.ArrayList;
import java.util.Date;
import univpm.social.time.TimeConversion;



public class User extends GeneralObject implements Model{
	
	private String email;
	private String birthday;
	private ArrayList<Albums> albums = new ArrayList<Albums>();
	
	
	public User(String name, String id, String email ,String birthday, ArrayList<Albums> albums) {
		
		super(name,id);
		this.email = email;
		this.albums = albums;
		this.birthday = birthday;
	}
	

	
	public ArrayList<Albums> getAlbums() 
	{
		return albums;
	}
	
	
	public String getName() {
		return super.getName();
	}
	
	

	public String getId() {
		return super.getId();
	}
	
	

	public String getEmail() {
		return email;
	}
	
	

	
	public String toString() 
	{
		return super.getId() + " " + super.getName() + " " + email  ;
	}
	
	
	public Date toDate() 
	{
	  return TimeConversion.fromStringToStandardDate(birthday);
	}
	
	
	public String getCreatedTime() 
	{
		return birthday;
	}
	
	

}