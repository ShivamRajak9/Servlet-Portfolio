package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ReadService;
import com.service.ReadServiceImpl;

/**
 * Servlet implementation class ChangeCredential2
 */
public class ChangeCredential2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ReadService readServiceImpl = new ReadServiceImpl();
		String result = readServiceImpl.changeAdminLoginService2(id, username, password);
		if(result.equalsIgnoreCase("CHANGE CREDENTIAL")){
			session.setAttribute("msg", result);
			response.sendRedirect("admin.jsp");
		}else {
			session.setAttribute("msg", result);
			response.sendRedirect("changecredential.jsp");
		}
		
	}

}
