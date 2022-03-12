package main;

import control.ControllerRegisterEmployeesWelfare;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MovieData;


public class Main extends Application{

	public static MovieData mvsData=new MovieData();
	
	public static void main(String args[]) {
		mvsData.load();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//MovieData.addMovie(new Movie("HolaaaMv","123hr","Sala Media", "12/11/2022", "12:13"));
		//MovieData.addMovie(new Movie("miniminimini","113hr","MiniSala", "12/11/2022", "12:53"));

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterEmployeesWelfare.fxml"));
		loader.setController(new ControllerRegisterEmployeesWelfare());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
	}

}
