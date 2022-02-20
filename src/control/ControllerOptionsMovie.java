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

public class ControllerOptionsMovie {
	
	@FXML
    private Button backBTM;

    @FXML
    private Button modifyMovieBTM1;

    @FXML
    private Button newMovieBTM;

    @FXML
    private Button removeMovieBTM;

    @FXML
    void addMovie(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MovieRegistration.fxml"));
		loader.setController(new ControllerMovieRegistration());
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

    @FXML
    void deleteMovie(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/DeleteMovie.fxml"));
		loader.setController(new ControllerDeleteMovie());
		Parent parent = (Parent) loader.load();
		Stage stage2 = new Stage();
		Scene scene = new Scene(parent);
		stage2.setScene(scene);
		stage2.show();
    }

    @FXML
    void editMovie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/EditMovie.fxml"));
		loader.setController(new ControllerEditMovie());
		Parent parent = (Parent) loader.load();
		Stage stage2 = new Stage();
		Scene scene = new Scene(parent);
		stage2.setScene(scene);
		stage2.show();
    }
    
}
