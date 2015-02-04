package models;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import dao.CategoryCourseRetrieveData;
import dto.CategoryCourseObjects;


public class CategoryCourseRetrieveManager {
	public ArrayList<CategoryCourseObjects> GetCatData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<CategoryCourseObjects> catData = null;
		ArrayList<CategoryCourseObjects> courseData = null;
		CategoryCourseRetrieveData rdata=new CategoryCourseRetrieveData();
			
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
				System.out.print("got to manager");
			catData=rdata.GetCatData(connection, request, response);
			courseData=rdata.GetCatData(connection, request, response);
			System.out.println("got to manager::"+catData);
			} 
			catch (Exception e) {
			throw e;
			}
			return catData;
			}

}



