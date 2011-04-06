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

for(String entry : data.getVars() ) {
	out.println(entry +": " + "<input type=\"text\" name=\"" + entry + "\" />" + "<br>");
}

%>
<br>
  <input type = "hidden" name="filename" value="test.tex" />
  <input type="submit" name="button" value="submit" />
</form>

</body>
</html>