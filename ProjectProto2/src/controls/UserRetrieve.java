package controls;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DBManager;
import models.UserRetrieveManager;
import dto.RecordObjects;
import dto.UserObjects;


	

	@WebServlet("/GetUserData")
	public class UserRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRetrieve() {
	super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	try
	{
	int instructid=Integer.valueOf(request.getParameter("instruct"));
	DBManager db= new DBManager();
	UserRetrieveManager retManager= new UserRetrieveManager();
	ArrayList<UserObjects> userData = null;
	Connection connection = db.Get_Connection();
	Gson gson = new Gson();
	String userdata=null;
	if(instructid==6 || instructid==7)
	{
		ArrayList<RecordObjects> recData = null;
		recData=retManager.GetRecs(connection, request, response);
		userdata = gson.toJson(recData);
		
	}
	else
	{
	userData = retManager.GetUserData(connection, request, response) ;
	
	userdata = gson.toJson(userData);
	}
	out.println("{\"User\":"+userdata+"}");
	//System.out.print(userdata);
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
	
