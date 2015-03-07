package controls;
import java.io.IOException;
import java.io.PrintWriter;
 


import dto.UserObjects;
import dto.UserObjectsInitial;


import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//http://www.journaldev.com/1907/java-servlet-session-management-tutorial-with-examples-of-cookies-httpsession-and-url-rewriting


import models.UserRetrieveManager;

import com.google.gson.Gson;

import dao.DBManager;
import dto.UserObjectsInitial;

	@WebServlet("/LoginUser")
	public class LoginUser extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    //private final String userID = "";
	    //private final String password = "";
	 
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	    	String user = null;
			String userpass = null;
			int userid=0;
			int userrole=0;
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
	    	//System.out.print(request.getAttribute("userid"));
	        // get request parameters for userID and password
	    	try {
	    		
	    	user=request.getParameter("user");
	    	System.out.print("user" + user );
	        System.out.print("got to controller");
	        DBManager db= new DBManager();
	        UserRetrieveManager retManager= new UserRetrieveManager();
	        ArrayList userData = null;
	        Connection connection = db.Get_Connection();
	        userData = retManager.GetUserDataInitial(connection, request, response) ;
	        //System.out.print("got to controller user data:");
	        //UserObjectsInitial UserObjectInitial = new UserObjectsInitial();
	        userid=((UserObjectsInitial) userData.get(0)).getUserid();
	        //System.out.print(userid);
	        userrole=((UserObjectsInitial) userData.get(0)).getUserrole();
	        //System.out.print(((UserObjectsInitial) userData.get(0)).getUserrole());
	        //System.out.print(userData.get(1));
	        /*Gson gson = new Gson();
	        String userdata = gson.toJson(userData);
	        out.println("{\"UserInitial\":"+userdata+"}");
	        System.out.print(userdata);*/
	        
	        
	        
	        
	      
	       if((userid>1 && userrole==1)){
	            HttpSession session = request.getSession();
	            session.setAttribute("userid", userid);
	            session.setAttribute("userrole",userrole);
	            //setting session to expiry in 30 mins
	            session.setMaxInactiveInterval(30*60);
	            Cookie userName = new Cookie("user", String.valueOf(userid).concat(String.valueOf(userrole)));
	            response.addCookie(userName);
	            String ust=userName.getValue();
	            //System.out.print("got to here in user login:::" + ust + " ");
	            //String nextJSP = "index.jsp";
	            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	            //dispatcher.(request,response);
	            //response.sendRedirect(nextJSP);
	           //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
	            //dispatcher.forward(request,response);
	            //Get the encoded URL string
	            //String encodedURL = response.encodeRedirectURL("index.jsp");
	            //response.sendRedirect("index.jsp");
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
	            
	            //out.println("<font color=red>Either user name or password is wrong.</font>");
	            rd.include(request, response);
	            //String encodedURL = response.encodeRedirectURL("index.html");
	            //response.sendRedirect(encodedURL);
	            
	            //System.out.print("got to here in user login 2");
	        }else{
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/userlogin.jsp");
	            
	            //out.println("<font color=red>Either user name or password is wrong.</font>");
	            rd.include(request, response);
	        }
	 
	    }
	    	catch (Exception ex)
			{
			out.println("Error: " + ex.getMessage());
			}
			finally
			{
			out.close();
			}
	 
	}
	}


