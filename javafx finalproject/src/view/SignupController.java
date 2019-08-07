package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {
	@FXML
	Button btnBack;
	@FXML
	TextField txtLoginName;
	@FXML
	TextField txtFirstName;
	@FXML
	TextField txtLastName;

	/**
	 * Return back to Welcome window
	 */
	public void back() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WelcomeWindow.fxml"));
			fxmlLoader.load();
			Stage stage = (Stage) btnBack.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.getRoot());
			stage.setScene(scene);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Add a new user to the user repository
	 * 
	 * Validate user input - first name, last name, login name are not empty Call
	 * UserRepository.AddUser and make sure return value is true Return back to
	 * Welcome window
	 */
	public void join() {
		try {

			UserRepositoryItem user = new UserRepositoryItem();
			user.firstName = txtFirstName.getText();

			// If first name is empty - show error message and return
			if (user.firstName.isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("First Name Is Empty");
				alert.setHeaderText("First Name Is Empty");
				alert.setContentText("First name can't be empty");
				alert.showAndWait();
				return;
			}

			// If last name is empty - show error message and return
			user.lastName = txtLastName.getText();
			if (user.lastName.isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Last Name Is Empty");
				alert.setHeaderText("Last Name Is Empty");
				alert.setContentText("Last name can't be empty");
				alert.showAndWait();
				return;
			}

			// If login name is empty - show error message and return
			user.loginName = txtLoginName.getText();
			if (user.loginName.isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login Name Is Empty");
				alert.setHeaderText("Login Name Is Empty");
				alert.setContentText("Login name can't be empty");
				alert.showAndWait();
				return;
			}
			user.score = 0;
			
			// If AddUser return false show error message and return
			if (!UserRepository.GetInstnace().AddUser(user)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login Name Already Used");
				alert.setHeaderText("Login Name Already Used");
				alert.setContentText("Please choose another login name");
				alert.showAndWait();
				return;
			}
			UserRepository.GetInstnace().SaveChanges();
			back();
			/*
			 * FXMLLoader fxmlLoader = new
			 * FXMLLoader(getClass().getResource("WelcomeWindow.fxml")); fxmlLoader.load();
			 * Stage stage = (Stage) btnBack.getScene().getWindow(); Scene scene = new
			 * Scene(fxmlLoader.getRoot()); stage.setScene(scene);
			 */

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}