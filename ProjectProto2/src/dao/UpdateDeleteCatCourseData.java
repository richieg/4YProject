


	
	package dao;

	import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


	import java.util.Random;

	import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MessageObjects;

	public class UpdateDeleteCatCourseData {
		
		ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
		PreparedStatement ps;
		PreparedStatement ps1;
		String message=null;
		int messageid=0;
		public ArrayList<MessageObjects> RestoreArchiveCourseCat(Connection connection, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
				
			
				int checknum=0;
				int coursecatid=0;
				int instruct=0;
		
		
				
				try {
			
			    //checknum= Integer.parseInt(request.getParameter("checknum"));
			    instruct= Integer.parseInt(request.getParameter("instructid"));
			    coursecatid=Integer.parseInt(request.getParameter("catcourseid"));
			    
			    System.out.println(instruct);
			    System.out.println(coursecatid);
			 
			   		
			   		int up=0;
			   		int up1=0;
			   		if(instruct==4)
			   		{
			   			//ps = connection.prepareStatement("Update tb_category set archived=1 where cat_id=?");
			   			ps1 = connection.prepareStatement("Update tb_category set archived=1 where cat_id=?");
			   		}
			   		/*else if(instruct==1)
			   		{
			   			ps = connection.prepareStatement("Update tb_category set archived=0 where catid=?");
			   		}*/
			   		else if(instruct==5)
			   		{
			   			//ps = connection.prepareStatement("Update tb_courses set archived=1 where course_id=?");
			   			ps1= connection.prepareStatement("Update tb_tutor_courses set archived=1 where tutorcourseid=?");
			   		}
			   		else
			   		{
			   			//ps = connection.prepareStatement("Update tb_courses set archived=0 where course_id=?");
			   			ps1= connection.prepareStatement("Update tb_tutor_courses set archived=0 where tutorcourseid=?");
			   		}
					//ps.setInt(1, coursecatid);
					ps1.setInt(1, coursecatid);
					
					up = ps1.executeUpdate();
					  System.out.println(up);
					
					if(up>0)
					{
						if(instruct==4)
						{
							message= "<div style='color:blue'>Category "+coursecatid+" deleted successfully</div>";
						}
						else
						{
							message= "<div style='color:blue'>Course "+coursecatid+" deleted successfully</div>";
						}
						/*else if (checknum==1 && instruct==1)
						{
							message= "<div style='color:blue'>Category "+coursecatid+" deleted successfully</div>";
						}
					}
					if(up>0 && up1>0)	
					{
						if(checknum==2 && instruct==1)
						{
							message= "<div style='color:blue'>Course "+coursecatid+" restored successfully</div>";
						}
						else
						{
							message= "<div style='color:blue'>Course "+coursecatid+" deleted successfully</div>";
						}*/
					}
					else message ="<div style='color:red'>An error has occured please contact IT!</div>";
					MessageObjects messageObjects = new MessageObjects();
					messageObjects.setMessagecode(2);
					messageObjects.setInsertmessagestring(message);
					insertMessage.add(messageObjects);
					
				} catch (Exception e) {
					throw e;
					}
				return insertMessage;
					}
		
		
		public ArrayList<MessageObjects>UpdateCategory(Connection connection, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			
			String name=null;
			String description=null;
			int catid=0;
			
			
			System.out.println("got to dao for update");
			
			name = request.getParameter("name");
			description = request.getParameter("description");
			catid = Integer.valueOf(request.getParameter("catid"));
			
				System.out.println(name);
			System.out.println(catid);
			System.out.println(description);
		    PreparedStatement ps;
		    int rse = 0;
			try {
				ps = connection.prepareStatement("Update TB_Category set categoryname=?,categorynotes=? where cat_id=?");
				
				ps.setString(1, name);
				ps.setString(2, description);
				ps.setInt(3, catid);
				
				
			
				
				 rse= ps.executeUpdate();
				 
					if(rse>0)
					{		messageid=1;
							message= "<div style='color:blue'>Category "+catid+" has been updated successfully</div>";
					}
					else{
						messageid=2;
						message ="<div style='color:red'>An error has occured please contact IT!</div>";
					}
					MessageObjects messageObjects = new MessageObjects();
					messageObjects.setMessagecode(messageid);
					messageObjects.setInsertmessagestring(message);
					insertMessage.add(messageObjects);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return insertMessage;
		}
		
		public ArrayList<MessageObjects>UpdateCourse(Connection connection, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			
			int tutorid=0;
			int capacity=0;
			int courseid=0;
			
			

			
			tutorid = Integer.valueOf(request.getParameter("tutorid"));
			capacity = Integer.valueOf(request.getParameter("capacity"));
			courseid = Integer.valueOf(request.getParameter("courseid"));
			
	
		    PreparedStatement ps1;
		    int rse = 0;
			try {

				ps1  = connection.prepareStatement("Update TB_Tutor_Courses set tutorid=?, capacity=? where tutorcourseid=?");
		
				ps1.setInt(1,tutorid);
				ps1.setInt(2, capacity);
				ps1.setInt(3, courseid);
				
				
			
				
		
				 rse=ps1.executeUpdate();
				 
				 
					if(rse>0)
					{
							message= "<div style='color:blue'>Course "+courseid+" has been updated successfully</div>";
					}
					else message ="<div style='color:red'>An error has occured please contact IT!</div>";
					MessageObjects messageObjects = new MessageObjects();
					messageObjects.setMessagecode(2);
					messageObjects.setInsertmessagestring(message);
					insertMessage.add(messageObjects);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return insertMessage;
		}
		
		

}
