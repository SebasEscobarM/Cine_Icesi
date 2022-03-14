package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import control.ControllerSpectatorRegistration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;

class MovieDataTest {
	
	private static MovieData mvsData=new MovieData();
	
	public void setupStage1() {
		mvsData.addMovie(new Movie("SpiderMan", "140min", "Sala Media", "29/03/2022", "15:30"));
		mvsData.addMovie(new Movie("Piratas del caribe", "115min", "MiniSala", "20/03/2022", "17:00"));
	}
	@Test
	void testAddUser() throws IOException {
		//For this test the movies start without any user registered.
		//Is going to be registered a user in the first chair of each movie. The Users in each movie is 1.
		//Is going to be registered a user in the first chair of each movie, but the system are going to discard this change because the chairs are busy. The Users in each movie is 1.
		
		/*FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SpectatorRegistration.fxml"));
		loader.setController(new ControllerSpectatorRegistration());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
		
		
		fail("Not yet implemented");*/
	}

}
