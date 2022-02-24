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
    	
    	String filmRoom = filmRoomCMB.getSelectionModel().getSelectedItem();
    	
    	String movieHour = movieTimeTF.getText();
    	
    	LocalDate date = movieDayDP.getValue();
    	int year = date.getYear();
    	int month = date.getMonthValue();
    	int day = date.getDayOfMonth();
    	String dateDMY = day+"/"+month+"/"+year;
    	String[] facts = movie.split(" - ");
    	int permission = seachMovieTime(filmRoom, movieHour, dateDMY);
    	if(permission == 0) {
    		for(int i=0;i<MovieData.movie.size();i++) {
        		if(MovieData.movie.get(i).getNameFilm().equals(facts[0]) && MovieData.movie.get(i).getDurationFilm().equalsIgnoreCase(facts[1]) && MovieData.movie.get(i).getFilmRoom().equals(facts[2]) && MovieData.movie.get(i).getHourMovie().equals(facts[3]) && MovieData.movie.get(i).getDayMovie().equals(facts[4])) {
        			MovieData.movie.get(i).setNameFilm(nameFilm);
        			MovieData.movie.get(i).setDurationFilm(durationMovie);
        			MovieData.movie.get(i).setFilmRoom(filmRoom);
        			MovieData.movie.get(i).setHourMovie(movieHour);
        			MovieData.movie.get(i).setDayMovie(dateDMY);
        			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SuccessfulEdit.fxml"));
        			ControllerSuccessfulEdit control = new ControllerSuccessfulEdit();
        			control.setSuperStage((Stage) editFilmBTM.getScene().getWindow());
        			loader.setController(control);
        			Parent parent = (Parent) loader.load();
        			Stage stage2 = new Stage();
        			Scene scene = new Scene(parent);
        			stage2.setScene(scene);
        			stage2.show();
        		}
    		}	
    	}
    }
    
    public int seachMovieTime(String room,String hour,String dateDMY) throws IOException {
    	int error = 0;
    	for(int i=0;i<MovieData.movie.size();i++) {
    		if(MovieData.movie.get(i).getFilmRoom().equals(room)) {
				if (MovieData.movie.get(i).getHourMovie().equalsIgnoreCase(hour)) {
					if(MovieData.movie.get(i).getDayMovie().equalsIgnoreCase(dateDMY)) {
						error = 1;
						//No se puede añadir porque tiene la misma sala, hora y la misma fecha
						mistakes(error);
						break;
					}
				}
    		} else {
    			if (MovieData.movie.get(i).getHourMovie().equalsIgnoreCase(hour)) {
					if(MovieData.movie.get(i).getDayMovie().equalsIgnoreCase(dateDMY)) {
						error = 2;
						//No se puede añadir porque tiene otra sala pero esta ocupada en esa hora y fecha
						mistakes(error);
						break;
					}
				}
			}
    	}
    	return error;
    }

    public void mistakes(int error) throws IOException {
    	switch(error) {
    	case 1: FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ExceptionSameRoomHourDay"));
    			loader.setController(new ControllerExceptionSameRoomHourDay());
    			Parent parent = (Parent) loader.load();
    			Stage stage = new Stage();
    			Scene scene = new Scene(parent);
    			stage.setScene(scene);
    			stage.show();
    		break;
		case 2: FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("../ui/ExceptionSameRoomHourDay"));
				loader2.setController(new ControllerExceptionSameRoomHourDay());
				Parent parent2 = (Parent) loader2.load();
				Stage stage2 = new Stage();
				Scene scene2 = new Scene(parent2);
				stage2.setScene(scene2);
				stage2.show();
    		break;
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("MiniSala");
		list.add("Sala Media");
		filmRoomCMB.setItems(list); 
	}
    
}
