package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.EducationService;
import com.service.EducationServiceImpl;

/**
 * Servlet implementation class Education
 */
public class Education extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String description = request.getParameter("description");
		
		EducationService educationServiceImpl = new EducationServiceImpl();
		String result = educationServiceImpl.addEducationService1(year, title, subtitle, description);
		if(result.equalsIgnoreCase("Valid")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Education2");
			requestDispatcher.forward(request, response);
		}else {
			session.setAttribute("msg", result);
			response.sendRedirect("addeducation.jsp");
		}
		
	}

}
