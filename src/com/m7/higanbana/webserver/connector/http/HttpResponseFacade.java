package com.m7.higanbana.webserver.connector.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class HttpResponseFacade implements HttpServletResponse {
  private HttpServletResponse response;
  public HttpResponseFacade(HttpResponse response) {
    this.response = response;
  }

  /** implementation of HttpServletResponse  */
  @Override
  public void addCookie(Cookie cookie) {
    response.addCookie(cookie);
  }
  @Override
  public void addDateHeader(String name, long value) {
    response.addDateHeader(name, value);
  }

  @Override
  public void addHeader(String name, String value) {
    response.addHeader(name, value);
  }

  @Override
  public void addIntHeader(String name, int value) {
    response.addIntHeader(name, value);
  }

  @Override
  public boolean containsHeader(String name) {
    return response.containsHeader(name);
  }

  @Override
  public String encodeRedirectURL(String url) {
    return response.encodeRedirectURL(url);
  }

  @Override
  public String encodeRedirectUrl(String url) {
    return response.encodeRedirectUrl(url);
  }

  @Override
  public String encodeUrl(String url) {
    return response.encodeUrl(url);
  }

  @Override
  public String encodeURL(String url) {
    return response.encodeURL(url);
  }

  @Override
  public void flushBuffer() throws IOException {
     response.flushBuffer();
  }

  @Override
  public int getBufferSize() {
    return response.getBufferSize();
  }

  @Override
  public String getCharacterEncoding() {
    return response.getCharacterEncoding();
  }

  @Override
  public Locale getLocale() {
    return response.getLocale();
  }

  @Override
  public ServletOutputStream getOutputStream() throws IOException {
    return response.getOutputStream();
  }

  @Override
  public PrintWriter getWriter() throws IOException {
    return response.getWriter();
  }

  @Override
  public boolean isCommitted() {
    return response.isCommitted();
  }

  @Override
  public void reset() {
    response.reset();
  }

  @Override
  public void resetBuffer() {
    response.resetBuffer();
  }

  @Override
  public void sendError(int sc) throws IOException {
    response.sendError(sc);
  }

  @Override
  public void sendError(int sc, String message) throws IOException {
    response.sendError(sc, message);
  }

  @Override
  public void sendRedirect(String location) throws IOException {
    response.sendRedirect(location);
  }

  @Override
  public void setBufferSize(int size) {
    response.setBufferSize(size);
  }

  @Override
  public void setContentLength(int length) {
    response.setContentLength(length);
  }

  @Override
  public void setContentType(String type) {
    response.setContentType(type);
  }

  @Override
  public void setDateHeader(String name, long value) {
    response.setDateHeader(name, value);
  }

  @Override
  public void setHeader(String name, String value) {
    response.setHeader(name, value);
  }

  @Override
  public void setIntHeader(String name, int value) {
    response.setIntHeader(name, value);
  }

  @Override
  public void setLocale(Locale locale) {
    response.setLocale(locale);
  }

  @Override
  public void setStatus(int sc) {
    response.setStatus(sc);
  }

  @Override
  public void setStatus(int sc, String message) {
    response.setStatus(sc, message);
  }

@Override
public String getContentType() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setCharacterEncoding(String arg0) {
	// TODO Auto-generated method stub
	
}
}
