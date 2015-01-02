package models;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RetrieveData;
import dto.UserObjects;

public class RetrieveManager {
	
	public ArrayList GetUserData(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			ArrayList userData = null;
			try {
			// Here you can validate before connecting DAO class, eg. User session condition
			RetrieveData rdata=new RetrieveData();
			userData=rdata.GetUserData(connection, request, response);
			} 
			catch (Exception e) {
			throw e;
			}
			return userData;
			}

}
