package univpm.social.model;

import java.util.Date;

/**
 * Questa interfaccia prepara i metodi del modello
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public interface Model {
	
	public String getCreatedTime();
	public String getName();
	public Date toDate();  
    public String getId();

}
