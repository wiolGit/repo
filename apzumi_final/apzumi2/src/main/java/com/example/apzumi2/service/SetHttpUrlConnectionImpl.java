package com.example.apzumi2.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.stereotype.Service;

import com.example.apzumi2.model.PostContentModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CharMatcher;



@Service
public class SetHttpUrlConnectionImpl implements SetHttpUrlConnection {

	
    final String url =" https://jsonplaceholder.typicode.com/posts";
  
    
    public List< PostContentModel> callGetConsentService() {
    	
    	
    	return makeMapping(getPostContentData());
    	
    	
    }
    
    private List<PostContentModel> makeMapping(String  str ) {
    	
    
    	List<PostContentModel> mapobj = new ArrayList<PostContentModel>();
    	
        Object object;
		try {
			object = new JSONParser().parse(str);
			  JSONArray companyList  = (JSONArray) object;  
			   mapobj = new ObjectMapper().readValue(str,  new TypeReference<List<PostContentModel>>() {});
				//Map<Integer, PostContentModel> mapobj = new ObjectMapper().readValue(str, HashMap.class);
			
			  
			  
			  
		} catch (ParseException e) {
		
			e.printStackTrace();
		
		} catch (JsonMappingException e) {
		
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
      
       System.out.println("Start printing elements:");	   
       System.out.println("Total Recovered: " +  mapobj.get(0).getBody());
       System.out.println("Total Recovered: " + mapobj.get(0).getBody());
       System.out.println("Total Recovered: " + mapobj.get(0).getBody());
       System.out.println("Total Recovered: " + mapobj.get(0).getBody());
	return mapobj;
    } 
    
    
    @Override
	public String  getPostContentData() {
		
	   
		  try {
			  HttpURLConnection c = null;
	      
			  URL u = new URL(url);
		        c = (HttpURLConnection) u.openConnection();
		        c.setRequestMethod("GET");
		        c.setRequestProperty("Content-Type", "application/json; utf-8");
		        c.setRequestProperty("Accept", "application/json");
		        c.connect();
		        
		        int status = c.getResponseCode();

		        switch (status) {
		            case 200:
		            case 201:
		                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(), "utf-8"));
		                StringBuilder sb = new StringBuilder();
		                String line;
		                while ((line = br.readLine()) != null) {
		                    sb.append(line);
		                    System.out.println(line);
		                }
		                br.close();

		                System.out.println(sb.toString());
                		return  sb.toString();
                       
                       
                     
	             
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    return "";
		
		
	}
}
