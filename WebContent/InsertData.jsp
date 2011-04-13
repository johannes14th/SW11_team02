<%@ page import="gui.DataForm" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="de.nixosoft.jlr.JLRConverter" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "CreateFileDialog.jsp" method = post>
<table>
<%

String inputfilename = request.getParameter("inputfilename");

DataForm data = new DataForm("C:\\Users\\johannes\\SW11\\test.tex");//(application.getRealPath(inputfilename));

String author = request.getParameter("author");
String newfilename = request.getParameter("filename");

List<String> values = new ArrayList<String>();
for(String entry : data.getVars() ) {
	values.add(request.getParameter(entry));
	out.println(entry +": " + request.getParameter(entry) + "<br>");
}

String directory = application.getRealPath(inputfilename).substring(0,application.getRealPath(inputfilename).lastIndexOf("\\"));

String outputFile;
if(newfilename != null) {
	outputFile = directory + "\\" +  newfilename;
} else {
	outputFile = directory + "\\out_" + inputfilename;
}

if(data.getHandle().insertData(values, outputFile) == true) {
	out.println("success");
} else {
	out.println("fail");
}

if(data.getHandle().insertMetaData(author, System.currentTimeMillis()) == true) {
	out.println("successMD");
} else {
	out.println("failMD");
}


out.println("<tr><td><input type = \"hidden\" name=\"tmpFilename\" value=\"" + outputFile + "\" /></td></tr>");

%>

<tr><td><input type="submit" name="button" value="save" /></td></tr>
  </table>
</form>


</body>
</html>