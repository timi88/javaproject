package view;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Welcome implements Initializable {
	@FXML
	Button levelButton;
	@FXML
	Button signUp;
	@FXML
	ComboBox listUser;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<UserRepositoryItem> allUsers = UserRepository.GetInstnace().GetAllUsers();
		for (int i = 0; i < allUsers.size(); ++i) {
			listUser.getItems().add(allUsers.get(i).loginName);
		}

	}

	public void buttonaction() {
		try {

			String selectedLoginName = listUser.getValue().toString();
			List<UserRepositoryItem> allUsers = UserRepository.GetInstnace().GetAllUsers();
			for (int i = 0; i < allUsers.size(); ++i) {
				if (allUsers.get(i).loginName.equals(selectedLoginName)) {
					UserRepository.GetInstnace().loggedUser = allUsers.get(i);
				}
			}

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LevelButton.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = (Stage) levelButton.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.getRoot());
			stage.setScene(scene);

		} catch (Exception e) {
			System.out.println("e.getMessage (): " + e.getMessage());
		}

	}

	public void signup() {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = (Stage) signUp.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.getRoot());
			stage.setScene(scene);

		} catch (Exception e) {
			System.out.println("e.getMessage (): " + e.getMessage());
		}
	}
}