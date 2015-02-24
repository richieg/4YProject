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
	
	 ps = connection.prepareStatement("SELECT cat_id,categoryname,categorynotes,count(course_id) as coursecount,btn4,btn1,btn2,btn3 FROM TB_category inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=?  left outer join tb_courses on tb_category.Cat_ID=tb_courses.Category and tb_category.Archived=tb_courses.archived where tb_category.archived=? group by cat_id;");
	 ps.setInt(1, instruct);
	 ps.setInt(2,archived);
	 
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		
	String coursecnt=String.valueOf(rs.getInt("coursecount"));
	
	CategoryCourseObjects catCourseObject = new CategoryCourseObjects();
	catCourseObject.setCategoryid(rs.getInt("cat_id"));
	catCourseObject.setCatname(rs.getString("categoryname"));
	catCourseObject.setCatdescript(rs.getString("categorynotes"));
	catCourseObject.setGenriccount(rs.getInt("coursecount"));
	//catCourseObject.setBtn4("btn4");
	catCourseObject.setBtn4(coursecnt.concat(" ").concat(rs.getString("btn4")));
	catCourseObject.setBtn1(rs.getString("btn1"));
	catCourseObject.setBtn2(rs.getString("btn2"));
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
		 ps = connection.prepareStatement("SELECT course_id,coursename,categoryname,bodname,level,capacity,semesterid,tb_tutor_courses.tutorcourseid,count(student_id) as NumStudents,btn1,btn2,btn3,btn4 FROM TB_courses  inner join tb_category on tb_category.cat_id=tb_courses.category inner join tb_tutor_courses on tb_tutor_courses.courseid=tb_courses.course_id inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=? inner join tb_accredbody on tb_accredbody.id=tb_courses.acredbody left outer join tb_student_courses on tb_student_courses.tutorcourseid= tb_tutor_courses.tutorcourseid where tb_category.cat_id=? and tb_courses.archived=0;");
	}
	else
	{
	 ps = connection.prepareStatement("SELECT course_id,coursename,categoryname,bodname,level,capacity,semesterid,tb_tutor_courses.tutorcourseid,count(student_id) as NumStudents,btn1,btn2,btn3,btn4 FROM TB_courses  inner join tb_category on tb_category.cat_id=tb_courses.category inner join tb_tutor_courses on tb_tutor_courses.courseid=tb_courses.course_id inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=? inner join tb_accredbody on tb_accredbody.id=tb_courses.acredbody left outer join tb_student_courses on tb_student_courses.tutorcourseid= tb_tutor_courses.tutorcourseid  where tb_courses.archived in(?);");
	}
	 ps.setInt(1,instruct);
	 ps.setInt(2,archived);
	 
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{

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
	
	courseObject.setBtn4(studentcnt.concat(" ").concat(rs.getString("btn4")));
	courseObject .setBtn1(rs.getString("btn1"));
	courseObject .setBtn2(rs.getString("btn2"));
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
