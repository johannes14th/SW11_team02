<%@page import="javax.naming.Context"%>
<%@ page import = "CreateTemplate.Template" %>
<%@ page import = "editTemplate.Data" %>

<%

String realPath = request.getParameter("filename");
String content = request.getParameter("input");

System.out.println(realPath);

Data data = new Data(realPath);

if(content != null)
	data.setInput(content);

String redirectURL = "editTemplate.jsp";
response.sendRedirect(redirectURL);

%>