package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CategoryCourseObjects;
import dto.CourseObjects;


public class CategoryCourseRetrieveData {
	
	public ArrayList<CategoryCourseObjects> GetCatData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PreparedStatement ps = null;
		int instruct=Integer.valueOf(request.getParameter("instruct"));
		ArrayList<CategoryCourseObjects> catData = new ArrayList<>();
	try
	{
	int archived=Integer.parseInt(request.getParameter("archived"));
	
	 ps = connection.prepareStatement("SELECT cat_id,categoryname,categorynotes,count(courseid) as coursecount,btn4,btn1,btn2,btn3 FROM TB_category "
	 		+ "inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=? "
	 		+ "left outer join tb_courses on tb_category.Cat_ID=tb_courses.Category "
	 		+ "left outer join tb_tutor_courses on tb_tutor_courses.courseid=tb_courses.course_id "
	 		+ "and tb_category.Archived=tb_courses.archived where tb_category.archived=? group by cat_id;");
	 ps.setInt(1, instruct);
	 ps.setInt(2,archived);
	 
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		
	String coursecnt=String.valueOf(rs.getInt("coursecount"));
	int ccount=rs.getInt("coursecount");
	CategoryCourseObjects catCourseObject = new CategoryCourseObjects();
	catCourseObject.setCategoryid(rs.getInt("cat_id"));
	catCourseObject.setCatname(rs.getString("categoryname"));
	catCourseObject.setCatdescript(rs.getString("categorynotes"));
	catCourseObject.setGenriccount(rs.getInt("coursecount"));
	if(ccount>0)
	{
	catCourseObject.setBtn4(coursecnt.concat(" ").concat("<button class='btn btn-default' id='viewc' title='View Courses'><span class='glyphicon glyphicon-eye-open'></span></button>"));
	}
	else
	{
		catCourseObject.setBtn4(coursecnt.concat(" ").concat("<button class='btn btn-default' id='viewc' title='View Courses' disabled='disabled'><span class='glyphicon glyphicon-eye-open'></span></button>"));	
	}
	
	catCourseObject.setBtn1("<button id='editCat' class='btn btn-primary' role='update' title='Edit Category Details'><span class='glyphicon glyphicon-pencil'</span></button>");
			if(ccount==0)
			{
			catCourseObject.setBtn2("<button id='deleteCat' class='btn btn-danger' role='delete' title='Delete Category'><span class='glyphicon glyphicon-trash'></span></button>");
			}
			else
			{
			catCourseObject.setBtn2("<button id='deleteCat' class='btn btn-danger' role='delete' title='Delete Category' disabled='disabled'><span class='glyphicon glyphicon-trash'></span></button>");	
			}
	
	
	
	catCourseObject.setBtn3(rs.getString("btn3"));
	
	catData.add(catCourseObject);

	   



		

	}
	return catData;
	}
	catch(Exception e)
	{
	throw e;
	}
	}
	
	


	
	public ArrayList<CourseObjects> GetCourseData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PreparedStatement ps = null;
	int instruct=Integer.valueOf(request.getParameter("instruct"));
		ArrayList<CourseObjects> courseData = new ArrayList<>();
	try
	{
	int archived=Integer.parseInt(request.getParameter("archived"));

	if(archived>1)
	{
		 ps = connection.prepareStatement("SELECT course_id,coursename,categoryname,bodname,level,capacity,semesterid,tb_tutor_courses.tutorcourseid,count(student_id) as NumStudents,btn1,btn2,btn3,btn4,concat(substring(FirstName,1,1),'.', LastName) as tname,tutorid FROM TB_courses inner join tb_category on tb_category.cat_id=tb_courses.category inner join tb_tutor_courses on tb_tutor_courses.courseid=tb_courses.course_id inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=? inner join tb_accredbody on tb_accredbody.id=tb_courses.acredbody left outer join tb_student_courses on tb_student_courses.tutorcourseid=tb_tutor_courses.tutorcourseid inner join tb_user on tb_user.UserID=tb_tutor_courses.TutorID where tb_category.cat_id=? and tb_courses.archived=0 group by TutorCourseID;");
	}
	else
	{
	 ps = connection.prepareStatement("SELECT course_id,coursename,categoryname,bodname,level,capacity,tb_tutor_courses.semesterid,tb_tutor_courses.tutorcourseid,count(student_id) as NumStudents,btn1,btn2,btn3,btn4,concat(substring(FirstName,1,1),'.', LastName) as tname,tutorid FROM TB_courses inner join tb_category on tb_category.cat_id=tb_courses.category inner join tb_tutor_courses on tb_tutor_courses.courseid=tb_courses.course_id inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=? inner join tb_accredbody on tb_accredbody.id=tb_courses.acredbody left outer join tb_student_courses on tb_student_courses.tutorcourseid= tb_tutor_courses.tutorcourseid  inner join tb_user on tb_user.UserID=tb_tutor_courses.TutorID where tb_courses.archived in (?) group by TutorCourseID;");
	}
	 ps.setInt(1,instruct);
	 ps.setInt(2,archived);
	 
	int ttcount=0;
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
	int tutorid=rs.getInt("tutorid");
	int tcourseid=rs.getInt("tutorcourseid");
	int numstudents=rs.getInt("numstudents");
	
	
	String studentcnt=String.valueOf(rs.getInt("numstudents"));
	CourseObjects courseObject = new CourseObjects();
	courseObject .setCourseid(rs.getInt("course_id"));
	courseObject .setCoursename(rs.getString("coursename"));
	courseObject .setAcredbody(rs.getString("bodname"));
	courseObject .setLevel(rs.getInt("level"));
	courseObject .setCategoryname(rs.getString("categoryname"));
	courseObject .setCapacity(rs.getInt("capacity"));
	courseObject .setRefno(rs.getInt("tutorcourseid"));
	courseObject .setSemesterid(rs.getInt("semesterid"));
	courseObject .setTutorname(rs.getString("tname"));
	
	
	if(numstudents>0)
	{
	courseObject.setBtn4(studentcnt.concat(" ").concat("<button class='btn btn-default' id='viewcs' title='View Participants'><span class='glyphicon glyphicon-eye-open'></span></button>"));
	}
	else
	{
		courseObject.setBtn4(studentcnt.concat(" ").concat("<button class='btn btn-default' id='viewcs' title='View Participants' disabled='disabled'><span class='glyphicon glyphicon-eye-open'></span></button>"));	
	}
	ps = connection.prepareStatement("SELECT count(tutorcourse) as tc from tb_timetable where tutorcourse="+tcourseid+";");
	ResultSet rs1 = ps.executeQuery();
	while(rs1.next())
	{
	ttcount=rs1.getInt("tc");
	}
	if(ttcount>0)
	{
		courseObject.setBtn1("<button id='editCourse' class='btn btn-primary' role='update' tid='"+tutorid+"' title='Update Course Details' disabled='disabled'><span class='glyphicon glyphicon-pencil'</span></button>");
		courseObject .setBtn2("<button id='deleteCourse' class='btn btn-danger' role='delete' title='Delete Course' disabled='disabled'><span class='glyphicon glyphicon-trash'></span></button>");
	}
	
	else
	{
	courseObject.setBtn1("<button id='editCourse' class='btn btn-primary' role='update' tid='"+tutorid+"' title='Update Course Details'><span class='glyphicon glyphicon-pencil'</span></button>");
	courseObject .setBtn2("<button id='deleteCourse' class='btn btn-danger' role='delete' title='Delete Course'><span class='glyphicon glyphicon-trash'></span></button>");
	}

	courseObject .setBtn3(rs.getString("btn3"));

	//System.out.print(UserObject);
	courseData.add(courseObject);

	  



		

	}
	return courseData;
	}
	catch(Exception e)
	{
	throw e;
	}
	}

	
	
	
	

}
