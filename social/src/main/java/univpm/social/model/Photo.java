package univpm.social.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import univpm.social.time.TimeConversion;

public class Photo  extends GeneralObject implements Model {


	 private String createdTime;

     
	 
	 public Photo(String name, String createdTime, String id) {       
		 
		 super(name,id);
		 this.createdTime = createdTime;
	}


	public String getName() {
		return super.getName();
	}


	public String getCreatedTime() {
		return createdTime;
	}


	 public String getId() 
	 {
		 return super.getId();
	 }
	
 
	public Date toDate() 
	{
       return TimeConversion.toIso8601(createdTime);
	}
	
	
	public String toString() 
	{
		return "NOME FOTO: "+ this.getName() + " ID: " + this.getId() + " DATA DI PUBBLICAZIONE: " +createdTime;
	}
	 
	 
	 
	 
	 
	 
	 

}
