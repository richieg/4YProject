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




import models.TimeTableRetrieveManager;

	import com.google.gson.Gson;

	import dao.DBManager;

import dto.CourseObjects;
import dto.TimeTableObjects;




		
		@WebServlet("/TimeTableRetrieve")
		public class TimeTableRetrieve extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public TimeTableRetrieve() {
		super();
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String ttdata=null;
		Gson gson = new Gson();
		try
		{
		int instruct=Integer.valueOf(request.getParameter("instruct"));
	
		DBManager db= new DBManager();
		TimeTableRetrieveManager retManager= new TimeTableRetrieveManager();
		ArrayList<TimeTableObjects> ttData = null;
		
		Connection connection = db.Get_Connection();
		
		
		if(instruct==5)
		{
			ttData=retManager.GetSemDetails(connection, request, response);
		}
		else
		{
		
			ttData= retManager.GetTTData(connection, request, response) ;
		}
				ttdata = gson.toJson(ttData);
	

		
		out.println("{\"TimeTableData\":"+ttdata+"}");
		//ut.println(catdata);

		ttData=null;
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


