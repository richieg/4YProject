package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		 ps = connection.prepareStatement("Select id,iname from tb_days;");
		}
		else if(instruct==2)
		{
			
		ps = connection.prepareStatement("Select distinct tb_times.id,iname,day from tb_times inner join tb_timetabletemp on tb_timetabletemp.Day =? where timeslot not in(select timeslot from tb_timetabletemp where day=? having count(timeslot)>5 );");
		ps.setInt(1,attrib1);
		ps.setInt(2, attrib2);
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
				ps=connection.prepareStatement("select distinct room_id as id,roomname as iname from tb_room where roomcapacity>=(select capacity from tb_tutor_courses where tutorcourseid=?) and pcqty>=(select capacity from tb_tutor_courses where tutorcourseid=?) and room_id not in (select roomid from tb_timetabletemp where day=? and timeslot=?);");
				ps.setInt(1,attrib3);
				ps.setInt(2,attrib3);
				ps.setInt(3,attrib1);
				ps.setInt(4,attrib2);
			}
			else
			{
				ps=connection.prepareStatement("select distinct room_id as id,roomname as iname from tb_room where roomcapacity>=(select capacity from tb_tutor_courses where tutorcourseid=?) and room_id not in (select roomid from tb_timetabletemp where day=? and timeslot=?);");
				ps.setInt(1,attrib3);

				ps.setInt(2,attrib1);
				ps.setInt(3,attrib2);
			}
		}
		else if (instruct==7)
		{
			ps=connection.prepareStatement("select distinct tb_semester.semesterid as id, year(startdate) as iname from tb_timetable inner join tb_semester on tb_semester.ID=tb_timetable.semesterid;");
			
		}
		
		else if (instruct==8)
		{
			ps=connection.prepareStatement("select distinct tb_semester.semesterid as id, year(startdate) as iname from tb_timetable inner join tb_semester on tb_semester.ID=tb_timetable.semesterid where tb_semesterid=?;");
			
		}
		 //ps.setInt(1, instruct);
		 //ps.setInt(2,archived);
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
		
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
		
		
		public ArrayList<TimeTableObjects> RetireveTimeTable(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
		{
				
		PreparedStatement ps1;
		PreparedStatement ps2;
		PreparedStatement ps3;
		ResultSet rs;
		int ttid = -2;
		int timetableid=-2;
		int instruct=Integer.valueOf(request.getParameter("instruct"));
		ArrayList<TimeTableObjects> ttData = new ArrayList<>();
		String [] tables={"tb_timetable","tb_timetabletemp"};
	
		ttid=Integer.valueOf(request.getParameter("table"));
		
		System.out.println("ttid for update="+ttid);
		int ack=0;
	
		System.out.println("got to dao");
		System.out.println("ttid"+ttid);
		String table=null;
		String fromWhere=null;
		String optString=null;
		
	
		
		
		
		System.out.println(table);
		
		
		if(instruct==10)
		{
			ack=1;
			timetableid=Integer.valueOf(request.getParameter("timetableid"));
			ps1=connection.prepareStatement("insert into tb_timetabletemp2 select * from tb_timetabletemp;");
			int res = ps1.executeUpdate();
			if(res>0)
			{
			ps1=connection.prepareStatement("delete from tb_timetabletemp;");
			int res2=ps1.executeUpdate();
			if(res2>0)
			{
				ps1=connection.prepareStatement("insert into tb_timetabletemp (semesterid,day,timeslot,tutorcourse,roomid) select semesterid,day,timeslot,TutorCourse,roomid from tb_timetable where semesterid=?;");
				ps1.setInt(1,timetableid);
				int res3=ps1.executeUpdate();
				if(res3>0)
				{
					ps1=connection.prepareStatement("delete from tb_timetable where semesterid=?;");
					ps1.setInt(1,timetableid);
					int res5=ps1.executeUpdate();
					if(res5>0)
					{
					ack=0;
					ttid=1;
					}
				}
				
			}
			else
			{
				ps3=connection.prepareStatement("delete from tb_timetabletemp;");
				ps2=connection.prepareStatement("insert into tb_timetabletemp select * from tb_timetabletemp2;");
				int res4=ps2.executeUpdate();
				int res5=ps3.executeUpdate();
			}
			}
			
		}
		if(ack==0)
		{
		table=tables[ttid];
		if(instruct==0)
		{
			fromWhere="(select max(semesterid) from "+table+")";
			optString=">0";
		}
		else if(instruct==20)
		{
			optString="="+Integer.valueOf(request.getParameter("tutorid"));
			fromWhere="(select max(semesterid) from "+table+")";
		}
			
		else
		{
			timetableid=Integer.valueOf(request.getParameter("timetableid"));
			fromWhere=""+timetableid+"";
			optString=">0";
		}
	
		for(int daycnt=0;daycnt<5;daycnt++)
		{
		ps1=connection.prepareStatement("select day,tb_days.iname as dayname,timeslot,tutorcourse,coursename,roomid,roomname,concat(substring(FirstName,1,1),'.', LastName) as tname,"+table+".semesterid as sem, year(startdate) as year from " +table
		+ " inner join tb_tutor_courses on tb_tutor_courses.TutorCourseID ="+table+".TutorCourse "
		+ "inner join tb_courses on tb_courses.course_id=tb_tutor_courses.courseid join tb_semester on tb_semester.ID="+table+".semesterid "
		+ "inner join tb_days on tb_days.id="+table+".day "
		+ "inner join tb_user on tb_user.UserID=tb_tutor_courses.TutorID "
		+ "inner join tb_room on tb_room.Room_ID="+table+".RoomID where day=? and "+table+".semesterid="+fromWhere+" and tutorid " +optString+ " order by day,timeslot;");
			   System.out.println(ps1);
		
			
			   ps1.setInt(1, daycnt);
			  
			rs = ps1.executeQuery();
				int curday=0;
				
				String [] [] slots;
				
				int times=10;
				int timeslots=5;
				int day=0;
				int time=0;
				int tc=0;
				int semesterid=0;
				int room=0;
				String timetabletitle=null;
				
				String dayname=null;
				String roomname = null;
				String coursename=null;
				String tutorname=null;
				String [] days={"Monday","Tuesday","Wednesday","Thursday","Friday"};
				String [] colours={"#FDFD96","#77DD77","AECC6CF","#FFD1DC","#B19CD9"};

				int [] slotscnt;
				slotscnt=new int[50];
				slots=new String[times][timeslots];
				setSlots(slotscnt,slots,times,timeslots);
				
		
			
			
			    while(rs.next())
				{
			   
			    day=rs.getInt("day");
			    dayname=rs.getString("dayname");
			    time=rs.getInt("timeslot");
			    tc=rs.getInt("tutorcourse");
			    coursename=rs.getString("coursename");
			    room=rs.getInt("roomid");
			    roomname=rs.getString("roomname");
			    tutorname=rs.getString("tname");
			    semesterid=rs.getInt("sem");
			    timetabletitle=("Semester: "+rs.getString("sem").concat(" ").concat("Year: "+rs.getString("year")));
			    
			    
			    String button = null;
				
				if(ttid==1 || instruct==10)
				{
					button="<button class='btn btn-danger' id='deleteE' day='"+day+"' time='"+time+"' course='"+tc+"'>X</button>";
				}
				else
				{
					
						button="";
			
				}
			    
			    
	
			   
			
				  
			    
			    	slotscnt[time]=slotscnt[time]+1;
			    	
			    	slots[time][slotscnt[time]]=button+"<br><span style='color:blue'>"+coursename+"</span><br><span style='color:red'>"+tutorname+"</span><br><span style='color:green'>"+roomname+"</sapn>";
			    
			  
			    }
			    
			    
			
				for(int b=0;b<timeslots;b++)
				{
				TimeTableObjects ttObject = new TimeTableObjects();
				
				ttObject.setId(daycnt);
				if(b==0)
				{
				ttObject.setIname("<span style='font-size:20px'><b>"+days[daycnt]+"</B></span>");
				}
				else
				{
					ttObject.setIname(" ");	
				}
				
				ttObject.setCell(slots[0][b]);
				ttObject.setCell1(slots[1][b]);
				ttObject.setCell2(slots[2][b]);
				ttObject.setCell3(slots[3][b]);
				ttObject.setCell4(slots[4][b]);
				ttObject.setCell5(slots[5][b]);
				ttObject.setCell6(slots[6][b]);
				ttObject.setCell7(slots[7][b]);
				ttObject.setCell8(slots[8][b]);
				ttObject.setCell9(slots[9][b]);
				ttObject.setId(semesterid);
				ttObject.setTimetabletitle(timetabletitle);
				System.out.println(ttObject.getCell1());
			
				ttData.add(ttObject);
				}
		}
		

				
				
}	
			
				
		return ttData;
			
			}
			
			public void setSlots(int [] slotscnt,String [] [] slots, int times,int timeslots)
			{
			for(int a=0;a<slotscnt.length;a++)
			{
				slotscnt[a]=-1;
				
			}
			for(int b=0;b<times;b++)
			{
				for(int d=0;d<timeslots;d++)
				{
				slots[b][d]=" ";
				}
				//slots[ ][b]=" ";
			}
			}
		
		
			public ArrayList<TimeTableObjects> RetireveSemesterDetails(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
			{
				PreparedStatement ps1;
				String startdate;
				String enddate;
				ArrayList<TimeTableObjects> ttData = new ArrayList<>();
				Gson gson = new Gson();
				ps1=connection.prepareStatement("select id,SemesterID,StartDate,EndDate from tb_semester where semesterid!=-1;");
				ResultSet rs = ps1.executeQuery();
				
		
				while (rs.next())
				{
					  SimpleDateFormat ft = 
						      new SimpleDateFormat ("dd.MM.yyyy");
					  startdate=ft.format(rs.getDate("StartDate"));
					  enddate=ft.format(rs.getDate("EndDate"));
					System.out.println(rs.getInt("semesterID")+" "+startdate+" "+enddate);
					TimeTableObjects ttObject = new TimeTableObjects();
					ttObject.setSemid(rs.getInt("semesterID"));
					ttObject.setStartdate(startdate);
					ttObject.setEndate(enddate);
					ttData.add(ttObject);
					
				}
				String ttdata = gson.toJson(ttData);
				
				System.out.println(ttdata);
				return ttData;
				
			}
			
			
			
			public ArrayList<TimeTableObjects> RetireveTutorTT(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
			{
				PreparedStatement ps1;
				String startdate;
				String enddate;
				ArrayList<TimeTableObjects> ttData = new ArrayList<>();
				
				ps1=connection.prepareStatement("select tutorcourseid,tb_times.iname as timeslot,CourseName,RoomName from tb_timetable inner join tb_tutor_courses on tb_tutor_courses.tutorcourseid=tb_timetable.tutorcourse inner join tb_courses on tb_courses.course_id=tb_tutor_courses.CourseID inner join tb_times on tb_times.id=tb_timetable.timeslot inner join tb_room on tb_room.Room_ID=tb_timetable.RoomID where day = 0 and tutorid=?;");
				ps1.setInt(1, Integer.valueOf(request.getParameter("tutorid")));
				ResultSet rs = ps1.executeQuery();
				//dayofweek(curdate())
		
				while (rs.next())
				{
					 /* SimpleDateFormat ft = 
						      new SimpleDateFormat ("dd.MM.yyyy");
					  startdate=ft.format(rs.getDate("StartDate"));
					  enddate=ft.format(rs.getDate("EndDate"));*/
					
					TimeTableObjects ttObject = new TimeTableObjects();
					ttObject.setCell(rs.getString("timeslot"));
					ttObject.setCell1(rs.getString("coursename"));
					ttObject.setCell2(rs.getString("roomname"));
					ttObject.setCell3("<button class='btn btn-info' id='rollcall' data-toggle='modal' data-target='#rollcallmodal'><span class='glyphicon glyphicon-eye-open'></span></button>");
					ttData.add(ttObject);
					
				}
				return ttData;
				
			}
			
			
			
			
		
		
		

}
