package application;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class New_Volunteer_Controller {
	@FXML 
	private ToggleGroup options;

	@FXML
	private TextField Username;

	@FXML
	private TextField Password;

	@FXML
	private TextField Minitial;

	@FXML
	private TextField Fname;

	@FXML
	private TextField Lname;

	@FXML
	private TextField Email;

	@FXML
	private TextField Phone;

	@FXML
	private TextField Gender;

	@FXML
	private TextField Address;

	@FXML
	private TextField BirthDate;

	@FXML
	private TextField EmergencyContact;

	@FXML
	private Button AddUser;

	public void initialize() {
		Volunteer v = new Volunteer();
		AddUser.setOnAction((event) -> {
			
			v.setFirstName(Fname.getText());
			v.setLastName(Lname.getText());
			v.setMiddleInitial(Minitial.getText());
			v.setBirthDate(BirthDate.getText());
			v.setGender(Gender.getText());
			v.setEmail(Email.getText());
			v.setEmergencyContact(EmergencyContact.getText());
			v.setPhone(Phone.getText());
			v.setAddress(Address.getText());
			v.setUserName(Username.getText());
			v.setPassword(Password.getText());
			v.setCourtOrdered(false);
			
			System.out.println(v.toString());
			
			DBVolunteer volun = new DBVolunteer(v);
			
			Stage stage = (Stage) AddUser.getScene().getWindow();
		    stage.close();
			
			
		});
	}
}
