package application;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
public class Main extends Application {
	private double xOffset =0;
	private double yOffset =0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Sign Up");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException {
		launch(args);
		
	}

}
