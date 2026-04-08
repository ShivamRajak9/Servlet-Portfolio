package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ReadAdminLoginModel;
import com.service.ReadServiceImpl;

/**
 * Servlet implementation class ReadAdminLogin
 */
public class ReadAdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ReadServiceImpl readServiceImpl = new ReadServiceImpl();
		ReadAdminLoginModel readAdminLoginService = readServiceImpl.readAdminLoginService();
		if(readAdminLoginService==null) {
			session.setAttribute("msg", "Something Went Wrong Try Again");
			response.sendRedirect("admin.jsp");	
		}else {
			session.setAttribute("adminLoginData", readAdminLoginService);
			response.sendRedirect("changecredential.jsp");		
		}
	}
}
