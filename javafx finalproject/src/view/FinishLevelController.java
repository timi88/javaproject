package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FinishLevelController {
	@FXML
	private Button btlBack;
	
	/**
	 * return to level button
	 */
	public void backToLevel() {
		 try {
			  Stage stage = (Stage) btlBack.getScene().getWindow();
			    stage.close();
	 
		 }catch (Exception e) {
			 System.out.println(e.getMessage());

	}
	}
	}
