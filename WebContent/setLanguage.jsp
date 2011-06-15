<%@ page import="database.HandleDatabase" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String language = request.getParameter("language");
String username = (String)session.getAttribute("username");
HandleDatabase handler = new HandleDatabase();
handler.setLanguage(username,language);
response.sendRedirect("showFile.jsp");
%>