package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * admin control to create users
 *
 */
public class NewUser_Controller {
	
	@FXML 
	private ToggleGroup options;

	@FXML
	private RadioButton Admin;
	
	@FXML
	private RadioButton Employee;

	@FXML
	private RadioButton Volunteer;

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

	@FXML
	private Button Cancel;
	
	public void initialize() {
		AddUser.setOnAction((event) -> {
			EmployeeClass e = new EmployeeClass();
			Volunteer v = new Volunteer();
			Admin a = new Admin();
			int sent = 0;

			if (Admin.isSelected()) {
				sent = 1;
				a.setFirstName(Fname.getText());
				a.setLastName(Lname.getText());
				a.setMiddleInitial(Minitial.getText());
				a.setBirthDate(BirthDate.getText());
				a.setGender(Gender.getText());
				a.setEmail(Email.getText());
				a.setEmergencyContact(EmergencyContact.getText());
				a.setPhone(Phone.getText());
				a.setUsername(Username.getText());
				a.setPassword(Password.getText());
				a.setAddress(Address.getText());
				
				System.out.println(a.toString());
				
				DBAdmin adm = new DBAdmin(a);
				
			}else if (Employee.isSelected()) {
				sent = 2;
				e.setFirstName(Fname.getText());
				e.setLastName(Lname.getText());
				e.setMiddleInitial(Minitial.getText());
				e.setBirthDate(BirthDate.getText());
				e.setGender(Gender.getText());
				e.setEmail(Email.getText());
				e.setEmergencyContact(EmergencyContact.getText());
				e.setPhone(Phone.getText());
				e.setAddress(Address.getText());
				e.setEmployeeUser(Username.getText());
				e.setEmployeePass(Password.getText());
				
				System.out.println(e.toString());
				
				DBEmployee emp = new DBEmployee(e);
			}else if (Volunteer.isSelected()) {
				sent = 3;
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
				
			}// else {
			//	System.out.println("This is not Working and they aren't being saved in objects!!!");
			//}
			
			

			//File storage = new File("person.dat");
			//try {
				//@SuppressWarnings("resource")
				//ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat", true));
				//if(sent == 2) {
				//	out.writeObject(v);
				//}else if(sent == 1) {
					//out.writeObject(e);
				//}else{
					//System.out.println("Not writing to file properly!!!");
				//}
			//} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			//}

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
		
	}

}
