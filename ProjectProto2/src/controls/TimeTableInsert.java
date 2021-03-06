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

import models.TimeTableManager;

import com.google.gson.Gson;

import dao.DBManager;
import dto.MessageObjects;
import dto.TimeTableObjects;
import dto.UserObjectsInitial;


	@WebServlet("/TimeTableInsert")
	public class TimeTableInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TimeTableInsert() {
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
	TimeTableManager retManager= new TimeTableManager();
	ArrayList<MessageObjects> imessage = null;
	ArrayList<TimeTableObjects> ttData = null;
	System.out.println("instruct in cintrol for timetable="+instruct);
	Connection connection = db.Get_Connection();
		if(instruct==0 || instruct==10 || instruct==20)
		{
			ttData=retManager.GetTimeTable(connection, request, response);
			ttdata = gson.toJson(ttData);
		}
		else if(instruct==1)
		{
			imessage= retManager.InsertTTData(connection, request, response) ;
			int messagecode=((MessageObjects) imessage.get(0)).getMessagecode();
			System.out.println(messagecode);
			if(messagecode==1)
			{
				ttData=retManager.GetTimeTable(connection, request, response);
			}
			ttdata = gson.toJson(ttData);
		}
		else if(instruct==2){
				imessage= retManager.DeleteTTData(connection, request, response) ;
				
				
			
				ttdata = gson.toJson(imessage);
		}
		else if(instruct==3){
			imessage= retManager.SaveTTasWIP(connection, request, response) ;
			int messagecode=((MessageObjects) imessage.get(0)).getMessagecode();
			System.out.println(messagecode);
			ttdata = gson.toJson(imessage);
		}
		
		else if(instruct==4 || instruct==11){
			imessage= retManager.SaveTTPerm(connection, request, response) ;
			int messagecode=((MessageObjects) imessage.get(0)).getMessagecode();
			System.out.println(messagecode);
			ttdata = gson.toJson(imessage);
	}
		
		
		else if(instruct==5){
			imessage= retManager.InsertSemester(connection, request, response) ;
			int messagecode=((MessageObjects) imessage.get(0)).getMessagecode();
			System.out.println(messagecode);
			ttdata = gson.toJson(imessage);
	}
		else if(instruct==6){
			imessage= retManager.InsertHolsPeriods(connection, request, response) ;
			int messagecode=((MessageObjects) imessage.get(0)).getMessagecode();
			System.out.println(messagecode);
			ttdata = gson.toJson(imessage);
	}
	
		System.out.println("tdata="+ttdata);
	
	

	
	out.println("{\"TimeTableData1\":"+ttdata+"}");
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


