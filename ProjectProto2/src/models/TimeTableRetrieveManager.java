package models;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryCourseRetrieveData;
import dao.InsertTimeTableData;
import dao.RetrieveTimeTableData;
import dto.CategoryCourseObjects;
import dto.MessageObjects;
import dto.TimeTableObjects;

public class TimeTableRetrieveManager {
	
	
	
	public ArrayList<TimeTableObjects> GetTTData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<TimeTableObjects> ttData = null;
	
	RetrieveTimeTableData rdata=new RetrieveTimeTableData();


			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			ttData=rdata.GetTTData(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return ttData;

}
	
	public ArrayList<TimeTableObjects> GetTimeTable(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<TimeTableObjects> ttData = null;
	
	RetrieveTimeTableData rdata=new RetrieveTimeTableData();
	System.out.println("got ot manager to get ttdata");
			
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			ttData=rdata.RetireveTimeTable(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return ttData;

}
	
	
	
	public ArrayList<TimeTableObjects> GetSemDetails(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<TimeTableObjects> ttData = null;
	
	RetrieveTimeTableData rdata=new RetrieveTimeTableData();
	System.out.println("got ot manager to get ttdata");
			
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			ttData=rdata.RetireveSemesterDetails(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return ttData;

}
	
	
	
	public ArrayList<MessageObjects> InsertTTData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<MessageObjects> message = null;

	InsertTimeTableData idata=new InsertTimeTableData ();
	System.out.println("got ot manager toi nsert ttdata");	
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			message=idata.InsertTTData(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return message;

}
	public ArrayList<MessageObjects>DeleteTTData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<MessageObjects> message = null;

	InsertTimeTableData idata=new InsertTimeTableData ();
	System.out.println("got ot manager to delete ttdata");	
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			message=idata.DeleteTTData(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return message;

}
	
	public ArrayList<MessageObjects>SaveTTasWIP(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<MessageObjects> message = null;

	InsertTimeTableData idata=new InsertTimeTableData ();
	System.out.println("got ot manager to delete ttdata");	
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			message=idata.SaveTTWIP(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return message;

}
	
	
	public ArrayList<MessageObjects>SaveTTPerm(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<MessageObjects> message = null;

	InsertTimeTableData idata=new InsertTimeTableData ();
	System.out.println("got ot manager to delete ttdata");	
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			message=idata.SaveTTPerm(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return message;

}
	public ArrayList<MessageObjects>InsertSemester(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<MessageObjects> message = null;

	InsertTimeTableData idata=new InsertTimeTableData ();
	System.out.println("got ot manager to delete ttdata");	
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			message=idata.InsertSemester(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return message;

}
	
	public ArrayList<MessageObjects>InsertHolsPeriods(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<MessageObjects> message = null;

	InsertTimeTableData idata=new InsertTimeTableData ();
	System.out.println("got ot manager to delete ttdata");	
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			message=idata.InsertHols(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return message;

}
	
	public ArrayList<MessageObjects>ResetTTWIP(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<MessageObjects> message = null;

	InsertTimeTableData idata=new InsertTimeTableData ();
	System.out.println("got ot manager to delete ttdata");	
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			message=idata.ResetTTWIP(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return message;

}
}
