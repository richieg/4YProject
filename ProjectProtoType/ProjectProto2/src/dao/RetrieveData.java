package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dto.UserObjects;

public class RetrieveData {

public ArrayList<UserObjects> GetUserData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
{
ArrayList<UserObjects> userData = new ArrayList<UserObjects>();
try
{
PreparedStatement ps = connection.prepareStatement("SELECT firstName,lastName,address FROM TB_User ORDER BY userid DESC");
ResultSet rs = ps.executeQuery();
while(rs.next())
{
	String fname=rs.getString("firstname");
	System.out.print(fname);
UserObjects UserObject = new UserObjects();
UserObject.setFname(rs.getString("firstName"));
UserObject.setLname(rs.getString("lastName"));
UserObject.setAddress1(rs.getString("address"));
userData.add(UserObject);
}
return userData;
}
catch(Exception e)
{
throw e;
}
}


}
