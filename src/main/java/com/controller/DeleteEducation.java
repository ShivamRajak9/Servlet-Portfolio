package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.EducationServiceImpl;

/**
 * Servlet implementation class DeleteEducation
 */
public class DeleteEducation extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String result = new EducationServiceImpl().deleteEducation(id);
		if(result.equalsIgnoreCase("Deleted")) {
			session.setAttribute("msg", "Education Deleted Success Full");
			response.sendRedirect("ReadEducation");
		}else {
			session.setAttribute("msg", result);
			response.sendRedirect("readEducation.jsp");
		}
		 
	}
}
