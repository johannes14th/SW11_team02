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

out.println("<table>");
out.println("<tr><td><b>Edit Template:</b></td></tr>");
out.println("<form action =\"createTemplate.jsp\" method=\"post\">");
out.println("<tr><td><textarea name=\"input\" size=\"20\" rows=\"15\" cols=\"60\" wrap=\"physical\" value=\""+ data.getInput() + "\">" + data.getInput() + "</textarea></td></tr>");
out.println("<input type=\"hidden\" name=\"filename\" value=\"" + tmp + "\"</input>" );
out.println("<tr><td><input type=\"submit\" name=\"button\" value=\"save\" /></td></tr>");
out.println("</form>");

if(content != "")
	out.println("<tr><td>"+data.getSaved()+"</td></tr>");

out.println("</table>");

if(content == "") {
	Template template = new Template(application.getRealPath(tmp));
	if(template.isAllowedExtension(template.getExtension())) {
		template.createTemplate();
		out.println("<font color=\"green\">Template successfully created!<br><br></font>");
		out.println("<b>Filename:</b> "+template.getFilename());
		out.println("<br>");
		out.println("<b>Path: </b>"+application.getRealPath(tmp));
	} else {
		out.println("No valid Extension!");
	}
}


%>
</body>
</html>