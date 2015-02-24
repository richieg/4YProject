package dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import dto.MessageObjects;

public class InsertStudentData {
	
	
	public ArrayList<MessageObjects>InsertStuData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
			String dataIn=null;
			int datainSize=0;
			
		
			
			
					
					//String instructid=request.getParameter(("instructid"));
					System.out.println("got to student inert");
					//String[] studentData = request.getParameterValues("Data[]");
					
					String data=request.getParameter("data");
					System.out.println(data);
					Object obj = JSONValue.parse(data);
					JSONArray array = (JSONArray) obj;
					datainSize=array.size();
					dataIn=null;
					
					 StringBuilder finalStringb =new StringBuilder();
					  
				 
					    

					
					for(int i=0;i<datainSize;i++)
					{
					 
						 System.out.println(array.get(i));
						 if(i==datainSize-1)
						 {
							 finalStringb.append(array.get(i)); 
						 }
						 else
						 {
						 finalStringb.append(array.get(i)).append(","); 
						 }
						 
					}
					String finalS = finalStringb.toString();
					System.out.println(finalS);
		
			
			CallableStatement ps;
			try {
				ps = connection.prepareCall("{Call insertStudentData(?,?,?)}");
				ps.setString(1,finalS);
				ps.setInt(2,datainSize);
				ps.registerOutParameter(3, Types.INTEGER);
				Boolean rs = ps.execute();
				int sr=ps.getInt(3);
				MessageObjects messageObjects = new MessageObjects();
				if(sr!=datainSize)
				{
					messageObjects.setMessagecode(2);
					messageObjects.setInsertmessagestring("An error has occured please review data and try again");
					insertMessage.add(messageObjects);
					
				}
				
				else{
			
				messageObjects.setMessagecode(1);
				messageObjects.setInsertmessagestring("Students added to courses succesffully");
				insertMessage.add(messageObjects);
				}
		

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return  insertMessage ;

		
	} catch (Exception e) {
	throw e;
	}
			
	}
	
	
	
	public ArrayList<MessageObjects>UpdateStuData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
		
			int datainSize=0;
			
			
			int courseid=0;
			int instruct=0;
			int studentid=0;
			String ngrade = null;
			
	
	
			
			try {
			PreparedStatement ps = null;
		    
		    instruct= Integer.parseInt(request.getParameter("instructid"));
		    courseid=Integer.parseInt(request.getParameter("courseid"));
		    ngrade=request.getParameter("grade");
		    studentid=Integer.parseInt(request.getParameter("studentid"));
		    
		    System.out.println(instruct);
		    System.out.println(courseid);
		 
		   		
		   		if(instruct==8)
		   		{
		   			//ps = connection.prepareStatement("Update tb_category set archived=1 where cat_id=?");
		   			ps = connection.prepareStatement("Update tb_student_courses set grade=? where tutorcourseid=? and student_id=?");
		   		}
		   		
		   		ps.setInt(2, courseid);
		   		ps.setString(1, ngrade);
		   		ps.setInt(3, studentid);
		   		
		   		
			
		
			
			
					int sr = ps.executeUpdate();

				MessageObjects messageObjects = new MessageObjects();
				if(sr<1)
				{
					messageObjects.setMessagecode(2);
					messageObjects.setInsertmessagestring("An error has occured please review data and try again");
					insertMessage.add(messageObjects);
					
				}
				
				else{
			
				messageObjects.setMessagecode(1);
				messageObjects.setInsertmessagestring("Student grade update succesffully");
				insertMessage.add(messageObjects);
				}
		

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return  insertMessage ;

		
	} catch (Exception e) {
	throw e;
	}
			
	}
	
	
	
	
}

	


