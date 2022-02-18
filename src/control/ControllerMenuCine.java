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

public class ControllerMenuCine {
	
	@FXML
	private Button availableMoviesBTM;

	@FXML
	private Button registerMoviesBTM;

	@FXML
	private Button registerUsersBTM;

	@FXML
	void availableMovies(ActionEvent event) {

	}

	@FXML
	void registerMovies(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegistroFunciones.fxml"));
		loader.setController(new ControllerRegistroFunciones());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void registerUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegistroUsuarios.fxml"));
		loader.setController(new ControllerRegistroUsuarios());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	
}
