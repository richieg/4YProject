package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MessageObjects;
import dto.TimeTableObjects;

public class InsertTimeTableData {
	
	
	public ArrayList<MessageObjects> InsertTTData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("got to tt inset");
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		int ttid=0;
		int instruct=Integer.valueOf(request.getParameter("instruct"));
		int dayid=Integer.valueOf(request.getParameter("dayid"));
		int timeid=Integer.valueOf(request.getParameter("timeid"));
		int courseid=Integer.valueOf(request.getParameter("courseid"));
		int roomid=Integer.valueOf(request.getParameter("roomid"));
		int timetableid=Integer.valueOf(request.getParameter("timetableid"));
		
		
		System.out.println(instruct);
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		int rse=0;
		System.out.println("got to tt inset");
	
		
		ps = connection.prepareStatement("INSERT into TB_timetabletemp values(?,?,?,?,?,?,?)");
		ps.setInt(1,timetableid);
		ps.setInt(2,dayid);
		ps.setInt(3,timeid);
		ps.setInt(4,courseid);
		ps.setInt(5,roomid);
		ps.setInt(6,1);
		ps.setString(7,"2015-03-10");
		
		rse= ps.executeUpdate();
		System.out.println(rse);
		MessageObjects messageObjects = new MessageObjects();
		if(rse>0)
		{  
		
			messageObjects.setMessagecode(1);
			messageObjects.setInsertmessagestring("<div style='color:blue'>New entry added to timetable successfully</div>");
			insertMessage.add(messageObjects);
			
			
		}
		else
		{
			messageObjects.setMessagecode(2);
			messageObjects.setInsertmessagestring("<div style='color:red'>An error has occured please contact IT!</div>");
			insertMessage.add(messageObjects);
		}
		return insertMessage;
		}
	
	
	
	public ArrayList<MessageObjects> SaveTTWIP(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
	
		PreparedStatement ps = null;
	
		
		
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		int rse=0;
		System.out.println("got to tt inset");
		ps = connection.prepareStatement("Update TB_timetabletemp set archived=0");
	
	
		
		rse= ps.executeUpdate();
		System.out.println(rse);
		MessageObjects messageObjects = new MessageObjects();
		if(rse>0)
		{  
		
			messageObjects.setMessagecode(1);
			messageObjects.setInsertmessagestring("<div style='color:blue'>New entry added to timetable successfully</div>");
			insertMessage.add(messageObjects);
			
			
		}
		else
		{
			messageObjects.setMessagecode(2);
			messageObjects.setInsertmessagestring("<div style='color:red'>An error has occured please contact IT!</div>");
			insertMessage.add(messageObjects);
		}
		return insertMessage;
		}
	
	
	public ArrayList<MessageObjects> SaveTTPerm(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
	
		CallableStatement ps = null;
		PreparedStatement pr=null;
		int semid=Integer.valueOf(request.getParameter("semid"));
		int instruct=Integer.valueOf(request.getParameter("instruct"));
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		Boolean rse=false;
		System.out.println("got to tt inset");
		ps = connection.prepareCall("{Call SaveTT(?,?)}");
		ps.setInt(1, semid);
		ps.registerOutParameter(2, Types.INTEGER);
	
	
	
		
		rse= ps.execute();
		int semcount=ps.getInt(2);
		System.out.println("sem count="+semcount);
		System.out.println(rse);
		MessageObjects messageObjects = new MessageObjects();
		if(semcount>0)
		{  
		
			messageObjects.setMessagecode(1);
			messageObjects.setInsertmessagestring("<div style='color:blue'>New entry added to timetable successfully</div>");
			insertMessage.add(messageObjects);
			if(instruct==11)
			{ 
				
				pr=connection.prepareStatement("insert into tb_timetabletemp select * from tb_timetabletemp2;");
				int ss=pr.executeUpdate();
				System.out.println("value after insert to temp from temps2"+ss);
				if(ss>0)
				{
					
					pr=connection.prepareStatement("delete from tb_timetabletemp where semesterid=?");
					pr.setInt(1,semid);
					int st=pr.executeUpdate();
					System.out.println("value after delete fromtfrom temps2"+st);
					if(st>0)
					{
						pr=connection.prepareStatement("delete from tb_timetabletemp2");
						int sp=pr.executeUpdate();
					}
				}
			}
			
			
		}
		else
		{
			messageObjects.setMessagecode(2);
			messageObjects.setInsertmessagestring("<div style='color:red'>An error has occured please contact IT!</div>");
			insertMessage.add(messageObjects);
		}
		return insertMessage;
		}
	
	
	public ArrayList<MessageObjects> ResetTTWIP(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
	
		PreparedStatement ps = null;
	
		
		
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		int rse=0;
		System.out.println("got to tt inset");
		ps = connection.prepareStatement("Delete from TB_timetabletemp where archived=1");
	
	
		
		rse= ps.executeUpdate();
		System.out.println(rse);
		MessageObjects messageObjects = new MessageObjects();
		if(rse>0)
		{  
		
			messageObjects.setMessagecode(1);
			messageObjects.setInsertmessagestring("<div style='color:blue'>New entry added to timetable successfully</div>");
			insertMessage.add(messageObjects);
			
			
		}
		else
		{
			messageObjects.setMessagecode(2);
			messageObjects.setInsertmessagestring("<div style='color:red'>An error has occured please contact IT!</div>");
			insertMessage.add(messageObjects);
		}
		return insertMessage;
		}
	
	
	public ArrayList<MessageObjects> InsertSemester(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
	
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		String startdate=null;
		String enddate = null;
		int semester=0;
		
		semester=Integer.valueOf(request.getParameter("semester"));
		startdate=request.getParameter("startdate");
		enddate=request.getParameter("enddate");
	
		
		
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		int rse=0;
		
		System.out.println("got to tt inset");
		ps = connection.prepareStatement("insert into tb_semester(startdate,enddate,semesterid) values(?,?,?)");
	
		ps.setString(1, startdate);
		ps.setString(2, enddate);
		ps.setInt(3, semester);
		
		rse= ps.executeUpdate();
		System.out.println(rse);
		MessageObjects messageObjects = new MessageObjects();
		if(rse>0)
		{  
			ps1 = connection.prepareStatement("select id from tb_semester where startdate=? and enddate=? and semesterid=?");
			ps1.setString(1, startdate);
			ps1.setString(2, enddate);
			ps1.setInt(3, semester);
			ResultSet rs = ps1.executeQuery();
			while (rs.next())
			{
			int semid=rs.getInt("id");
			
				messageObjects.setMessagecode(semid);
				messageObjects.setInsertmessagestring("<div style='color:blue'>New semester added succesfully</div>");
				insertMessage.add(messageObjects);
				
			
		
			}
			
			
		}
		else
		{
			messageObjects.setMessagecode(2);
			messageObjects.setInsertmessagestring("<div style='color:red'>An error has occured please contact IT!</div>");
			insertMessage.add(messageObjects);
		}
		return insertMessage;
		}
	
	
	
	public ArrayList<MessageObjects> InsertHols(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
	
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		String startdate=null;
		String enddate = null;
		int semester=0;
		
		semester=Integer.valueOf(request.getParameter("semester"));
		startdate=request.getParameter("startdate");
		enddate=request.getParameter("enddate");
	
		
		
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		int rse=0;
		
		System.out.println("got to tt inset");
		ps = connection.prepareStatement("insert into tb_excludedates (startdate,enddate,semesterid) values(?,?,?)");
	
		ps.setString(1, startdate);
		ps.setString(2, enddate);
		ps.setInt(3, semester);
		
		rse= ps.executeUpdate();
		System.out.println(rse);
		MessageObjects messageObjects = new MessageObjects();
		if(rse>0)
		{  
			
			
				messageObjects.setMessagecode(1);
				messageObjects.setInsertmessagestring("<div style='color:blue'>New semester added succesfully</div>");
				insertMessage.add(messageObjects);
				
			
		
			
			
			
		}
		else
		{
			messageObjects.setMessagecode(2);
			messageObjects.setInsertmessagestring("<div style='color:red'>An error has occured please contact IT!</div>");
			insertMessage.add(messageObjects);
		}
		return insertMessage;
		}
	
	
	
	public ArrayList<MessageObjects> DeleteTTData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("got to tt inset");
		PreparedStatement ps = null;
		
		int instruct=Integer.valueOf(request.getParameter("instruct"));
		int dayid=Integer.valueOf(request.getParameter("dayid"));
		int timeid=Integer.valueOf(request.getParameter("timeid"));
		int courseid=Integer.valueOf(request.getParameter("courseid"));
	
		
		
		System.out.println(instruct);
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		int rse=0;
		System.out.println("got to tt delete");
		ps = connection.prepareStatement("Delete from TB_timetabletemp where day=? and timeslot=? and tutorcourse=?;");
	
		ps.setInt(1,dayid);
		ps.setInt(2,timeid);
		ps.setInt(3,courseid);
	
		
		rse= ps.executeUpdate();
		System.out.println("value after delete="+rse);
		MessageObjects messageObjects = new MessageObjects();
		if(rse>0)
		{  
		
			messageObjects.setMessagecode(1);
			messageObjects.setInsertmessagestring("<div style='color:blue'>New entry added to timetable successfully</div>");
			insertMessage.add(messageObjects);
			
			
		}
		else
		{
			messageObjects.setMessagecode(2);
			messageObjects.setInsertmessagestring("<div style='color:red'>An error has occured please contact IT!</div>");
			insertMessage.add(messageObjects);
		}
		return insertMessage;
		}



}
