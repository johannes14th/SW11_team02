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
	var pwd = document.forms["loginForm"]["pwd"].value;
	var username = document.forms["loginForm"]["username"].value;
	
	if(username == "") {
		alert("Please enter a username");
		return false;
	}
	
	if (pwd == "") {
  		alert("Please enter a password");
  		return false;
	}

  
}

</script>

</head>
<body>

<div id="wrapper">
<jsp:include page="banner.jsp"></jsp:include>
<jsp:include page="contentBegin.jsp"></jsp:include>

<form action="checkLogin.jsp" method= "post" name="loginForm" onSubmit="return checkForm()">
<table>
<tr><td>Username: </td><td><input type="text" name="username"></td></tr>
<tr><td>Password: </td><td><input type="password" name="pwd"></td></tr>
<tr><td colspan=2><input type="submit" value="login"></td></tr>
</table>

</form>

<%
String error = request.getParameter("error");

if(error != "" && error != null) {
	if(error.equals("1")) {
		out.println("<font color=\"red\">Username doesn't exist!</font>");
	} else if(error.equals("2")) {
		out.println("<font color=\"red\">Wrong password!</font>");
	}
}

%>

<jsp:include page="contentEnd.jsp"></jsp:include>

</div>
</body>
</html>