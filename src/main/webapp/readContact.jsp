<!-- Token Checking : Session Checking  -->
<%
 	String logindata = (String)session.getAttribute("adminlogin");
	if(logindata==null){
		response.sendRedirect("adminLogin.jsp");
		return;
	}
%>

<!DOCTYPE html>
<%@page import="com.model.EmployeeModel" %>
<%@page import="java.util.List" %>
<%@page import="com.dao.ReadDao" %>
<%@page import="com.dao.ReadDaoImpl" %>
<html>
<head>
<meta charset="UTF-8">
<title>Read Contact</title>
 <link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body>

	<%@include file="messageBox/printMessage.jsp" %>
	
	<%
	ReadDao read = new ReadDaoImpl();
	List<EmployeeModel> list = read.readContact();
	int sn = 1;
	for (EmployeeModel empData : list) {
	%>
		<h4>SN: <%=sn %> </h4>
	<h4>
		Name:
		<%=empData.getName()%> </h4>
	<h4>
		Email:
		<%=empData.getEmail() %> </h4>
	<h4>
		Message:
		<%=empData.getMessage() %> </h4>
	<h4>
		DateTime:
		<%=empData.getDateTime()%> </h4>
		<form action="Delete" method = "post">
			<input type="hidden"  name ="id" value="<%=empData.getId() %>">
			<button>Delete</button>
		</form>
	<%
	sn++;
	}
	%>
	<div class="top-center-container">
  <form action="readContact.jsp" method="post" style="margin:0;">
    <button type="submit" class="top-button"> REFRESH</button>
  </form>

  <a href="index.jsp" class="top-button"> Main Home</a>
  <a href="admin.jsp" class="top-button"> Admin Home</a>
</div>


</body>
</html>