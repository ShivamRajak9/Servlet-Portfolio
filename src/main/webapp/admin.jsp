<!-- Token Checking : Session Checking  -->
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
<title>Admin</title>
</head>
<body>
		<%@include file="messageBox/printMessage.jsp" %>
		<h1>Admin Panel</h1>
		<a href="readContact.jsp">Read All Contact</a> <br>
		<a href="uploadProject.jsp">Upload Project</a> <br>
		<a href="readAllProject.jsp">Read All Projects</a> <br>
		<a href="uploadResume.jsp">Upload Resume</a> <br>
		<a href="addeducation.jsp">Add Education</a> <br>
		<a href="ReadEducation">Read Education</a> <br>
		
		<form action="Logout" method="post">
			<button>Logout</button>
		</form>
		<form action="ReadAdminLogin" method="post">
			<button>CHANGE CREDENTIAL</button>
		</form>
</body>
</html>