package models;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import dao.CategoryCourseRetrieveData;
import dto.CategoryCourseObjects;
import dto.CourseObjects;


public class CategoryCourseRetrieveManager {
	public ArrayList<CategoryCourseObjects> GetCatData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<CategoryCourseObjects> catData = null;
	
		CategoryCourseRetrieveData rdata=new CategoryCourseRetrieveData();
			
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			catData=rdata.GetCatData(connection, request, response);

		
			} 
			catch (Exception e) {
			throw e;
			}
			return catData;
			}
	
	
	public ArrayList<CourseObjects> GetCourseData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ArrayList<CourseObjects> courseData = null;
		CategoryCourseRetrieveData rdata=new CategoryCourseRetrieveData();
			System.out.println("got to manager for course retrieve");
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
		
			
			courseData=rdata.GetCourseData(connection, request, response);
		
			} 
			catch (Exception e) {
			throw e;
			}
			return courseData;
			}

}





