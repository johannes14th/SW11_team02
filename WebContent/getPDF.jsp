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

String filename = request.getParameter("filename");
String directory = request.getParameter("directory");

out.println("FILE: " + filename + "<br>");
out.println("DIR: " + directory);

CreatorPdf creator = new CreatorPdf(directory);
File pdf = creator.createPdf(filename);

%>
</body>
</html>