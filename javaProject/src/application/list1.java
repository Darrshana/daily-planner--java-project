package application;
import java.sql.Date;
import java.sql.Time;

public class list1{
	String name,status;
	String date;
	String time,user;
	public list1(String name,String date2, String time2, String string) {
		super();
		this.name = name;
		this.date = date2;
		this.time = time2;
		this.status = string;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String time) {
		this.user = user;
	}
		
	
	
	
	
}