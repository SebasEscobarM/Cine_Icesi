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

public class ControllerSelectMovieToEdit implements Initializable{
	
	@FXML
    private Button backBTM;

    @FXML
    private ComboBox<String> functionsAvailableCMB;

    @FXML
    private Button selectMovieBTM;
    
    @FXML
    void backAct(ActionEvent event) {
    	Stage stage = (Stage) this.backBTM.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void selectedMovie(ActionEvent event) throws IOException {
    	String movie = functionsAvailableCMB.getSelectionModel().getSelectedItem();
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/EditMovie.fxml"));
		loader.setController(new ControllerEditMovie(movie));
		Parent parent = (Parent) loader.load();
		Stage stage2 = new Stage();
		Scene scene = new Scene(parent);
		stage2.setScene(scene);
		stage2.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
    	for(int i=0;i<MovieData.movie.size();i++) {
    		list.add(MovieData.movie.get(i).getNameFilm()+" - "+MovieData.movie.get(i).getDurationFilm()+" - "+MovieData.movie.get(i).getFilmRoom()+" - "+MovieData.movie.get(i).getHourMovie()+" - "+MovieData.movie.get(i).getDayMovie());
    	}
    	functionsAvailableCMB.setItems(list);
	}
	
}
