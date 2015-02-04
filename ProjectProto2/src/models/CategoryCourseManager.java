package models;


import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import dao.CategoryCourseInsertData;
import dto.MessageObjects;

public class CategoryCourseManager {
	
	public ArrayList<MessageObjects>InsertCategory(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message=null;
		ArrayList<MessageObjects> categoryMessage = new ArrayList<MessageObjects>();
	
		try{
			message =(request.getParameter("fname"))+" "+(request.getParameter("lname"));
			
			if(message != null && message !="" && message.length()>0)
			{
			
		
			CategoryCourseInsertData ccd = new CategoryCourseInsertData();
			categoryMessage = ccd.InsertCategory(connection, request, response);
			
			}
		
	} catch (Exception e) {
		throw e;
		}
		return categoryMessage;
		
		}
}
