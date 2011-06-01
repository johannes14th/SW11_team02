<%@ page import="chooseTemplate.ChooseTemplate"%>
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

<h1>Your Files:</h1>
<form action = "delete.jsp" method = "post">
<%
String[] extension = {".docx",".pdf",".xml"};

String username = (String)session.getAttribute("username");

out.println("<table><tr>");
for(int a = 0; a < extension.length; a++)
	out.println("<td>" + extension[a] + "</td>");
out.println("</tr><tr>");

for(int a = 0; a < extension.length; a++)
{
	ChooseTemplate servTempl= new ChooseTemplate(FileHandler.getUserPath(username),extension[a]);
	servTempl.getTemplateNames();
	out.println("<td><table>");	
	for(int i = 0; i < servTempl.getSize(); i++)
	{
	  //out.println("<tr>");
	  //for(int b = 0; b < a ; b++)
		  //out.println("<td></td>");
	  out.println("<tr><td><input type='radio' name='delete' value='"+ servTempl.getTemplateName(i) +"'>"
			  + servTempl.getTemplateName(i) + "</td></tr>");
	}
	out.println("</table></td>");
}
%>
  </tr>
  
  <tr><td><input type="submit" name="button" value="delete" /></td>
  </tr>
  </table>
</form>


<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>