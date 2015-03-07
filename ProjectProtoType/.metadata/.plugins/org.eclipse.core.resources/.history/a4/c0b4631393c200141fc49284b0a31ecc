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

import models.InsertManager;
import dao.DBManager;
import dto.MessageObjects;
import fsao.BulkUpload;
import fsao.CreateUserAc;

/**
* Servlet implementation class InsertData
*/
@WebServlet("/InsertData")

public class UserInsert 
	extends HttpServlet {
		private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{
	    int checknum= Integer.parseInt(request.getParameter("checknum"));  
		DBManager db= new DBManager();
		InsertManager insertManager= new InsertManager();
		//CreateUserAc cs = new CreateUserAc();
		ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
		//String message = null;
		Connection connection = db.Get_Connection();
		if(checknum==2 || checknum==4)
		{
			insertMessage= insertManager.RestoreArchiveUser(connection, request, response);
		}
		else if(checknum==5)
		{
			insertMessage=insertManager.UpdateUser(connection, request, response);
		}
	
		
		else
		{
			insertMessage= insertManager.InsertUser(connection, request, response);
		}
		//cs.MakeDirectory();
		Gson gson = new Gson();
		String Message = gson.toJson(insertMessage);
		
		
			out.println("{\"Message\":"+Message+"}");
			
		
		
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
