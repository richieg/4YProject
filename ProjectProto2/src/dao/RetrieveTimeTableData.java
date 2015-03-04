package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CategoryCourseObjects;
import dto.TimeTableObjects;

public class RetrieveTimeTableData {
	
	
	public ArrayList<TimeTableObjects> GetTTData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PreparedStatement ps = null;
		int instruct=Integer.valueOf(request.getParameter("instruct"));
		int attrib1=Integer.valueOf(request.getParameter("attrib1"));
		int attrib2=Integer.valueOf(request.getParameter("attrib2"));
		int attrib3=Integer.valueOf(request.getParameter("attrib3"));
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<TimeTableObjects> ttData = new ArrayList<>();
		

		
		
		
		try
		{
		//int archived=Integer.parseInt(request.getParameter("archived"));
		if(instruct==1)
		{
		 ps = connection.prepareStatement("Select id,iname from tb_days where (select count(day) from tb_timetabletemp)<50;");
		}
		else if(instruct==2)
		{
			System.out.println("got to second statement");
		ps = connection.prepareStatement("Select id,iname from tb_times where id not in (select timeslot from tb_timetabletemp where day=?);");
		ps.setInt(1,attrib1);
		}
		else if(instruct==3)
		{
			ps=connection.prepareStatement("select tutorcourseid as id,coursename as iname from tb_tutor_courses inner join tb_courses on tb_tutor_courses.CourseID = tb_courses.Course_ID where tutorid not in(select tutorid from tb_timetabletemp inner join tb_tutor_courses on tb_tutor_courses.TutorCourseID = tb_timetabletemp.TutorCourse where day=? and timeslot=?);");
			ps.setInt(1,attrib1);
			ps.setInt(2,attrib2);
		}
		else if(instruct==4)
		{
			int resreq=0;
			ps=connection.prepareStatement("select  resourcesreq as reqrec from tb_tutor_courses where tutorcourseid=?;");
			ps.setInt(1,attrib3);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			resreq=rs.getInt("reqrec");
			}
			ps.close();
			if(resreq==2)
			{
				ps=connection.prepareStatement("select room_id as id,roomname as iname from tb_room where roomcapacity>=(select capacity from tb_tutor_courses where tutorcourseid=?) and pcqty>=(select capacity from tb_tutor_courses where tutorcourseid=?) and room_id not in (select roomid from tb_timetabletemp where day=? and timeslot=?);");
				ps.setInt(1,attrib3);
				ps.setInt(2,attrib3);
				ps.setInt(3,attrib1);
				ps.setInt(4,attrib2);
			}
			else
			{
				ps=connection.prepareStatement("select room_id as id,roomname as iname from tb_room where roomcapacity>=(select capacity from tb_tutor_courses where tutorcourseid=?) and room_id not in (select roomid from tb_timetabletemp where day=? and timeslot=?);");
				ps.setInt(1,attrib3);

				ps.setInt(2,attrib1);
				ps.setInt(3,attrib2);
			}
		}
		 //ps.setInt(1, instruct);
		 //ps.setInt(2,archived);
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			
			System.out.println(rs.getString("iname"));
		
		TimeTableObjects ttObject = new TimeTableObjects();
		ttObject.setId(rs.getInt("id"));
		ttObject.setIname(rs.getString("iname"));
	
		
		ttData.add(ttObject);

		   



			

		}
		return ttData;
		}
		catch(Exception e)
		{
		throw e;
		}
		}
		

}
