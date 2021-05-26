package application;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Mysqlconnect {
	Connection conn =null;
	 public static Connection connectdb()
	    {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/todolist","root","17Darsha,");
	            //JOptionPane.showMessageDialog(null, "Connection Established");
	            return conn;
	        }
	        catch(Exception e)
	        {
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	        }
	    }  
	 
	 public static ObservableList<list1>getdatalist1(String mail){
		 Connection conn= connectdb();
		 ObservableList<list1> list =FXCollections.observableArrayList();
		 try {
			 PreparedStatement ps =conn.prepareStatement("SELECT name,date,time,status from list1 where email=?");
			ps.setString(1,mail);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				list.add(new list1(rs.getString("name"),rs.getString("date"),rs.getString("time"),rs.getString("status"))); ;
			 }
				 
			 
		 }catch(Exception e) {
			 
		 }
		return list;	
	 }
	 
}
