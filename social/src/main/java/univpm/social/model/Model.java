package univpm.social.model;

import java.util.Date;

public interface Model {
	
	public String getCreatedTime();
	public String getName();
	public Date toDate();  
    public String getId();

}
