package control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.Main;
import model.Movie;
import model.User;

public class ControllerRoomMiniSala implements Initializable{

    @FXML
    private GridPane roomSalaMiniSala;

    @FXML
    private Button chair1;

    @FXML
    private Button chair2;

    @FXML
    private Button chair8;

    @FXML
    private Button chair9;

    @FXML
    private Button chair15;

    @FXML
    private Button chair16;

    @FXML
    private Button chair22;

    @FXML
    private Button chair23;

    @FXML
    private Button chair3;

    @FXML
    private Button chair4;

    @FXML
    private Button chair10;

    @FXML
    private Button chair11;

    @FXML
    private Button chair17;

    @FXML
    private Button chair18;

    @FXML
    private Button chair24;

    @FXML
    private Button chair25;

    @FXML
    private Button chair5;

    @FXML
    private Button chair12;

    @FXML
    private Button chair19;

    @FXML
    private Button chair26;

    @FXML
    private Button chair6;

    @FXML
    private Button chair7;

    @FXML
    private Button chair13;

    @FXML
    private Button chair14;

    @FXML
    private Button chair20;

    @FXML
    private Button chair21;

    @FXML
    private Button chair27;

    @FXML
    private Button chair28;

    @FXML
    private Button selectChairBTN;

    @FXML
    private Button backBTM;
    
    private Movie mvEdit;
    
    private User nwUser;
    
    private ArrayList<Button> prSlctd;
    
    private ObservableList<Node> btns;
    
    public ControllerRoomMiniSala(Movie mv, User u) {
    	mvEdit=mv;
    	nwUser=u;
    }

    @FXML
    void preSelectChair(ActionEvent event) {
    	((Button) event.getSource()).setStyle("-fx-background-color: #c78408");
    	
    	if(prSlctd.get(0)!=null) {
    		prSlctd.get(0).setStyle("-fx-background-color: #509e3a");
    	}
    	prSlctd.set(0, (Button) event.getSource());
    }
    
    @FXML
    void backAct(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ConfirmBack.fxml"));
    	ControllerConfirmBack control = new ControllerConfirmBack();
    	control.setSuperStage((Stage) backBTM.getScene().getWindow());
		loader.setController(control);
		Parent parent;
		try {
			parent = (Parent) loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void confirmChair(ActionEvent event) {

    	for(int i=0;i<btns.size();i++) {
    		if(prSlctd.get(0)==btns.get(i))
        	{
        		mvEdit.addUserToAChair(nwUser, i);
        		Main.mvsData.save();
        		
        		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SuccessfulRegistration.fxml"));
    			ControllerSuccessfulRegistration control = new ControllerSuccessfulRegistration();
    			control.setSuperStage((Stage) selectChairBTN.getScene().getWindow());
    			loader.setController(control);
    			Parent parent;
				try {
					parent = (Parent) loader.load();
					Stage stage2 = new Stage();
	    			Scene scene = new Scene(parent);
	    			stage2.setScene(scene);
	    			stage2.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
        	} /*else if(Verificar de alguna forma si la silla ya está ocupada){
        	
        		//La idea es que analice y salga la excepción solo cuando se oprima el botón de "seleccionar"
        		
        		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ExceptionChairOccuped.fxml"));
				loader.setController(new ControllerExceptionChairOccuped());
				Parent parent = (Parent) loader.load();
				Stage stage = new Stage();
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
        	} */
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		prSlctd=new ArrayList<>();
		prSlctd.add(null);
		
		btns=roomSalaMiniSala.getChildren();
		for(int i=0;i<mvEdit.getChairs().size();i++) {
			
			if(mvEdit.getChairs().get(i)==null) {
				btns.get(i).setStyle("-fx-background-color: #509e3a");
			}else{
				btns.get(i).setStyle("-fx-background-color: #d44848");
				btns.get(i).setDisable(true);
			}
		}
	}

}
