package dao;

import java.sql.*;
import java.io.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	
	 public Connection Get_ConnectionInitial() throws Exception
	 {
	 try
	 {
	 String url = "jdbc:mysql://localhost:3306/tedasuserdev";
	 Connection connection = null;
	 Class.forName("com.mysql.jdbc.Driver").newInstance();
	 connection = DriverManager.getConnection(url, "root", "");
	 return connection;
	 }
	 catch (SQLException e)
	 {
	 throw e;
	 }
	 catch (Exception e)
	 {
	 throw e;
	 }
	 }
	
	

	
	 public Connection Get_Connection() throws Exception
	 {
	 try
	 {
	 String url = "jdbc:mysql://localhost:3306/tedascoredev";
	 Connection connection = null;
	 Class.forName("com.mysql.jdbc.Driver").newInstance();
	 connection = DriverManager.getConnection(url, "root", "");
	 return connection;
	 }
	 catch (SQLException e)
	 {
	 throw e;
	 }
	 catch (Exception e)
	 {
	 throw e;
	 }
	 }
	
	 
}