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
	
	
	
	
	public ArrayList<UserObjectsInitial>GetUserDataInitial(Connection connection,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ArrayList<UserObjectsInitial> userData = new ArrayList<UserObjectsInitial>();
		
		String username = null;
		String userpass = null;
		

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
	PreparedStatement ps = null;
	
	ArrayList<UserObjects> userData = new ArrayList<UserObjects>();
try
{
String archived=request.getParameter("archived");
String role = request.getParameter("role");

System.out.println("archive"+archived);
System.out.println("role"+role);
System.out.println(archived.substring(0, 1));
System.out.println(archived.substring(2, 3));


 ps = connection.prepareStatement("SELECT userid,firstName,lastName,address FROM TB_User where archived in (?,?) and role in(?,?)");

ps.setString(1, archived.substring(0, 1));
ps.setString(2, archived.substring(2, 3));
ps.setString(3, role.substring(0, 1));
ps.setString(4, role.substring(2, 3));
ResultSet rs = ps.executeQuery();
while(rs.next())
{
	
UserObjects UserObject = new UserObjects();
UserObject.setUserid(rs.getInt("userid"));
UserObject.setFname(rs.getString("firstName"));
UserObject.setLname(rs.getString("lastName"));
UserObject.setAddress1(rs.getString("address"));
//System.out.print(UserObject);
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
