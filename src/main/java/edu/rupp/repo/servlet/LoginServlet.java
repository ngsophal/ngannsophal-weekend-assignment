package edu.rupp.repo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//request.getRequestDispatcher("link.jsp").include(request, response);
		//from client
		String email    = request.getParameter("name");
		String password = request.getParameter("password");
		
		//Start Create mockup list of users info 10 records		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
	    ArrayList<User> emps = new ArrayList<User>();
	    emps.add(new User(1,"admin","adminPassword"));
		emps.add(new User(1,"user-test","userPassword"));
	    
		int valid = 0;
		for(User item:emps){
			if(password.equals(item.getPassword())){
				if(email.equals(item.getUserName())){
					out.print("Welcome, "+email);
					HttpSession session=request.getSession();
					//session.setAttribute("s_id",item.getId());
					session.setAttribute("s_username",item.getUserName());
					session.setAttribute("s_password",item.getPassword());
					valid = 1;
					response.sendRedirect(request.getContextPath() + "/customerList.jsp");
				}
			}
		}
		if(valid == 0){
			out.printf("<br><br><br><br><center>The username or passord you have entered does not match any account!</center>");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		
		out.close();
	}

}
