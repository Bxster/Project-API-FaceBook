package univpm.social.facebook.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Albums extends GeneralObject implements Model {
	
	private String createdTime;
    private String name;
    private String id;
    private ArrayList<MultimediaElement>multimedialElements;
    
    
    public Albums(String createdTime, String name, String id, ArrayList<MultimediaElement>multimediaElements) 
    {
    	super(id,name,createdTime);
    	this.id = id;
    	this.multimedialElements = multimediaElements;
    }


	public String getCreatedTime() {
		return createdTime;
	}


	public String getName() {
		return name;
	}


	public String getId() {
		return id;
	}


	public ArrayList<MultimediaElement> getMultimedialElements() {
		return multimedialElements;
	}
	
    
    public Date toDate() 
    {
    	return TimeConversion.toIso8601(this.createdTime);
    }

}
