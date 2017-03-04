<%
if(session.getAttribute("s_username") == null ){
	response.sendRedirect("login.jsp");    
}else{
	response.sendRedirect("customerList.jsp"); 	
}%>
<html>
<body>
<h2>Simple JDBC + Servlet!</h2>

<br/></br><a href="/readDataServlet">read tables</a>


</body>
</html>
