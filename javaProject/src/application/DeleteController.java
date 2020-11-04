package application;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class DeleteController{
	
	Connection conn = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;


    @FXML
    private Button delete;

    @FXML
    private TextField delete_name;
    public void Delete_tasks()  {
    	conn=Mysqlconnect.connectdb();
    	String sql1="DELETE FROM todolist.list1 WHERE name= ?";
    	try {
    		ps1=conn.prepareStatement(sql1);
    		String name=delete_name.getText();
    		ps1.setString(1,name);
    		ps1.execute();
    	JOptionPane.showMessageDialog(null, "Task Deleted");
    	
    	
    	
    	
        
    	} catch (SQLException e) {
    		
    		e.printStackTrace();
    	}
    	
       
    	
    }
    




	
}




	


