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
</head>
<body>
		<%@include file="messageBox/printMessage.jsp" %>
		<form action="UploadResume" method="post" enctype="multipart/form-data">
			<input type="file" name="myresume"> <br>
			<button>Upload/Update Resume</button>
		</form>		
</body>
</html>