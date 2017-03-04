package edu.rupp.repo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class MyFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("Filter init called");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        final PrintWriter out = resp.getWriter();
        // Get the IP address of client machine.   
        String ipAddress = req.getRemoteAddr();
        
        Long currentTime = System.currentTimeMillis();
        Date startTime = new Date(currentTime);
        out.print("<h1>Filter is invoked before : " + startTime + "</h1>");

        chain.doFilter(req, resp);// sends request to next resource
        
        Long endTime = System.currentTimeMillis();
        
        out.print("<h1>Filter is invoked after : " + new Date(endTime) +" </h1>");
        out.print("<h1>Time spent for this request " +  (endTime- currentTime) +" millis</h1>");
        out.print(" access from IP : " + ipAddress);
    }

    public void destroy() {
        System.out.println("Filter destroy called");
    }
}
