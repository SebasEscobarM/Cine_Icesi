package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;

public class ControllerRegisterEmployeesWelfare {
	
	@FXML
	private Button accessBTM;

	@FXML
	private TextField idTF;

	@FXML
	void access(ActionEvent event) throws IOException {
		Stage currentStage=(Stage)accessBTM.getScene().getWindow();
		currentStage.close();
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/CinemaMenu.fxml"));
		loader.setController(new ControllerCinemaMenu());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void checkID(ActionEvent event) {
		idTF.getText();
		
	}
	    
}
