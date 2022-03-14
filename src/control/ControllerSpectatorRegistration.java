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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.Movie;
import model.User;

public class ControllerSpectatorRegistration implements Initializable{
	
	@FXML
    private Button addUserBTM;
	
	@FXML
    private Button backBTM;

    @FXML
    private TextField idUserTF;

    @FXML
    public TextField nameUserTF;

    @FXML
    private ComboBox<String> selectedMovieCMB;

    @FXML
    void addUser(ActionEvent event) throws IOException {
    	
    	String nameUser = nameUserTF.getText();
    	String idUser = idUserTF.getText();
    	String movie = selectedMovieCMB.getSelectionModel().getSelectedItem();
    	String[] infoMovie = movie.split(" - ");
    	User nwUser=new User(nameUser, idUser);
    	Movie movieEdit=Main.mvsData.getMovie(infoMovie[0],infoMovie[1],infoMovie[2], infoMovie[3], infoMovie[4]);

    	if(!(movieEdit.sameId(nwUser))) {
    		if (infoMovie[2].equalsIgnoreCase("Sala Media")) {
    			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RoomSalaMedia.fxml"));
        		loader.setController(new ControllerRoomSalaMedia(movieEdit, nwUser));
        		Parent parent = (Parent) loader.load();
        		Stage stage = new Stage();
        		Scene scene = new Scene(parent);
        		stage.setScene(scene);
        		stage.show();
        		
        		
    		} else if (infoMovie[2].equalsIgnoreCase("MiniSala")) {
    			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RoomMiniSala.fxml"));
    			loader.setController(new ControllerRoomMiniSala(movieEdit, nwUser));
        		Parent parent = (Parent) loader.load();
        		Stage stage = new Stage();
        		Scene scene = new Scene(parent);
        		stage.setScene(scene);
        		stage.show();
        		
    		}
    		
    	} else {
    		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ExceptionSameIdUser.fxml"));
    		loader.setController(new ControllerExceptionSameIdUser());
    		Parent parent = (Parent) loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(parent);
    		stage.setScene(scene);
    		stage.show();
    	}
    }
    
    @FXML
    void backAct(ActionEvent event) throws IOException {
    	Stage stage = (Stage) this.backBTM.getScene().getWindow();
		stage.close();
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/CinemaMenu.fxml"));
		loader.setController(new ControllerCinemaMenu());
		Parent parent = (Parent) loader.load();
		Stage stage2 = new Stage();
		Scene scene = new Scene(parent);
		stage2.setScene(scene);
		stage2.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
    	for(int i=0;i<Main.mvsData.movies.size();i++) {
    		list.add(Main.mvsData.movies.get(i).getNameFilm()+" - "+Main.mvsData.movies.get(i).getDurationFilm()+" - "+Main.mvsData.movies.get(i).getFilmRoom()+" - "+Main.mvsData.movies.get(i).getHourMovie()+" - "+Main.mvsData.movies.get(i).getDayMovie());
    	}
    	selectedMovieCMB.setItems(list);
	}
    
}
