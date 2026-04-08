package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.EducationService;
import com.service.EducationServiceImpl;

/**
 * Servlet implementation class UpdateEducation
 */
public class UpdateEducation extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		
		EducationService educationServiceImpl = new EducationServiceImpl();
		String result = educationServiceImpl.updateEducationService(id,year, title, subtitle, description);
		if(result.equalsIgnoreCase("UPDATED")) {
			session.setAttribute("msg", "EDUCATION UPDATED");
			response.sendRedirect("ReadEducation");
		}else {
			session.setAttribute("msg", result);
			response.sendRedirect("admin.jsp");
		}
		
	}
}
