package application;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Admin_Controller {
	
	@FXML
	private ToggleGroup database;
	
	@FXML
	private TextArea Database;
	
	@FXML
	private TextArea CurrentProfile;
	
	@FXML
	private RadioButton Employee;
	
	@FXML
	private RadioButton Admin;
	
	@FXML
	private RadioButton Volunteer;
	
	@FXML 
	private TextField searchField;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private Button LogOut;
	
	@FXML
	private Button viewProfile;
	
	@FXML
	private Button EditProfile;
	
	@FXML
	private Button logHours;
	
	@FXML
	public void initialize() {
		LogOut.setOnAction((event) -> {
			Stage thirdStage = (Stage) LogOut.getScene().getWindow();
			thirdStage.setTitle("Aurora Food Pantry Home Page");
			BorderPane root;
			try {
				root = (BorderPane) FXMLLoader.load(getClass().getResource("HomePage.fxml"));
				Scene scene = new Scene(root, 700, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(scene);
				thirdStage.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File f = new File("EMPID.dat");
			System.out.println(f.delete());
		});
	}
}
