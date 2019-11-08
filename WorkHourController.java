package application;

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
		
		EmployeeTable e = new EmployeeTable();
		HashMap<Integer, EmployeeClass> h = e.getEmployees();
		submit.setOnAction((event) -> {
			
			Stage s = (Stage)text.getScene().getWindow();
			s.close();
		});
		
		Cancel.setOnAction((event) -> {
			Stage s = (Stage)text.getScene().getWindow();
			s.close();
		});
	}
	
}
