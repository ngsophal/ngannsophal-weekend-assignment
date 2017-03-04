<%
if(session.getAttribute("s_username") == null ){
	//response.sendRedirect("login.jsp");    
}else{
	response.sendRedirect("customerList.jsp"); 	
}%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="bg-black">
<head>
	<link rel="stylesheet" href="static/bootstrap/bootstrap-adapter/css/datatables.css">
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">	
    <title>Customer Management(Assignment) | Log in</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
         <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/AdminLTE.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In Form</title>
</head>

<body class="bg-black">

        <div class="form-box" id="login-box">
        	
            <div class="header"><h4 class="glyphicon glyphicon-user"></h4>&nbsp;&nbsp;SIGN IN</div>
            <form action="LoginServlet" method="post">
                <div class="body bg-gray">
                	<div>
                		<i><b>NgannSophal Mite Weekend Assignment</b><br>(JDBC servlet + jsp web application)</i><br><br>
                		Note: mockup data with following account (username/pwd)<br>
                		
                		1 - admin / adminPassword<br>
                		2 - user-test / userPassword
                		
                	</div>
                    <div class="form-group">
                        <input  class="form-control" type="text" placeholder="Enter user" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <input  type="password" id="password" name="password" class="form-control" placeholder="password"   />
                    </div>
                </div>
                <div class="footer">   
                     <input type="submit" class="btn btn-primary" name="submit" value="Sign In" style="width:100px;" />
                </div>
            </form>

        </div>

        
        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<!-- Bootstrap 3.3.5 -->
    	<script src="static/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
