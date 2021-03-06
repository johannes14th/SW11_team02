<%@page import="chooseTemplate.ChooseTemplate"%>
<%@page import="CreateTemplate.Template"%>
<%@ page import="fileHandler.FileHandler" %>
<%@ page import = "translator.Translator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebTEXter</title>
<link href="webtexter.css" rel="stylesheet" type="text/css" />
<%
String username = (String)session.getAttribute("username");
%>




<script type="text/javascript">

function redirect() {
	window.location.href="templateAssistant.jsp";
}

</script>

</head>
<body>

<div id="wrapper">
<jsp:include page="banner.jsp"></jsp:include>
<jsp:include page="contentBegin.jsp"></jsp:include>

<div id="infobox" style="top: 250px;">

<%= Translator.getMessage("editTemplate_info",username) %>

</div>

<table>
<tr><td>&nbsp</td></tr>
<tr><td><img alt="" src="images/bearbeiten.jpg" width="100"></td><td>&nbsp;&nbsp;</td><td valign="middle"><font size="6px"><%= Translator.getMessage("editDoc",username) %></font></td></tr>
<tr><td>&nbsp</td></tr>
<tr><td>&nbsp</td></tr>
</table>

<table>
<tr>
<td> <%= Translator.getMessage("chooseTemplate",username) %>: </td>
<td>
<form>

  <select name=file_name>
<%
//String username = (String)session.getAttribute("username");

ChooseTemplate servTempl= new ChooseTemplate(FileHandler.getUserPath(username),".xml");

servTempl.getTemplateNames();

for(int i = 0; i < servTempl.getSize(); i++) {
  out.println("<option>" + servTempl.getTemplateName(i) + "</OPTION>") ;
}
%>
  </select>
  </td></tr>
  <tr><td>&nbsp</td></tr>
  <tr>
  <td colspan=3 align=right>
  <input type="submit" name="button" value="<%= Translator.getMessage("Open",username) %>" />
  <input type="submit" name="button" onclick="redirect()" value="<%= Translator.getMessage("Cancel",username) %>" />
</form>

        
 <% 
 String file_name = request.getParameter("file_name");

 if(request.getParameter("button") != null && request.getParameter("button").equals(Translator.getMessage("Cancel",username)))
 	response.sendRedirect("templateAssistant.jsp");
 
 servTempl.setFileName(file_name);
 
 if(file_name != "" && file_name != null) {
 	String realPath = FileHandler.getUserPath(username) + "/" + file_name;
 	Template template = new Template(realPath);
 	String content = template.getContent();
 
 	out.println("<table>");
 	out.println("<tr><td><b>Content:</b></td></tr>");
 	out.println("<form action =\"saveTemplate.jsp\" method=\"post\">");
 	out.println("<tr><td><textarea name=\"input\" size=\"20\" rows=\"15\" cols=\"60\" wrap=\"physical\">" + content + "</textarea></td></tr>");
 	out.println("<input type=\"hidden\" name=\"filename\" value=\"" + realPath + "\"</input>" );
 	out.println("<tr><td><input type=\"submit\" name=\"button\" value=\"save\" /></td></tr>");
 	out.println("</form>");
 	out.println("</table>");
 }
 
 %>

</td>
</tr>
</table>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>
</body>
</html>