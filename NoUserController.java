package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NoUserController {
	@FXML
	private Button Exit;

	public void initialize() throws Exception {
		Exit.setOnAction((event) -> {
			Stage s = (Stage)Exit.getScene().getWindow();
			s.close();
		});
	}

}
