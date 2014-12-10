package com.proto.proj;

import java.sql.*;
import java.io.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	static Statement stmt = null;
	static ResultSet rs = null;
	
	 public static void main (String args [])
				throws SQLException, IOException {
			    try {
			    	try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      System.out.println("driver loaded");
			    } catch (ClassNotFoundException e) {
				    System.out.println ("Could not load the driver");
				}
			//Either server name or IP address can be used here.
			   // String servername = "147.252.224.76"; //"ferdia.student.cs.dit.ie";
			    
			    Connection conn = null;
			    
			    try {
			    	String url = "jdbc:mysql://localhost:3306/";
			        conn = DriverManager.getConnection(url, "root", "");
			        String sessionDetails="";
			        stmt = conn.createStatement();
			        rs = stmt.executeQuery("SELECT * FROM tedascoredev.tb_user");
			        while (rs.next()) {
					sessionDetails += rs.getString(1) + " " +
						                   rs.getString(2)+ " " +
								                   rs.getString(3)+ " " +
										                   rs.getString(4);
					    }
			        System.out.println(sessionDetails);
			        // Do something with the Connection

			       
			    } catch (SQLException ex) {
			        // handle any errors
			        System.out.println("SQLException: " + ex.getMessage());
			        System.out.println("SQLState: " + ex.getSQLState());
			        System.out.println("VendorError: " + ex.getErrorCode());
			    }
	 }
}