package dto;

public class MessageObjects {

	private int messagecode;
	private String insertmessagestring;
	private String catcoursemessagestring;

	public String getCatcoursemessagestring() {
		return catcoursemessagestring;
	}
	public void setCatcoursemessagestring(String catcoursemessagestring) {
		this.catcoursemessagestring = catcoursemessagestring;
	}
	public int getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(int messagecode) {
		this.messagecode = messagecode;
	}
	public String getInsertmessagestring() {
		return insertmessagestring;
	}
	public void setInsertmessagestring(String insertsuccesstring) {
		this.insertmessagestring = insertsuccesstring;
	}
}

