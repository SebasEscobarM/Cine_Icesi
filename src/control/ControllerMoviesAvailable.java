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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.Movie;
import model.MovieData;

public class ControllerMoviesAvailable implements Initializable{
	
	@FXML
    private Button backBTM;
	
	@FXML
    private TableColumn<Movie, String> dateMovieCol;

    @FXML
    private TableColumn<Movie, String> durationMovieCol;

    @FXML
    private TableColumn<Movie, String> hourMovieCol;

    @FXML
    private TableView<Movie> moviesAvailableTV;

    @FXML
    private TableColumn<Movie, String> nameMovieCol;

    @FXML
    private TableColumn<Movie, String> roomMovieCol;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameMovieCol.setCellValueFactory(new PropertyValueFactory<>("nameFilm"));
		durationMovieCol.setCellValueFactory(new PropertyValueFactory<>("durationFilm"));
		roomMovieCol.setCellValueFactory(new PropertyValueFactory<>("filmRoom"));
		hourMovieCol.setCellValueFactory(new PropertyValueFactory<>("hourMovie"));
		dateMovieCol.setCellValueFactory(new PropertyValueFactory<>("dayMovie"));
		
		moviesAvailableTV.setItems(MovieData.movie);
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
