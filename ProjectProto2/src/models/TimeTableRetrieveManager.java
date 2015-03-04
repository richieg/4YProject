package models;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryCourseRetrieveData;
import dao.InsertTimeTableData;
import dao.RetrieveTimeTableData;
import dto.CategoryCourseObjects;
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
	
	
	
	public ArrayList<TimeTableObjects> InsertTTData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<TimeTableObjects> ttData = null;

	InsertTimeTableData idata=new InsertTimeTableData ();
			
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			ttData=idata.InsertTTData(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return ttData;

}
}
