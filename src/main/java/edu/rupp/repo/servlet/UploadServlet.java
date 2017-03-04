/**
 * 
 */
package edu.rupp.repo.servlet;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author sopheamak
 *
 */
public class UploadServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private boolean isMultipart;
    private String filePath;
    //50k
    private int maxFileSize = 500 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;

    
    @Override
    public void init() throws ServletException {
        System.out.println("=====init method is called====");
        //populate initialize resources
     // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload"); 
    }

   
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        if (!isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        String tempDir = System.getProperty("java.io.tmpdir");
        factory.setRepository(new File(tempDir));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);

        try {
            // Parse the request to get file items.
            List<FileItem> fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator<FileItem> i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    //String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    //String contentType = fi.getContentType();
                    //boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    System.out.println(String.format(" fileName [%s] size [%s]", fileName, sizeInBytes));
                    
                    // Write the file
                    file = new File(filePath + fileName);
                    System.out.println(" file location :" + file.getAbsolutePath());
                    fi.write(file);
                    
                    out.println("Uploaded Filename: " + fileName + "<br>");
                    out.println("file store location is : " + file.getAbsolutePath() + "<br>");
                    out.println("<br><a href='upload.jsp'>Upload More</a>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception ex) {
            //System.out.println(ex);
            throw new ServletException(ex.getMessage());
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
    }

    @Override
    public void destroy() {
        System.out.println("=====destroy method is called====");
    }

}
