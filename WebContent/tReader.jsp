<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="editTemplate.Data" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Data x = new Data("latex1.tex");
%>
<jsp:useBean id="formtext" class="editTemplate.Data" scope="session" />
<%
x.setInput(request.getParameter("input"));
%>
<jsp:setProperty name="formtext" property="input" />
<FORM METHOD=POST ACTION="tReader.jsp">
Edit the Template: <br><textarea NAME=input size=20 rows="15" cols="60" wrap="physical"
value=<jsp:getProperty name="formtext" property="input"/>><jsp:getProperty name="formtext" property="input" /></textarea><BR>
<P><INPUT TYPE=SUBMIT VALUE="Save">
</FORM>
<jsp:getProperty name="formtext" property="saved" />

</body>
</html>