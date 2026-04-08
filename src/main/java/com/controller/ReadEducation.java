package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.EducationDTO;
import com.service.EducationServiceImpl;

/**
 * Servlet implementation class ReadEducation
 */
public class ReadEducation extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<EducationDTO> readEducation= new EducationServiceImpl().readEducation();
		HttpSession session = request.getSession();
		session.setAttribute("readeducation", readEducation);
		response.sendRedirect("readEducation.jsp");
	}

}
