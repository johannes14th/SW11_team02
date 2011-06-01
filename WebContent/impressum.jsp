<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Untitled Document</title>
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

<div id="logobox">
						<h1>Impressum</h1>
						<p><b>Super High Intelligent Technologies</b></p>
						<p>Inffeldgasse 25D Keller<br />
						8010 Graz</p>
						<p>Tel.: 0676 7499025</p>
</div>

<br>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/firmenlogo_big.png" alt="" />
<br>
<br>
	<jsp:include page="contentEnd.jsp"></jsp:include>
</div>
</body>
</html>