package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RetrieveData;
import dto.RecordObjects;
import dto.UserObjects;

public class RetrieveManager {
	
	
	
	public ArrayList GetUserDataInitial(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList userData1 = null;
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
			RetrieveData rdata=new RetrieveData();
			userData1=rdata.GetUserDataInitial(connection, request, response);
			
			} 
			catch (Exception e) {
			throw e;
			}
			return userData1;
			}
	
	public ArrayList<UserObjects> GetUserData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<UserObjects> userData = null;
		RetrieveData rdata=new RetrieveData();
			
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
			
			userData=rdata.GetUserData(connection, request, response);
			} 
			catch (Exception e) {
			throw e;
			}
			return userData;
			}
	public ArrayList<RecordObjects> GetRecs(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		
		RetrieveData rdata=new RetrieveData();
		ArrayList<RecordObjects> userRecord = new ArrayList<RecordObjects>();
	try
	{


		

		 userRecord=rdata.GetRecs(connection, request, response);
		 

	}
	catch(Exception e)
	{
	throw e;
	}
	return userRecord;
	}

}
