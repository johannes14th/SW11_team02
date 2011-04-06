<%@page import="javax.naming.Context"%>
<%@ page import = "CreateTemplate.Template" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="createTemplate.jsp" method="post">Create File: 
  <input type="text" name="filename" />
  
  <br />
  <input type="submit" name="button" value="create" />
  
</form>
<%

String tmp = request.getParameter("filename");

Template template = new Template(application.getRealPath(tmp));
if(template.isAllowedExtension(template.getExtension())) {
	template.createTemplate();
	out.println("<b>Filename:</b> "+template.getFilename());
	out.println("<br>");
	out.println("<b>Path: </b>"+application.getRealPath(tmp));
} else {
	out.println("No valid Extension!");
}


%>
</body>
</html>