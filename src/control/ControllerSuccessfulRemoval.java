package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerSuccessfulRemoval {
	
	Stage superStage;

	@FXML
    private Button continueBTN;

    @FXML
    void continueApp(ActionEvent event) {
    	Stage stage = (Stage) this.continueBTN.getScene().getWindow();
        stage.close();
        superStage.close();
    }
    
    public void setSuperStage(Stage window) {
		this.superStage = window;
		
	}
	
}
