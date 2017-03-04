<%
if(session.getAttribute("s_username") != null){
} else {
    response.sendRedirect("/login.jsp");
}%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
		<jsp:include page="left_menu.html" />
		<div class="content-wrapper">
             <link rel="stylesheet" href="bootstrap/bootstrap-adapter/css/datatables.css">

			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Customer List
					<!--<small>Preview</small>-->
				</h1>
			</section>
			<script>
			function visitPage(){
		        window.location='edit.jsp';
		    }
			//start removing the message url para
			function ChangeUrl(page, url) {
		        if (typeof (history.pushState) != "undefined") {
		            var obj = { Page: page, Url: url };
		            history.pushState(obj, obj.Page, obj.Url);
		        } else {
		            alert("Browser does not support HTML5.");
		        }
		    }
		
			$( document ).ready(function() {
				var msg_status = "<%= request.getParameter("message") %>";
				
				if(msg_status != 'null'){
					alert( msg_status );
					ChangeUrl('', 'customerList.jsp');
				}
			    
			});
			//end removing the message url para
			</script>
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<!-- left column -->
					<div class="col-md-12">
						<div class="box">&nbsp;
							<div class="row">
								<div class="form-group">
									<div class="col-md-12" style="margin-left:-25px;">
										<button onclick="visitPage();" class="btn btn-primary pull-right" type="button">
											<i class="fa fa-plus"></i>&nbsp;&nbsp;Add New Customer    
										</button>
									</div>
								</div>
							</div>
							<div class="box-header">
								<h2 class="box-title">
									<i class="glyphicon glyphicon-menu-hamburger"></i>&nbsp;&nbsp;&nbsp;
									Recently Customer
									
								</h2>	
														
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="tbl_customer" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th rowspan="2"
												style="text-align: left; vertical-align: middle;">ID.</th>
											<th rowspan="2"
												style="text-align: left; vertical-align: middle;">First Name</th>
											<th rowspan="2"
												style="text-align: left; vertical-align: middle;">Last Name</th>
											<th rowspan="2"
												style="text-align: left; vertical-align: middle;">Gender</th>
											<th rowspan="2"
												style="text-align: left; vertical-align: middle;">Email</th>
											<th rowspan="2"
												style="text-align: left; vertical-align: middle;">Phone</th>
											
											<th colspan="3" style="text-align: left;">Action</th>
										</tr>
										<tr>
											<!-- <th>Detail</th> -->
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<sql:setDataSource
									        var="myDS" driver="com.mysql.jdbc.Driver"
									        url="jdbc:mysql://localhost:3306/test" user="root" password="" />
									     
									    <sql:query var="listUsers" dataSource="${myDS}">
									        SELECT * FROM td_customer ORDER BY cus_id DESC;
									    </sql:query>
				                                       
				                  
										<c:forEach var="user" items="${listUsers.rows}">
							                <tr>
							                    <td><c:out value="${user.cus_id}" /></td>
							                    <td><c:out value="${user.cus_first_name}" /></td>
							                    <td><c:out value="${user.cus_last_name}" /></td>
							                    <td><c:out value="${user.cus_gender}" /></td>
							                    <td><c:out value="${user.cus_email_address}" /></td>
							                    <td><c:out value="${user.cus_phoneNumber}" /></td>
							                    <td><a style="cursor: pointer;" href="edit.jsp?id=${user.cus_id}"  title="Edit"
													 type="button"> <i
														class="fa fa-pencil-square-o"></i></a></td>
												<td><a href="deleteDataServlet?id=${user.cus_id}" title="Delete"
													data-value="${user.cus_id}"><i
														class="glyphicon glyphicon-trash"></i></a></td>
							                </tr>
							            </c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.box-body -->
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
<script>	  
      $(function () {
        $("#tbl_customer").DataTable({
			"paging": true,
            "lengthChange": true,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": false
		});
		 var table = $('#tbl_customer').dataTable();
		 $('#tbl_customer tbody').on( 'click', 'tr', function () {
				//alert($(this).val());
				if ( $(this).hasClass('selected') ) {
					$(this).removeClass('selected');
				}
				else {
					table.$('tr.selected').removeClass('selected');
					$(this).addClass('selected');
				}
			});
			
			$.fn.orderNRow = function(oTableLocal){
				var n = 0;
				oTableLocal.$("tr").each(function(){
					var values = $(this).children("td:first-child").html(++n);
				});
			}
		    
      });
    </script>


   
    
    <!-- Bootstrap 3.3.5 -->
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <!-- DataTables -->
    <script src="static/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="static/plugins/datatables/dataTables.bootstrap.min.js"></script>
    <!-- Morris.js charts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    
    <!-- AdminLTE App -->
    <script src="static/dist/js/app.min.js"></script>
	
  </body>
</html>
