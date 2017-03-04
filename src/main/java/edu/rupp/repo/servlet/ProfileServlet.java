package edu.rupp.repo.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//request.getRequestDispatcher("link.jsp").include(request, response);
		
		HttpSession session=request.getSession(false);
		if(session!=null){
			//Long id          = (Long)session.getAttribute("s_id");
			String email     = (String)session.getAttribute("s_username");
			String password  = (String)session.getAttribute("s_password");
			Date createddate = (Date)session.getAttribute("s_createddate");
			String urlphoto  = (String)session.getAttribute("s_urlphoto");
			
			/*out.println("<Strong>Welcome to Profile</Strong>");
			//out.println("\nID: "+id);
			out.println("<br>Email: "+email);
			out.println("<br>Password: "+password);
			out.println("<br>Created Date: "+createddate);
			out.println("<br>Url Photo: "+urlphoto);*/
			
		}
		else{
			out.print("Please login first");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		out.close();
	}
	
	
}
