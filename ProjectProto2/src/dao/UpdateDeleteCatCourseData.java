


	
	package dao;

	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
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
		public ArrayList<MessageObjects> RestoreArchiveCourseCat(Connection connection, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
				
			
				int checknum=0;
				int coursecatid=0;
				int instruct=0;
		
				String message=null;
				
				try {
			
			    //checknum= Integer.parseInt(request.getParameter("checknum"));
			    instruct= Integer.parseInt(request.getParameter("instructid"));
			    coursecatid=Integer.parseInt(request.getParameter("catcourseid"));
			    
			    System.out.println(instruct);
			 
			   		
			   		int up=0;
			   		int up1=0;
			   		if(instruct==4)
			   		{
			   			ps = connection.prepareStatement("Update tb_category set archived=1 where cat_id=?");
			   		}
			   		/*else if(instruct==1)
			   		{
			   			ps = connection.prepareStatement("Update tb_category set archived=0 where catid=?");
			   		}*/
			   		else if(instruct==5)
			   		{
			   			ps = connection.prepareStatement("Update tb_courses set archived=1 where course_id=?");
			   			ps1= connection.prepareStatement("Update tb_tutor_courses set archived=1 where course_id=?");
			   		}
			   		else
			   		{
			   			ps = connection.prepareStatement("Update tb_courses set archived=0 where course_id=?");
			   			ps1= connection.prepareStatement("Update tb_tutor_courses set archived=0 where course_id=?");
			   		}
					ps.setInt(1, coursecatid);
					ps1.setInt(1, coursecatid);
					
					up = ps.executeUpdate();
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
		

}
