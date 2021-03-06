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

import models.CategoryCourseManager;
import models.UserInsertManager;
import dao.CategoryCourseInsertData;
import dao.DBManager;
import dao.InsertCourseData;
import dto.MessageObjects;
import fsao.CreateUserAc;

/**
* Servlet implementation class InsertData
*/
@WebServlet("/CategoryCourses")

public class CategoryCoursesInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	try
	 {
		String instructid=request.getParameter(("instructid"));
		ArrayList<MessageObjects> categoryMessage = new ArrayList<MessageObjects>();
		DBManager db= new DBManager();
		Connection connection = db.Get_Connection();
		CategoryCourseManager ccm= new CategoryCourseManager();

		
		
		
		if(instructid.equals("1"))
		{
		
	
	
		categoryMessage=ccm.InsertCategory(connection, request, response);
		
		}
		else if(instructid.equals("2"))
		{
			categoryMessage=ccm.InsertCourse(connection, request, response);
		}
		else if(instructid.equals("4") || instructid.equals("5"))
		{
		
			categoryMessage=ccm.RestoreArchiveCatCourse(connection, request, response);
		}
		else if(instructid.equals("6") || instructid.equals("7"))
				{
			categoryMessage=ccm.UpdateCatCourse(connection, request, response);
				}
	
		
		
		Gson gson = new Gson();
		String Message = gson.toJson(categoryMessage);
		
		
			out.println("{\"CatMessage\":"+Message+"}");
			
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
