package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LevelButtonController implements Initializable {
	@FXML
	Button btlEasy;
	@FXML
	Button btlMedium;
	@FXML
	Button btlAdvenced;
	@FXML
	Label LblInstruction;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LblInstruction.setText(
				"Hi " + UserRepository.GetInstnace().loggedUser.firstName + ", Please choose a level to play!");
	}
/**
 * load the main window with the easy question repository and set a score
 */
	public void LoadEasyQeustions() {
		try {
			MainWindowController.Repository = EasyQuestionsRepository.GetInstnace();
			MainWindowController.ScoreOfQustion = 10;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			fxmlLoader.load();
			Stage stage = (Stage) btlEasy.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.getRoot());
			stage.setScene(scene);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	/**
	 * load the main window with the medium question repository and set the score
	 */
	public void LoadMediumQeustions() {
		try {
			MainWindowController.Repository = MediumQuestionsRepository.GetInstnace();
			MainWindowController.ScoreOfQustion = 20;

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			fxmlLoader.load();
			Stage stage = (Stage) btlMedium.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.getRoot());
			stage.setScene(scene);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	/**
	 * load the main window with the advanced question repository and set a score
	 */
	public void LoadAdvancedQeustions() {
		try {
			MainWindowController.Repository = AdvancedQuestionsRepository.GetInstnace();
			MainWindowController.ScoreOfQustion = 50;

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			fxmlLoader.load();
			Stage stage = (Stage) btlAdvenced.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.getRoot());
			stage.setScene(scene);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}