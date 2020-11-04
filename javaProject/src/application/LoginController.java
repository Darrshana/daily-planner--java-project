package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController  implements Initializable {
	
    @FXML
    private TextField lg_username;

    @FXML
    private PasswordField lg_password;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;
    Statement statement = null;
    
    public LoginController() {
    	conn = Mysqlconnect.connectdb();
    }
	@FXML
	    void LoginButtonpressed(MouseEvent event) {
		try {
	    	 String username = lg_username.getText();
			 String password = lg_password.getText();
			 System.out.println(username+"\t"+password);
			 statement = conn.createStatement();
   		 
			 String query = "Select * from signup where username='"+username+"'and password='"+password+"'";
			 resultSet = statement.executeQuery(query);
   	
			 if(!resultSet.next()){
				 JOptionPane.showMessageDialog(null, "Error in login....Please try again!!");
			 }
			 else {
				 String str = username + ".....Logging in successful!!";
				//JOptionPane.showMessageDialog(null, str);
				SampleController s1=new SampleController();
				SampleController.UserName(username);
				lg_username.clear();
				lg_password.clear();
				 FXMLLoader loader4 = new FXMLLoader(getClass().getResource("Planner.fxml"));
		    		Parent root4 = loader4.load();
		    				
		    				Stage stage =new Stage();
		    				stage.setTitle("Planner");
		    				stage.setScene(new Scene(root4));
		    				stage.show();
		    					
		    			
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
   }
	    
	
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
