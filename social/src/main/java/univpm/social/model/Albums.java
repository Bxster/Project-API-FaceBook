package univpm.social.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import univpm.social.time.TimeConversion;

                  
public class Albums extends GeneralObject {
	
	private String createdTime;
	private ArrayList<Photo>photo = new ArrayList();

	//                                              ArrayList<Photo>photo
	public Albums(String name , String createdTime ,String albumId, ArrayList<Photo>photo) 
	{
	   super(name,albumId);
	   this.createdTime  = createdTime;
	   this.photo = photo;
	}
	
	
	public String getCreatedTime() 
	{
		return createdTime;
	}
	
	
	public String getName() 
	{
		return super.getName();
	}
	
	public String getAlbumId() 
	{
		return super.getId();
	}
	
	
	public Date toDate() 
	{
       return TimeConversion.toIso8601(createdTime);	
	}
	
	// Si potrebbe decidere dove inserire l'add photo 
	public void addPhoto(Photo p) 
	{
	   photo.add(p);	
	}
	
	
	public String toString() 
	{
	  return this.getName() + " " + this.getCreatedTime() + " " + this.getId() ;
	}
	
	
	public ArrayList<Photo> getPhotos()
	{
		return photo;
	}
	
	

}
