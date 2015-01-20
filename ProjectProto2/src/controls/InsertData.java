package controls;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.InsertManager;
import dao.DBManager;
import fsao.CreateUserAc;

/**
* Servlet implementation class InsertData
*/
@WebServlet("/InsertData")

public class InsertData 
	extends HttpServlet {
		private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{
		DBManager db= new DBManager();
		InsertManager insertManager= new InsertManager();
		//CreateUserAc cs = new CreateUserAc();
		
		String message = null;
		Connection connection = db.Get_Connection();
		message= insertManager.InsertUser(connection, request, response);
		//cs.MakeDirectory();
		if (message!=null)
		{
		out.println("<div>"+message+"</div>");
		}
		else
		{
		out.println("false");
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
