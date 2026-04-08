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
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="css/button.css">

</head>
<body>
	<%@include file="messageBox/printMessage.jsp" %>
	<div class="top-center-container">
	  <a href="index.jsp" class="top-button"> Main Home</a>
	  <a href="admin.jsp" class="top-button"> Admin Home</a>
	</div>

	<form action="UploadProject1" method="post" enctype="multipart/form-data">
		<input type="file" name="myfile" > <br>
		<button>Upload</button>
	</form>
</body>
</html>