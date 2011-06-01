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

<h1>Anpassen</h1>

<form action = "DataForm.jsp" method = "post">


<%

out.println("<table>");
out.println("<tr><td>System Templates : </td><td>  <select name=file_name>");

ChooseTemplate servTempl= new ChooseTemplate(FileHandler.getTemplatePath(),".tex");

servTempl.getTemplateNames();

for(int i = 0; i < servTempl.getSize(); i++)
{
  out.println("<option>" + servTempl.getTemplateName(i) + "</OPTION>") ;
}
%>
  </select></td>
  
  <td><input type="submit" name="button" value="open" /></td>
  </tr>
  </table>
</form>

<form action = "DataForm.jsp" method = "post">


<%
String username = (String)session.getAttribute("username");
out.println("<table>");
out.println("<tr><td>User Templates : </td><td><select name=file_name>");

servTempl= new ChooseTemplate(FileHandler.getUserPath(username),".tex");

servTempl.getTemplateNames();

for(int i = 0; i < servTempl.getSize(); i++)
{
  out.println("<option>" + servTempl.getTemplateName(i) + "</OPTION>") ;
}
%>
  </select></td>
  
  <td><input type="submit" name="button" value="open" /></td>
  </tr>
  </table>
</form>

        
 <% 
 String file_name = request.getParameter("file_name");
 servTempl.setFileName(file_name);
 %>


<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>