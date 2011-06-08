<%@	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import = "translator.Translator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="webtexter.css" rel="stylesheet" type="text/css" />

<%
String username = (String)session.getAttribute("username");
%>

<script type="text/javascript">

var test = 0;

function redirect() {
	window.location.href="templateAssistant.jsp";
	test=1;
}

function validateForm() {

	var x=document.forms["CheckFileDialog"]["filename"].value;


	if(test == 0) {
		if (x==null || x=="") {
  			alert("Templatename must filled out!");
  			return false;
 	 	}
	}
	
}

</script>

</head>
<body>
<div id="wrapper">
<jsp:include page="banner.jsp"></jsp:include>
<jsp:include page="contentBegin.jsp"></jsp:include>

<%
/*if(request.getParameter("tmpFilename") != null) {
	out.println("<h1>Create File:</h1>");
} else {
	out.println("<h1>Create Template:</h1>");
}*/



%>

<div id="infobox" style="top: 220px; left: 580px; width:350px;">

<%= Translator.getMessage("createTemplate_info",username) %> <br><br>

<i><%= Translator.getMessage("Warning",username) %>: </i> <%= Translator.getMessage("create_warning",username) %>
</div>

<table>
<tr><td>&nbsp</td></tr>
<tr><td><img alt="" src="images/erstellen.jpg" width="100"></td><td>&nbsp;&nbsp;</td><td valign="middle"><font size="6px"><%= Translator.getMessage("createDoc",username) %></font></td></tr>
<tr><td>&nbsp</td></tr>
<tr><td>&nbsp</td></tr>
</table>



<%
/*if(request.getParameter("tmpFilename") != null) {
  out.println("Filename:");
} else {
  out.println("Templatename:");	
}*/
%>
<form name="CheckFileDialog" action ="createTemplate.jsp" method="post" onSubmit = "return validateForm()">

<table>
<tr><td><%= Translator.getMessage("DocName",username) %>:&nbsp;&nbsp;&nbsp;</td>
<td>
  <input type="text" name="filename" />
  
  
  <%
  if(request.getParameter("tmpFilename") != null) {
	  out.println("<input type=\"text\" name=\"tmpFilename\" value=\""+ request.getParameter("tmpFilename") +"\">");
  }
  
  %>
  </td></tr>
  <tr>
  <td align="right" colspan=2>
  <input type="submit" name="button" value="<%= Translator.getMessage("create",username) %>" />
  <input type="submit" name="button" onclick="redirect()" value="<%= Translator.getMessage("Cancel",username) %>" /></td>
  </tr></table>
  </form>


<%
if(request.getParameter("message") != null)
	if(request.getParameter("message").equalsIgnoreCase("1"))
      out.println(Translator.getMessage("InsertFileName",username));

if(request.getParameter("message")!= null)
	out.println(request.getAttribute("message"));

%>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>