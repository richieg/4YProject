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
import models.InsertManager;
import models.StudentDataManager;
import dao.CategoryCourseInsertData;
import dao.DBManager;
import dao.InsertCourseData;
import dto.MessageObjects;
import fsao.CreateUserAc;

/**
* Servlet implementation class InsertData
*/
@WebServlet("/StudentData")

public class StudentDataInsert  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	try
	 {
		int instructid=Integer.valueOf(request.getParameter("instructid"));

		ArrayList<MessageObjects> studentMessage = new ArrayList<MessageObjects>();
		DBManager db= new DBManager();
		Connection connection = db.Get_Connection();
		StudentDataManager sdm = new StudentDataManager();
		
		if(instructid==8)
		{
			studentMessage=sdm.UpdateStudentRecs(connection, request, response);
		}
		else{
		studentMessage=sdm.InsertStudenttoCourse(connection, request, response);
		}
		
		Gson gson = new Gson();
		String Message = gson.toJson(studentMessage);
		
		
			out.println("{\"StudentMessage\":"+Message+"}");
			
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
