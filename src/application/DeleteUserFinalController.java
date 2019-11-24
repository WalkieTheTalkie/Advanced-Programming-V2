package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class DeleteUserFinalController {

	@FXML
	private Button Cancel;
	
	@FXML 
	private Button Delete;
	
	private int idNum;
	private Boolean isVolunteer;
	
	@FXML
	public void initialize() {
		Cancel.setOnAction((event) -> {
			Stage s = (Stage)Cancel.getScene().getWindow();
			s.close();
		});
		
		Delete.setOnAction((event) -> {
			if (isVolunteer) {
				VolunteerTable v = new VolunteerTable();
				v.delete(idNum);
				Stage s = (Stage)Delete.getScene().getWindow();
				s.close();
			} else {
				EmployeeTable e = new EmployeeTable();
				e.delete(idNum);
				Stage s = (Stage)Delete.getScene().getWindow();
				s.close();
			}
		});
	}	
	
	public void setDelete(int id, Boolean eORv) {
		this.idNum = id;
		this.isVolunteer = eORv;
	}
	
}
