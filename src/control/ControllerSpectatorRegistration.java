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
import model.MovieData;
import model.User;
import model.UserData;

public class ControllerSpectatorRegistration implements Initializable{
	
	@FXML
    private Button addUserBTM;
	
	@FXML
    private Button backBTM;

    @FXML
    private TextField idUserTF;

    @FXML
    private TextField nameUserTF;

    @FXML
    private ComboBox<String> selectedMovieCMB;

    @FXML
    void addUser(ActionEvent event) throws IOException {
    	String nameUser = nameUserTF.getText();
    	String idUser = idUserTF.getText();
    	int check = searchUser(nameUser, idUser);
    	if(check == 1) {
    		UserData.user.add(new User(nameUser,idUser));
    		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SuccessfulRegistration.fxml"));
			ControllerSuccessfulRegistration control = new ControllerSuccessfulRegistration();
			control.setSuperStage((Stage) addUserBTM.getScene().getWindow());
			loader.setController(control);
			Parent parent = (Parent) loader.load();
			Stage stage2 = new Stage();
			Scene scene = new Scene(parent);
			stage2.setScene(scene);
			stage2.show();
    	} else {
    		//throw new SameIdUser();
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
    
    public int searchUser(String name,String id) {
    	int position = 1;
    	for(int i=0;i<UserData.user.size();i++) {
    		if(UserData.user.get(i).getIdUsers().equalsIgnoreCase(id)) {
    			position = -1;
    		}
    	}
    	return position;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
    	for(int i=0;i<MovieData.movie.size();i++) {
    		list.add(MovieData.movie.get(i).getNameFilm()+" - "+MovieData.movie.get(i).getDurationFilm()+" - "+MovieData.movie.get(i).getFilmRoom()+" - "+MovieData.movie.get(i).getHourMovie()+" - "+MovieData.movie.get(i).getDayMovie());
    	}
    	selectedMovieCMB.setItems(list);
	}
    
}
