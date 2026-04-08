<!-- Token Checking : Session Checking  -->
<%@page import="com.dto.EducationDTO"%>
<%@page import="java.util.ArrayList"%>
<%
 	String logindata = (String)session.getAttribute("adminlogin");
	if(logindata==null){
		response.sendRedirect("adminLogin.jsp");
		return;
	}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="css/button.css">
<title>Read Education</title>
</head>
<body>
	<%@include file="messageBox/printMessage.jsp" %>
	
	<%
	ArrayList<EducationDTO> arrayList =(ArrayList<EducationDTO>)session.getAttribute("readeducation");
	if(arrayList==null){
		response.sendRedirect("admin.jsp");
		return;
	}
	int sn = 1;
	int index = 0;
	for (EducationDTO educationDTO : arrayList) {
	%>
		<h4>SN: <%=sn %> </h4>
	<h4>
		Year:
		<%=educationDTO.getYear()%> </h4>
	<h4>
		Title:
		<%=educationDTO.getTitle() %> </h4>
	<h4>
		SubTitle:
		<%=educationDTO.getSubtitle() %> </h4>
	<h4>
		Description:
		<%=educationDTO.getDescription() %> </h4>
	<h4>
		DateTime:
		<%=educationDTO.getDatetime()%> </h4>
		<form action="DeleteEducation" method = "post">
			<input type="hidden"  name ="id" value="<%=educationDTO.getId()%>">
			<button>Delete</button>
		</form>
		<br>
		<form action="updateEducation.jsp" method = "post">
			<input type="hidden"  name ="index" value="<%=index%>">
			<button>Update</button>
		</form>
	<%
	sn++;
	index++;
	}
	%>
	<div class="top-center-container">
    <a href="ReadEducation" class="top-button">REFRESH</a>
	 <a href="index.jsp" class="top-button"> Main Home</a>
	 <a href="admin.jsp" class="top-button"> Admin Home</a>
</div>
	
</body>
</html>