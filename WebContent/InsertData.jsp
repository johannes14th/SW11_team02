<%@ page import="java.io.File"%>
<%@ page import="genTex.GenTeX"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="pdfCreator.CreatorPdf" %>
<%@ page import="fileHandler.FileHandler" %>
<%@ page import="handleXML.HandleXML" %>
<%@ page import="genDocx.GenDocX" %>


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
String button = request.getParameter("button");
String username = (String)session.getAttribute("username");
String filename = request.getParameter("filename");

File xml = new File(FileHandler.getSystemPath() + "/latex_templates/test.xml");
HandleXML handler = new HandleXML(xml);
GenDocX docxGenerator = new GenDocX(xml);
GenTeX texGenerator = new GenTeX(xml); 

out.println("<tr><td><b>Metadata</b></td></tr>");

HashMap<String, String> metadata = new HashMap<String, String>();
for(String meta : handler.getMetaData()) {
	metadata.put(meta, request.getParameter(meta));
	out.println("<tr><td>"+meta +":</td><td>" + request.getParameter(meta) + "</td></tr>");
}

out.println("<tr><td>&nbsp</td></tr>");

out.println("<tr><td><b>Variables</b></td></tr>");



HashMap<String, String> values = new HashMap<String, String>();
for(String entry : handler.getVarList() ) {
	values.put(entry, request.getParameter(entry));
	out.println("<tr><td>"+entry +":</td><td>" + request.getParameter(entry) + "</td></tr>");
}

out.println("<tr><td>&nbsp</td></tr>");
out.println("</table>");



boolean fileCreate = false;

if(button.equals("DOCX")) {
	if(docxGenerator.generateDocX(values, metadata,username) == true) {
		
		if(!filename.contains(".docx"))
			filename += ".docx";
		
		String name = "users/" + username + "/" + filename;
		
		out.println("<table>");
		out.println("<tr><td colspan=\"2\"><font color=\"green\">File successfully created!</font></td></tr>");
		out.println("<tr><td colspan=\"2\"><a href=\"" + name + "\">"+ filename + "</a></td></tr>");
		out.println("<tr><td colspan=\"2\"><b>Path: </b>"+ FileHandler.getSystemPath() +"</td></tr>");
		out.println("</table>");
		fileCreate = true;
	}
} else if(button.equals("TEX")) {
	if(texGenerator.generateTeX(values, metadata,username) == true) {
		if(!filename.contains(".tex"))
			filename += ".tex";
		
		String name = "users/" + username + "/" + filename;
		out.println("<table>");
		out.println("<tr><td colspan=\"2\"><font color=\"green\">File successfully created!</font></td></tr>");
		out.println("<tr><td colspan=\"2\"><a href=\"" + name + "\">"+ filename + "</a></td></tr>");
		out.println("<tr><td colspan=\"2\"><b>Path: </b>"+ FileHandler.getSystemPath() +"</td></tr>");
		out.println("</table>");
		fileCreate = true;
	}
} else {
	
	if(texGenerator.generateTeX(values, metadata,username) == true) {
	
		System.out.println("FP" + FileHandler.getUserPath(username) + "/" + filename);
		
		File pdf = new File(FileHandler.getUserPath(username) + File.separator + filename);
		
		CreatorPdf creator = new CreatorPdf(FileHandler.getUserPath(username));
	
		if(username != "") {
			out.println("username: " + username);
			pdf = creator.createPdf(filename,username);
		}
		else
			pdf = creator.createPdf(filename,"");
		
		if(!filename.contains(".pdf"))
			filename += ".pdf";
		
		String name = "users/" + username + "/" + filename;
		
		out.println("<form action=\"deleteFile.jsp\" method=\"post\">");
		out.println("<table>");
		out.println("<tr><td>PDF Successfully created: <a href=\"" + name + "\" target=\"_blank\">"+ pdf.getName() + "</a></td>" );
		out.println("<td><input type=\"hidden\" name=\"path\" value=\"" + pdf.getAbsolutePath() +"\"></td>");
		out.println("<td><input type=\"submit\" value=\"delete\"></td>");
		out.println("</table>");
		out.println("</form>");
		fileCreate = true;
	}


}

if(!fileCreate) {
	out.println("<table>");
	out.println("<tr><td colspan=\"2\"><font color=\"red\">File not successfully created!</font></td></tr>");
	out.println("</table>");
}

%>
</table>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>

</body>
</html>