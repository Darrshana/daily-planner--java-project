 package application;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


public class SignupController implements Initializable{
	
	@FXML
	    private TextField su_username;

	    @FXML
	    private TextField su_email;

	    @FXML
	    private PasswordField su_password;
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet resultSet = null;
	    ResultSet rs2 = null;
	    Statement statement = null;
	    
	    public SignupController() {
	    	conn = Mysqlconnect.connectdb();
	    }
	    @FXML
		 void Signupbuttonpressed(MouseEvent event) {
	    	try {
		    	 String username = su_username.getText();
				 String email = su_email.getText();
				 String password = su_password.getText();
				 System.out.println(username+"\t"+email+"\t"+password);
	    		 statement = conn.createStatement();
	    		 
	    		 String query2 ="Select * from signup where email='"+email+"'";
	    	     rs2 = statement.executeQuery(query2);
	    	     boolean isThere=rs2.next();
	    		 
	    	     String query = "Select * from signup where username='"+username+"'and email='"+email+"'and password='"+password+"'";
	    		 resultSet = statement.executeQuery(query);
	    	     
	    	     
	    	     	    		 
	    	     if(!resultSet.next() && !isThere){
	    			String sql="insert into signup(username , email , password)values(?,?,?)";
	    	    	
					ps=conn.prepareStatement(sql);
					ps.setString(1,username);
					ps.setString(2,email);
					ps.setString(3,password);
				
					ps.execute();
					String str = username+"....Successfuly signed in!";
					//JOptionPane.showMessageDialog(null, str);
					 su_username.clear();
					 su_email.clear();
					 su_password.clear();
					FXMLLoader loader5 = new FXMLLoader(getClass().getResource("Login.fxml"));
		    		Parent root5 = loader5.load();
		    				
		    				Stage stage =new Stage();
		    				stage.setTitle("Login");
		    				stage.setScene(new Scene(root5));
		    				stage.show();
	    	 	}
	    	     
	    	     
	    	   
	    	   else{
	    		   FXMLLoader fxmlloader1 = new FXMLLoader(getClass().getResource("signuperror.fxml"));
		    		Parent root1 = (Parent) fxmlloader1.load();
		    		Stage stage1 = new Stage();
		    		stage1.setTitle("Warning");
		    		stage1.setScene(new Scene(root1));
		    		stage1.show();
	    			
	    			
	    			

	    	   }
	    	}
	    	
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
		@FXML
		 void LoginButtonpressed(MouseEvent event) {
				try { 
					FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Login.fxml"));
		    		Parent root = (Parent) fxmlloader.load();
		    		Stage stage = new Stage();
		    		stage.setTitle("Login");
		    		stage.setScene(new Scene(root));
		    		stage.show();
		    		
		    	}
		    	catch(Exception e) {
		    		System.out.println("Can't load a Login window");
		    	}
		    }
	
		
		public void initialize(URL location,ResourceBundle resources) {
		
			
		}
}
