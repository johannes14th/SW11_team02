<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="webtexter.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body{
	background: #000066;
}
-->
</style>
</head>
<body>
<ul id="menu">
<%
String status = (String) session.getAttribute("loginstatus");

boolean loggedIn = false;

if(status != "" && status != null) {
	
	System.out.println(status);
	
	if(status.equals("true"))
		loggedIn = true;
}

if(loggedIn) {
	out.println("<li><a href=\"intern.jsp\" target=\"mainFrame\">Intern</a></li>");
	out.println("<li><a href=\"chooseTemplate.jsp\" target=\"mainFrame\">Template Assistant</a></li>");
	out.println("<li><a href=\"createNewTemplate.jsp\" target=\"mainFrame\">Create Template</a></li>");
	out.println("<li><a href=\"editTemplate.jsp\" target=\"mainFrame\">Edit Template</a></li>");
	out.println("<li><a href=\"logout.jsp\" target=\"mainFrame\">Logout</a></li>");
} else {
	out.println("<li><a href=\"loginForm.jsp\" target=\"mainFrame\">login</a></li>");
}

%>

	<li><a href="main.html" target="mainFrame">Home</a></li>


	<li><a href="impressum.jsp" target="mainFrame">Impressum</a></li>
</ul>
</body>
</html>