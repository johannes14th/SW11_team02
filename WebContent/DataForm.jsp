<%@ page import="gui.DataForm" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function validateForm()
{
var x=document.forms["DataForm"]["Filename"].value
if (x==null || x=="")
  {
  alert("Filename must filled out!");
  return false;
  }
}

</script>

</head>
<body>

<form name = "DataForm" action = "InsertData.jsp" method = "post" onSubmit="return validateForm()">
<table>
<%

DataForm data = new DataForm(application.getRealPath("test.tex"));

out.println("<tr><td><b>Metadata</b></td></tr>");

for(String meta : data.getMetadata()) {
	String metaData = "";
	
	if(request.getParameter(meta) != null)
		metaData = request.getParameter(meta);
	
	out.println("<tr><td>"+meta +":</td><td>" + "<input type=\"text\" name=\"" + meta + "\" value=\"" + metaData  +  "\" />" + "</td></tr>");
	
}

out.println("<tr><td>&nbsp</td></tr>");

out.println("<tr><td><b>Variables</b></td></tr>");
for(String entry : data.getVars() ) {
	
	String parameter = "";
	
	if(request.getParameter(entry) != null)
		parameter = request.getParameter(entry);
	
	out.println("<tr><td>"+entry +":</td><td>" + "<input type=\"text\" name=\"" + entry + "\" value=\"" + parameter  +  "\" />" + "</td></tr>");
}

%>
<tr><td><input type = "hidden" name="inputfilename" value="test.tex" /></td></tr>
<tr><td><input type="submit" name="button" value="submit" /></td></tr>
</table>
</form>

</body>
</html>