package com.m7.webserver.test7.core;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import org.apache.catalina.Container;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.Loader;
import org.apache.catalina.DefaultContext;

public class SimpleLoader implements Loader, Lifecycle {

  public static final String WEB_ROOT =
    System.getProperty("user.dir") + File.separator  + "webroot";
  ClassLoader classLoader = null;
  Container container = null;

  public SimpleLoader() {
    try {
      URL[] urls = new URL[1];
      URLStreamHandler streamHandler = null;
      File classPath = new File(WEB_ROOT);
      String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
      urls[0] = new URL(null, repository, streamHandler);
      classLoader = new URLClassLoader(urls);
    }
    catch (IOException e) {
      System.out.println(e.toString() );
    }

  }
  @Override
public ClassLoader getClassLoader() {
    return classLoader;
  }
  @Override
  public Container getContainer() {
    return container;
  }
  @Override
  public void setContainer(Container container) {
    this.container = container;
  }
  @Override
  public DefaultContext getDefaultContext() {
    return null;
  }
  @Override
  public void setDefaultContext(DefaultContext defaultContext) {
  }
  @Override
  public boolean getDelegate() {
    return false;
  }
  @Override
  public void setDelegate(boolean delegate) {
  }
  @Override
  public String getInfo() {
    return "A simple loader";
  }
  @Override
  public boolean getReloadable() {
    return false;
  }

  @Override
  public synchronized void start() throws LifecycleException {
    System.out.println("Starting SimpleLoader");
  }
  @Override
  public void stop() throws LifecycleException {
  }
@Override
public void addLifecycleListener(LifecycleListener listener) {
	// TODO Auto-generated method stub
	
}
@Override
public LifecycleListener[] findLifecycleListeners() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void removeLifecycleListener(LifecycleListener listener) {
	// TODO Auto-generated method stub
	
}
@Override
public void setReloadable(boolean reloadable) {
	// TODO Auto-generated method stub
	
}
@Override
public void addPropertyChangeListener(PropertyChangeListener listener) {
	// TODO Auto-generated method stub
	
}
@Override
public void addRepository(String repository) {
	// TODO Auto-generated method stub
	
}
@Override
public String[] findRepositories() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean modified() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void removePropertyChangeListener(PropertyChangeListener listener) {
	// TODO Auto-generated method stub
	
}

}
