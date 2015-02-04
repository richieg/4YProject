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
import models.RetrieveManager;
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
	DBManager db= new DBManager();
	RetrieveManager retManager= new RetrieveManager();
	ArrayList<UserObjects> userData = null;
	Connection connection = db.Get_Connection();
	userData = retManager.GetUserData(connection, request, response) ;
	Gson gson = new Gson();
	String userdata = gson.toJson(userData);
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
	
