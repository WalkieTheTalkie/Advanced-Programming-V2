package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Admin_Controller {
	
	@FXML
	private ToggleGroup database;
	
	@FXML
	private TextArea typeHere;
	
	@FXML
	private RadioButton Employee;
	
	@FXML
	private RadioButton Admin;
	
	@FXML
	private RadioButton Volunteer;
	
	@FXML 
	private TextField searchField;
	
	@FXML
	private Button searchButton;
}
