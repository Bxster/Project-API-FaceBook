package univpm.social.facebook.model;

import java.util.Date;

public interface Model {
	
	public String getCreatedTime();
	public String getName();
	public String getId();
	public Date toDate();

}
