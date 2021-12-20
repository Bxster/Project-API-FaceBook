package univpm.social.model;

public abstract class GeneralObject {
	
	
	private String id;
	private String name;
	
	public GeneralObject(String name, String id) 
	{
		this.id = id;
		this.name = name;
	}
	
	
	
	public String getId() 
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}

}
