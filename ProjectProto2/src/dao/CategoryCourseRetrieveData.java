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
	
		
	System.out.print(instruct);
	 ps = connection.prepareStatement("SELECT cat_id,categoryname,categorynotes,count(course_id) as coursecount,btn4,btn1,btn2,btn3 FROM TB_category inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=?  left outer join tb_courses on tb_category.Cat_ID=tb_courses.Category where tb_category.archived=? and TB_Courses.archived=? group by cat_id;");
	 ps.setInt(1, instruct);
	 ps.setInt(2,archived);
	 ps.setInt(3,archived);
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{

	System.out.println(rs.getString("btn4"));
		
	CategoryCourseObjects catCourseObject = new CategoryCourseObjects();
	catCourseObject.setCategoryid(rs.getInt("cat_id"));
	catCourseObject.setCatname(rs.getString("categoryname"));
	catCourseObject.setCatdescript(rs.getString("categorynotes"));
	catCourseObject.setGenriccount(rs.getInt("coursecount"));
	String coursecnt=String.valueOf(rs.getInt("coursecount"));
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
	
	
	/*public ArrayList<CourseObjects> GetCourseData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PreparedStatement ps = null;
	
		ArrayList<CourseObjects> courseData = new ArrayList<>();
	try
	{
	int archived=Integer.parseInt(request.getParameter("archived"));
	System.out.println("got to dao fro course retrieve");

	 ps = connection.prepareStatement("SELECT course_id,coursename,acredbody,level FROM TB_courses where archived in(?);");
	 ps.setInt(1,archived);
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		System.out.println("reurned valuees");
	System.out.println(rs.getInt("course_id"));
	System.out.println(rs.getString("coursename"));
	System.out.println(rs.getInt("level"));
		
	CourseObjects courseObject = new CourseObjects();
	courseObject .setCourseid(rs.getInt("course_id"));
	courseObject .setCoursename(rs.getString("coursename"));
	courseObject .setAcredbody(rs.getString("acredbody"));
	courseObject .setLevel(rs.getInt("level"));
	//System.out.print(UserObject);
	courseData.add(courseObject);

	  



		

	}
	return courseData;
	}
	catch(Exception e)
	{
	throw e;
	}
	}*/

	
	public ArrayList<CourseObjects> GetCourseData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PreparedStatement ps = null;
	int instruct=Integer.valueOf(request.getParameter("instruct"));
		ArrayList<CourseObjects> courseData = new ArrayList<>();
	try
	{
	int archived=Integer.parseInt(request.getParameter("archived"));
	System.out.println("got to dao fro course retrieve");
	System.out.println(instruct);
	if(archived>1)
	{
		 ps = connection.prepareStatement("	SELECT course_id,coursename,categoryname,bodname,btn1,btn2,btn3,level FROM TB_courses inner join tb_category on tb_category.cat_id=tb_courses.category inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=? inner join tb_accredbody on tb_accredbody.id=tb_courses.acredbody where tb_category.cat_id=? and tb_courses.archived=0;");
	}
	else
	{
	 ps = connection.prepareStatement("	SELECT course_id,coursename,categoryname,bodname,btn1,btn2,btn3,level FROM TB_courses inner join tb_category on tb_category.cat_id=tb_courses.category inner join TB_CatCourse_Buttons on TB_CatCourse_Buttons.instructid=? inner join tb_accredbody on tb_accredbody.id=tb_courses.acredbody where tb_courses.archived in(?);");
	}
	 ps.setInt(1,instruct);
	 ps.setInt(2,archived);
	 
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		System.out.println("reurned valuees");
	System.out.println(rs.getInt("course_id"));
	System.out.println(rs.getString("coursename"));
	System.out.println(rs.getInt("level"));
		
	CourseObjects courseObject = new CourseObjects();
	courseObject .setCourseid(rs.getInt("course_id"));
	courseObject .setCoursename(rs.getString("coursename"));
	courseObject .setAcredbody(rs.getString("bodname"));
	courseObject .setLevel(rs.getInt("level"));
	courseObject .setCategoryname(rs.getString("categoryname"));
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
