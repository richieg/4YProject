package controls;

import java.io.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 









import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import dao.DBManager;
import dao.InsertUserData;


	
	
	@WebServlet("/FileUploadServlet")
	public class FileUploadServlet   extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadServlet () {
	super();
	}
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 50 * 1024;
   private int maxMemSize = 4 * 1024;
   private File file ;
	int dupCount=0;
   


  public void init( ){
      //et the file location where it would be stored.
      filePath = 
             getServletContext().getInitParameter("file-upload"); 
  }
   public void doPost(HttpServletRequest request, 
               HttpServletResponse response)
              throws ServletException, java.io.IOException {
      // Check that we have a file upload request
      isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		

		BufferedReader br = null;
      if( !isMultipart ){
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
      factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      try{ 
    	   
    		DBManager db= new DBManager();
    		Connection connection = db.Get_Connection();
      // Parse the request to get file items.
      List fileItems = upload.parseRequest(request);
	
      // Process the uploaded file items
      Iterator i = fileItems.iterator();

      /*out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet upload</title>");  
      out.println("</head>");
      out.println("<body>");*/
      while ( i.hasNext () ) 
      {
         FileItem fi = (FileItem)i.next();
         if ( !fi.isFormField () )	
         {
            // Get the uploaded file parameters
             String fieldName = fi.getFieldName();
             String fileName = fi.getName();
             String contentType = fi.getContentType();
             boolean isInMemory = fi.isInMemory();
             long sizeInBytes = fi.getSize();
            // Write the file
            if( fileName.lastIndexOf("\\") >= 0 ){
               file = new File( filePath + 
               fileName.substring( fileName.lastIndexOf("\\"))) ;
            }else{
               file = new File( filePath + 
               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
            }
            fi.write( file ) ;
          //out.println("Uploaded Filename: " + fileName +"<br>");
        File csvFile = file;
   
      	String line = "";
      	String cvsSplitBy = ",";
      	int count=0;
      	int checkCount=0;
     
      
      	SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
      	SimpleDateFormat dmyFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
      	dmyFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      		br = new BufferedReader(new FileReader(csvFile));
      		while ((line = br.readLine()) != null) {
      		
       
      		        // use comma as separator
      			String[] userDetailscheck = line.split(cvsSplitBy);
      			if(userDetailscheck[0].isEmpty()||userDetailscheck[1].isEmpty()||userDetailscheck[2].isEmpty()||userDetailscheck[3].isEmpty()||userDetailscheck[4].isEmpty()||userDetailscheck[5].isEmpty()||userDetailscheck[6].isEmpty()||userDetailscheck[7].isEmpty()||userDetailscheck[8].isEmpty()||userDetailscheck[9].isEmpty())
      			{
      			checkCount=1;
      			String encodedURL = response.encodeRedirectURL("errorpage.jsp");
      		    response.sendRedirect(encodedURL);
      		    return;
      			}
      		}
      		if(checkCount==0)
      		{
      			if(count>0)
      			{
      				while ((line = br.readLine()) != null) {
      		      		
      			    
          		        // use comma as separator
          			String[] userDetails = line.split(cvsSplitBy);
      			
      		        
          			
      			Date dob= dmyFormat.parse(userDetails[8]);
      			System.out.println(userDetails[1]);
      			String sdob = ymdFormat.format(dob);
      			
      			InsertUserData iud= new InsertUserData();
      			int usercount= iud.CheckForDups(userDetails[1],userDetails[2],userDetails[3],sdob,connection);
      			System.out.println("usercount=="+usercount);
      			if (usercount<1)
      			{
      			iud.InsertSingleUser(userDetails[0],userDetails[1],userDetails[2],userDetails[3],userDetails[4],userDetails[5],Integer.valueOf(userDetails[6]),userDetails[7],sdob,Integer.valueOf(userDetails[9]),connection);
      			}
      			else{
      				dupCount+=usercount;
      			}
      			}
      			count++;
      		}
      		}
         }
      }
      	  }catch(Exception ex) {
      	       System.out.println(ex);
      	  }
      finally {
  		if (br != null) {
  			try {
  				br.close();
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  		}
      }
      if(dupCount>0)
      {
    	  System.out.println("dupcount=="+dupCount);
    	  Cookie successCookie = new Cookie("user","user");
          //setting cookie to expiry in 30 mins
          successCookie.setMaxAge(30*60);
          response.addCookie(successCookie);
    		String encodedURL = response.encodeRedirectURL("errorpage.jsp");
  		    response.sendRedirect(encodedURL);
  		    return;
      }
      String encodedURL = response.encodeRedirectURL("userindex.jsp");
      response.sendRedirect(encodedURL);
       
      	
      	}
   public void doGet(HttpServletRequest request, 
           HttpServletResponse response)
throws ServletException, java.io.IOException {

throw new ServletException("GET method used with " +
    getClass( ).getName( )+": POST method required.");
} 
       

}