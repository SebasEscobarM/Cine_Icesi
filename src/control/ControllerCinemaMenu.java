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

public class ControllerCinemaMenu {
	
	@FXML
	private Button availableMoviesBTM;
	
	@FXML
    private Button registerEmployeeBTM;

	@FXML
	private Button registerMoviesBTM;

	@FXML
	private Button registerUsersBTM;

	@FXML
	void availableMovies(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MoviesAvailable.fxml"));
		loader.setController(new ControllerMoviesAvailable());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		Stage stage3 = (Stage) this.registerMoviesBTM.getScene().getWindow();
        stage3.close();
	}

	@FXML
	void registerMovies(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/OptionsMovie.fxml"));
		loader.setController(new ControllerOptionsMovie());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		Stage stage2 = (Stage) this.registerMoviesBTM.getScene().getWindow();
        stage2.close();
	}

	@FXML
	void registerUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/OptionsSpectator.fxml"));
		loader.setController(new ControllerOptionsSpectator());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		Stage stage1 = (Stage) this.registerUsersBTM.getScene().getWindow();
        stage1.close();
	}
	
	@FXML
    void registerEmployees(ActionEvent event) {

    }
	
}
