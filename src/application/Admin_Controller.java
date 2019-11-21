package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
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
	private Button viewMyProfile;
	
	@FXML
	private Button EditMyProfile;
	
	@FXML
	private Button AddProfile;
	
	@FXML
	private Button EditProfile;
	
	@FXML
	private Button RemoveProfile;
	
	@FXML
	private Button FirstNameButton;
	
	@FXML
	private Button LastNameButton;
	
	@FXML
	private Button MostHoursButton;
	
	@FXML
	private Button LeastHoursButton;
	
	@FXML
	private Button IDButton;
	
	@FXML
	public void initialize() throws ClassNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream("EMPID.dat");
		ObjectInputStream ios = new ObjectInputStream(fis);
		Admin a = (Admin) ios.readObject();
		Database.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
		Database.setPlaceholder(new Label("^ Select a Radio Button Above ^"));
		
		viewMyProfile.setOnAction((event) -> {
			CurrentProfile.clear();
			CurrentProfile.appendText(a.toString());
			CurrentProfile.appendText("\n\n ------------- \n\n");
		});
		EditMyProfile.setOnAction((event) ->{
			Stage thirdStage = (Stage) EditProfile.getScene().getWindow();
			thirdStage.setTitle("Aurora Food Admin Editor Page");
			BorderPane root;
			try {
				root = (BorderPane) FXMLLoader.load(getClass().getResource("Admin_UserEditor.fxml"));
				Scene scene = new Scene(root, 700, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(scene);
				thirdStage.show();

			} catch (IOException ie) {
				// TODO Auto-generated catch block
				ie.printStackTrace();

			}
			//CurrentProfile.appendText("\n\n ------------- \n\n");
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
			
			Database.getColumns().clear();
			Database.getItems().clear();
			
			TableColumn<Integer, EmployeeClass> ID = new TableColumn("ID");
			ID.setCellValueFactory(new PropertyValueFactory<>("EmployeeID"));
			TableColumn<Integer, EmployeeClass> WorkH = new TableColumn("Hours");
			WorkH.setCellValueFactory(new PropertyValueFactory<>("workinHours"));
			TableColumn<String, EmployeeClass> User = new TableColumn("Username");
			User.setCellValueFactory(new PropertyValueFactory<>("employeeUser"));
			TableColumn<String, EmployeeClass> Pass = new TableColumn("Password");
			Pass.setCellValueFactory(new PropertyValueFactory<>("employeePass"));
			TableColumn<String, EmployeeClass> first= new TableColumn("First Name");
			first.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
			TableColumn<String, EmployeeClass> MI = new TableColumn("MI");
			MI.setCellValueFactory(new PropertyValueFactory<>("MiddleInitial"));
			TableColumn<String, EmployeeClass> last = new TableColumn("Last Name");
			last.setCellValueFactory(new PropertyValueFactory<>("LastName"));
			TableColumn<String, EmployeeClass> email = new TableColumn("Email");
			email.setCellValueFactory(new PropertyValueFactory<>("Email"));
			TableColumn<String, EmployeeClass> Phone = new TableColumn("Phone");
			Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
			TableColumn<String, EmployeeClass> Gender = new TableColumn("Gender");
			Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
			TableColumn<String, EmployeeClass> Address = new TableColumn("Address");
			Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			TableColumn<String, EmployeeClass> BirthDate = new TableColumn("Birth Date");
			BirthDate.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
			TableColumn<String, EmployeeClass> EmergencyContact = new TableColumn("Emergency Contact");
			EmergencyContact.setCellValueFactory(new PropertyValueFactory<>("EmergencyContact"));
			
			
			EmployeeTable ET = new EmployeeTable();
			HashMap<Integer, EmployeeClass> hash = ET.getEmployees();
			ArrayList<EmployeeClass> display = new ArrayList<EmployeeClass>(); 
			
			for(Integer i: hash.keySet()) {
				display.add(hash.get(i));
			}
			
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
			
			Iterator itera = display.iterator();
			
			while(itera.hasNext()) {
				Database.getItems().add(itera.next());
			}
			
		});
		
		Admin1.setOnAction((event) ->{
			Database.getColumns().clear();
			Database.getItems().clear();
			
			TableColumn<Integer, Admin> ID = new TableColumn("ID");
			ID.setCellValueFactory(new PropertyValueFactory<>("id"));
			TableColumn<String, Admin> User = new TableColumn("Username");
			User.setCellValueFactory(new PropertyValueFactory<>("username"));
			TableColumn<String, Admin> Pass = new TableColumn("Password");
			Pass.setCellValueFactory(new PropertyValueFactory<>("password"));
			TableColumn<String, Admin> first= new TableColumn("First Name");
			first.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
			TableColumn<String, Admin> MI = new TableColumn("MI");
			MI.setCellValueFactory(new PropertyValueFactory<>("MiddleInitial"));
			TableColumn<String, Admin> last = new TableColumn("Last Name");
			last.setCellValueFactory(new PropertyValueFactory<>("LastName"));
			TableColumn<String, Admin> email = new TableColumn("Email");
			email.setCellValueFactory(new PropertyValueFactory<>("Email"));
			TableColumn<String, Admin> Phone = new TableColumn("Phone");
			Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
			TableColumn<String, Admin> Gender = new TableColumn("Gender");
			Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
			TableColumn<String, Admin> Address = new TableColumn("Address");
			Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			TableColumn<String, Admin> BirthDate = new TableColumn("Birth Date");
			BirthDate.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
			TableColumn<String, Admin> EmergencyContact = new TableColumn("Emergency Contact");
			EmergencyContact.setCellValueFactory(new PropertyValueFactory<>("EmergencyContact"));
			
			
			AdminTable AT = new AdminTable();
			HashMap<Integer, Admin> hash = AT.getAdmin();
			ArrayList<Admin> display = new ArrayList<Admin>(); 
			
			for(Integer i: hash.keySet()) {
				display.add(hash.get(i));
			}
			
			Database.getColumns().add(ID);
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
			
			Iterator itera = display.iterator();
			
			while(itera.hasNext()) {
				Database.getItems().add(itera.next());
			}
		});
		
		Volunteer1.setOnAction((event) ->{
			Database.getColumns().clear();
			Database.getItems().clear();
			
			TableColumn<Integer, Volunteer> ID = new TableColumn("ID");
			ID.setCellValueFactory(new PropertyValueFactory<>("VolunteerID"));
			TableColumn<Integer, Volunteer> WorkH = new TableColumn("Hours");
			WorkH.setCellValueFactory(new PropertyValueFactory<>("HoursVolunteered"));
			TableColumn<Boolean, Volunteer> court = new TableColumn("Court Ordered?");
			court.setCellValueFactory(new PropertyValueFactory<>("CourtOrdered"));
			TableColumn<String, Volunteer> User = new TableColumn("Username");
			User.setCellValueFactory(new PropertyValueFactory<>("UserName"));
			TableColumn<String, Volunteer> Pass = new TableColumn("Password");
			Pass.setCellValueFactory(new PropertyValueFactory<>("Password"));
			TableColumn<String, Volunteer> first= new TableColumn("First Name");
			first.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
			TableColumn<String, Volunteer> MI = new TableColumn("MI");
			MI.setCellValueFactory(new PropertyValueFactory<>("MiddleInitial"));
			TableColumn<String, Volunteer> last = new TableColumn("Last Name");
			last.setCellValueFactory(new PropertyValueFactory<>("LastName"));
			TableColumn<String, Volunteer> email = new TableColumn("Email");
			email.setCellValueFactory(new PropertyValueFactory<>("Email"));
			TableColumn<String, Volunteer> Phone = new TableColumn("Phone");
			Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
			TableColumn<String, Volunteer> Gender = new TableColumn("Gender");
			Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
			TableColumn<String, Volunteer> Address = new TableColumn("Address");
			Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			TableColumn<String, Volunteer> BirthDate = new TableColumn("Birth Date");
			BirthDate.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
			TableColumn<String, Volunteer> EmergencyContact = new TableColumn("Emergency Contact");
			EmergencyContact.setCellValueFactory(new PropertyValueFactory<>("EmergencyContact"));
			
			
			VolunteerTable VT = new VolunteerTable();
			HashMap<Integer, Volunteer> hash = VT.getVolunteers();
			ArrayList<Volunteer> display = new ArrayList<Volunteer>(); 
			
			for(Integer i: hash.keySet()) {
				display.add(hash.get(i));
			}
			
			Database.getColumns().add(ID);
			Database.getColumns().add(WorkH);
			Database.getColumns().add(court);
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
			
			Iterator itera = display.iterator();
			
			while(itera.hasNext()) {
				Database.getItems().add(itera.next());
			}
			
		});
		
		AddProfile.setOnAction((event) -> {
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