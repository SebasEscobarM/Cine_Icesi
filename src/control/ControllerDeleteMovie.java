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
    	for(int i=0;i<MovieData.movie.size();i++) {
    		if(MovieData.movie.get(i).getNameFilm().equals(facts[0]) && MovieData.movie.get(i).getDurationFilm().equalsIgnoreCase(facts[1]) && MovieData.movie.get(i).getFilmRoom().equals(facts[2]) && MovieData.movie.get(i).getHourMovie().equals(facts[3]) && MovieData.movie.get(i).getDayMovie().equals(facts[4])) {
    			MovieData.movie.remove(i);
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
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
		for (int i=0;i<MovieData.movie.size();i++) {
    		list.add(MovieData.movie.get(i).getNameFilm()+" - "+MovieData.movie.get(i).getDurationFilm()+" - "+MovieData.movie.get(i).getFilmRoom()+" - "+MovieData.movie.get(i).getHourMovie()+" - "+MovieData.movie.get(i).getDayMovie());
		}
		functionsAvailableCMB.setItems(list);
	}
    
}
