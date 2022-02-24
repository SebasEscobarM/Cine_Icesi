package control;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;

import exception.SameMovies;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.Movie;
import model.MovieData;

public class ControllerMovieRegistration implements Initializable {
	
	@FXML
    private Button backBTM;
	
	@FXML
    private TextField durationFilmTF;

    @FXML
    private DatePicker movieDayDP;

    @FXML
    private TextField movieTimeTF;

    @FXML
    private TextField nameFilmTF;
    
    @FXML
    private Button registerFilmBTM;
    
    @FXML
    private ComboBox<String> filmRoomCMB;

    @FXML
    void registerFilm(ActionEvent event) throws IOException, SameMovies{
    	String nameFilm = nameFilmTF.getText();
    	
    	String durationMovie = durationFilmTF.getText()+"hr";
    	
    	String filmRoom = filmRoomCMB.getSelectionModel().getSelectedItem();
    	
    	String movieHour = movieTimeTF.getText();
    	
    	LocalDate date = movieDayDP.getValue();
    	int year = date.getYear();
    	int month = date.getMonthValue();
    	int day = date.getDayOfMonth();
    	String dateDMY = ""+day+"/"+month+"/"+year;
    	
    	int check = seachMovie(nameFilm, durationMovie, filmRoom, movieHour, dateDMY);
    	if(check == 1) {
    		MovieData.movie.add(new Movie(nameFilm,durationMovie,filmRoom,dateDMY,movieHour));
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SuccessfulRegistration.fxml"));
			ControllerSuccessfulRegistration control = new ControllerSuccessfulRegistration();
			control.setSuperStage((Stage) registerFilmBTM.getScene().getWindow());
			loader.setController(control);
			Parent parent = (Parent) loader.load();
			Stage stage2 = new Stage();
			Scene scene = new Scene(parent);
			stage2.setScene(scene);
			stage2.show();
    	} else {
    		//throw new SameMovies();
    		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ExceptionSameMovies.fxml"));
    		loader.setController(new ControllerExceptionSameMovie());
    		Parent parent = (Parent) loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(parent);
    		stage.setScene(scene);
    		stage.show();
    	}
    	
    }
    
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("MiniSala");
		list.add("Sala Media");
		filmRoomCMB.setItems(list); 
	}
	
	public int seachMovie(String name,String duration,String room,String hour,String dateDMY) {
    	int position = 1;
    	for(int i=0;i<MovieData.movie.size();i++) {
    		if(MovieData.movie.get(i).getHourMovie().equalsIgnoreCase(hour) && MovieData.movie.get(i).getDayMovie().equalsIgnoreCase(dateDMY)) {
    			position = -1;
    		}
    	}
    	return position;
    }
}
