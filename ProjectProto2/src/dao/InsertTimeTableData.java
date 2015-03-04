package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TimeTableObjects;

public class InsertTimeTableData {
	
	
	public ArrayList<TimeTableObjects> InsertTTData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		int instruct=Integer.valueOf(request.getParameter("instruct"));
		int attrib1=Integer.valueOf(request.getParameter("attrib1"));
		int attrib2=Integer.valueOf(request.getParameter("attrib2"));
		int attrib3=Integer.valueOf(request.getParameter("attrib3"));
		int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		//int attrib4=Integer.valueOf(request.getParameter("attrib4"));
		ArrayList<TimeTableObjects> ttData = new ArrayList<>();
		int rse=0;
		
		ps = connection.prepareStatement("INSERT into TB_timetabletemp values(?,?,?,?,?,?)");
		ps.setInt(1,1);
		ps.setInt(2,attrib1);
		ps.setInt(3,attrib2);
		ps.setInt(4,attrib3);
		ps.setInt(5,attrib4);
		ps.setInt(6,0);
		
		rse= ps.executeUpdate();
		System.out.println(rse);
		if(rse>0)
		{  System.out.println("got to here 1");
for(int daycnt=0;daycnt<5;daycnt++)
{
ps1=connection.prepareStatement("select day,tb_days.iname as dayname,timeslot,tutorcourse,coursename,roomid,roomname,concat(FirstName,' ', LastName) as tname from tb_timetabletemp " 
+ "inner join tb_tutor_courses on tb_tutor_courses.TutorCourseID =tb_timetabletemp.TutorCourse "
+ "inner join tb_courses on tb_courses.course_id=tb_tutor_courses.courseid "
+ "inner join tb_days on tb_days.id=tb_timetabletemp.day "
+ "inner join tb_user on tb_user.UserID=tb_tutor_courses.TutorID "
+ "inner join tb_room on tb_room.Room_ID=tb_timetabletemp.RoomID where day=? order by day,timeslot;");
	   System.out.println("got to here 2");
	   ps1.setInt(1, daycnt);
		ResultSet rs = ps1.executeQuery();
		int curday=0;
		
		String [] [] slots;
		;
		int times=10;
		int timeslots=5;
		int day=0;
		int time=0;
		int tc=0;
		int room=0;
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
	    System.out.println("got to here 3");
	    day=rs.getInt("day");
	    dayname=rs.getString("dayname");
	    time=rs.getInt("timeslot");
	    tc=rs.getInt("tutorcourse");
	    coursename=rs.getString("coursename");
	    room=rs.getInt("roomid");
	    roomname=rs.getString("roomname");
	    tutorname=rs.getString("tname");
	    
	    System.out.println(day);
	    System.out.println(dayname);
	    
	    
	    System.out.println(time);
	  
	    System.out.println(tc);
	    
	    System.out.println(coursename);
	
	    System.out.println(room);
	    System.out.println(roomname);
	   
	
		  
	    
	    	slotscnt[time]=slotscnt[time]+1;
	    	System.out.println("slots cnt"+slotscnt[time]);
	    	slots[time][slotscnt[time]]=coursename+"<br>"+tutorname+"<br>"+roomname;
	    	System.out.println(slots[time][slotscnt[time]]);
	    	
	    	
	    	System.out.println("got to here 1 !!!!!");
	  
	    }
	    
	    
	    System.out.println("got to here 2!!!!!");
	
			System.out.println("got to here 3 !!!!!");
		for(int b=0;b<timeslots;b++)
		{
		TimeTableObjects ttObject = new TimeTableObjects();
		
		ttObject.setId(daycnt);
		if(b==0)
		{
		ttObject.setIname(days[daycnt]);
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
}
