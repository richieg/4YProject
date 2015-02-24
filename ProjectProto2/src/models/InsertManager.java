package models;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InsertUserData;
import dao.UpdateDeleteUserData;
import dto.MessageObjects;

public class InsertManager {
	public ArrayList<MessageObjects>InsertUser(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String message = null;
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
			try {
			message =(request.getParameter("fname"))+" "+(request.getParameter("lname"));
			
			if(message != null && message !="" && message.length()>0)
			{
			InsertUserData datain= new InsertUserData();
			insertMessage=datain.InsertUser(connection, request, response);
			}
			
			} catch (Exception e) {
			throw e;
			}
			return insertMessage;
			}
	public ArrayList<MessageObjects>RestoreArchiveUser(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String message = null;
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
			try {
			message =(request.getParameter("userid"))+" "+(request.getParameter("checknum"));
		
			if(message != null && message !="" && message.length()>0)
			{
				UpdateDeleteUserData upDel= new UpdateDeleteUserData();
				insertMessage=upDel.RestoreArchiveUser(connection, request, response);
			}
			
			} catch (Exception e) {
			throw e;
			}
			return insertMessage;
			}
	
	
	public ArrayList<MessageObjects>UpdateUser(Connection connection, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String message = null;
			ArrayList<MessageObjects> insertMessage = new ArrayList<MessageObjects>();
			try {
			
			UpdateDeleteUserData udd= new UpdateDeleteUserData();
			insertMessage=udd.UpdateUser(connection, request, response);
			
			
			} catch (Exception e) {
			throw e;
			}
			return insertMessage;
			}
	
	
	
	
	
	
	
	
	
	
}
