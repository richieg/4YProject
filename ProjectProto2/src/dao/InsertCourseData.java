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

	public class InsertCourseData { 
		
		public ArrayList<MessageObjects>InsertCourse(Connection connection, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
				
			ArrayList<MessageObjects> courseMessage = new ArrayList<MessageObjects>();
			int catid;
			int courseid;
			String coursename;
			String accredbodname;
			int tutorid;
			int semesterid;
			int capacity;
			int equipreq;
			int level;
			int archived=0;
			int rt=0;
			int coursecheck=0;
			
			   catid = Integer.valueOf(request.getParameter("catid"));
			   courseid=Integer.valueOf(request.getParameter("courseid"));
			   coursename=request.getParameter("coursename");
			   level=Integer.valueOf(request.getParameter("level"));
			   accredbodname=request.getParameter("accredbodname");
			   tutorid=Integer.valueOf(request.getParameter("tutorid"));
			   semesterid=Integer.valueOf(request.getParameter("semesterid"));
			   capacity=Integer.valueOf(request.getParameter("capacity"));
			   equipreq=Integer.valueOf(request.getParameter("equipreq"));
			 
			   if (courseid==1)
			   {
				   //coursecheck=CheckforCourses(coursename,connection);   
				   //coursecheck=CheckforCourses(coursename+","+","+accredbodname+","+level,connection);   
			   }
			 
			   MessageObjects messageObjects = new MessageObjects();
               if(coursecheck<1)	
               {
			   rt=InsertToCourses(catid,courseid,coursename,accredbodname,tutorid,semesterid,capacity,equipreq,level,connection);
               
					System.out.println(rt);
					   if(rt>0)
					   {
						   messageObjects.setMessagecode(6);
							messageObjects.setInsertmessagestring("<h4>Course Entered Successfully</h4>");
							courseMessage.add(messageObjects);
						    
							
					   }
					   else
					   {
						   messageObjects.setMessagecode(7);
							messageObjects.setInsertmessagestring("<h4>An error has occured</h4>");
							courseMessage.add(messageObjects);
					   }
		          }
               else{
            	   messageObjects.setMessagecode(7);
				messageObjects.setInsertmessagestring("<h4>A course with this name already exists</h4>");
				courseMessage.add(messageObjects);
               }
					
					return courseMessage;
			
		}
		
		public int InsertToCourses(int catid,int courseid,String coursename,String accredbodname,int tutorid,int semesterid,int capacity,int equipreq,int level,Connection connection)
		
		{
		
			
			CallableStatement cu;
			int successcnt=0;
			try {
				cu = connection.prepareCall("{Call addNewCourse(?,?,?,?,?,?,?,?,?,?)}");
				cu.setInt(1,catid);
				cu.setInt(2,courseid);
			   	cu.setString(3, coursename);
			   	cu.setString(4, accredbodname);
			   	cu.setInt(5,tutorid);
				cu.setInt(6,semesterid);
				cu.setInt(7,capacity);
				cu.setInt(8,equipreq);
				cu.setInt(9,level);
				
			  
			    cu.registerOutParameter(10, Types.INTEGER);
			    boolean cut =cu.execute();
			    successcnt=cu.getInt(10);
			   
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return successcnt;
		}
		
	public int CheckforCourses(String name,Connection connection){

		int dupcnt=0;
		CallableStatement cu;
		try {
			cu = connection.prepareCall("{Call checkForDups(?,?,?)}");
			cu.setInt(1,2);
		   	cu.setString(2, name);
		  
		    cu.registerOutParameter(3, Types.INTEGER);
		    boolean cut =cu.execute();
		   
		    	dupcnt= cu.getInt(3);
		    	//System.out.println("returned catcount::"+dupcnt);
		    	
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dupcnt;


	}
	


}
