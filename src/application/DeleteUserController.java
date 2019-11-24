package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DeleteUserController {
	@FXML
	private Label username;
	
	@FXML
	private Label password;
	
	@FXML
	private Label firstName;
	
	@FXML
	private Label middleInitial;
	
	@FXML
	private Label lastName;
	
	@FXML
	private Label email;
	
	@FXML
	private Label phone;
	
	@FXML
	private Label gender;
	
	@FXML
	private Label address;
	
	@FXML
	private Label birthDate;
	
	@FXML
	private Label emergencyContact;
	
	@FXML
	private TextField id;
	
	@FXML
	private RadioButton employee;
	
	@FXML
	private RadioButton volunteer;
	
	@FXML 
	private Button Delete;
	
	@FXML
	private Button Cancel;
	
	@FXML
	private Button Search;
	
	@FXML
	private Label idError;
	
	private int idNum;
	
	@FXML
	public void initialize() {
		Search.setOnAction((event) -> {
			try {
				idError.setText("");
				username.setText("");
				password.setText("");
				firstName.setText("");
				middleInitial.setText("");
				lastName.setText("");
				email.setText("");
				phone.setText("");
				address.setText("");
				birthDate.setText("");
				emergencyContact.setText("");
				this.idNum = Integer.parseInt(id.getText());
				if (volunteer.isSelected()) {
					VolunteerTable v = new VolunteerTable();
					Volunteer temp = v.getVolunteerByID(idNum);
					if (temp.getUserName() == null || idNum <= 0) {
						idError.setText("Volunteer does not exist");
					}else {
						username.setText(temp.getUserName());
						password.setText(temp.getPassword());
						firstName.setText(temp.getFirstName());
						middleInitial.setText(temp.getMiddleInitial());
						lastName.setText(temp.getLastName());
						email.setText(temp.getEmail());
						phone.setText(temp.getPhone());
						gender.setText(temp.getGender());
						address.setText(temp.getAddress());
						birthDate.setText(temp.getBirthDate());
						emergencyContact.setText(temp.getEmergencyContact());
					}
				} else if (employee.isSelected()) {
					EmployeeTable e = new EmployeeTable();
					EmployeeClass temp = e.getEmployeeByID(idNum);
					if (temp.getEmployeeUser() == null || idNum <= 0) {
						idError.setText("Employee does not exist");
					} else {
						username.setText(temp.getEmployeeUser());
						password.setText(temp.getEmployeePass());
						firstName.setText(temp.getFirstName());
						middleInitial.setText(temp.getMiddleInitial());
						lastName.setText(temp.getLastName());
						email.setText(temp.getEmail());
						phone.setText(temp.getPhone());
						gender.setText(temp.getGender());
						address.setText(temp.getAddress());
						birthDate.setText(temp.getBirthDate());
						emergencyContact.setText(temp.getEmergencyContact());
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
		
		Delete.setOnAction((event) -> {
			if (idNum <= 0) {
				idError.setText("Invalid ID number");
			} else {
				Stage deleteStage = new Stage();
				deleteStage.setTitle("");
				BorderPane root;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteUserFinal.fxml"));
					root = (BorderPane) loader.load();
					Scene scene = new Scene(root, 200, 200);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					deleteStage.setScene(scene);
					// get controller and pass arguments
					DeleteUserFinalController controller = loader.getController();
					controller.setDelete(idNum, volunteer.isSelected());
					deleteStage.showAndWait();
					Stage thirdStage = (Stage) Cancel.getScene().getWindow();
					thirdStage.setTitle("Aurora Food Pantry Admin Page");
					BorderPane root2 = (BorderPane) FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
					Scene scene2 = new Scene(root2, 700, 700);
					scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					thirdStage.setScene(scene2);
					thirdStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	}
}
