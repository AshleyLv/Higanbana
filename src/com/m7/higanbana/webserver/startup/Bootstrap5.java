package com.m7.higanbana.webserver.startup;

import org.apache.catalina.Connector;
import org.apache.catalina.Context;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.Loader;
import org.apache.catalina.Mapper;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.http.HttpConnector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.loader.WebappClassLoader;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.logger.FileLogger;

import com.m7.higanbana.webserver.core.SimpleContext;
import com.m7.higanbana.webserver.core.SimpleContextConfig;
import com.m7.higanbana.webserver.core.SimpleContextLifecycleListener;
import com.m7.higanbana.webserver.core.SimpleContextMapper;
import com.m7.higanbana.webserver.core.SimpleLoader;
import com.m7.higanbana.webserver.core.SimpleWrapper;
import com.m7.higanbana.webserver.valve.ClientIPLoggerValve;
import com.m7.higanbana.webserver.valve.HeaderLoggerValve;


public final class Bootstrap5 {
//	 public static void main(String[] args) {
//		    Connector connector = new HttpConnector();
//		    Wrapper wrapper1 = new SimpleWrapper();
//		    wrapper1.setName("Primitive");
//		    wrapper1.setServletClass("com.m7.webserver.test2.PrimitiveServlet");
//		    Wrapper wrapper2 = new SimpleWrapper();
//		    wrapper2.setName("Modern");
//		    wrapper2.setServletClass("com.m7.webserver.test2.ModernServlet");
//
//		    Context context = new SimpleContext();
//		    context.addChild(wrapper1);
//		    context.addChild(wrapper2);
//
//		    Mapper mapper = new SimpleContextMapper();
//		    mapper.setProtocol("http");
//		    LifecycleListener listener = new SimpleContextLifecycleListener();
//		    ((Lifecycle) context).addLifecycleListener(listener);
//		    context.addMapper(mapper);
//		    Loader loader = new SimpleLoader();
//		    context.setLoader(loader);
//		    // context.addServletMapping(pattern, name);
//		    context.addServletMapping("/Primitive", "Primitive");
//		    context.addServletMapping("/Modern", "Modern");
//		    
//		    // ------ add logger --------
//		    FileLogger logger = new FileLogger();
//		    logger.setPrefix("FileLog_");
//		    logger.setSuffix(".txt");
//		    logger.setTimestamp(true);
//		    logger.setDirectory("D:\\tempfiles");
//		    context.setLogger(logger);
//		    
//		    connector.setContainer(context);
//		    try {
//		      connector.initialize();
//		      ((Lifecycle) connector).start();
//		      ((Lifecycle) context).start();
//
//		      // make the application wait until we press a key.
//		      System.in.read();
//		      ((Lifecycle) context).stop();
//		    }
//		    catch (Exception e) {
//		      e.printStackTrace();
//		    }
//		  }
	
	public static void main(String[] args) {

	    //invoke: http://localhost:8080/Modern or  http://localhost:8080/Primitive

	    System.setProperty("catalina.base", "D:\\tempfiles");
	    Connector connector = new HttpConnector();
	    Wrapper wrapper1 = new SimpleWrapper();
	    wrapper1.setName("Primitive");
	    wrapper1.setServletClass("com.m7.webserver.test2.PrimitiveServlet");
	    Wrapper wrapper2 = new SimpleWrapper();
	    wrapper2.setName("Modern");
	    wrapper2.setServletClass("com.m7.webserver.test2.ModernServlet");

	    Context context = new StandardContext();
	    // StandardContext's start method adds a default mapper
	    context.setPath("/myApp");
	    context.setDocBase("myApp");

	    context.addChild(wrapper1);
	    context.addChild(wrapper2);

	    // context.addServletMapping(pattern, name);
	    context.addServletMapping("/Primitive", "Primitive");
	    context.addServletMapping("/Modern", "Modern");
	    // add ContextConfig. This listener is important because it configures
	    // StandardContext (sets configured to true), otherwise StandardContext
	    // won't start
	    LifecycleListener listener = new SimpleContextConfig();
	    ((Lifecycle) context).addLifecycleListener(listener);

	    // here is our loader
	    Loader loader = new WebappLoader();
	    // associate the loader with the Context
	    context.setLoader(loader);

	    // ------ add logger --------
	    FileLogger logger = new FileLogger();
	    logger.setPrefix("FileLog_");
	    logger.setSuffix(".txt");
	    logger.setTimestamp(true);
	    logger.setDirectory("D:\\tempfiles");
	    context.setLogger(logger);
	    
	    connector.setContainer(context);

	    try {
	      connector.initialize();
	      ((Lifecycle) connector).start();
	      ((Lifecycle) context).start();
	      // now we want to know some details about WebappLoader
	      WebappClassLoader classLoader = (WebappClassLoader) loader.getClassLoader();
	      System.out.println("Resources' docBase: " + ((org.apache.naming.resources.ProxyDirContext) classLoader.getResources()).getDocBase());
	      String[] repositories = classLoader.findRepositories();
	      for (int i=0; i<repositories.length; i++) {
	        System.out.println("  repository: " + repositories[i]);
	      }

	      // make the application wait until we press a key.
	      System.in.read();
	      ((Lifecycle) context).stop();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
