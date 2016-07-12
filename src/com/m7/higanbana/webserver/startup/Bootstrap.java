package com.m7.higanbana.webserver.startup;

import com.m7.higanbana.webserver.connector.http.HttpConnector;

public final class Bootstrap {
	  public static void main(String[] args) {
	    HttpConnector connector = new HttpConnector();
	    connector.start();
	  }
}
