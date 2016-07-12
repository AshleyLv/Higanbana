package com.m7.higanbana.webserver.core;

import java.io.IOException;

import com.m7.higanbana.webserver.connector.http.HttpRequest;
import com.m7.higanbana.webserver.connector.http.HttpResponse;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
