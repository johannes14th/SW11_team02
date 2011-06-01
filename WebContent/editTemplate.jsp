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

Bearbeiten Sie Ihre Dokumente!<br> W�hlen Sie dazu die gew�nschte Datei!

</div>

<table>
<tr><td>&nbsp</td></tr>
<tr><td><img alt="" src="images/bearbeiten.jpg" width="100"></td><td>&nbsp;&nbsp;</td><td valign="middle"><font size="6px">Dokument bearbeiten</font></td></tr>
<tr><td>&nbsp</td></tr>
<tr><td>&nbsp</td></tr>
</table>

<table>
<tr>
<td> W�hlen Sie das Dokument: </td>
<td>
<form>

  <select name=file_name>
<%
ChooseTemplate servTempl= new ChooseTemplate(FileHandler.getSystemPath(),".tex");

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
  <input type="submit" name="button" value="�ffnen" />
  <input type="submit" name="button" onclick="redirect()" value="Abbrechen" />
</form>

        
 <% 
 String file_name = request.getParameter("file_name");

 if(request.getParameter("button") != null && request.getParameter("button").equals("Abbrechen"))
 	response.sendRedirect("templateAssistant.jsp");
 
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

</td>
</tr>
</table>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>
</body>
</html>