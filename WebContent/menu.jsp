 <%@ page import = "translator.Translator" %>

<%
String status = (String) session.getAttribute("loginstatus");

boolean loggedIn = false;

if(status != "" && status != null) {
	
	System.out.println(status);
	
	if(status.equals("true"))
		loggedIn = true;
}

%>


<table border=0  width=100%>
				
					
					<%
					String username = (String)session.getAttribute("username");
					
						if(loggedIn) {
							out.println("<tr>");
							out.println("<td align=left>");
							out.println("<table>");
							out.println("<tr>");
							out.println("<td>");
							out.println("<a href=\"main.jsp\">"+Translator.getMessage("Home",username)+"</a> |");
							out.println("<a href=\"intern.jsp\">"+Translator.getMessage("My",username)+"</a> |");
							out.println("<a href=\"templateAssistant.jsp\">" +Translator.getMessage("DocAssist",username)+"</a> |");
							out.println("<a href=\"logout.jsp\">Logout</a> |");
							out.println("<a href=\"impressum.jsp\">Impressum</a> |");
							out.println("<a href=\"showFile.jsp\">MyFiles</a> |");
							out.println("</td>");
							out.println("</tr>");
							out.println("</table>");							
							out.println("</td>");
							out.println("</tr>");							
						} else {

							out.println("<tr>");
							out.println("<td align=left>");
							out.println("<table>");
							out.println("<tr><td>&nbsp;</td></tr><tr>");
							out.println("<td><a href=\"main.jsp\">Startseite</a> |</td>");
							out.println("<td> <a href=\"login.jsp\">Registrieren</a> |</td>");
							out.println("<td> <a href=\"impressum.jsp\">Impressum</a></td>");
							out.println("</tr>");
							out.println("</table>");
							out.println("</td>");
					  		out.println("<td align=\"right\">");
							out.println("<table border=0>");
							out.println("<tr>");
							out.println("<form action=\"checkLogin.jsp\" method= \"post\" name=\"loginForm\" onSubmit=\"return checkForm()\">");
							out.println("<td>Benutzername: </td><td><input type=\"text\" name=\"username\"></td></tr><tr>");
							out.println("<td>Passwort: </td><td><input type=\"password\" name=\"pwd\"></td>");
							out.println("<td colspan=2><input type=\"submit\" value=\"Login\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
							out.println("</form>");
							out.println("</tr>");
							out.println("</table>");
							out.println("</td>");
							out.println("</tr>");

						}
					%>

</table>

