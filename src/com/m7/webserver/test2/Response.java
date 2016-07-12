package com.m7.webserver.test2;

import java.io.OutputStream; 
import java.io.IOException; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.File; 
import java.io.PrintWriter; 
import java.util.Locale; 
import javax.servlet.ServletResponse; 
import javax.servlet.ServletOutputStream; 

public class Response implements ServletResponse { 
	private static final int BUFFER_SIZE = 1024; 
	Request request; 
	OutputStream output; 
	PrintWriter writer; 
	public Response(OutputStream output) { 
		this.output = output; 
	} 
	
	public void setRequest(Request request) { 
		this.request = request; 
	} 
	
	/* This method is used to serve static pages */ 
	public void sendStaticResource() throws IOException { 
		byte[] bytes = new byte[BUFFER_SIZE]; 
		FileInputStream fis = null; 
		try { 
			/* request.getUri has been replaced by request.getRequestURI */
			File file = new File(Constants.WEB_ROOT, request.getUri()); 
			
			fis = new FileInputStream(file); 
			/* HTTP Response = Status-Line *(( general-header | response-header | entity-header ) CRLF) CRLF [ message-body ] Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF */ 
			int ch = fis.read(bytes, 0, BUFFER_SIZE); 
			while (ch!=-1) { 
				output.write(bytes, 0, ch); 
				ch = fis.read(bytes, 0, BUFFER_SIZE); 
			} 
		} catch (FileNotFoundException e) { 
			String errorMessage = "HTTP/1.1 404 File Not Found\r\n" 
				+ "Content-Type: text/html\r\n" 
				+ "Content-Length: 23\r\n" + "\r\n" 
				+ "<h1>File Not Found</h1>"; 
			output.write(errorMessage.getBytes()); 
		} finally { 
			if (fis!=null)
				fis.close(); 
		} 
	} 
	
	/** implementation of ServletResponse */ 
	@Override
	public void flushBuffer(){
		
	}
	
	@Override
	public int getBufferSize() { 
		return 0; 
	}
	
	@Override
	public String getCharacterEncoding() { 
		return null; 
	} 
	
	@Override
	public Locale getLocale() { 
		return null; 
	} 
	
	@Override
	public ServletOutputStream getOutputStream() throws IOException { 
		return null; 
	} 
	
	@Override
	public PrintWriter getWriter() throws IOException {
		// autoflush is true, println() will flush,
		// but print() will not. 
		writer = new PrintWriter(output, true); 
		return writer; 
	} 
	
	@Override
	public boolean isCommitted() { 
		return false; 
	} 
	
	@Override
	public void reset() { } 
	
	@Override
	public void resetBuffer() { } 
	@Override
	public void setBufferSize(int size) { } 
	
	@Override
	public void setContentLength(int length) { } 
	
	@Override
	public void setContentType(String type) { } 
	
	@Override
	public void setLocale(Locale locale) { }

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