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
 <link rel="stylesheet" type="text/css" href="css/button.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="messageBox/printMessage.jsp" %>
	<form action="Education" method="post">
		 <br> <input type="text" name="year" placeholder="Enter Year"> <br>  <br>
		<input type="text" name="title" placeholder="Enter Title"> <br>  <br>
		<input type="text" name="subtitle" placeholder="Enter Sub Title"> <br>  <br>
		<input type="text" name="description" placeholder="Enter Description Title"> <br>  <br>
		<button>Add Education</button>
	</form>
	
	<div class="top-center-container">
	  <form action="addeducation.jsp" method="post" style="margin:0;">
	    <button type="submit" class="top-button"> REFRESH</button>
	  </form>

	  <a href="index.jsp" class="top-button"> Main Home</a>
	  <a href="admin.jsp" class="top-button"> Admin Home</a>
	</div>
</body>
</html>