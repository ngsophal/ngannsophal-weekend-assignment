/**
 * 
 */
package edu.rupp.repo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.rupp.repo.domain.TestDomain;
import edu.rupp.repo.jdbc.test.SampleSqlSelect;

/**
 * @author sopheamak
 *
 */
public class ReadDataServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=====ReadDataServlet.service method is called ====");
        //json format?
        if ("json".equals(request.getParameter("type"))) {
            doGetAsJsonFormat(request, response);
            return;
        }
        //render to html page
       // Set response content type
        response.setContentType("text/html");
        
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        String cus_first_name = request.getParameter("cus_first_name");
        String cus_last_name = request.getParameter("cus_last_name");
        String cus_gender = request.getParameter("cus_gender");
        String cus_email_address = request.getParameter("cus_email_address");
        
        if (cus_first_name !=null) {
            out.print(cus_first_name);
        }
        out.println(String.format("<h1> Records table result </h1>"));
        
        SampleSqlSelect sampleSqlSelect = new SampleSqlSelect();
        
        try {
            //dbType is  1 is NATIVE-SQL  else is DBCP 
            String dbType = request.getParameter("dbType");
            
            //get records from database talbe
            //List<TestDomain> results = sampleSqlSelect.readDataFromDataSource();
            List<TestDomain> results = "1".equals(dbType) ?
                    sampleSqlSelect.readData() : 
                        sampleSqlSelect.readDataFromDataSource();
            out.print("<a href='edit.jsp'> Create New Customer</a>");
            out.print("<table width='500px' border='1'>");
            out.print("<tr bgcolor='gray'><td>Id</td><td>FirstName</td><td>delete</td></tr>");
            for (TestDomain testDomain : results) {
                out.print(String.format("<tr><td><a href='edit.jsp?id=%s'>%s</a></td>"
                        + "<td>%s</td>"
                        + "<td><a href='/deleteDataServlet?id=%s'>Delete</a>"
                        + "</td></tr>", testDomain.getCus_id(),
                        testDomain.getCus_id(), testDomain.getCus_first_name(), testDomain.getCus_id()));
            }
            out.print("</table>");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("something is wrong with server " + e.getMessage());
        }
      
    }
    /**response as json content*/
    private void doGetAsJsonFormat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final SampleSqlSelect sampleSqlSelect = new SampleSqlSelect();
        try {
            List<TestDomain> results = sampleSqlSelect.readDataFromDataSource();
            ObjectMapper mapper = new ObjectMapper();
            
            
            // Set response content type
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            mapper.writeValue(out, results);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("something is wrong with server " + e.getMessage());
        }
    }
    @Override
    public void destroy() {
        System.out.println("=====destroy method is called====");
    }

}
