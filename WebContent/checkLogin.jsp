<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="database.HandleDatabase" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String username = request.getParameter("username");
String pwd = request.getParameter("pwd");

	
HandleDatabase handler = new HandleDatabase();
	
if(handler.databaseHasEntry(username)) {
  if(handler.checkPwd(username,pwd)) {
	  out.println("Success");
	  session.setAttribute("username",username);
	  session.setAttribute("loginstatus","true");
	  response.sendRedirect("intern.jsp");

  } else {
	  response.sendRedirect("loginForm.jsp?error=2");
  }
  
} else {
	  response.sendRedirect("loginForm.jsp?error=1");
}


%>

</body>
</html>