package application;

import java.sql.Date;
import java.sql.Time;

public class Todolist{
	String name,status;
	Date date;
	Time time;
	public Todolist(String name, Date date2, Time time2, String string) {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	
	
	
	
}