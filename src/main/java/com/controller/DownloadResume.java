package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadResume
 */
public class DownloadResume extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String realPath = servletContext.getRealPath("myresume");
		FileInputStream fis = new FileInputStream(realPath+File.separator+"shivamresume.pdf");  
		byte [] b =new byte[fis.available()];
		fis.read(b);  
		
		ServletOutputStream outputStream = response.getOutputStream();
		response.setHeader("content-disposition", "filename=shivamcv.pdf");
		response.setContentType("application/octet-stream");
		outputStream.write(b);
		
		fis.close();
		outputStream.close();  
		
		
	}
}
