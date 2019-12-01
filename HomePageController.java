package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * controls the Home Page and allows a user
 * to decide to see which database table to view.
 *
 */
public class HomePageController {
	@FXML
	private Button Continue;

	@FXML
	private TextField userName;

	@FXML
	private TextField Password;

	@FXML
	private ToggleGroup users;

	@FXML
	private RadioButton Volunteer;

	@FXML
	private RadioButton Employee;

	@FXML
	private RadioButton Admin;

	@FXML
	private Hyperlink newUser;
	
	@FXML
	private Label errorMessage;

	@FXML
	public void initialize() throws FileNotFoundException {
		newUser.setOnAction((event) -> {
			Stage secondStage = new Stage();
			try {
				secondStage.setTitle("Aurora Food Pantry New Volunteer Page");
				BorderPane root = FXMLLoader.load(getClass().getResource("New_Volunteer.fxml"));
				Scene scene = new Scene(root, 600, 600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				secondStage.setScene(scene);
				secondStage.show();
			} catch (Exception e) {
				e.printStackTrace();

			}
		});

		Continue.setOnAction((event) -> {
			Stage thirdStage = (Stage) Continue.getScene().getWindow();
			CheckUserPass check = new CheckUserPass();
			if (Volunteer.isSelected()) {
				int correctUserPass = check.CheckUserPassVolunteer(userName.getText(), Password.getText());
				if (correctUserPass == 1) {
					VolunteerTable tab = new VolunteerTable();
					HashMap<Integer, Volunteer> a = tab.getVolunteers();

					System.out.println(a.keySet());

					for (int key : a.keySet()) {
						if (userName.getText().equals(a.get(key).getUserName())) {
							if (Password.getText().equals(a.get(key).getPassword())) {
								System.out.println(a.get(key).toString());
								File f = new File("EMPID.dat");
								try {

									System.out.println(a.get(key).getVolunteerID());

									FileOutputStream fos = new FileOutputStream(f);
									ObjectOutputStream oos = new ObjectOutputStream(fos);
									oos.writeObject(a.get(key));
									FileInputStream fis = new FileInputStream(f);
									ObjectInputStream ios = new ObjectInputStream(fis);
									System.out.println(ios.readObject());

								} catch (IOException | ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					try {
						thirdStage.setTitle("Aurora Food Pantry Volunteer Page");
						BorderPane root = FXMLLoader.load(getClass().getResource("Volunteer_Scene.fxml"));
						Scene scene = new Scene(root, 700, 700);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						thirdStage.setScene(scene);
						thirdStage.show();
					} catch (Exception e) {
						e.printStackTrace();

					}
				} else if (correctUserPass == 0) {
					errorMessage.setText("Username/Password wrong");
				} else {
					System.out.print("\nSomething went wrong");
				}
				
			} else if (Employee.isSelected()) {
				int correctUserPass = check.CheckUserPassEmployee(userName.getText(), Password.getText());
				if (correctUserPass == 1) {
					EmployeeTable tab = new EmployeeTable();
					HashMap<Integer, EmployeeClass> a = tab.getEmployees();

					System.out.println(a.keySet());

					for (int key : a.keySet()) {
						if (userName.getText().equals(a.get(key).getEmployeeUser())) {
							if (Password.getText().equals(a.get(key).getEmployeePass())) {
								System.out.println(a.get(key).toString());
								File f = new File("EMPID.dat");
								try {

									System.out.println(a.get(key).getEmployeeID());

									FileOutputStream fos = new FileOutputStream(f);
									ObjectOutputStream oos = new ObjectOutputStream(fos);
									oos.writeObject(a.get(key));
									FileInputStream fis = new FileInputStream(f);
									ObjectInputStream ios = new ObjectInputStream(fis);
									System.out.println(ios.readObject());

								} catch (IOException | ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					try {
						thirdStage.setTitle("Aurora Food Pantry Employee Page");
						BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Employee_Scene.fxml"));
						Scene scene = new Scene(root, 700, 700);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						thirdStage.setScene(scene);
						thirdStage.show();
					} catch (Exception e) {
						e.printStackTrace();

					}
				} else if (correctUserPass == 0) {
					errorMessage.setText("Username/Password wrong");
				} else {
					System.out.print("\nWell, this didn't work");
				}
			} else if (Admin.isSelected()) {
				int correctUserPass = check.CheckUserPassAdmin(userName.getText(), Password.getText());
				if (correctUserPass == 1) {
					AdminTable tab = new AdminTable();
					HashMap<Integer, Admin> a = tab.getAdmin();

					System.out.println(a.keySet());

					for (int key : a.keySet()) {
						if (userName.getText().equals(a.get(key).getUsername())) {
							if (Password.getText().equals(a.get(key).getPassword())) {
								System.out.println(a.get(key).toString());
								File f = new File("EMPID.dat");
								try {

									System.out.println(a.get(key).getId());

									FileOutputStream fos = new FileOutputStream(f);
									ObjectOutputStream oos = new ObjectOutputStream(fos);
									oos.writeObject(a.get(key));
									FileInputStream fis = new FileInputStream(f);
									ObjectInputStream ios = new ObjectInputStream(fis);
									System.out.println(ios.readObject());

								} catch (IOException | ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					try {
						thirdStage.setTitle("Aurora Food Pantry Admin Page");
						BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
						Scene scene = new Scene(root, 700, 700);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						thirdStage.setScene(scene);
						thirdStage.show();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (correctUserPass == 0) {
					errorMessage.setText("Username/Password wrong");
				} else {
					System.out.print("\nThat wasn't supposed to happen");
				}
			} else {
				System.out.println("You need to select a radio button.");
				Stage fourthStage = new Stage();
				fourthStage.setTitle("Error");
				BorderPane root;
				try {
					root = (BorderPane) FXMLLoader.load(getClass().getResource("NoUserSelectedError.fxml"));
					Scene scene = new Scene(root, 200, 200);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					fourthStage.setScene(scene);
					fourthStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

}
