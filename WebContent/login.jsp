 <%@ page import="database.HandleDatabase" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="webtexter.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function checkForm() {
	var pwd1 = document.forms["loginForm"]["pwd"].value;
	var pwd2 = document.forms["loginForm"]["pwd2"].value;
	var username = document.forms["loginForm"]["username"].value;

	if (!(pwd1 == pwd2) || pwd1 == "" || pwd2 == "" ) {
  		alert("Please enter the same password");
  		return false;
	}
	
	if(username == "") {
		alert("Please enter a username");
		return false;
	}
  
}

</script>

</head>
<body>
<div id="wrapper">
	<jsp:include page="banner.jsp"></jsp:include>
	<jsp:include page="contentBegin.jsp"></jsp:include>

<form action = "login.jsp" method = "post" name = "loginForm" onSubmit="return checkForm()">
<table>
<tr><td colspan="2"><b>Create a new User Account</b></td></tr>
<tr><td colspan="2">&nbsp</td></tr>
<tr><td>Username: </td><td><input type ="text" name="username" value=""></td></tr>
<tr><td>Password: </td><td><input type = "password" name = "pwd" value=""></td></tr>
<tr><td>Confirm Password: </td><td><input type = "password" name = "pwd2" value=""></td></tr>
<tr><td colspan="2">&nbsp</td></tr>
<input type = "hidden" name="dbaction" value="create">
<tr><td>&nbsp</td><td align="right"><input type = "submit" value="Cancel"><input type = "submit" value="Create"></td></tr>

</table>

</form>

<%


String parameter = request.getParameter("dbaction");
String username = request.getParameter("username");
String pwd = request.getParameter("pwd");

if(parameter == null)
	parameter = "";

if(parameter.equalsIgnoreCase("create")) {
	
	HandleDatabase handler = new HandleDatabase();
	
	if(!handler.databaseHasEntry(username)) {
	  handler.createAccount(username,pwd,"de");
	  if(handler.databaseHasEntry(username)) {
		  out.println("Account successfully created!");
	  } else {
		  out.println("Error in Creating account!");
	  }
	} else {
		out.println("Username already in use!");
	}
	
}

%>
	<jsp:include page="contentEnd.jsp"></jsp:include>
</div>
</body>
</html>