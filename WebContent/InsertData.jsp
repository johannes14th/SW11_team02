<%@ page import="gui.DataForm" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String filename = request.getParameter("filename");

DataForm data = new DataForm(application.getRealPath(filename));
List<String> values = new ArrayList<String>();
for(String entry : data.getVars() ) {
	values.add(request.getParameter(entry));
	out.println(entry +": " + request.getParameter(entry) + "<br>");
}

String directory = application.getRealPath(filename).substring(0,application.getRealPath(filename).lastIndexOf("\\"));
String outputFile = directory + "out.tex";
data.getHandle().insertData(values, outputFile);

%>


</body>
</html>