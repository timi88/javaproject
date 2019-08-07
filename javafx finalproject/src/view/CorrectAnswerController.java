package view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CorrectAnswerController {
	@FXML
	private Button btnNextQuestion;
	/**
	 * return to the main window
	 */
	public void nextquestion() {
		try {

			    Stage stage = (Stage) btnNextQuestion.getScene().getWindow();
			    stage.close();

		} catch (Exception e) {
			System.out.println("e.getMessage (): " + e.getMessage());
		}

}

}
