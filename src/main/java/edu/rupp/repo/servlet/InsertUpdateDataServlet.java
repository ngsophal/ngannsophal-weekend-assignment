/**
 * 
 */
package edu.rupp.repo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.rupp.repo.jdbc.TestDaoImpl;

/**
 * @author sopheamak
 *
 */
public class InsertUpdateDataServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(InsertUpdateDataServlet.class);
    private TestDaoImpl daoImpl = null;
    
    @Override
    public void init() throws ServletException {
        daoImpl = new TestDaoImpl();
    }
    /**
     * updateDataServlet
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("=====InsertUpdateDataServlet.service method is called ====");
        //render to html page
       // Set response content type
        response.setContentType("text/html");
        
        String id = request.getParameter("id");
        //String message = request.getParameter("message");
        String firstName = request.getParameter("cus_first_name");
        String lastName = request.getParameter("cus_last_name");
        String gender = request.getParameter("cus_gender");
        String email = request.getParameter("cus_email_address");
        String phone = request.getParameter("cus_phoneNumber");
        String address = request.getParameter("cus_address");
        //Date dob = request.getParameter("dob").;//.getParameter("dob");
        //Date d1 = dob.getTime();
        
        String dobDateStr = request.getParameter("cus_DOB");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        Date dobStr = null;
		try {
			dobStr = (Date) sdf.parse(dobDateStr);
			LOG.info("dopStr= "+dobStr);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        
        try {
        	gender = gender.trim();
        	java.sql.Date sqlDate = new java.sql.Date(dobStr.getTime());
        	LOG.info("sqlDate= "+sqlDate);
            //create new record
            if (id == null) { 
            	LOG.info("NEW= "+sqlDate);
                daoImpl.writeData(firstName,lastName,gender,email,phone,address, sqlDate);//),dob);
                //out.println(String.format("<center> <h2>Record has been added! </h2></center>"));
                response.sendRedirect("/customerList.jsp?message= Record has been added" );
            } else {
                //out.println(String.format("<center> <h2>Record has been updated! </h2></center>"));            	
                daoImpl.upateData(Integer.valueOf(id), firstName,lastName,gender,email,phone,address, sqlDate);//dobStr);
                response.sendRedirect("/customerList.jsp?message= Record has been updated" );
            }
            
            //get records from database table
            //out.print("<center><a href='customerList.jsp'>See All</a></center>");
            //out.print("<a href='/readDataServlet'>See All</a>");
            
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("something is wrong with server " + e.getMessage());
        }
      
    }

    @Override
    public void destroy() {
        LOG.info("=====destroy method is called====");
    }

}
