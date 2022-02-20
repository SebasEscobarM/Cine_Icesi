package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import main.Main;

public class ControllerDeleteSpectator {
	
	@FXML
    private Button backBTM;

    @FXML
    private Button deleteSpectatorBTM;

    @FXML
    private ComboBox<String> spectatorsAvailableCMB;

    @FXML
    void backAct(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ConfirmBack.fxml"));
    	ControllerConfirmBack control = new ControllerConfirmBack();
    	control.setSuperStage((Stage) backBTM.getScene().getWindow());
		loader.setController(control);
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void deleteUsers(ActionEvent event) {
    	
    }

    //Este ComboBox mostrar� los usuarios disponibles.
    @FXML
    void usersAvailable(ActionEvent event) {
    	
    }
}
