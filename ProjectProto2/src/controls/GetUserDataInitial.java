package controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DBManager;
import models.RetrieveManager;


@WebServlet("/GetUserDataInitial")
public class GetUserDataInitial extends HttpServlet {
private static final long serialVersionUID = 1L;

public GetUserDataInitial() {
super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
try
{
	System.out.print("got to controller");
DBManager db= new DBManager();
RetrieveManager retManager= new RetrieveManager();
ArrayList userData = null;
Connection connection = db.Get_ConnectionInitial();
userData = retManager.GetUserDataInitial(connection, request, response) ;
Gson gson = new Gson();
String userdata = gson.toJson(userData);
//out.println("{\"UserInitial\":"+userdata+"}");

//System.out.print("got to controller2");

}
catch (Exception ex)
{
out.println("Error: " + ex.getMessage());
}
finally
{
out.close();
}
}
}