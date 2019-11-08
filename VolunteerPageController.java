package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class VolunteerPageController {
	@FXML
	private RadioButton viewProfile;

	@FXML
	private RadioButton editProfile;

	@FXML
	private RadioButton viewWorkHours;

	@FXML
	private RadioButton logWorkHours;
	
	@FXML
	private ToggleGroup volOptions;

	@FXML
	private TextArea area;

	@FXML
	private Button selected;

	@FXML
	private Button submit;

	public void initialize() {
		selected.setOnAction((event) -> {
			if(viewProfile.isSelected()){
				
			}else if(editProfile.isSelected()) {
				
			}else if(viewWorkHours.isSelected()) {
				
			}else if(logWorkHours.isSelected()) {
				
			}else {
				System.out.println("This is not working");
			}
			
		});
	}

}
