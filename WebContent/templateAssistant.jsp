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

<div id="infobox" style="top: 200px; left: 500px;">
<table border=0>
<tr height=80><td>Erstellen Sie neue Dokumente!</td></tr>
<tr><td>&nbsp;</td></tr>
<tr height="100"><td>Bearbeiten Sie bestehende Dokumente!</td></tr>
<tr><td>&nbsp;</td></tr>
<tr height="100"><td>Erzeugen Sie das fertige Dokument!</td></tr>
<tr><td>&nbsp;</td></tr>
</table>

</div>

<h1>Dokumentenassistent</h1>


<table border=0>
<tr><td colspan=3>&nbsp;</td></tr>
<tr><td><img alt="" src="images/erstellen.jpg" width="100"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a style="text-decoration: none;" href="createNewTemplate.jsp"><font size="6px">Erstellen</font></h1></a></td></tr>
<tr><td colspan=3><font size="1px">&nbsp;</font></td></tr>
<tr><td><img alt="" src="images/bearbeiten.jpg" width="100"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a style="text-decoration: none;"href="editTemplate.jsp"><font size="6px">Bearbeiten</font></a></td></tr>
<tr><td colspan=3><font size="1px">&nbsp;</font></td></tr>
<tr><td><img alt="" src="images/fertigstellen.jpg" width="100"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td><a style="text-decoration: none;"href="chooseTemplate.jsp"><font size="6px">Fertig stellen</font></a></td></tr>
<tr><td colspan=3>&nbsp;</td></tr>
</table>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>