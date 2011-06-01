<%@ page import = "java.io.File" %>
<%@ page import="fileHandler.FileHandler" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String filename = request.getParameter("delete");
String username = (String)session.getAttribute("username");
String path = FileHandler.getUserPath(username);
File file = new File(path + FileHandler.getSeparator()+ filename);
file.delete();
response.sendRedirect("showFile.jsp");
%>
