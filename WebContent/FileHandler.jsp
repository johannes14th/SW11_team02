<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="fileHandler.FileHandler" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
//String seperator = System.getProperty("file.separator");
//String path = System.getProperty("wtp.deploy") + seperator + "WebTEXter";
//System.out.println(FileHandler.getSystemPath());

System.out.println(FileHandler.getUserPath("David"));
System.out.println(FileHandler.getSystemPath());
%>


</body>
</html>