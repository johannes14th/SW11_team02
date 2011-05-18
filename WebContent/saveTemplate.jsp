<%@page import="javax.naming.Context"%>
<%@ page import = "CreateTemplate.Template" %>
<%@ page import = "editTemplate.Data" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String tmp = request.getParameter("filename");
String content = request.getParameter("input");

Data data = new Data(application.getRealPath(tmp));

if(content != "")
	data.setInput(content);

String redirectURL = "editTemplate.jsp";
response.sendRedirect(redirectURL);

%>
</body>
</html>