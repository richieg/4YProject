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
		System.out.print("got to dao");
		ArrayList<CategoryCourseObjects> catData = new ArrayList<>();
	try
	{
	int archived=Integer.parseInt(request.getParameter("archived"));
	
	System.out.print(archived);
	 ps = connection.prepareStatement("SELECT cat_id,categoryname,categorynotes,count(course_id) as coursecount FROM TB_category left outer join tb_courses on tb_category.Cat_ID=tb_courses.Category where tb_category.archived=? group by cat_id;");
	 ps.setInt(1,archived);
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{

	
		
	CategoryCourseObjects catCourseObject = new CategoryCourseObjects();
	catCourseObject.setCategoryid(rs.getInt("cat_id"));
	catCourseObject.setCatname(rs.getString("categoryname"));
	catCourseObject.setCatdescript(rs.getString("categorynotes"));
	catCourseObject.setGenriccount(rs.getInt("coursecount"));
	//System.out.print(UserObject);
	catData.add(catCourseObject);

	    System.out.println("control::"+catData);



		

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
		System.out.print("got to dao");
		ArrayList<CourseObjects> courseData = new ArrayList<>();
	try
	{
	int archived=Integer.parseInt(request.getParameter("archived"));
	
	System.out.print(archived);
	 ps = connection.prepareStatement("SELECT course_id,coursename,acredbody,level FROM TB_course where archived in(?,?);");
	 ps.setInt(1,archived);
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{

	
		
	CourseObjects courseObject = new CourseObjects();
	courseObject .setCourseid(rs.getInt("course_id"));
	courseObject .setCoursename(rs.getString("coursename"));
	courseObject .setAcredbody(rs.getString("acredbodycategorynotes"));
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
	}

}
