package univpm.social.facebook.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MultimediaElement extends GeneralObject implements Model {
	
	private String name;
	private String id;
	private String createdTime;
	private String tags;
    
	
	public MultimediaElement(String name, String id, String createdTime, String tags) 
	{
		super(id,name,createdTime);
		this.tags = tags;
	}


	public String getName() {
		return name;
	}


	public String getId() {
		return id;
	}


	public String getCreatedTime() {
		return createdTime;
	}


	public String getTags() {
		return tags;
	}
	
	
	
	
	public Date toDate() 
	{
       return TimeConversion.toIso8601(this.createdTime);
	}
	
	
	
	

}
