/**
 * @author Ben Jaynes
 * @author Rachel Skonning
 * @author Angel Vivanco
 * @author Luke Gaudiano
 */
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
/**
 * This is the controller for the Admin Scene on the AdminPage.fxml.
 * Allows users to read from a mySQL database and take a table of
 * employees and volunteers
 * 
 */
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
	private TextField idSearch;
	
	@FXML
	private Button searchButton2;
	
	/**
	 * runs the controller when called
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
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
		/**
		 * allows admin to change information of user
		 */
		EditMyProfile.setOnAction((event) ->{
			Stage thirdStage = (Stage) EditMyProfile.getScene().getWindow();
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
			

			/**
			 * stores data in hashmap and iterates through it to display
			 * data
			 */
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

		/**
		 * stores data in hashmap and iterates through it to display
		 * data
		 */
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

		/**
		 * Applies volunteer values to table
		 */
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
		/**
		 * Adds users to database. Only admins have the power to append hiearchies. 
		 */
		AddProfile.setOnAction((event) -> {
			Stage thirdStage = (Stage) LogOut.getScene().getWindow();
			thirdStage.setTitle("Aurora Food Pantry Add User");
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
				
		});
			/**
			 * deletes a user from database
			 */
		RemoveProfile.setOnAction((event) -> {
			Stage fourthStage = (Stage) RemoveProfile.getScene().getWindow();
			fourthStage.setTitle("Aurora Food Pantry Delete User");
			BorderPane root;
			try {
				root = (BorderPane) FXMLLoader.load(getClass().getResource("deleteUser.fxml"));
				Scene scene = new Scene(root, 700, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				fourthStage.setScene(scene);
				fourthStage.show();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	/**
	 * Making tables out of objects
	 */
		AdminTable AT = new AdminTable();
		EmployeeTable EM = new EmployeeTable();
		VolunteerTable VT = new VolunteerTable();
		/**
		 * Uses comparator to compare last names of specified database
		 */
		LastNameButton.setOnAction((event) -> {
			//CurrentProfile.clear();
			HashMap<Integer, Admin> HMA = AT.getAdmin();
			Set<Integer> key = HMA.keySet();
			Admin[] AR = new Admin[key.size()];
			Iterator IT = key.iterator();
			if (Admin1.isSelected()) {
				for (int i = 0; i < key.size(); i++) {
					AR[i] = HMA.get(IT.next());
					//System.out.println(AR[i]);
				}
				for (int i = 0; i < key.size(); i++) {
					//System.out.println(AR[i]);
				}
				//System.out.println(AR.length);

				Admin temp;
				//System.out.println("Strings in sorted order:");
				for (int j = 0; j < AR.length; j++) {
					for (int i = j + 1; i < AR.length; i++) {
						// comparing adjacent strings
						if (AR[i].compare(AR[j], AR[i]) > 0) {
							temp = AR[j];
							AR[j] = AR[i];
							AR[i] = temp;
						}
					}
				}

				// System.out.println(Arrays.asList(AR).toString());
				//CurrentProfile.appendText(Arrays.asList(AR).toString());
				// System.out.println((new Admin()).compare(AR[0], AR[1]));
				Database.getItems().clear();
				for (int i = 0; i < AR.length; i++) {
					Database.getItems().add(AR[i]);
				}
			} else if (Volunteer1.isSelected()) {
				//CurrentProfile.clear();
				HashMap<Integer, Volunteer> HMV = VT.getVolunteers();
				Set<Integer> keyV = HMV.keySet();
				Volunteer[] ARV = new Volunteer[keyV.size()];
				Iterator ITV = keyV.iterator();
				for (int i = 0; i < keyV.size(); i++) {
					ARV[i] = HMV.get(ITV.next());
					//System.out.println(ARV[i].getLastName());
				}
				//System.out.println(ARV.length);

				Volunteer temp;
				//System.out.println("Strings in sorted order:");
				for (int j = 0; j < ARV.length; j++) {
					for (int i = j + 1; i < ARV.length; i++) {
						// comparing adjacent strings
						if (ARV[i].compare(ARV[j], ARV[i]) > 0) {
							temp = ARV[j];
							ARV[j] = ARV[i];
							ARV[i] = temp;
						}
					}
				}
				for (int i = 0; i < ARV.length; i++) {
					//System.out.println(ARV[i].getLastName());
				}

				//CurrentProfile.appendText(Arrays.asList(ARV).toString());
				Database.getItems().clear();
				for (int i = 0; i < ARV.length; i++) {
					Database.getItems().add(ARV[i]);
				}
			} else if (Employee.isSelected()) {

				//CurrentProfile.clear();
				HashMap<Integer, EmployeeClass> HME = EM.getEmployees();
				Set<Integer> keyE = HME.keySet();
				EmployeeClass[] ARE = new EmployeeClass[keyE.size()];
				Iterator ITE = keyE.iterator();
				for (int i = 0; i < keyE.size(); i++) {
					ARE[i] = HME.get(ITE.next());
					//System.out.println(ARE[i].getLastName());
				}
				//System.out.println(ARE.length);

				EmployeeClass temp;
				//System.out.println("Strings in sorted order:");
				for (int j = 0; j < ARE.length; j++) {
					for (int i = j + 1; i < ARE.length; i++) {
						// comparing adjacent strings
						if (ARE[i].compare(ARE[j], ARE[i]) > 0) {
							temp = ARE[j];
							ARE[j] = ARE[i];
							ARE[i] = temp;
						}
					}
				}
				for (int i = 0; i < ARE.length; i++) {
					//System.out.println(ARE[i].getLastName());
				}
				//CurrentProfile.appendText(Arrays.asList(ARE).toString());
				Database.getItems().clear();
				for (int i = 0; i < ARE.length; i++) {
					Database.getItems().add(ARE[i]);
				}
			} else {
				// Nothing happens if they don't have a radio button selected
			}
		});
		FirstNameButton.setOnAction((event) -> {
			if (Volunteer1.isSelected()) {
				CurrentProfile.clear();
				HashMap<Integer, Volunteer> HMV = VT.getVolunteers();
				Set<Integer> keyV = HMV.keySet();
				Person[] ARV = new Volunteer[keyV.size()];
				Iterator ITV = keyV.iterator();
				for (int i = 0; i < keyV.size(); i++) {
					ARV[i] = HMV.get(ITV.next());
				}

				HeapStringFirstNameSort JB = new HeapStringFirstNameSort(ARV);
				ARV = JB.HEAPSort();

				System.out.println();
				System.out.println("Sorted :");
				System.out.println();

				for (int i = 0; i < keyV.size(); i++) {
					CurrentProfile.appendText((ARV[i].getFirstName() + ", "));
				}
				

			}else if (Admin1.isSelected()) {
				CurrentProfile.clear();
				HashMap<Integer, Admin> HMA = AT.getAdmin();
				Set<Integer> keyA = HMA.keySet();
				Person[] ARA = new Admin[keyA.size()];
				Iterator ITA = keyA.iterator();
				for (int i = 0; i < keyA.size(); i++) {
					ARA[i] = HMA.get(ITA.next());
				}

				HeapStringFirstNameSort JB = new HeapStringFirstNameSort(ARA);
				ARA = JB.HEAPSort();

				System.out.println();
				System.out.println("Sorted :");
				System.out.println();

				for (int i = 0; i < keyA.size(); i++) {
					CurrentProfile.appendText((ARA[i].getFirstName() + ", "));
				}
			}else if (Employee.isSelected()) {
				CurrentProfile.clear();
				HashMap<Integer, EmployeeClass> HME = EM.getEmployees();
				Set<Integer> keyE = HME.keySet();
				Person[] ARE = new EmployeeClass[keyE.size()];
				Iterator ITE = keyE.iterator();
				for (int i = 0; i < keyE.size(); i++) {
					ARE[i] = HME.get(ITE.next());
				}

				HeapStringFirstNameSort JB = new HeapStringFirstNameSort(ARE);
				ARE = JB.HEAPSort();

				System.out.println();
				System.out.println("Sorted :");

				for (int i = 0; i < keyE.size(); i++) {
					CurrentProfile.appendText((ARE[i].getFirstName() + ", "));
				}
			}

		});
		
		searchButton.setOnAction((event) -> {
			ArrayList<EmployeeClass> emps = SearchByLastName.EmpSearchByLastName(searchField.getText());
			ArrayList<Admin> ad = SearchByLastName.AdminSearchByLastName(searchField.getText());
			ArrayList<Volunteer> v = SearchByLastName.VolunSearchByLastName(searchField.getText());
			CurrentProfile.appendText("\n\nAdmin: ");
			if (ad.isEmpty()) {
				CurrentProfile.appendText("\nNo one by that name");
			} else {
				Iterator<Admin> itera = ad.iterator();
				while (itera.hasNext()) {
					CurrentProfile.appendText("\n" + itera.next());
				}
			}
			CurrentProfile.appendText("\n\nEmployees: ");
			if (emps.isEmpty()) {
				CurrentProfile.appendText("\nNo one by that name");
			} else {
				Iterator<EmployeeClass> itera = emps.iterator();
				while (itera.hasNext()) {
					CurrentProfile.appendText("\n" + itera.next());
				}
			}
			CurrentProfile.appendText("\n\nVolunteers: ");
			if (v.isEmpty()) {
				CurrentProfile.appendText("\nNo one by that name");
			} else {
				Iterator<Volunteer> itera = v.iterator();
				while (itera.hasNext()) {
					CurrentProfile.appendText("\n\n" + itera.next());
				}
			}
		});
		
		searchButton2.setOnAction((event) -> {
			try {
				Admin ad = BinarySearchSortByID.AdBinarySearchByID(Integer.parseInt(idSearch.getText()));
				EmployeeClass e = BinarySearchSortByID.EmpBinarySearchByID(Integer.parseInt(idSearch.getText()));
				Volunteer v = BinarySearchSortByID.VBinarySearchByID(Integer.parseInt(idSearch.getText()));
				CurrentProfile.appendText("\n\nAdmin: ");
				if( ad.getUsername() == null) {
					CurrentProfile.appendText("\nThere is no Admin with that ID number");
				} else {
					CurrentProfile.appendText(ad.toString());
				}
				CurrentProfile.appendText("\n\nEmployee: ");
				if (e.getEmployeeUser() == null) {
					CurrentProfile.appendText("\nThere is no Employee with that ID number");
				} else {
					CurrentProfile.appendText(e.toString());
				}
				CurrentProfile.appendText("\n\nVolunteer: ");
				if (v.getUserName() == null) {
					CurrentProfile.appendText("\nThere is no Volunteer with that ID number");
				} else {
					CurrentProfile.appendText("\n" + v.toString());
				}
			} catch (NumberFormatException ex) {
				CurrentProfile.appendText("\n\nPlease enter a valid ID number");
			}
			
		});
		
		IDButton.setOnAction((event) -> {
			if (Admin1.isSelected()) {
				LinkedList<Admin> ad = BinarySearchSortByID.AdminSortByID();
				Database.getItems().clear();
				for (int i = 0; i < ad.size(); i++) {
					Database.getItems().add(ad.get(i));
				}
			} else if (Employee.isSelected()) {
				LinkedList<EmployeeClass> emp = BinarySearchSortByID.EmployeeSortByID();
				Database.getItems().clear();
				for (int i = 0; i < emp.size(); i++) {
					Database.getItems().add(emp.get(i));
				}
			} else if (Volunteer1.isSelected()) {
				LinkedList<Volunteer> volun = BinarySearchSortByID.VolunteersSortByID();
				Database.getItems().clear();
				for (int i = 0; i < volun.size(); i++) {
					Database.getItems().add(volun.get(i));
				}
			} else {
				// does nothing if no radio button is selected
			}
		});
		
		EditProfile.setOnAction((event) -> {
			Stage thirdStage = (Stage) EditProfile.getScene().getWindow();
			thirdStage.setTitle("Aurora Food Edit User");
			BorderPane root;
			try {
				root = (BorderPane) FXMLLoader.load(getClass().getResource("EditUser.fxml"));
				Scene scene = new Scene(root, 700, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(scene);
				thirdStage.show();

			} catch (IOException ie) {
				// TODO Auto-generated catch block
				ie.printStackTrace();

			}
		});
		/*
		 * 
		 * Sorting Profiles by Most Hours
		 * 
		 */
		MostHoursButton.setOnAction((event)->{
			CurrentProfile.clear();
			if (Admin1.isSelected()) {
				CurrentProfile.appendText("NOT APPLICABLE");
			}
			else if (Employee.isSelected()) {
			HashMap<Integer, EmployeeClass> h = EM.getEmployees();
			Set<Integer> A = h.keySet();
			EmployeeClass[] ah = new EmployeeClass[A.size()];
			Iterator it = A.iterator();
			for(int i = 0; i<h.size();i++) {
				ah[i] = h.get(it.next());
			} 
			int mh[] = new int[ah.length];
			for(int j = 0; j < ah.length; j++) {
				mh[j] = ah[j].getWorkinHours();
			}
			sort(mh, 0, mh.length-1);
			Arrays.sort(ah);
			CurrentProfile.appendText(Arrays.asList(ah).toString());
			}
			else {
				HashMap<Integer, Volunteer> h = VT.getVolunteers();
				Set<Integer> A = h.keySet();
				Volunteer[] ah = new Volunteer[A.size()];
				Iterator it = A.iterator();
				for(int i = 0; i<h.size();i++) {
					ah[i] = h.get(it.next());
				} 
				int mh[] = new int[ah.length];
				for(int j = 0; j < ah.length; j++) {
					mh[j] = ah[j].getHoursVolunteered();
				}
				sort(mh, 0, mh.length-1);
				for(int n = 0; n<mh.length; ++n) {
					System.out.println(mh[n] + " ");
				}
				Arrays.sort(ah);
				CurrentProfile.appendText(Arrays.asList(ah).toString());
				
				
			}
		});
		

		
	
		
	}
/**
 * Start of the merge sort, takes hours worked and puts them in 
 * largest to smallest order.
 * @param a array of hours
 * @param left left side of the array
 * @param middle middle of array
 * @param right right of the array
 */

void merge(int a[], int left, int middle, int right){
	int n = middle - left + 1;
	int f = right - middle;
	
	//temporary arrays
	int temp[] = new int[n];
	int temp2[] = new int[f];
	//storing values in said arrays
	for(int i = 0; i<n; ++i) {
		temp[i] = a[left+i];
	}
	for(int k = 0; k<f; ++k) {
		temp2[k] = a[middle + 1 + k];
	}
	
	//initial indexes
	int s1 = 0, s2 = 0;
	int b = left;
	while (s1 < n && s2 < f) {
		if(temp[s1] <= temp2[s2]) {
			a[b] = temp[s1];
			s1++;
		}
		else {
			a[b] = temp2[s2];
			s2++;
		}
	}
	while (s1 < n) {
		a[b] = temp[s1];
		s1++;
		b++;
	}
	while(s2 < f) {
		a[b] = temp2[s2];
		s2++;
		b++;
	}
}
/**
 * Takes the array and sorts it within. Calls merge to combine the two 
 * methods.
 * @param a array of hours worked
 * @param left left of array
 * @param right right of array
 */
void sort(int a[], int left, int right) {
	if(left < right)
	{
		int middle = (left + right)/2;
		sort(a,left,middle);
		sort(a,middle+1,right);
		merge(a,left,middle,right);
	}
}
	
}
