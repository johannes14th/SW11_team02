<%@page import="ZipFolder.ChooseFilesForZip"%>
<%@page import="ZipFolder.ZipFolder"%>
<%@page import="fileHandler.FileHandler"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.File" %>

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

String username = (String)session.getAttribute("username");

username = "neuerTest";

//ChooseFilesForZip servTempl= new ChooseFilesForZip(FileHandler.getUserPath() + FileHandler.getSeparator() + "latex_templates");
ChooseFilesForZip servTempl= new ChooseFilesForZip(FileHandler.getUserPath(username));

ArrayList<File> files = servTempl.getFiles();
ArrayList<File> chosenFiles = new ArrayList<File>();


String zipname = request.getParameter("zipname");

String[] values = request.getParameterValues("options");


if (values != null) {
    for (int i = 0; i < values.length; i++) 
    {
    	chosenFiles.add(files.get(Integer.valueOf(values[i])));
    }
}

servTempl.setChosenFiles(chosenFiles);

// TODO check if chosenFiles > 1
ZipFolder zipfolder = null;

if(zipname != null && chosenFiles.size() > 1) {
	zipfolder = new ZipFolder(FileHandler.getUserPath(username) + FileHandler.getSeparator()  + zipname, chosenFiles);
} else {
	out.println("Eingabe überprüfen! Mindestens zwei Files müssen gewählt sein");
}
// TODO FileDownload
if(zipfolder != null)
out.println("<a href=" + zipfolder.getFolder().getAbsolutePath() +">Download</a>");

//response.sendRedirect(FileHandler.getSystemPath() + FileHandler.getSeparator()  + "name2.zip");



%>

</body>
</html>