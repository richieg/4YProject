package models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import dao.CategoryCourseInsertData;
import dao.InsertCourseData;
import dao.UpdateDeleteCatCourseData;
import dao.UpdateDeleteUserData;
import dto.MessageObjects;

public class CategoryCourseManager {
	
	


	
	public ArrayList<MessageObjects>InsertCategory(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ArrayList<MessageObjects> categoryMessage = new ArrayList<MessageObjects>();
	
		try{
			
			
			
		
			CategoryCourseInsertData ccd = new CategoryCourseInsertData();
			categoryMessage = ccd.InsertCategory(connection, request, response);
			
		
		
	} catch (Exception e) {
		throw e;
		}
		return categoryMessage;
		
		}
	
	
	public ArrayList<MessageObjects>InsertCourse(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ArrayList<MessageObjects> categoryMessage = new ArrayList<MessageObjects>();
	
		try{
			
		
			
		
			InsertCourseData cd = new InsertCourseData ();
			categoryMessage = cd.InsertCourse(connection, request, response);
			
		
		
	} catch (Exception e) {
		throw e;
		}
		return categoryMessage;
		
		}
	
	
	
	
	
	
	
	public ArrayList<MessageObjects>RestoreArchiveCatCourse(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String message = null;
			
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
			try {
			
				
				System.out.println("got to manager for update");
				UpdateDeleteCatCourseData udcc= new UpdateDeleteCatCourseData();
				insertMessage=udcc.RestoreArchiveCourseCat(connection, request, response);

			
			} catch (Exception e) {
			throw e;
			}
			return insertMessage;
			}
	
	public ArrayList<MessageObjects>UpdateCatCourse(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String instructid=request.getParameter(("instructid"));
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
			try {
			
				
			
				
				System.out.println("got to manager for update 2");
				UpdateDeleteCatCourseData udcc= new UpdateDeleteCatCourseData();
				
				if(instructid.equals("6"))
				{
				insertMessage=udcc.UpdateCategory(connection, request, response);
				}
				else
				{
				insertMessage=udcc.UpdateCourse(connection, request, response);
				}
					
			
			} catch (Exception e) {
			throw e;
			}
			return insertMessage;
			}
	
	
	

	
}
