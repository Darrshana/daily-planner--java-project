package application;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.sql.PreparedStatement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ArrayChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class SampleController implements Initializable {
	public static String u;
	public static void Email(String mail) {
		u=mail;
	}

    @FXML
    private TableView<list1> table_todolist;

    @FXML
    private TableColumn<list1,String> name;

    @FXML
    private TableColumn<list1,Date> date;

    @FXML
    private TableColumn<list1,Time> time;
    

    @FXML
    private TableColumn<list1,String> status;

    @FXML
    private TextField calender;

    @FXML
    private RadioButton today;

    @FXML
    private RadioButton overdue;

    @FXML
    private RadioButton completed;

    @FXML
    private RadioButton priority;

    @FXML
    private Button button_create;


    @FXML
    private Button button_update;

    @FXML
    private Button button_delete;

    @FXML
    private TextField text_name;

    @FXML
    private DatePicker text_date;

    @FXML
    private TextField text_time;

    @FXML
    private TextField text_status;
    @FXML
    void update(MouseEvent event) {
    	
    		conn=Mysqlconnect.connectdb();
        	String sql2="UPDATE list1 SET name=?,date=?,time=?,status=? where name =?";
        	try {
    			ps2=conn.prepareStatement(sql2);
    			ps2.setString(1,text_name.getText());
    			
    			ps2.setString(2,text_date.getEditor().getText());
    			ps2.setString(3,text_time.getText());
    			ps2.setString(4,text_status.getText());
    			ps2.setString(5,text_name.getText());
    			ps2.execute();
    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Update.fxml"));
    		Parent root3 = loader2.load();
    				
    				Stage stage =new Stage();
    				stage.setTitle("Update Window");
    				stage.setScene(new Scene(root3));
    				stage.show();
    				text_name.clear();
    				text_date.getEditor().clear();
    				text_time.clear();
    				text_status.clear();
    				listM=Mysqlconnect.getdatalist1(u);
    			    table_todolist.setItems(listM);
    			    Search();
    			   
    			} catch(Exception e) {
    				e.printStackTrace();
    			}
    }
    @FXML
    
    void delete(MouseEvent event) throws IOException {
    	
    		conn=Mysqlconnect.connectdb();
        	String sql1="DELETE FROM todolist.list1 WHERE name = ?";
        	try {
    			ps1=conn.prepareStatement(sql1);
    			ps1.setString(1,text_name.getText());
    			ps1.execute();
    		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Delete.fxml"));
    		Parent root2 = loader1.load();
    				
    				Stage stage =new Stage();
    				stage.setTitle("Delete Window");
    				stage.setScene(new Scene(root2));
    				stage.show();
    				listM=Mysqlconnect.getdatalist1(u);
    			    table_todolist.setItems(listM);
    			    text_name.clear();
    			    text_date.getEditor().clear();
    				text_time.clear();
    				text_status.clear();
    				Search();
    				}
    			    catch(Exception e) {
        				e.printStackTrace();
        			}  			    
    	    		
    			
    }
    public void Add_tasks() throws IOException {
    	conn=Mysqlconnect.connectdb();
    	String sql="insert into list1(name,date,time,status,email)values(?,?,?,?,?)";
    	try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,text_name.getText());
			ps.setString(2,text_date.getEditor().getText());
			ps.setString(3,text_time.getText());
			ps.setString(4,text_status.getText());
			ps.setString(5,u);
			ps.execute();
		//JOptionPane.showMessageDialog(null, "Task added");
			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("Image.fxml"));
    		Parent root3 = loader3.load();
    				
    				Stage stage =new Stage();
    				stage.setTitle("Task Added");
    				stage.setScene(new Scene(root3));
    				stage.show();
		text_name.clear();
		text_date.getEditor().clear();
		text_time.clear();
		text_status.clear();
		listM=Mysqlconnect.getdatalist1(u);
	    table_todolist.setItems(listM);
	    Search();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    ObservableList<list1> listM,list2;
    int index =-1;
    private int iNumber=1;
    private IntegerProperty index1=new SimpleIntegerProperty();
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps11 = null;
    
    ResultSet rs = null;
    @Override
    public void initialize(URL url,ResourceBundle rb) {
    name.setCellValueFactory(new PropertyValueFactory<list1,String>("name"));
    date.setCellValueFactory(new PropertyValueFactory<list1,Date>("date"));
    time.setCellValueFactory(new PropertyValueFactory<list1,Time>("time"));
    status.setCellValueFactory(new PropertyValueFactory<list1,String>("status"));
    
    listM=Mysqlconnect.getdatalist1(u);
    table_todolist.setItems(listM);
    Search();
    
 
}
 void Search() {  
	    name.setCellValueFactory(new PropertyValueFactory<list1,String>("name"));
	    date.setCellValueFactory(new PropertyValueFactory<list1,Date>("date"));
	    time.setCellValueFactory(new PropertyValueFactory<list1,Time>("time"));
	    status.setCellValueFactory(new PropertyValueFactory<list1,String>("status"));
	    
	    list2 = Mysqlconnect.getdatalist1(u);
	    table_todolist.setItems(list2);
	    FilteredList<list1> filteredData=new FilteredList<>(list2,b->true);
	    calender.textProperty().addListener((observable,oldValue,newValue)->{
	    filteredData.setPredicate(search->{
	    		if(newValue == null || newValue.isEmpty()) {
	    			return true;
	    		}
	    	String filter=newValue;
	    	if(search.getDate().contains(filter)) {
	    		return true;
	    	}
	    	else if(search.getStatus().contains(filter)) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    	});
	    });
	    SortedList<list1> sortedData=new SortedList<>(filteredData);
	    sortedData.comparatorProperty().bind(table_todolist.comparatorProperty())  ;
	    table_todolist.setItems(sortedData);


    }}
	




    
	
	


