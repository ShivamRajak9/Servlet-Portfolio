<%@page import="com.model.ReadAdminLoginModel"%>
<%
 	String logindata = (String)session.getAttribute("adminlogin");
	if(logindata==null){
		response.sendRedirect("adminLogin.jsp");
		return;
	}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
	
	<%@include file="messageBox/printMessage.jsp" %>
	<%  ReadAdminLoginModel readAdminLoginService = (ReadAdminLoginModel) session.getAttribute("adminLoginData"); %>
	<form action="ChangeCredential1" method="post">
		<input type="hidden" name="id" value="<%=readAdminLoginService.getId()%>"> <br>
		<label>USER NAME</label> <br>
		<input type="text" name="username" value="<%=readAdminLoginService.getUsername()%>"> <br><br>
		<label>PASSWORD</label> <br>
		<input type="text" name="password" value="<%=readAdminLoginService.getPassword()%>"> <br> <br>
		<button>CHANGE</button>
	</form>
</body>
</html>