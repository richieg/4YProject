package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataInsert {
	public String InsertUser(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String userDetails = null;
			String fname=null;
			String lname=null;
			String address1=null;
			String address2=null;
			String address3=null;
			String address4=null;
			String postcode=null;
			int phone=0;
			String email=null;
			String dob =null;
			String efname = null;
			String elname=null;
			int checknum=0;
			
			
			try {
			System.out.print("got to data insert");
		    fname = request.getParameter("fname");
		    lname = request.getParameter("lname");
		    address1 = request.getParameter("address1");
		    address2 = request.getParameter("address2");
		    address3 = request.getParameter("address3");
		    address4 = request.getParameter("address4");
		    postcode = request.getParameter("postcode");
		    phone = Integer.parseInt(request.getParameter("phone"));
		    email = request.getParameter("email");
		    dob = request.getParameter("dob");
		    checknum= Integer.parseInt(request.getParameter("checknum"));  
		    
		    System.out.println("checknum::"+checknum);
		
		  
		   
		   	System.out.println(fname);
		   	if(checknum==1)
		   	{
		   	CallableStatement cu = connection.prepareCall("{Call checkUsers(?,?,?,?,?)}");
		   	cu.setString(1, fname);
		   	cu.setString(2, lname);
		   	cu.setString(3, address1);
		   	cu.setString(4, dob);
		    cu.registerOutParameter(5, Types.INTEGER);
		    boolean cut =cu.execute();
		    checknum= cu.getInt(5);
		    
			System.out.println("returned user count:::");
			System.out.println(checknum);
		   	}
			boolean rs=false;
			if(checknum==0)
			{
			Random rand=new Random();
			
			int extid = rand.nextInt(100);
			System.out.println("extid::"+extid);
			String externalid=String.valueOf(extid);
			System.out.println("extid::"+externalid);
			CallableStatement ps = connection.prepareCall("{Call InsertUser(?,?,?,?,?,?,?,?,?,?,?,?)}");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, address1);
			ps.setString(4, address2);
			ps.setString(5, address3);
			ps.setString(6, address4);
			ps.setString(7, postcode);
			ps.setInt(8, phone);
			ps.setString(9, email);
			ps.setString(10, dob);
			ps.setString(11,externalid);
			
			ps.registerOutParameter(12, Types.INTEGER);
		
			
			
			//System.out.println("got to here");
		
			rs = ps.execute();
			int sr=ps.getInt(12);
			
			System.out.println("returned user id:::");
			System.out.println(sr);		}
			else{
				PreparedStatement ps = connection.prepareStatement("SELECT firstName,lastName FROM TB_User where firstname=? and lastname=?");
				ps.setString(1, fname);
				ps.setString(2, lname);
				ResultSet rse = ps.executeQuery();
				while(rse.next())
				{
				efname=rse.getString("firstName");
				elname=rse.getString("lastName");
				}
				return "<div style='color:red'>Possible duplication of users details: <tr><td>"+efname+"</td>"+" "+"<td><td>"+elname+ "<button id=\"SubmitButton1\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#ModalActionAlert\">Submit</button>";
			}
			
			
			if (rs) {
			return "New User Added Successfully" ;
			} else {
			return "An Error has occured";
			}
			
			} catch (Exception e) {
			throw e;
			}
			}
			
	
	
			}



