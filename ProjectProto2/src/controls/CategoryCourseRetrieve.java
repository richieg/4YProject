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
import javax.sound.midi.ControllerEventListener;

import models.CategoryCourseRetrieveManager;




import com.google.gson.Gson;

import dao.DBManager;
import dto.CategoryCourseObjects;
import dto.CourseObjects;




	
	@WebServlet("/CategoryCourseRetrieve")
	public class CategoryCourseRetrieve  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryCourseRetrieve () {
	super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	String catdata=null;
	Gson gson = new Gson();
	try
	{
	String instruct=request.getParameter("instruct");
	System.out.println("instruct in controoller:::"+instruct);
	DBManager db= new DBManager();
	CategoryCourseRetrieveManager retManager= new CategoryCourseRetrieveManager();
	ArrayList<CategoryCourseObjects> catData = null;
	ArrayList<CourseObjects> courseData = null;
	Connection connection = db.Get_Connection();
	if(instruct.equals("1"))
			{
			catData = retManager.GetCatData(connection, request, response) ;
			catdata = gson.toJson(catData);
			}
	if(instruct.equals("2"))
			{
		System.out.println("ControllerEventListener for course instruct id="+instruct);
			courseData=retManager.GetCourseData(connection, request, response);
			catdata = gson.toJson(courseData);
			//System.out.println(catData);
			}
	

	
	out.println("{\"Category\":"+catdata+"}");
	//ut.println(catdata);

	catData=null;
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
