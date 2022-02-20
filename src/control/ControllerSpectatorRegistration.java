package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;

public class ControllerSpectatorRegistration {
	
	@FXML
    private Button addUserBTM;
	
	@FXML
    private Button backBTM;

    @FXML
    private TextField idUserTF;

    @FXML
    private TextField nameUserTF;

    @FXML
    private ComboBox<String> selectedMovieCMB;

    @FXML
    void addUser(ActionEvent event) {

    }

    @FXML
    void idUser(ActionEvent event) {

    }

    @FXML
    void nameUser(ActionEvent event) {

    }
    
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
    
    
}
