package control;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.Movie;
import model.MovieData;

public class ControllerEditMovie implements Initializable{
	
	String movie;
	Movie replaceMovie;
	
	@FXML
    private Button backBTM;

    @FXML
    private TextField durationFilmTF;

    @FXML
    private Button editFilmBTM;

    @FXML
    private ComboBox<String> filmRoomCMB;

    @FXML
    private DatePicker movieDayDP;

    @FXML
    private TextField movieTimeTF;

    @FXML
    private TextField nameFilmTF;
    
    public ControllerEditMovie(String movie) {
    	this.movie = movie;
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

    @FXML
    void editFilm(ActionEvent event) throws IOException {
    	String nameFilm = nameFilmTF.getText();
    	
    	String durationMovie = durationFilmTF.getText();
    	
    	String filmRoom = filmRoomCMB.getAccessibleText();
    	
    	String movieHour = movieTimeTF.getText();
    	
    	LocalDate date = movieDayDP.getValue();
    	int year = date.getYear();
    	int month = date.getMonthValue();
    	int day = date.getDayOfMonth();
    	String dateDMY = "day/month/year";
    	boolean permission = seachMovieTime(filmRoom, movieHour, dateDMY);
    	String[] facts = movie.split(" - ");
    	if(permission == true) {
    		for(int i=0;i<MovieData.movie.size();i++) {
        		if(MovieData.movie.get(i).getNameFilm().equals(facts[0]) && MovieData.movie.get(i).getDurationFilm().equalsIgnoreCase(facts[1]) && MovieData.movie.get(i).getFilmRoom().equals(facts[2]) && MovieData.movie.get(i).getHourMovie().equals(facts[3]) && MovieData.movie.get(i).getDayMovie().equals(facts[4])) {
        			replaceMovie = MovieData.movie.get(i);
        			MovieData.movie.get(i) = replaceMovie;
        		}
    		}	
    	} else {
    		// nosepuede
    	}
    	
    	
    }
    
    public boolean seachMovieTime(String room,String hour,String dateDMY) {
    	boolean confirm = false;
    	for(int i=0;i<MovieData.movie.size();i++) {
    		if(MovieData.movie.get(i).getFilmRoom().equals(room)) {
				if (MovieData.movie.get(i).getHourMovie().equalsIgnoreCase(hour)) {
					if(MovieData.movie.get(i).getDayMovie().equalsIgnoreCase(dateDMY)) {
						//No se puede añadir. Exception
					} else {
						confirm = true;
					}
				} else {
					confirm = true;
				}
    		} else {
    			if (MovieData.movie.get(i).getHourMovie().equalsIgnoreCase(hour)) {
					if(MovieData.movie.get(i).getDayMovie().equalsIgnoreCase(dateDMY)) {
						//No se puede añadir. Exception
					} else {
						confirm = true;
					}
				} else {
					confirm = true;
				}
    		}
    	}
    	return confirm;
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("MiniSala");
		list.add("Sala Media");
		filmRoomCMB.setItems(list); 
	}
    
}
