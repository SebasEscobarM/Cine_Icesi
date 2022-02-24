package exception;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;

public class SameMovies extends Exception{
	
	public SameMovies() throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ExceptionSameMovies.fxml"));
		loader.setController(new SameMovies());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	
}
