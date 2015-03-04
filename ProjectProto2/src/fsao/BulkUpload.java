package fsao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dto.MessageObjects;

public class BulkUpload {
	

	 

	 
	  public ArrayList<MessageObjects>  insertBulk(String filepath){
		ArrayList<MessageObjects> insertMessages = new ArrayList<MessageObjects>();
		String csvFile = filepath;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] user= line.split(cvsSplitBy);
	 
				System.out.println("User [Firstname= " + user[1] 
	                                 + " , Lastname=" + user[2] + "]");
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
		MessageObjects insertMessage = new MessageObjects();
		insertMessage.setMessagecode(7);
		insertMessage.setInsertmessagestring("<h4>A course with this name already exists</h4>");
	 	insertMessages.add(insertMessage);
		return insertMessages;
	  }
	
	}


