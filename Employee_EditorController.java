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
/**
 * Allows an employee to edit certain data
 *
 */
public class Employee_EditorController {

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
		EmployeeClass e = (EmployeeClass) ios.readObject();

		Fname.appendText(e.getFirstName());
		;
		Lname.appendText(e.getLastName());
		Minitial.appendText(e.getMiddleInitial());
		BirthDate.appendText(e.getBirthDate());
		Gender.appendText(e.getGender());
		Email.appendText(e.getEmail());
		EmergencyContact.appendText(e.getEmergencyContact());
		Phone.appendText(e.getPhone());
		Address.appendText(e.getAddress());
		Username.appendText(e.getEmployeeUser());
		Password.appendText(e.getEmployeePass());

		Save.setOnAction((event) -> {

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

			EmployeeTable et = new EmployeeTable();
			et.updateEmployee(e);

			EmployeeTable tab = new EmployeeTable();
			HashMap<Integer, EmployeeClass> a = tab.getEmployees();

			System.out.println(a.keySet());

			for (int key : a.keySet()) {
				if (Username.getText().equals(a.get(key).getEmployeeUser())) {
					if (Password.getText().equals(a.get(key).getEmployeePass())) {
						System.out.println(a.get(key).toString());
						File f = new File("EMPID.dat");
						try {

							System.out.println(a.get(key).getEmployeeID());

							FileOutputStream fos = new FileOutputStream(f);
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(a.get(key));
							FileInputStream fis = new FileInputStream(f);
							ObjectInputStream ios2 = new ObjectInputStream(fis);
							System.out.println(ios2.readObject());

						} catch (IOException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}

			try {
				Stage thirdStage = (Stage) Cancel.getScene().getWindow();
				thirdStage.setTitle("Aurora Food Pantry Employee Page");
				BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Employee_Scene.fxml"));
				Scene scene = new Scene(root, 700, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(scene);
				thirdStage.show();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		Cancel.setOnAction((event) -> {
			try {
				Stage thirdStage = (Stage) Cancel.getScene().getWindow();
				thirdStage.setTitle("Aurora Food Pantry Employee Page");
				BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Employee_Scene.fxml"));
				Scene scene = new Scene(root, 700, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				thirdStage.setScene(scene);
				thirdStage.show();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}
}
