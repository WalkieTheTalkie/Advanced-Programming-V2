package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Admin_Controller {
	
	@FXML
	private ToggleGroup database;
	
	@FXML
	private TableView Database;
	
	@FXML
	private TextArea CurrentProfile;
	
	@FXML
	private RadioButton Employee;
	
	@FXML
	private RadioButton Admin1;
	
	@FXML
	private RadioButton Volunteer1;
	
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
	public void initialize() throws ClassNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream("EMPID.dat");
		ObjectInputStream ios = new ObjectInputStream(fis);
		Admin a = (Admin) ios.readObject();
		
		viewProfile.setOnAction((event) -> {
			CurrentProfile.clear();
			CurrentProfile.appendText(a.toString());
			CurrentProfile.appendText("\n\n ------------- \n\n");
		});
		
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
		
		Employee.setOnAction((event) ->{
			
		
			TableColumn ID = new TableColumn("ID");
			TableColumn WorkH = new TableColumn("Hours");
			TableColumn User = new TableColumn("Username");
			TableColumn Pass = new TableColumn("Password");
			TableColumn first= new TableColumn("First Name");
			TableColumn MI = new TableColumn("MI");
			TableColumn last = new TableColumn("Last Name");
			TableColumn email = new TableColumn("Email");
			TableColumn Phone = new TableColumn("Phone");
			TableColumn Gender = new TableColumn("Gender");
			TableColumn Address = new TableColumn("Address");
			TableColumn BirthDate = new TableColumn("Birth Date");
			TableColumn EmergencyContact = new TableColumn("Emergency Contact");		
			
			EmergencyContact.setPrefWidth(150);
			
			EmployeeTable ET = new EmployeeTable();
			HashMap<Integer, EmployeeClass> hash = ET.getEmployees();
			
			ObservableList<Object> data = FXCollections.observableArrayList();
			for(Integer i: hash.keySet()) {
				data.add(hash.get(i));
			}
			
			Database.setItems(data);
			
			Database.getColumns().add(ID);
			Database.getColumns().add(WorkH);
			Database.getColumns().add(User);
			Database.getColumns().add(Pass);
			Database.getColumns().add(first);
			Database.getColumns().add(MI);
			Database.getColumns().add(last);
			Database.getColumns().add(email);
			Database.getColumns().add(Phone);
			Database.getColumns().add(Gender);
			Database.getColumns().add(Address);
			Database.getColumns().add(BirthDate);
			Database.getColumns().add(EmergencyContact);
			
		
			
		});
		
		Admin1.setOnAction((event) ->{
			
		});
		
		Volunteer1.setOnAction((event) ->{
			
		});
		
		EditProfile.setOnAction((event) -> {
			Stage thirdStage = (Stage) LogOut.getScene().getWindow();
			thirdStage.setTitle("Aurora Food Pantry Home Page");
			BorderPane root;
				try {
					root = (BorderPane) FXMLLoader.load(getClass().getResource("NewUserPage.fxml"));
					Scene scene = new Scene(root, 700, 700);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					thirdStage.setScene(scene);
					thirdStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		});{
			
		}
	}
	
}
