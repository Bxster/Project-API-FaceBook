package univpm.social.service;

import org.springframework.web.client.RestTemplate;

import univpm.social.exceptions.FileException;
import univpm.social.utility.FileExtern;
import univpm.social.utility.ToJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class ServiceImpl implements univpm.social.service.Service {

	
	
	// private String appToken="";
	//private String userId="4543545659027502"; //4543545659027502
	//private String userToken="EAAG6hIm80mEBAMvDRHnVcezokKiAB30Y0Byg2xV4TIjd8s0oSwXVRfdndzJUMzZAk7QSfq9czF8JS0Vt1SrJzjKfL5McZAgHTe1vDfoKuaBGXeUEVn2A8dP096qlPkLLoxdxomFGZAVwb41XaX7LFy8GiK7RCyMgKMPnMUcOq8O9uPOAFdZAQ576EGu0CzSXoWywLV6gsfg5AzLYL9L8vs6Ov8rq0HBN8pR0ilJ8NA2vznPne0qM";

   	private  ArrayList<String> getFromFile() throws IOException, FileException 
	{
	   return FileExtern.readFromFile("WRITE_ME.txt",true);	
	}
	
	public JSONObject getGeneralInformation() throws IOException, FileException 
	{

	   String userId = this.getFromFile().get(0);
	   String userToken = this.getFromFile().get(1) + this.getFromFile().get(2);
	   String url = "https://graph.facebook.com/v12.0/"+userId+"?method=GET&fields=id%2Cname%2Calbums%2Cemail%2Cbirthday&access_token="+userToken;
       return ToJson.getJson(url);
	}
	
	
	public JSONObject getWhatYouWant(String param) throws IOException, FileException 
	{
	   String URL = "https://graph.facebook.com/v12.0/"+this.getFromFile().get(0)+"?method=GET&fields=id%2Cname%2Cemail"+"%2C"+param+"&access_token="+(this.getFromFile().get(1) + this.getFromFile().get(2));
	   
	   return ToJson.getJson(URL);
	}
	

}