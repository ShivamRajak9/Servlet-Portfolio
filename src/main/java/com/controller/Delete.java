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
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DeleteService delete = new DeleteServiceImpl();
		String result = delete.contactdeleteService(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		response.sendRedirect("readContact.jsp");
	}
}
