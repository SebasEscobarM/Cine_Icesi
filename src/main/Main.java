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
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterEmployeesWelfare.fxml"));
		loader.setController(new ControllerRegisterEmployeesWelfare());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
	}

}
