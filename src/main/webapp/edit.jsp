<%
if(session.getAttribute("s_username") != null){
} else {
    response.sendRedirect("/login.jsp");
}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  

<%@page import="edu.rupp.repo.domain.TestDomain"%>
<%@page import="edu.rupp.repo.jdbc.TestDaoImpl"%>

<%
String id = request.getParameter("id");
TestDaoImpl daoImpl = new TestDaoImpl();
TestDomain domain = daoImpl.readDataById(id ==null? null: Integer.valueOf(id));
%>

<html>
<jsp:include page="header.jsp" />
	<jsp:include page="left_menu.html" />
	<script>	
		$( document ).ready(function() {
			var cus_gender = "<%=domain !=null ? domain.getCus_gender() :' ' %>";			
			if(cus_gender != 'null'){
				if(cus_gender.trim() == 'M'){
					$("#cus_gender").prop('selectedIndex', 1);
				}else if(cus_gender.trim() == 'F'){
					$("#cus_gender").prop('selectedIndex', 2);
				}				
			}		    
		});
	</script>
	<div class="content-wrapper">
        <link rel="stylesheet" href="bootstrap/bootstrap-adapter/css/datatables.css">

		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				<%
		         if (id != null) {
		         %>
		         Update Customer Record
		         - ID : <%=id%>
		         <input type="hidden" name="id" value="<%=id%>"/>
		       <%     }   else  {%>
		         Create New Customer Record
		       <% } %>
				<!--<small>Preview</small>-->
			</h1>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">
					<div class="box">
						<div class="box-header">
							<h2 class="box-title">
								<i class="glyphicon glyphicon-menu-hamburger"></i>&nbsp;&nbsp;&nbsp;
								Customer Information
							</h2>								
						</div>
						<!-- /.box-header -->
						<div class="box-body">
	
							
								<form id="frmcustomer" action="/updateDataServlet" method="POST">								        
							       	   <%
								         if (id != null) {
								         %>
								         <input type="hidden" name="id" value="<%=id%>"/>
								       <%     }   else  {%>
								       <% } %>
							        
							           <div class="row">
					                        <div class="form-group">   
					                            <div class="col-md-2">
					                                <label>First Name</label>
					                            </div>
					                            <div class="col-md-4">
					                                <input type="text" class="form-control" name="cus_first_name" id="cus_first_name" value="<%=domain !=null ? domain.getCus_first_name() :' ' %>"/>
					                            </div>
					                            <div class="col-md-2">
					                                <label>Last Name</label>
					                            </div>
					                            <div class="col-md-4">
					                                 <input type="text" class="form-control" name="cus_last_name" id="cus_last_name" value="<%=domain !=null ? domain.getCus_last_name() :' ' %>"/>                                                              
					                            </div>                           
					                        </div>                                        									
					                    </div>&nbsp;
					                    
					                    <div class="row">
					                        <div class="form-group">   
					                            <div class="col-md-2">
					                                <label>Gender</label>
					                            </div>
					                            <div class="col-md-4">
					                                <select class="form-control" name="cus_gender" id="cus_gender">
														<option value="0">----Select Gender----</option>
														<option value="M" >M</option>
														<option value="F" >F</option>
													</select>										
					                            </div>
					                            <div class="col-md-2">
					                                <label>Email</label>
					                            </div>
					                            <div class="col-md-4">
					                                 <input type="text" class="form-control" name="cus_email_address" id="cus_email_address" value="<%=domain !=null ? domain.getCus_email_address() :' ' %>"/>                                                              
					                            </div>                           
					                        </div>                                        									
					                    </div>&nbsp;
					                    
					                    <div class="row">
					                        <div class="form-group">   
					                            <div class="col-md-2">
					                                <label>Phone</label>
					                            </div>
					                            <div class="col-md-4">
					                                <input type="text" class="form-control" name="cus_phoneNumber" id="cus_phoneNumber" value="<%=domain !=null ? domain.getCus_phoneNumber() :' ' %>"/>
					                            </div>
					                            <div class="col-md-2">
					                                <label>Address</label>
					                            </div>
					                            <div class="col-md-4">
					                                 <input type="text" class="form-control" name="cus_address" id="cus_address" value="<%=domain !=null ? domain.getCus_address() :' ' %>"/>                                                              
					                            </div>                           
					                        </div>                                        									
					                    </div>&nbsp;
					                    
					                    <div class="row">
					                        <div class="form-group">   
					                            <div class="col-md-2">
					                                <label>DOB</label>
					                            </div>
					                            <div class="col-md-4">
					                                <input type="text" class="form-control" name="cus_DOB" id="cus_DOB"  class="form-control" value="<%=domain !=null ? domain.getCus_DOB() :' ' %>" />
					                            </div>
					                            <div class="col-md-2">
					                            </div>
					                            <div class="col-md-4">
					                                                                                               
					                            </div>                           
					                        </div>                                        									
					                    </div>&nbsp;						                     
					                    
					                    <div class="row">
											<div class="form-group">
												<div class="col-md-10"> </div>
												<div class="col-md-2 text-right">
													<button type="submit" class="btn btn-primary">
					                                	<i class="fa fa-save"></i>&nbsp;&nbsp;&nbsp; Save &nbsp;&nbsp;&nbsp;
					                                </button> 
												</div>
											</div>
										</div>						        
							         
							      </form>
								
							
							
							
						</div><!-- /.box-body -->
					</div>
					</div>	
				</div>
			</section>
			<!-- /.content -->
		</div><!--/.content-wrapper-->
	</div><!--/.wrapper-->


	<!-- jQuery 2.1.4 -->
	<script src="static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- DataTables -->
	<script src="static/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="static/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- datepicker -->
	<script src="static/plugins/datepicker/bootstrap-datepicker.js"></script>


	<!-- Bootstrap 3.3.5 -->
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <!-- DataTables -->
    <script src="static/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="static/plugins/datatables/dataTables.bootstrap.min.js"></script>
    <!-- Morris.js charts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    
    <!-- AdminLTE App -->
    <script src="static/dist/js/app.min.js"></script>
	
	<script src="static/plugins/datepicker/bootstrap-datepicker.js"></script> 
    <script>	
		$('#cus_DOB').datepicker({
			  format: 'yyyy-mm-dd',
			  autoclose: true
		});
    </script>
	<script>
		$(function() {	  
			  
			  $('#frmcustomer').submit(function(){
				
				if($('#cus_first_name').val()==" ")
				{
					$('#cus_first_name').focus();
					alert("Please input first name !!!");
					return false;
				}
				if($('#cus_last_name').val()==" ")
				{
					$('#cus_last_name').focus();
					alert("Please input last name !!!");
					return false;
				}			
				if($('#cus_gender').val()==0)
				{
					$('#cus_gender').focus();
					alert("Please choose gender !!!");
					return false;
				}				
				
				if($('#cus_email_address').val()==" ")
				{
					$('#cus_email_address').focus();
					alert("Please input Email Address !!!");
					return false;
				}
				if($('#cus_phoneNumber').val()==" ")
				{
					$('#cus_phoneNumber').focus();
					alert("Please input phone number !!!");
					return false;
				}	
				if($('#cus_address').val()==" ")
				{
					$('#cus_address').focus();
					alert("Please input Address !!!");
					return false;
				}
											
				if($('#cus_DOB').val()==" ")
				{
					$('#cus_DOB').focus();
					alert("Please select DOB !!!");
					return false;
				}
				
								
				return true;
			  });
		  });	  
		  		  	 
	</script>    
  
	
  </body>
</html>
