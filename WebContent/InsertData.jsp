<%@page import="java.io.File"%>
<%@page import="fileHandler.FileHandler"%>
<%@ page import="gui.DataForm" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pdfCreator.CreatorPdf" %>
<%@ page import="de.nixosoft.jlr.JLRConverter" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="webtexter.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="wrapper">
<jsp:include page="banner.jsp"></jsp:include>
<jsp:include page="contentBegin.jsp"></jsp:include>
<table>
<%

String inputfilename = request.getParameter("inputfilename");
String username = (String)session.getAttribute("username");

DataForm data;

//if(username != "")
//	data = new DataForm(FileHandler.getUserPath(username).concat(File.separator + inputfilename));
//else
	data = new DataForm(application.getRealPath(inputfilename));

String author = request.getParameter("Author");

String newfilename = request.getParameter("Filename");

String file;
if(newfilename != "")
  file = request.getParameter("Filename");
else {
  file = "out_"+inputfilename;
}

out.println("<tr><td><b>Metadata</b></td></tr>");

for(String meta : data.getMetadata()) {
	if(meta.equalsIgnoreCase("filename")) {
		if(request.getParameter(meta) != null)
			out.println("<tr><td>"+meta +":</td><td>" + file + "</td></tr>");
	} else {
	  out.println("<tr><td>"+meta +":</td><td>" + request.getParameter(meta) + "</td></tr>");
	}
}

out.println("<tr><td>&nbsp</td></tr>");

out.println("<tr><td><b>Variables</b></td></tr>");

List<String> values = new ArrayList<String>();
for(String entry : data.getVars() ) {
	values.add(request.getParameter(entry));
	out.println("<tr><td>"+entry +":</td><td>" + request.getParameter(entry) + "</td></tr>");
}

String directory;

if(username != "")
	directory = FileHandler.getUserPath(username);
else
	directory = application.getRealPath(inputfilename).substring(0,application.getRealPath(inputfilename).lastIndexOf("\\"));

String outputFile;
if(newfilename != "") {
	outputFile = directory + "\\" +  newfilename;
} else {
	outputFile = directory + "\\out_" + inputfilename;
}

out.println("<tr><td>&nbsp</td></tr>");
out.println("</table>");

System.out.println("LISTENGRÖSSE: " + values.size());
System.out.println("LISTENGRÖSSE - HANDLE: " + data.getHandle().getLatexVariables().size());


if(data.getHandle().insertData(values, outputFile) == true) {
	out.println("<table>");
	out.println("<tr><td colspan=\"2\"><font color=\"green\">File successfully created!</font></td></tr>");
	out.println("<tr><td colspan=\"2\"><b>Path: </b>"+outputFile+"</td></tr>");
	
	out.println("<form action=\"getPDF.jsp\" method =\"post\">");
	out.println("<input type=\"hidden\" name=\"directory\" value=\"" + directory + "\">");
	out.println("<input type=\"hidden\" name=\"filename\" value=\"" + newfilename + "\">");
	out.println("<input type=\"submit\" value=\"createPdf\">");
	out.println("</form>");
	out.println("</table>");

	
} else {
	out.println("<table>");
	out.println("<tr><td colspan=\"2\"><font color=\"red\">File not successfully created!</font></td></tr>");
	out.println("</table>");
}

if(data.getHandle().insertMetaData(author, System.currentTimeMillis()) == true) {
	//out.println("successMD");
} else {
	//out.println("failMD");
}



%>
</table>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>