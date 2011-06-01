<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.File" %>
<%@ page import="handleXML.HandleXML" %>
<%@ page import="genDocx.GenDocX" %>
<%@ page import="pdfCreator.CreatorPdf" %>
<%@ page import="fileHandler.FileHandler" %>
<%@ page import="com.javadocx.CreateDocx" %>


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
File xml = new File(FileHandler.getSystemPath() + "/latex_templates/test.xml");
HandleXML handler = new HandleXML(xml);
GenDocX generator = new GenDocX(xml);

String author = request.getParameter("author");

//String newfilename = request.getParameter("filename");


//String file;
//if(newfilename != "")
//  file = request.getParameter("Filename");
//else {
//  file = "out_"+inputfilename;
//}

out.println("<tr><td><b>Metadata</b></td></tr>");

HashMap<String, String> metadata = new HashMap<String, String>();
for(String meta : handler.getMetaData()) {
	//if(meta.equalsIgnoreCase("filename")) {
		metadata.put(meta, request.getParameter(meta));
			//out.println("<tr><td>"+meta +":</td><td>" + file + "</td></tr>");
	//} else {
	 // out.println("<tr><td>"+meta +":</td><td>" + request.getParameter(meta) + "</td></tr>");
	//}
}

out.println("<tr><td>&nbsp</td></tr>");

out.println("<tr><td><b>Variables</b></td></tr>");

HashMap<String, String> values = new HashMap<String, String>();
for(String entry : handler.getVarList() ) {
	values.put(entry, request.getParameter(entry));
	out.println("<tr><td>"+entry +":</td><td>" + request.getParameter(entry) + "</td></tr>");
}

//String directory = application.getRealPath(inputfilename).substring(0,application.getRealPath(inputfilename).lastIndexOf("\\"));
String directory = FileHandler.getSystemPath();

//String outputFile;
//if(newfilename != "") {
//	outputFile = directory + "\\" +  newfilename;
//} else {
//	outputFile = directory + "\\out_" + inputfilename;
//s}

out.println("<tr><td>&nbsp</td></tr>");
out.println("</table>");

System.out.println("LISTENGRÖSSE: " + values.size());
//System.out.println("LISTENGRÖSSE - HANDLE: " + data.getHandle().getLatexVariables().size());


if(generator.generateDocX(values, metadata) == true) {
	out.println("<table>");
	out.println("<tr><td colspan=\"2\"><font color=\"green\">File successfully created!</font></td></tr>");
	out.println("<tr><td colspan=\"2\"><b>Path: </b>"+ FileHandler.getSystemPath() +"</td></tr>");
	
	out.println("<form action=\"getPDF.jsp\" method =\"post\">");
	out.println("<input type=\"hidden\" name=\"directory\" value=\"" + directory + "\">");
	//out.println("<input type=\"hidden\" name=\"filename\" value=\"" + newfilename + "\">");
	out.println("<input type=\"submit\" value=\"createPdf\">");
	out.println("</form>");
	out.println("</table>");

	
} else {
	out.println("<table>");
	out.println("<tr><td colspan=\"2\"><font color=\"red\">File not successfully created!</font></td></tr>");
	out.println("</table>");
}

//if(data.getHandle().insertMetaData(author, System.currentTimeMillis()) == true) {
	//out.println("successMD");
//} else {
	//out.println("failMD");
//}



%>
</table>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>