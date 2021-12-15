package univpm.social.facebook.service;

import org.json.simple.JSONObject;

public interface Service {
	
	public JSONObject getGeneralInformation();
	public JSONObject getAlbumInformation();
	public JSONObject getMultimediaElementInformation();
	public JSONObject readJsonObject();

}
