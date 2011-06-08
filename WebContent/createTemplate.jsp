<%@page import="javax.naming.Context"%>
<%@ page import = "CreateTemplate.Template" %>
<%@ page import = "fileHandler.FileHandler" %>
<%@ page import = "java.io.File" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="webtexter.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="wrapper">
<jsp:include page="banner.jsp"></jsp:include>
<jsp:include page="contentBegin.jsp"></jsp:include>

<%

String tmp = request.getParameter("filename");
String content = request.getParameter("input");
String dbaction = request.getParameter("dbaction");
String username = (String)session.getAttribute("username");

System.out.println("BUTTON: " + request.getParameter("button"));

String path = FileHandler.getUserPath(username) + File.separator + tmp;


if(request.getParameter("button").equals("Abbrechen"))
	response.sendRedirect("templateAssistant.jsp");

	Template template;
  	template = new Template(FileHandler.getUserPath(username),tmp);

out.println("<table>");
out.println("<tr><td><b>Edit Template:</b></td></tr>");
out.println("<form action =\"createTemplate.jsp\" method=\"post\">");
out.println("<tr><td><textarea name=\"input\" size=\"20\" rows=\"15\" cols=\"60\" wrap=\"physical\">"+template.getContent()+"</textarea></td></tr>");
out.println("<input type=\"hidden\" name=\"filename\" value=\"" + tmp + "\"</input>" );
out.println("<input type=\"hidden\" name=\"dbaction\" value=\"create\"</input>" );
out.println("<tr><td><input type=\"submit\" name=\"button\" value=\"save\" /></td></tr>");
out.println("</form>");

out.println("</table>");

if(dbaction != null)
if(dbaction.equals("create")) {
	if(template.isAllowedExtension(template.getExtension())) {
		template.createEmptyTemplate();
		template.setContent(content);
		if(template.isValid()) {
			out.println("<font color=\"green\">Template successfully created!<br><br></font>");
			out.println("<b>Filename:</b> "+template.getFilename());
		} else {
			out.println("<font color=\"red\">Template not created!<br><br></font>");
		}
	} else {
		out.println("No valid Extension!");
	}
}


%>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>
</body>
</html>