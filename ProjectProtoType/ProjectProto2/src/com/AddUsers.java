package com;

import java.sql.CallableStatement;
import java.applet.Applet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class AddUsers extends Applet {
	 public static Statement stmt = null;
	 public static ResultSet rs = null;
	 public static Connection conn = null;

	 
	 public AddUsers(){}
	

	public Integer getUsersIndv(String fname,  String lname, String address)
	{

    String sessionDetails="";
    
    try {
    	stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM tedascoredev.tb_user");
	
    while (rs.next()) {
	sessionDetails += rs.getString(1) + " " +
		                   rs.getString(2)+ " " +
				                   rs.getString(3)+ " " +
    				                   rs.getString(4);
    }
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	return null;
	
	

}
	
	public Integer inserttUsersIndv(String fname,  String lname, String address)
	{
		int userID = 0;

    
		 CallableStatement cStmt;
		try {
			cStmt = conn.prepareCall("{call addUsers(?, ?, ?, ?)}");
		



		    



		    cStmt.setString(1, fname);
		    cStmt.setString(2, lname);
		    cStmt.setString(3, address);
		    cStmt.registerOutParameter(4, Types.INTEGER);
		    
		    
		    cStmt.executeQuery();
		    
		    userID = cStmt.getInt(4);
		    //

		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
   
	return userID;
	
	

}
}

