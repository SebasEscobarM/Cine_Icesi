package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.Employee;
import model.EmployeeData;

public class ControllerRegisterEmployeesWelfare implements Initializable{
	
	@FXML
	private Button accessBTM;

	@FXML
	private TextField idTF;

	@FXML
	void access(ActionEvent event) throws IOException {
		String id = idTF.getText();
		for(int i=0;i<EmployeeData.employeeRegister.size();i++) {
			if(id.equals(EmployeeData.employeeRegister.get(i).getIdEmployee())) {
				Stage currentStage = (Stage) accessBTM.getScene().getWindow();
				currentStage.close();
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/CinemaMenu.fxml"));
				loader.setController(new ControllerCinemaMenu());
				Parent parent = (Parent) loader.load();
				Stage stage = new Stage();
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			} /*else if (!id.equals(EmployeeData.employeeRegister.get(i).getIdEmployee()) && i == EmployeeData.employeeRegister.size()-1) {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ExceptionNotMatchWelfare.fxml"));
				loader.setController(new ControllerExceptionNotMatchWelfare());
				Parent parent = (Parent) loader.load();
				Stage stage = new Stage();
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			}*/
		}
	}
	
	public static void importarID() {

		try {
			String path = "SaveFiles//EmpleadosBienestar.txt";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			String data = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				data += line + "\n";
			}
			String[] id = data.split("\n");
			for (int i = 0; i < id.length; i++) {
				EmployeeData.employeeRegister.add(new Employee(id[i]));
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		importarID();
	}
	
}

