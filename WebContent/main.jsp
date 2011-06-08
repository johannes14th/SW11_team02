<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "translator.Translator" %>
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
<h1>
<%
//int userid = (int)session.getAttribute("userid");
//System.out.print(Translator.getMessage("welcome",userid));
%></h1>

<jsp:include page="contentEnd.jsp"></jsp:include>


</div>

</body>
</html>