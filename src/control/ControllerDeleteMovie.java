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
import model.Movie;
import model.MovieData;

public class ControllerDeleteMovie implements Initializable{
	
	@FXML
    private Button backBTM;

    @FXML
    private Button eliminateMovieBTM;

    @FXML
    private ComboBox<String> functionsAvailableCMB;

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
    void deleteMovie(ActionEvent event) throws IOException {
    	String movieFacts = functionsAvailableCMB.getSelectionModel().getSelectedItem();
    	String[] facts = movieFacts.split(" - ");
    	Movie mvToDelete=Main.mvsData.getMovie(facts[0], facts[1], facts[2], facts[3], facts[4]);
    	if(mvToDelete!=null) {
    		
    		Main.mvsData.deleteMovie(mvToDelete);
    		
    		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SuccessfulRemoval.fxml"));
			ControllerSuccessfulRemoval control = new ControllerSuccessfulRemoval();
			control.setSuperStage((Stage) eliminateMovieBTM.getScene().getWindow());
			loader.setController(control);
			Parent parent = (Parent) loader.load();
			Stage stage2 = new Stage();
			Scene scene = new Scene(parent);
			stage2.setScene(scene);
			stage2.show();
    	} 
    	/*
    	Buscar la manera de que cuando no haya película seleccionada o no haya creada y intente borrar una, salga la excepcion
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ExceptionNotSelectedFilm.fxml"));
		loader.setController(new ControllerExceptionNotSelectedFilm());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		*/
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
		for (int i=0;i<Main.mvsData.movies.size();i++) {
    		list.add(Main.mvsData.movies.get(i).getNameFilm()+" - "+Main.mvsData.movies.get(i).getDurationFilm()+" - "+Main.mvsData.movies.get(i).getFilmRoom()+" - "+Main.mvsData.movies.get(i).getHourMovie()+" - "+Main.mvsData.movies.get(i).getDayMovie());
		}
		functionsAvailableCMB.setItems(list);
	}
    
}
