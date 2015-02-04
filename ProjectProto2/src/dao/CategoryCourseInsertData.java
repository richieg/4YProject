package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MessageObjects;

public class CategoryCourseInsertData {
	
	public ArrayList<MessageObjects>InsertCategory(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		ArrayList<MessageObjects> categoryMessage = new ArrayList<MessageObjects>();
		String name=null;
		String description=null;
		int archived=0;
		int rt=0;
		int catcheck=0;
		
		   name = request.getParameter("name");
		   description = request.getParameter("description");
		   
		   catcheck=CheckforCategory(name,connection);
		   System.out.println("catcheck="+catcheck);
		 
		   rt=InsertToCategory(name,description,archived,connection);
		   MessageObjects messageObjects = new MessageObjects();
		   if(rt>0)
		   {
			   messageObjects.setMessagecode(6);
				messageObjects.setInsertmessagestring("<h4>Category Entered Successfully</h4>");
				categoryMessage.add(messageObjects);
			    
				
		   }
		   else
		   {
			   messageObjects.setMessagecode(7);
				messageObjects.setInsertmessagestring("<h4>Ann error has occured</h4>");
				categoryMessage.add(messageObjects);
		   }
		
		return categoryMessage;
		
	}
	
	public int InsertToCategory(String name,String description, int archived,Connection connection){
		
	    PreparedStatement ps;
	    int rse = 0;
		try {
			ps = connection.prepareStatement("INSERT into TB_Category (categoryname,categorynotes,archived) values(?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setInt(3, archived);
		
			
			 rse= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return rse;
	}
	
public int CheckforCategory(String name,Connection connection){

	int dupcnt=0;
	CallableStatement cu;
	try {
		cu = connection.prepareCall("{Call checkForDups(?,?,?)}");
		cu.setInt(1,1);
	   	cu.setString(2, name);
	  
	    cu.registerOutParameter(3, Types.INTEGER);
	    boolean cut =cu.execute();
	   
	    	dupcnt= cu.getInt(3);
	    	System.out.println("returned catcount::"+dupcnt);
	    	
	    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dupcnt;


}
}
