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
<h1>Willkommen bei WebTEXter!</h1>

<jsp:include page="contentEnd.jsp"></jsp:include>


</div>

</body>
</html>