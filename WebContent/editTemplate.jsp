<%@page import="chooseTemplate.ChooseTemplate"%>
<%@page import="CreateTemplate.Template"%>
<%@ page import="fileHandler.FileHandler" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebTEXter</title>
<link href="webtexter.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="wrapper">
<jsp:include page="banner.jsp"></jsp:include>
<jsp:include page="contentBegin.jsp"></jsp:include>
<h1>Edit Template:</h1>
<form>

  <select name=file_name>
<%
String username = (String)session.getAttribute("username");

ChooseTemplate servTempl= new ChooseTemplate(FileHandler.getUserPath(username),".tex");

servTempl.getTemplateNames();

for(int i = 0; i < servTempl.getSize(); i++) {
  out.println("<option>" + servTempl.getTemplateName(i) + "</OPTION>") ;
}
%>
  </select>
  
  <input type="submit" name="button" value="open" />
</form>

        
 <% 
 String file_name = request.getParameter("file_name");
 servTempl.setFileName(file_name);
 
 if(file_name != "" && file_name != null) {
 	String realPath = FileHandler.getSystemPath() + "/" + file_name;
 	Template template = new Template(realPath);
 	String content = template.getContent();
 
 	out.println("<table>");
 	out.println("<tr><td><b>Content:</b></td></tr>");
 	out.println("<form action =\"saveTemplate.jsp\" method=\"post\">");
 	out.println("<tr><td><textarea name=\"input\" size=\"20\" rows=\"15\" cols=\"60\" wrap=\"physical\" value=\""+ content + "\">" + content + "</textarea></td></tr>");
 	out.println("<input type=\"hidden\" name=\"filename\" value=\"" + file_name + "\"</input>" );
 	out.println("<tr><td><input type=\"submit\" name=\"button\" value=\"save\" /></td></tr>");
 	out.println("</form>");
 	out.println("</table>");
 }
 
 %>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>
</body>
</html>