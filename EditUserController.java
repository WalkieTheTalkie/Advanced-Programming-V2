package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * Class edits an existing user
 */
public class EditUserController {
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField middleInitial;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField phone;
	
	@FXML
	private TextField gender;
	
	@FXML
	private TextField address;
	
	@FXML
	private TextField birthDate;
	
	@FXML
	private TextField emergencyContact;
	
	@FXML
	private TextField id;
	
	@FXML
	private RadioButton employee;
	
	@FXML
	private RadioButton volunteer;
	
	@FXML 
	private Button Save;
	
	@FXML
	private Button Cancel;
	
	@FXML
	private Button Search;
	
	@FXML
	private Label idError;
	
	@FXML
	private Label successText;
	
	private int idNum;
	
	@FXML
	public void initialize() throws ClassNotFoundException, IOException{
		Search.setOnAction((event) -> {
			try {
				idError.setText("");
				this.idNum = Integer.parseInt(id.getText());
				if (volunteer.isSelected()) {
					VolunteerTable v = new VolunteerTable();
					Volunteer temp = v.getVolunteerByID(idNum);
					if (temp.getUserName() == null || idNum <= 0) {
						idError.setText("Volunteer does not exist");
					}else {
						username.appendText(temp.getUserName());
						password.appendText(temp.getPassword());
						firstName.appendText(temp.getFirstName());
						middleInitial.appendText(temp.getMiddleInitial());
						lastName.appendText(temp.getLastName());
						email.appendText(temp.getEmail());
						phone.appendText(temp.getPhone());
						gender.appendText(temp.getGender());
						address.appendText(temp.getAddress());
						birthDate.appendText(temp.getBirthDate());
						emergencyContact.appendText(temp.getEmergencyContact());
					}
				} else if (employee.isSelected()) {
					EmployeeTable e = new EmployeeTable();
					EmployeeClass temp = e.getEmployeeByID(idNum);
					if (temp.getEmployeeUser() == null || idNum <= 0) {
						idError.setText("Employee does not exist");
					} else {
						username.appendText(temp.getEmployeeUser());
						password.appendText(temp.getEmployeePass());
						firstName.appendText(temp.getFirstName());
						middleInitial.appendText(temp.getMiddleInitial());
						lastName.appendText(temp.getLastName());
						email.appendText(temp.getEmail());
						phone.appendText(temp.getPhone());
						gender.appendText(temp.getGender());
						address.appendText(temp.getAddress());
						birthDate.appendText(temp.getBirthDate());
						emergencyContact.appendText(temp.getEmergencyContact());
					}
				} else {
					System.out.print("\nError with radio buttons");
				}
			} catch(NumberFormatException ex) {
				idError.setText("Please enter a number");
			} catch(NullPointerException ex) {
				idError.setText("Invalid ID number");
			}
				
			
		});
		
		Save.setOnAction((event) -> {
			if (idNum <= 0) {
				idError.setText("Invalid ID number");
			} else {
				
				if (employee.isSelected()) {
					EmployeeClass e = new EmployeeClass();
					EmployeeTable ET = new EmployeeTable();
					e.setEmployeeID(idNum);
					e.setWorkinHours(ET.getEmployeeByID(idNum).getWorkinHours());
					e.setEmployeeUser(username.getText());
					e.setEmployeePass(password.getText());
					e.setFirstName(firstName.getText());
					e.setMiddleInitial(middleInitial.getText());
					e.setLastName(lastName.getText());
					e.setEmail(email.getText());
					e.setPhone(phone.getText());
					e.setAddress(address.getText());
					e.setGender(gender.getText());
					e.setBirthDate(birthDate.getText());
					e.setEmergencyContact(emergencyContact.getText());
					
					ET.updateEmployee(e);
					successText.setText("Edit successful");
				} else if (volunteer.isSelected()){
					Volunteer v = new Volunteer();
					VolunteerTable VT = new VolunteerTable();
					v.setVolunteerID(idNum);
					v.setCourtOrdered(VT.getVolunteerByID(idNum).getCourtOrdered());
					v.setHoursVolunteered(VT.getVolunteerByID(idNum).getHoursVolunteered());
					v.setUserName(username.getText());
					v.setPassword(password.getText());
					v.setFirstName(firstName.getText());
					v.setMiddleInitial(middleInitial.getText());
					v.setLastName(lastName.getText());
					v.setPhone(phone.getText());
					v.setEmail(email.getText());
					v.setAddress(address.getText());
					v.setGender(gender.getText());
					v.setBirthDate(birthDate.getText());
					v.setEmergencyContact(emergencyContact.getText());
					
					VT.updateVolunteer(v);
					successText.setText("Edit successful");
				} else {
					System.out.print("Something went wrong with the radio buttons");
				}
			}
			
		});
		
		Cancel.setOnAction((event) -> {
			try {
				Stage thirdStage = (Stage) Cancel.getScene().getWindow();
				thirdStage.setTitle("Aurora Food Pantry Admin Page");
				BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
				Scene scene = new Scene(root, 700, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(scene);
				thirdStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	};	
}
