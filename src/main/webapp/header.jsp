<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Customer Management</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">    
    
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    
    <!-- Select2 -->
    <link rel="stylesheet" href="static/plugins/select2/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="static/dist/css/skins/_all-skins.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="static/plugins/iCheck/flat/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="static/plugins/morris/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="static/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="static/plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="static/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <script src="static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>        
    <!--[endif]-->
    
  </head>
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="index.jsp" class="logo">
			  <!-- mini logo for sidebar mini 50x50 pixels -->
			  <span class="logo-mini"><b>C</b>M</span>
			  <!-- logo for regular state and mobile devices -->
			  <span class="logo-lg"><b>Customer Management </b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top" role="navigation">
			  <!-- Sidebar toggle button-->
			  <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
				<span class="sr-only">Toggle navigation</span>
			  </a>
			  <div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
				  <!-- User Account: style can be found in dropdown.less -->
				  <li class="dropdown user user-menu">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">                  
					  <i class="glyphicon glyphicon-user"></i>
					  <span>administrator <i class="caret"></i></span>
					</a>
					<ul class="dropdown-menu">
					  <!-- User image -->
					  <li class="user-header bg-light-blue">
						<!--<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">-->
						<p>
						  <!-- admin User --><%= session.getAttribute("s_username")  %>                
						</p>
					  </li>                 
					  <li class="user-footer">
						<!-- <div class="pull-left">
						  <a href="myProfile.jsp" class="btn btn-default btn-flat">Profile</a>
						</div> -->
						<div class="pull-right">
						  <a href="LogoutServlet" class="btn btn-default btn-flat">Sign out</a>
						</div>
					  </li>
					</ul>
				  </li>             
				</ul>
			  </div>
			</nav>
		</header>