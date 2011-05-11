<%@ page import="javax.naming.Context"%>
<%@ page import="pdfCreator.CreatorPdf"%>
<%@ page import="de.nixosoft.jlr.JLRConverter" %>

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
        %>

        <FORM  ACTION = "pdfCreate.jsp" NAME="form1" METHOD="POST"> 
        <INPUT TYPE="HIDDEN" VALUE="Create" NAME = "action">
            <INPUT TYPE="submit" VALUE="Button 1">
        </FORM>
        
        
        <%
        CreatorPdf create = new CreatorPdf();
        String action = request.getParameter("action");
        
        
         if(action.equals("Create") && action != null) {
             //out.println(action);
             if(create != null)
        		create.createPdf();
         }
        
        %>
        
        
<FORM>
<P><INPUT TYPE="BUTTON" NAME="red" VALUE="Red"
 ONCLICK='document.bgColor="red"'></P>
<P><INPUT TYPE="BUTTON" NAME="white" VALUE="White"
 ONCLICK='document.bgColor="white"'></P>
<P><INPUT TYPE="BUTTON" NAME="blue" VALUE="Blue"
 ONCLICK='document.bgColor="blue"'></P>
</FORM>





</body>
</html>