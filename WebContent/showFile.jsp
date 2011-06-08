<%@ page import="chooseTemplate.ChooseTemplate"%>
<%@ page import="fileHandler.FileHandler" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "translator.Translator" %>
<%@ page import = "database.HandleDatabase" %>
<%@ page import = "java.util.Vector" %>
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

<%
String username = (String)session.getAttribute("username");
%>
<script>
function checkPassword() {
		var pwd1 = document.forms["setPassword"]["pwd1"].value;
		var pwd2 = document.forms["setPassword"]["pwd2"].value;
	
		if (!(pwd1 == pwd2) || pwd1 == "" || pwd2 == "" ) {
	  		alert("Please enter the same password!");
	  		return false;
		}
}
</script>

<div id="infobox" style="top: 307px; left: 580px; width:350px;">
<%= Translator.getMessage("ProfileInfo1",username) %><br>
<%= Translator.getMessage("ProfileInfo2",username) %><br>
<%= Translator.getMessage("ProfileInfo3",username) %><br>
</div>


<table>
<tr><td>&nbsp</td></tr>
<tr><td><img alt="" src="images/profile.jpg" width="100"></td><td>&nbsp;&nbsp;</td><td valign="middle"><font size="6px"><%= Translator.getMessage("Profile",username) %></font></td></tr>
<tr><td>&nbsp</td></tr>
<tr><td>&nbsp</td></tr>
</table>

<font size="6px"><%= Translator.getMessage("PersonalSettings",username) %>:</font>
<p></p>
<br>
<form action = "setLanguage.jsp" method = "post">
<table>
<tr><td>Choose language:</td><td>&nbsp;
<select name="language">
      <option value="de" selected>Deutsch</option>
      <option value="en">English</option>
</select></td></tr>
</table>
<p></p>
<input type="submit" name="savelang" value="<%= Translator.getMessage("SaveLanguage",username) %>"/>
</form>

<form action = "showFile.jsp" name="setPassword" method = "post" onSubmit = "return checkPassword()">
<br>
<p></p>
<table>
<tr><td><b><%= Translator.getMessage("ChangePassword",username) %></b></td><td></td>
<tr><td></td>
<tr><td><%= Translator.getMessage("NewPassword",username) %>: </td><td>&nbsp;<input type = "password" name = "pwd1" value=""></td></tr>
<tr><td><%= Translator.getMessage("ConfirmNewPassword",username) %>:</td><td>&nbsp;<input type = "password" name = "pwd2" value=""></td></tr>
</table>
<p></p>
<input type = "hidden" name="action" value="savePW">
<input type="submit" name="pwsave" value="<%= Translator.getMessage("SavePassword",username) %>"/>
</form>

<%
String parameter = request.getParameter("action");
String pwd1 = request.getParameter("pwd1");

if(parameter == null)
	parameter = "";

if(parameter.equalsIgnoreCase("savePW")) {
	HandleDatabase handler = new HandleDatabase();
	handler.setPassword(username,pwd1);
	
	out.println("<font color=\"green\">"+Translator.getMessage("ConfirmNewPassword",username)+"</font>");
}
%>

<p></p>
<br>
<font size="6px"><%= Translator.getMessage("MyFiles",username) %>:</font>
<p></p>
<br>

<form action = "delete.jsp" method = "post">
<%
String[] extension = {".docx",".pdf",".xml"};

//String username = (String)session.getAttribute("username");

out.println("<table border=\"1\">");  
out.println("<colgroup>");
out.println("<col width=\"250\">");
out.println("<col width=\"250\">");
out.println("<col width=\"250\">");
out.println("</colgroup><tr>");


out.println("<td align=center>" + "MS Word "+Translator.getMessage("Documents",username) + "</td>");
out.println("<td align=center>" + "PDF " + Translator.getMessage("Documents",username) + "</td>");
out.println("<td align=center>" + "XML " + Translator.getMessage("Documents",username) + "</td>");
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
  

  </table>
  <br>
  <input type="submit" name="button" value="     <%= Translator.getMessage("Delete",username) %>     "/>
</form>


<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>