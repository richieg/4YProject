


package models;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import dao.InsertStudentData;
import dao.InsertUserData;
import dao.UpdateDeleteUserData;
import dto.MessageObjects;

public class StudentDataManager {
	public ArrayList<MessageObjects>InsertStudenttoCourse(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String message = null;
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();

			try{
			InsertStudentData isd= new InsertStudentData();
			insertMessage=isd.InsertStuData(connection, request, response);
			
			
			
							
						
							
					
								
		
		
			
			} catch (Exception e) {
			throw e;
			}
			return insertMessage;
			}
	
	
	
	public ArrayList<MessageObjects>UpdateStudentRecs(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String message = null;
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();

			try{
			InsertStudentData isd= new InsertStudentData();
			insertMessage=isd.UpdateStuData(connection, request, response);
			
			
			
							
						
							
					
								
		
		
			
			} catch (Exception e) {
			throw e;
			}
			return insertMessage;
			}
	
	
	
	
	
	
	
	
}
