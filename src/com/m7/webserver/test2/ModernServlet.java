package com.m7.webserver.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ModernServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("ModernServlet destroy"); 
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init ModernServlet"); 
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("from service"); 
		PrintWriter out = response.getWriter(); 
		out.println("Hello. Roses are red."); 
		out.print("Violets are blue."); 
		
	}

}
