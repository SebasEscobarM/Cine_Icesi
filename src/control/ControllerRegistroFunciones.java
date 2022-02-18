package control;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Observable;
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

public class ControllerRegistroFunciones implements Initializable {
	
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
    void durationFilm(ActionEvent event) {
    	durationFilmTF.getText();
    }

    @FXML
    void movieDay(ActionEvent event) {
    	LocalDate date = movieDayDP.getValue();
    	int year = date.getYear();
    	int month = date.getMonthValue();
    	int day = date.getDayOfMonth();
    	
    	System.out.println(day+"/"+month+"/"+year);
    }

    @FXML
    void movieTime(ActionEvent event) {
    	movieTimeTF.getText();
    }

    @FXML
    void registerFilm(ActionEvent event) {
    	nameFilmTF.getText();
    }
    
    @FXML
    void addFilm(ActionEvent event) {
    	
    }
    
    @FXML
    void backAct(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ConfirmarAtras.fxml"));
    	ControllerConfirmarAtras control = new ControllerConfirmarAtras();
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
}
