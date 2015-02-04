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

import models.CategoryCourseRetrieveManager;


import com.google.gson.Gson;

import dao.DBManager;
import dto.CategoryCourseObjects;




	
	@WebServlet("/CategoryCourseRetrieve")
	public class CategoryCourseRetrieve  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryCourseRetrieve () {
	super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	try
	{
	String instruct=request.getParameter("instruct");
		System.out.print("got to controller");
	DBManager db= new DBManager();
	CategoryCourseRetrieveManager retManager= new CategoryCourseRetrieveManager();
	ArrayList<CategoryCourseObjects> catData = null;
	Connection connection = db.Get_Connection();
	if(instruct.equals("1"))
			{
			catData = retManager.GetCatData(connection, request, response) ;
			}
	else
			{
			catData=retManager.GetCatData(connection, request, response);
			}
	
	Gson gson = new Gson();
	String catdata = gson.toJson(catData);
	out.println("{\"Category\":"+catdata+"}");
	System.out.print(catdata);
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
