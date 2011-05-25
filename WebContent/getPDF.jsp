<%@page import="javax.naming.Context"%>
<%@ page import = "CreateTemplate.Template" %>
<%@ page import = "editTemplate.Data" %>
<%@ page import = "pdfCreator.CreatorPdf" %>
<%@ page import = "de.nixosoft.jlr.JLRGenerator" %>
<%@ page import = "java.io.File" %>

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

String delete = request.getParameter("delete");

if(delete != "" && delete != null && delete.equals("1")) {
	out.println("<font color=\"green\">File successfully deleted!</font>");
} else {
	String filename = request.getParameter("filename");
	String directory = request.getParameter("directory");
	String username = (String)session.getAttribute("username");
	
	CreatorPdf creator = new CreatorPdf(directory);
	
	File pdf;
	
	if(username != "")
		pdf = creator.createPdf(filename,username);
	else
		pdf = creator.createPdf(filename,"");
	
	out.println("<form action=\"deleteFile.jsp\" method=\"post\">");
	out.println("<table>");
	out.println("<tr><td>PDF Successfully created: <a href=\"" + pdf.getAbsolutePath() + "\">"+ pdf.getName() + "</a></td>" );
	out.println("<td><input type=\"hidden\" name=\"path\" value=\"" + pdf.getAbsolutePath() +"\"></td>");
	out.println("<td><input type=\"submit\" value=\"delete\"></td>");
	out.println("</table>");
	out.println("</form>");
}
%>

</body>
</html>