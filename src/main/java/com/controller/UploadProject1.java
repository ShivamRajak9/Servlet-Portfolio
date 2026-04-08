package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.service.CreateServiceImpl;

/**
 * Servlet implementation class UploadProject1
 */
@MultipartConfig
public class UploadProject1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Part part = request.getPart("myfile");
		String fileName = part.getSubmittedFileName();
		String contentType = part.getContentType();  //image, png
		long size = part.getSize(); //byte
		
		CreateServiceImpl createServiceImpl = new CreateServiceImpl();
		String result = createServiceImpl.validateProjectFile(fileName,contentType, size);
		if(result.equalsIgnoreCase("Valid")) {
			//Redirect
			//NEXT SERVLET
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UploadProject2");
			requestDispatcher.forward(request, response);
			
		} else {
			session.setAttribute("msg", result);
			response.sendRedirect("uploadProject.jsp");
		}
		
	}

}
