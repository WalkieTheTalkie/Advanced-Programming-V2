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

public class Admin_EditorController {
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
		Admin a = (Admin) ios.readObject();
		
		
		Fname.appendText(a.getFirstName());;
		Lname.appendText(a.getLastName());
		Minitial.appendText(a.getMiddleInitial());
		BirthDate.appendText(a.getBirthDate());
		Gender.appendText(a.getGender());
		Email.appendText(a.getEmail());
		EmergencyContact.appendText(a.getEmergencyContact());
		Phone.appendText(a.getPhone());
		Address.appendText(a.getAddress());
		Username.appendText(a.getUsername());
		Password.appendText(a.getPassword());
		
		Save.setOnAction((event) -> {
		
			a.setFirstName(Fname.getText());
			a.setLastName(Lname.getText());
			a.setMiddleInitial(Minitial.getText());
			a.setBirthDate(BirthDate.getText());
			a.setGender(Gender.getText());
			a.setEmail(Email.getText());
			a.setEmergencyContact(EmergencyContact.getText());
			a.setPhone(Phone.getText());
			a.setAddress(Address.getText());
			a.setUsername(Username.getText());
			a.setPassword(Password.getText());

			System.out.println(a.toString());

			AdminTable t = new AdminTable();
			t.updateAdmin(a);
			
			AdminTable tab = new AdminTable();
			HashMap<Integer, Admin> ad = tab.getAdmin();

			System.out.println(ad.keySet());

			for (int key : ad.keySet()) {
				if (Username.getText().equals(ad.get(key).getUsername())) {
					if (Password.getText().equals(ad.get(key).getPassword())) {
						System.out.println(ad.get(key).toString());
						File f = new File("EMPID.dat");
						try {

							System.out.println(ad.get(key).getId());

							FileOutputStream fos = new FileOutputStream(f);
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(ad.get(key));
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
