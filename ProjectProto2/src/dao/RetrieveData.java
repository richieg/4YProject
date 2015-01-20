package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import dto.UserObjects;
import dto.UserObjectsInitial;

public class RetrieveData {
	
	
	
	
	public ArrayList<UserObjectsInitial> GetUserDataInitial(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ArrayList<UserObjectsInitial> userData = new ArrayList<UserObjectsInitial>();
		
		String username = null;
		String userpass = null;
		
		System.out.print("got to here");
	try
	{
	username = request.getParameter("user");
	
    userpass= request.getParameter("pwd");
   
	PreparedStatement ps = connection.prepareStatement("SELECT userid,userrole FROM TB_UserLogin where username=? and userpass=? ");
	ps.setString(1, username);
    ps.setString(2, userpass);	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		/*int fname=rs.getInt("userid");
		System.out.print("/n" +fname +"/n");
		int fpass=rs.getInt("userrole");
		System.out.print("/n" +fpass +"/n");
		*/
	UserObjectsInitial UserObjectInitial = new UserObjectsInitial();
	UserObjectInitial.setUserid(rs.getInt("userid"));
	UserObjectInitial.setUserrole(rs.getInt("userrole"));

	userData.add(UserObjectInitial);
	}
	return userData;
	}
	catch(Exception e)
	{
	throw e;
	}
	}

public ArrayList<UserObjects> GetUserData(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
{
	
	ArrayList<UserObjects> userData = new ArrayList<UserObjects>();
try
{
PreparedStatement ps = connection.prepareStatement("SELECT firstName,lastName,address FROM TB_User ORDER BY userid DESC");
ResultSet rs = ps.executeQuery();
while(rs.next())
{
	
UserObjects UserObject = new UserObjects();
UserObject.setFname(rs.getString("firstName"));
UserObject.setLname(rs.getString("lastName"));
UserObject.setAddress1(rs.getString("address"));
//System.out.print(UserObject);
userData.add(UserObject);

    //System.out.println(userData);



	

}
return userData;
}
catch(Exception e)
{
throw e;
}
}


}
