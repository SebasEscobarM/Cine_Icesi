package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import main.Main;

public class ControllerDeleteSpectator implements Initializable{
	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Si se hace cambiar arreglo que se recorre
		ObservableList<String> list = FXCollections.observableArrayList();
		/*for (int i=0;i<UserData.user.size();i++) {
			list.add(UserData.user.get(i).getNameUsers()+" - "+UserData.user.get(i).getIdUsers());
		}*/
		spectatorsAvailableCMB.setItems(list);
	}

}
