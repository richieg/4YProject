package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataInsert {
	public String InsertUser(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String fname = null;
			String lname = null;
			String address1 = null;
			try {
		    fname = request.getParameter("fname");
			lname= request.getParameter("lname");
			address1 = request.getParameter("address1");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_user (FirstName,LastName,Address,Postcode,LastUpdated)  VALUES(?,?,?,'D3','2014-12-14')");
			ps.setString(1, fname);
			System.out.println("got to here");
			ps.setString(2, lname);
			ps.setString(3, address1);
			int rs = ps.executeUpdate();
			System.out.println("got to here2");
			if (rs>0) {
			return fname ;
			} else {
			return null;
			}

			} catch (Exception e) {
			throw e;
			}
			}

			}


