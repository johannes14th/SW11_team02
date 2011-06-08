<%@ page import="chooseTemplate.ChooseTemplate"%>
<%@ page import="fileHandler.FileHandler" %>
<%@ page import="translator.Translator" %>
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

<%
String username = (String)session.getAttribute("username");
%>

<div id="infobox" style="top: 200px; left: 500px;">
<table border=0>
<tr height=80><td><%= Translator.getMessage("create_info",username) %></td></tr>
<tr><td>&nbsp;</td></tr>
<tr height="100"><td><%= Translator.getMessage("edit_info",username) %></td></tr>
<tr><td>&nbsp;</td></tr>
<tr height="100"><td><%= Translator.getMessage("generate_info",username) %></td></tr>
<tr><td>&nbsp;</td></tr>
</table>

</div>

<h1><%= Translator.getMessage("DocAssist",username) %> </h1>


<table border=0>
<tr><td colspan=3>&nbsp;</td></tr>
<tr><td><img alt="" src="images/erstellen.jpg" width="100"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a style="text-decoration: none;" href="createNewTemplate.jsp"><font size="6px"><%= Translator.getMessage("create",username)%></font></h1></a></td></tr>
<tr><td colspan=3><font size="1px">&nbsp;</font></td></tr>
<tr><td><img alt="" src="images/bearbeiten.jpg" width="100"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a style="text-decoration: none;"href="editTemplate.jsp"><font size="6px"><%= Translator.getMessage("edit",username) %></font></a></td></tr>
<tr><td colspan=3><font size="1px">&nbsp;</font></td></tr>
<tr><td><img alt="" src="images/fertigstellen.jpg" width="100"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a style="text-decoration: none;"href="chooseTemplate.jsp"><font size="6px"><%= Translator.getMessage("generate",username) %></font></a></td></tr>
<tr><td colspan=3>&nbsp;</td></tr>
</table>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>