<!-- Token Checking : Session Checking  -->
<%
 	String logindata = (String)session.getAttribute("adminlogin");
	if(logindata==null){
		response.sendRedirect("adminLogin.jsp");
		return;
	}
%>


<%@page import="java.util.List"%>
<%@page import="com.model.ProjectFile"%>
<%@page import="com.dao.ReadDaoImpl"%>
<%@page import="com.dao.ReadDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body>

	<%@include file="messageBox/printMessage.jsp" %>
	<div class="top-center-container" >
	 <a href="index.jsp" class="top-button" style="position: relative; left: 490px;">Main Home</a>
  <a href="admin.jsp" class="top-button" style="position: relative; left: 500px;">Admin Home</a>
	</div>

<%
	ReadDao readDao = new ReadDaoImpl();
	List<ProjectFile> list = readDao.readProjectFileData();
	for (ProjectFile projectFile : list) {
%>
	<div style="display: inline-block; margin: 45px;">
		<img style="height: 200px;" 
		     src="myproject/<%=projectFile.getFilename()%>" 
		     class="img-fluid" alt="project image">
		
		<div style="text-align: center; margin-top: 8px;">
			<form action="DeleteProjectFile" method="post">
				<input type="hidden" name="filename" value="<%=projectFile.getFilename()%>">
				<button style="color: red" class="btn btn-danger">Delete</button>
			
			</form>
		</div>
	</div>
<%
	}
%>


</body>
</html>