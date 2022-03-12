package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.Main;
import model.Movie;

public class ControllerMoviesAvailable implements Initializable{
	
	@FXML
    private Button backBTM;
	
	@FXML
    private TextArea reportArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		String report="";
		for(int i=0;i<Main.mvsData.movies.size();i++) {
			Movie m=Main.mvsData.movies.get(i);
			report+=(i+1)+". "+m.getNameFilm()+" - "+m.getDayMovie()+" - "+m.getFilmRoom()+"\n";
			String users="";
			for(int j=0;j<m.getChairs().size();j++) {
				if(m.getChairs().get(j)!=null) {
					users+="    "+m.getChairs().get(j).getNameUsers()+"\n";
				}
			}
			if(users.equalsIgnoreCase("")) {
				users="    No users regsitered for this movie.\n";
			}
			report+=users;
		}
		
		reportArea.setText(report);
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
	
}
