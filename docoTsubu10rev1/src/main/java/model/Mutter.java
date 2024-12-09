package model;

import java.io.Serializable;
import java.util.Date;



public class Mutter implements Serializable {
	
	private String userName; //ユーザー名
	private String text; //つぶやき内容
	private Date date;
	
	public Mutter() {}
	public Mutter (String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	public Mutter (String userName, String text ,Date date) {
		this.userName = userName;
		this.text = text;
		this.date = date;
	}
	public String getUserName() {return userName;}
	public String getText() {return text;}
	
	//
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
