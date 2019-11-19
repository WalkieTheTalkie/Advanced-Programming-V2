package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

				Object p = (Object) ios.readObject();
				EmployeeClass e = new EmployeeClass();
				Volunteer v = new Volunteer();
				Admin a = new Admin();

				if ((p.getClass().isInstance(e))) {
					e = (EmployeeClass) p;
					if (Add.isSelected()) {
						e.setWorkinHours(e.getWorkinHours() + Integer.parseInt(text.getText()));
					} else if (Subtract.isSelected()) {
						e.setWorkinHours(e.getWorkinHours() - Integer.parseInt(text.getText()));
					} else {
						System.out.println("\n\n--------------\n");
						System.out.println("just display an fxml representing not selected");
					}
					System.out.println("\n\n---------------\n");
					System.out.println(e.toString());

					File f = new File("EMPID.dat");
					f.delete();

					FileOutputStream FOS = new FileOutputStream("EMPID.dat");
					ObjectOutputStream OOS = new ObjectOutputStream(FOS);
					OOS.writeObject(e);
					
					EmployeeTable ET = new EmployeeTable();
					ET.updateEmployee(e);
				} else if ((p.getClass().isInstance(v))) {
					v = (Volunteer) p;
					if (Add.isSelected()) {
						v.setHoursVolunteered(v.getHoursVolunteered() + Integer.parseInt(text.getText()));
					} else if (Subtract.isSelected()) {
						v.setHoursVolunteered(v.getHoursVolunteered() - Integer.parseInt(text.getText()));
					} else {
						System.out.println("\n\n--------------\n");
						System.out.println("just display an fxml representing not selected");
					}
					System.out.println("\n\n---------------\n");
					System.out.println(v.toString());

					File f = new File("EMPID.dat");
					f.delete();

					FileOutputStream FOS = new FileOutputStream("EMPID.dat");
					ObjectOutputStream OOS = new ObjectOutputStream(FOS);
					OOS.writeObject(v);

					VolunteerTable vt = new VolunteerTable();
					vt.updateVolunteer(v);
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
