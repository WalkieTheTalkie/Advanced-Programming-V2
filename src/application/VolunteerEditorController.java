package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VolunteerEditorController {

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
	private Button Save;

	@FXML
	private Button Cancel;

	@FXML
	public void initialize() throws ClassNotFoundException, IOException {
		
		FileInputStream vfis = new FileInputStream("EMPID.dat");
		ObjectInputStream ios = new ObjectInputStream(vfis);
		Volunteer v = (Volunteer) ios.readObject();
		
		
		Fname.appendText(v.getFirstName());;
		Lname.appendText(v.getLastName());
		Minitial.appendText(v.getMiddleInitial());
		BirthDate.appendText(v.getBirthDate());
		Gender.appendText(v.getGender());
		Email.appendText(v.getEmail());
		EmergencyContact.appendText(v.getEmergencyContact());
		Phone.appendText(v.getPhone());
		Address.appendText(v.getAddress());
		Username.appendText(v.getUserName());
		Password.appendText(v.getPassword());
		
		Save.setOnAction((event) -> {
		
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

			System.out.println(v.toString());

			VolunteerTable t = new VolunteerTable();
			t.updateVolunteer(v);
			
			VolunteerTable tab = new VolunteerTable();
			HashMap<Integer, Volunteer> a = tab.getVolunteers();

			System.out.println(a.keySet());

			for (int key : a.keySet()) {
				if (Username.getText().equals(a.get(key).getUserName())) {
					if (Password.getText().equals(a.get(key).getPassword())) {
						System.out.println(a.get(key).toString());
						File f = new File("EMPID.dat");
						try {

							System.out.println(a.get(key).getVolunteerID());

							FileOutputStream fos = new FileOutputStream(f);
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(a.get(key));
							FileInputStream fis = new FileInputStream(f);
							ObjectInputStream ios2 = new ObjectInputStream(fis);
							System.out.println(ios2.readObject());

						} catch (IOException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			try {
				Stage thirdStage = (Stage) Cancel.getScene().getWindow();
				thirdStage.setTitle("Aurora Food Pantry Volunteer Page");
				BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Volunteer_Scene.fxml"));
				Scene scene = new Scene(root, 700, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(scene);
				thirdStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		Cancel.setOnAction((event) -> {
			try {
				Stage thirdStage = (Stage) Cancel.getScene().getWindow();
				thirdStage.setTitle("Aurora Food Pantry Volunteer Page");
				BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Volunteer_Scene.fxml"));
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
