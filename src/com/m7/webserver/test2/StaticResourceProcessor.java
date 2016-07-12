package com.m7.webserver.test2;

import java.io.IOException; 

public class StaticResourceProcessor { 
	public void process(Request request, Response response) { 
		try { 
			response.sendStaticResource(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
}
