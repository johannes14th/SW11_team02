<%@ page import="gui.DataForm" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "InsertData.jsp" method = post>
<%

DataForm data = new DataForm(application.getRealPath("test.tex"));

out.println("<p> METADATA: <br />");
if(data.getMetadata().size() > 0) {
	out.println("Filename: " + "<input type=\"text\" name=\"" + "filename" + "\" />" + "<br>");
}
if(data.getMetadata().size() > 1) {
	out.println("Author: " + "<input type=\"text\" name=\"" + "author" + "\" />" + "<br>");
}

out.println("</p>");

out.println("<p> Variables: <br />");
for(String entry : data.getVars() ) {
	out.println(entry +": " + "<input type=\"text\" name=\"" + entry + "\" />" + "<br>");
}
out.println("</p>");

%>
<br>
  <input type = "hidden" name="inputfilename" value="test.tex" />
  <input type="submit" name="button" value="submit" />
</form>

</body>
</html>