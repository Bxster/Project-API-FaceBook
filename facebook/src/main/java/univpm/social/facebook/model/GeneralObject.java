package univpm.social.facebook.model;

public abstract class GeneralObject {
	
	private String id;
	private String name;
	private String time;
	
	public GeneralObject(String id , String name, String time) 
	{
		this.id = id;
		this.name = name;
		this.time = time;
	}

}
