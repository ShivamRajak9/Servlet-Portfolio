package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.DeleteService;
import com.service.DeleteServiceImpl;

/**
 * Servlet implementation class DeleteProjectFile
 */
public class DeleteProjectFile extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String filename = request.getParameter("filename");
		DeleteService deleteServiceImpl = new DeleteServiceImpl();
		String result = deleteServiceImpl.projectfileDeleteService(filename);
		
		session.setAttribute("msg", result);
		response.sendRedirect("readAllProject.jsp");
		
		
		
	}
}
