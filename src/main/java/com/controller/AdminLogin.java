package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ReadService;
import com.service.ReadServiceImpl;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ReadService readService = new ReadServiceImpl();
		String result = readService.checkAdminLoginCreadential(username, password);
		
		if(result.equalsIgnoreCase("EXIST")) {
			session.setAttribute("adminlogin", username);
			response.sendRedirect("admin.jsp");
		} else {
			session.setAttribute("msg", result);
			response.sendRedirect("adminLogin.jsp");
		}
	}

}
