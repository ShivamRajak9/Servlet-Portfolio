<!-- Token Checking : Session Checking  -->
<%
 	String logindata = (String)session.getAttribute("adminlogin");
	if(logindata==null){
		response.sendRedirect("adminLogin.jsp");
		return;
	}
%>

<%@page import="com.dto.EducationDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/button.css">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<EducationDTO> arrayList =(ArrayList<EducationDTO>)session.getAttribute("readeducation");
	String index = request.getParameter("index");
	if(index==null){
		response.sendRedirect("admin.jsp");
		return;
	}
	
		EducationDTO educationDTO =	arrayList.get(Integer.parseInt(index));
	%>
	<form action="UpdateEducation" method="post">
		<input type="hidden" name="id" value="<%=educationDTO.getId()%>"> <br>  <br>
		 <br> <input type="text" name="year" value="<%=educationDTO.getYear() %>"> <br>  <br>
		<input type="text" name="title" value="<%=educationDTO.getTitle()%>"> <br>  <br>
		<input type="text" name="subtitle" value="<%=educationDTO.getSubtitle()%>"> <br>  <br>
		<input type="text" name="description" value="<%=educationDTO.getDescription()%>"> <br>  <br>
		<button>Update Education</button>
	</form>
	
	<div class="top-center-container">
	  <form action="updateEducation.jsp" method="post" style="margin:0;">
	    <button type="submit" class="top-button"> REFRESH</button>
	  </form>

	  <a href="index.jsp" class="top-button"> Main Home</a>
	  <a href="admin.jsp" class="top-button"> Admin Home</a>
	</div>
</body>
</html>