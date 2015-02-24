package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MessageObjects;

public class UpdateDeleteUserData {
	
	ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
	PreparedStatement ps;
	public ArrayList<MessageObjects> RestoreArchiveUser(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		
			int checknum=0;
	
			String message=null;
			
			try {
		
		    checknum= Integer.parseInt(request.getParameter("checknum"));
		    int userid=Integer.parseInt(request.getParameter("userid"));
		    
		    
		 
		   		
		   		int up=0;
		   		if(checknum==2)
		   		{
		   			ps = connection.prepareStatement("Update tb_user set archived=0 where userid=?");
		   		}
		   		else
		   		{
		   			ps = connection.prepareStatement("Update tb_user set archived=1 where userid=?");
		   		}
				ps.setInt(1, userid);
				
				up = ps.executeUpdate();
				if(up>0)
				{
					if(checknum==2)
					{
						message= "<div style='color:blue'>User "+userid+" restored successfully</div>";
					}
					else
					{
						message= "<div style='color:blue'>User "+userid+" deleted successfully</div>";
					}
				}
				else message ="<div style='color:red'>An error has occured please contact IT!</div>";
				MessageObjects messageObjects = new MessageObjects();
				messageObjects.setMessagecode(2);
				messageObjects.setInsertmessagestring(message);
				insertMessage.add(messageObjects);
				
			} catch (Exception e) {
				throw e;
				}
			return insertMessage;
				}
	
	
	public ArrayList<MessageObjects> UpdateUser(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			int userid=0;
			String address1=null;
			String address2=null;
			String address3=null;
			String postcode=null;
			String phone=null;
			String email=null;
			String message=null;
	
			
			try {
			/*System.out.print("got to data insert");
		    fname = request.getParameter("fname");
		    lname = request.getParameter("lname");*/
		    address1 = request.getParameter("address1");
		    address2 = request.getParameter("address2");
		    address3 = request.getParameter("address3");
		    
		    postcode = request.getParameter("postcode");
		    phone =request.getParameter("phone");
		    email = request.getParameter("email");
		    /*dob = request.getParameter("dob");
		    roles=request.getParameter("role");*/
		    //checknum= Integer.parseInt(request.getParameter("checknum"));*/
		    userid=Integer.parseInt(request.getParameter("userid"));
		    
		    
		 
		   		
		   		int up=0;
		   		PreparedStatement ps = connection.prepareStatement("Update tb_user set address=?,address2=?,address3=?,postcode=?,personalphone=?,personalemail=? where userid=?");
				ps.setString(1, address1);
				ps.setString(2, address2);
				ps.setString(3, address3);
				ps.setString(4, postcode);
				ps.setString(5, phone);
				ps.setString(6, email);
				
		   		
		   		ps.setInt(7, userid);
				
				up = ps.executeUpdate();
				if(up>0)
				{
				message= "<div style='color:blue'>User "+userid+" updated successfully</div>";
				}
				else message ="<div style='color:red'>An error has occured please contact IT!</div>";
				
				
				MessageObjects messageObjects = new MessageObjects();
				messageObjects.setMessagecode(1);
				messageObjects.setInsertmessagestring(message);
				insertMessage.add(messageObjects);
				
			} catch (Exception e) {
				throw e;
				}
			return insertMessage;
				}
	
	
	
	
	
}
	
	




