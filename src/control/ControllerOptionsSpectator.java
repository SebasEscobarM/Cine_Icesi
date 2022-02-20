package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;

public class ControllerOptionsSpectator {
	
	@FXML
    private Button backBTM;
	
	@FXML
    private Button newEmployeeBTM;

    @FXML
    private Button removeEmployeeBTM;

    @FXML
    void addEmployee(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SpectatorRegistration.fxml"));
		loader.setController(new ControllerSpectatorRegistration());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void deleteEmployee(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/DeleteSpectator.fxml"));
		loader.setController(new ControllerDeleteSpectator());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
    }
    
    @FXML
    void backAct(ActionEvent event) throws IOException {
    	Stage stage = (Stage) this.backBTM.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/CinemaMenu.fxml"));
		loader.setController(new ControllerCinemaMenu());
		Parent parent = (Parent) loader.load();
		Stage stage2 = new Stage();
		Scene scene = new Scene(parent);
		stage2.setScene(scene);
		stage2.show();
    }
    
}
