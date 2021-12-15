package univpm.social.facebook.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface Service {
	
	public JSONObject getGeneralInformation(String param);
	public JSONArray getAlbumInformation();
	public JSONArray getMultimediaElementInformation(String param);
	//public JSONObject readJsonObject();
	public String getUserToken();
	public String getUserId();

}
