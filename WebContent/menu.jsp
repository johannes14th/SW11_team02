<%
String status = (String) session.getAttribute("loginstatus");

boolean loggedIn = false;

if(status != "" && status != null) {
	
	System.out.println(status);
	
	if(status.equals("true"))
		loggedIn = true;
}

%>


<table border=0 width=100%>
				
					
					<%
						if(loggedIn) {
							out.println("<tr>");
							out.println("<td align=left>");
							out.println("<table>");
							out.println("<tr>");
							out.println("<td>");
							out.println("| <a href=\"main.jsp\">Home</a> |");
							out.println("<a href=\"intern.jsp\">Intern</a> |");
							out.println("<a href=\"chooseTemplate.jsp\">Template Assistant</a> |");
							out.println("<a href=\"createNewTemplate.jsp\">Create Template</a> |");
							out.println("<a href=\"editTemplate.jsp\">Edit Template</a> |");
							out.println("<a href=\"logout.jsp\">Logout</a> |");
							out.println("<a href=\"impressum.jsp\">Impressum</a> |");
							out.println("</td>");
							out.println("</tr>");
							out.println("</table>");							
							out.println("</td>");
							out.println("</tr>");							
						} else {

							out.println("<tr>");
							out.println("<td align=left>");
							out.println("<table>");
							out.println("<tr>");
							out.println("<td>| <a href=\"main.jsp\">Home</a> |</td>");
							out.println("<td> <a href=\"login.jsp\">Register</a> |</td>");
							out.println("<td> <a href=\"impressum.jsp\">Impressum</a> |</td>");
							out.println("</tr>");
							out.println("</table>");
							out.println("</td>");
					  		out.println("<td align=\"left\">");
							out.println("<table>");
							out.println("<tr>");
							out.println("<form action=\"checkLogin.jsp\" method= \"post\" name=\"loginForm\" onSubmit=\"return checkForm()\">");
							out.println("<td>Username: </td><td><input type=\"text\" name=\"username\"></td>");
							out.println("<td>Password: </td><td><input type=\"password\" name=\"pwd\"></td>");
							out.println("<td colspan=2><input type=\"submit\" value=\"login\"></td>");
							out.println("</form>");
							out.println("</tr>");
							out.println("</table>");
							out.println("</td>");
							out.println("</tr>");

						}
					%>

</table>

