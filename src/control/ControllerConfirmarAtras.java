package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerConfirmarAtras {
	
	Stage superStage;
	
	
	@FXML
    private Button cancelBTM;

    @FXML
    private Button confirmBTM;

    @FXML
    void cancelAct(ActionEvent event) {
    	Stage stage = (Stage) this.cancelBTM.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmAct(ActionEvent event) {
    	Stage stage = (Stage) this.cancelBTM.getScene().getWindow();
        stage.close();
        superStage.close();
        
    }

	public void setSuperStage(Stage window) {
		this.superStage = window;
		
	}

}
