<%@page import="chooseTemplate.ChooseTemplate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebTEXter</title>
</head>
<body>

<h1>Choose Template:</h1>


<form>

  <select name=file_name>
<%
ChooseTemplate servTempl= new ChooseTemplate("data//server_templates",".tex");

servTempl.getTemplateNames();

for(int i = 0; i < servTempl.getSize(); i++)
{
  out.println("<option>" + servTempl.getTemplateName(i) + "</OPTION>") ;
}
%>
  </select>
  
  <input type="submit" name="button" value="open" />
</form>

        
 <% 
 String file_name = request.getParameter("file_name");
 out.println(file_name);
 servTempl.setFileName(file_name);
 %>




</body>
</html>