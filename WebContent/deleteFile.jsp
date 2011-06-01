
    <%@ page import = "java.io.File" %>


<%
String filepath = request.getParameter("path");
File file = new File(filepath);
file.delete();

response.sendRedirect("getPDF.jsp?delete=1");

%>
