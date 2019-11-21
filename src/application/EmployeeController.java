package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EmployeeController {
	@FXML
	private ToggleGroup options;

	@FXML
	private RadioButton viewProfile;

	@FXML
	private RadioButton editProfile;

	@FXML
	private RadioButton viewWorkHours;

	@FXML
	private RadioButton logWorkHours;

	@FXML
	private TextArea area;

	@FXML
	private Button selected;

	@FXML
	private Button logOut;

	public void initialize() throws Exception {
		selected.setOnAction((event) -> {

			int i;
			try {
				FileInputStream fis = new FileInputStream("EMPID.dat");
				ObjectInputStream ios = new ObjectInputStream(fis);
				EmployeeClass e = (EmployeeClass) ios.readObject();
				if (viewProfile.isSelected()) {
					area.clear();
					area.appendText(e.toString());
					area.appendText("\n\n ------------- \n\n");
				} else if (editProfile.isSelected()) {
					Stage thirdStage = (Stage) editProfile.getScene().getWindow();
					thirdStage.setTitle("Aurora Food Employee Editor Page");
					BorderPane root;
					try {
						root = (BorderPane) FXMLLoader.load(getClass().getResource("Employee_UserEditor.fxml"));
						Scene scene = new Scene(root, 700, 700);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						thirdStage.setScene(scene);
						thirdStage.show();

					} catch (IOException ie) {
						// TODO Auto-generated catch block
						ie.printStackTrace();

					}
					area.appendText("\n\n ------------- \n\n");
				} else if (viewWorkHours.isSelected()) {
					String hours = "Working Hours:" + e.getWorkinHours();
					area.clear();
					area.appendText(hours);
					area.appendText("\n\n ------------- \n\n");
				} else if (logWorkHours.isSelected()) {
					Stage thirdStage = new Stage();
					thirdStage.setTitle("Aurora Food Pantry Working Hours Page");
					BorderPane root;
					try {
						root = (BorderPane) FXMLLoader.load(getClass().getResource("WorkHourLogger.fxml"));
						Scene scene = new Scene(root, 500, 500);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						thirdStage.setScene(scene);
						thirdStage.show();

					} catch (IOException ie) {
						// TODO Auto-generated catch block
						ie.printStackTrace();

					}
				} else {
					System.out.println("This is not working");
				}

			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		logOut.setOnAction((event) -> {
			Stage thirdStage = (Stage) logOut.getScene().getWindow();
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
	}
}
