package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WorkHourController {
	@FXML
	private ToggleGroup Choices;

	@FXML
	private RadioButton Add;

	@FXML
	private RadioButton Subtract;

	@FXML
	private Button submit;

	@FXML
	private Button Cancel;

	@FXML
	private TextField text;

	@FXML
	public void initialize() {
		submit.setOnAction((event) -> {

			try {
				FileInputStream fis = new FileInputStream("EMPID.dat");
				ObjectInputStream ios = new ObjectInputStream(fis);
				
				EmployeeClass e = new EmployeeClass();
				Volunteer v = new Volunteer();
				

				if ((ios.readObject().getClass().isInstance(e))) {
					e = (EmployeeClass) ios.readObject();
					if (Add.isSelected()) {
						e.setWorkinHours(e.getWorkinHours() + Integer.parseInt(text.getText()));
					} else if (Subtract.isSelected()) {
						e.setWorkinHours(e.getWorkinHours() - Integer.parseInt(text.getText()));
					} else {
						System.out.println("just display an fxml representing not selected");
					}
				} else if ((ios.readObject().getClass().isInstance(v))) {
					v = (Volunteer) ios.readObject();
					if (Add.isSelected()) {
						v.setHoursVolunteered(v.getHoursVolunteered() + Integer.parseInt(text.getText()));
					} else if (Subtract.isSelected()) {
						v.setHoursVolunteered(v.getHoursVolunteered() - Integer.parseInt(text.getText()));
					} else {
						System.out.println("just display an fxml representing not selected");
					}
				} else {
					System.out.println("Hmm something is not right...");
				}

			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Stage s = (Stage) text.getScene().getWindow();
			s.close();
		});

		Cancel.setOnAction((event) -> {
			Stage s = (Stage) text.getScene().getWindow();
			s.close();
		});
	}

}
