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
		int instruct=Integer.valueOf(request.getParameter("instruct"));
		int attrib1=Integer.valueOf(request.getParameter("attrib1"));
		int attrib2=Integer.valueOf(request.getParameter("attrib2"));
		int attrib3=Integer.valueOf(request.getParameter("attrib3"));
		int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		
		
		System.out.println(instruct);
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		int rse=0;
		System.out.println("got to tt inset");
		ps = connection.prepareStatement("INSERT into TB_timetabletemp values(?,?,?,?,?,?)");
		ps.setInt(1,1);
		ps.setInt(2,attrib1);
		ps.setInt(3,attrib2);
		ps.setInt(4,attrib3);
		ps.setInt(5,attrib4);
		ps.setInt(6,1);
		
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
	
		int semid=Integer.valueOf(request.getParameter("semid"));
		
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
		int attrib1=Integer.valueOf(request.getParameter("attrib1"));
		int attrib2=Integer.valueOf(request.getParameter("attrib2"));
		int attrib3=Integer.valueOf(request.getParameter("attrib3"));
	
		
		
		System.out.println(instruct);
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<MessageObjects> insertMessage = new ArrayList<>();
		int rse=0;
		System.out.println("got to tt delete");
		ps = connection.prepareStatement("Delete from TB_timetabletemp where day=? and timeslot=? and tutorcourse=?;");
	
		ps.setInt(1,attrib1);
		ps.setInt(2,attrib2);
		ps.setInt(3,attrib3);
	
		
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



}
