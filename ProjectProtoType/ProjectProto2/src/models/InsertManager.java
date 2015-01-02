package models;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataInsert;

public class InsertManager {
	public String InsertUser(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String message = null;
			try {
			message = request.getParameter("fname");
			if(message != null && message !="" && message.length()>0)
			{
				DataInsert datain= new DataInsert();
			message=datain.InsertUser(connection, request, response);
			}
			} catch (Exception e) {
			throw e;
			}
			return message;
			}
}
