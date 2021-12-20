package univpm.social.filters;

import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;

import univpm.social.exceptions.BadParameterException;
import univpm.social.exceptions.FileException;
import univpm.social.exceptions.NoAlbumsException;


public interface Filter {
   
	public JSONObject filterForYears(String year) throws IOException, FileException, NoAlbumsException;
	public JSONObject filterForMonth(String year , String month) throws ParseException, IOException, FileException, NoAlbumsException;
	public JSONObject filterForDay(String year , String Month ,String day) throws ParseException, IOException, FileException, NoAlbumsException;
	public JSONObject filter(String year , String Month ,String day) throws ParseException, BadParameterException, IOException, FileException, NoAlbumsException;

}