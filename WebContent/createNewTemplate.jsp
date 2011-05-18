<%@	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function validateForm()
{
var x=document.forms["CheckFileDialog"]["filename"].value
if (x==null || x=="")
  {
  alert("Templatename must filled out!");
  return false;
  }
}

</script>

</head>
<body>
<%
if(request.getParameter("tmpFilename") != null) {
	out.println("<h1>Create File:</h1>");
} else {
	out.println("<h1>Create Template:</h1>");
}

%>

<table>
<tr><td>Please take care of creating valid Latex files, with extension tex!</td></tr>

</table>


<form name="CheckFileDialog" action ="createTemplate.jsp" method="post" onSubmit = "return validateForm()">

<%
if(request.getParameter("tmpFilename") != null) {
  out.println("Filename:");
} else {
  out.println("Templatename:");	
}
%>

  <input type="text" name="filename" />
  
  <br />
  
  <%
  if(request.getParameter("tmpFilename") != null) {
	  out.println("<input type=\"text\" name=\"tmpFilename\" value=\""+ request.getParameter("tmpFilename") +"\">");
  }
  
  %>
  
  <input type="submit" name="button" value="create" />
  
</form>

<%
if(request.getParameter("message") != null)
	if(request.getParameter("message").equalsIgnoreCase("1"))
      out.println("Please insert a filename!");

if(request.getParameter("message")!= null)
	out.println(request.getAttribute("message"));

%>

</body>
</html>