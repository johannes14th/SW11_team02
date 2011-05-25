<%@page import="ZipFolder.ChooseFilesForZip"%>
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

<script type="text/javascript">
function checkForm() {
	var zipname = document.forms["zipForm"]["zipname"].value;
	
	if(zipname == "") {
		alert("Please enter a name for the zip");
		return false;
	}
  
}

</script>

</head>
<body>

<form action = "downloadZip.jsp" method = "post" name="zipForm" onSubmit="return checkForm()">

<%

String username = (String)session.getAttribute("username");
username = "neuerTest";

//ChooseFilesForZip servTempl= new ChooseFilesForZip(FileHandler.getSystemPath() + FileHandler.getSeparator() + "latex_templates");
ChooseFilesForZip servTempl= new ChooseFilesForZip(FileHandler.getUserPath(username));

ArrayList<File> files = servTempl.getFiles();

out.println("<table>");

for(int i = 0; i < files.size(); i++)
{
  out.println("<tr><td><input name=\"options\" type=\"checkbox\" value=" + i + ">" + files.get(i).getName() + "</input></td></tr>") ;
}

%>
<tr><td colspan="2">Name: <input type="text" name="zipname" /></td></tr>
<tr><td colspan="2"><input type="submit" name="button" value="zip files" /></td></tr>
</table>
</form>
</body>
</html>