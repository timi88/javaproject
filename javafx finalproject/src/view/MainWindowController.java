package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javax.annotation.Resources;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {

	public static QuestionsRepository Repository;
	public static int ScoreOfQustion = 0;

	@FXML
	private Label labelquestion;
	@FXML
	private ImageView pic1;
	@FXML
	private ImageView pic2;
	@FXML
	private ImageView pic3;
	@FXML
	private Label Labelscore;
	@FXML
	Button Back;
	@FXML
	Label letsplay;

	
	Map<ImageView, Boolean> correctByImage = new HashMap<ImageView, Boolean>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		RegisterOnClickEvent(pic1);
		RegisterOnClickEvent(pic2);
		RegisterOnClickEvent(pic3);
		Labelscore.setText(new Integer(UserRepository.GetInstnace().loggedUser.score).toString());
		Repository.RefreshList();
		LoadQuestion();
		
		letsplay.setText(
				"Hi " + UserRepository.GetInstnace().loggedUser.firstName + ", let's play!");
	}

	private void RegisterOnClickEvent(ImageView img) {
		img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				try {

					if (correctByImage.get(img)) {

						UserRepository.GetInstnace().loggedUser.score += ScoreOfQustion;
						UserRepository.GetInstnace().SaveChanges();

						Labelscore.setText(new Integer(UserRepository.GetInstnace().loggedUser.score).toString());

						String windowToShow = "";
						if (Repository.GetNumberOfQuestions() == 0)
							windowToShow = "FinishLevel.fxml";
						else
							windowToShow = "CorrectAnswer.fxml";

						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(windowToShow));
						Parent root1 = (Parent) fxmlLoader.load();
						Stage stage = new Stage();
						stage.setScene(new Scene(root1));
						stage.show();
						LoadQuestion();
					} else {
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WrongAnswer.fxml"));
						Parent root1 = (Parent) fxmlLoader.load();
						Stage stage = new Stage();
						stage.setScene(new Scene(root1));
						stage.show();
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				event.consume();
			}
		});
	}

	private void LoadQuestion() {

		QuestionRepositoryItem item = Repository.GetRandomItem();
		if (item == null) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LevelButton.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				// Stage stage = new Stage();
				// stage.setScene(new Scene(root1));
				// stage.show();
				Stage stage = (Stage) pic1.getScene().getWindow();
				Scene scene = new Scene(fxmlLoader.getRoot());
				stage.setScene(scene);
				stage.toBack();


			} catch (Exception e) {
				System.out.println("e.getMessage (): " + e.getMessage());
			}
			return;
		}

		labelquestion.setText(item.questionText);

		List<ImageView> allImages = new ArrayList<ImageView>();
		allImages.add(pic1);
		allImages.add(pic2);
		allImages.add(pic3);

		List<String> paths = item.getPaths();
		for (int i = 0; i < allImages.size(); ++i) {
			ImageView img = allImages.get(i);

			int numOfPaths = paths.size();
			Random rand = new Random();
			int pathIndex = rand.nextInt(numOfPaths);
			String path = paths.get(pathIndex);
			paths.remove(pathIndex);

			img.setImage(new Image(path));
			correctByImage.put(img, item.isCorrectPath(path));
		}
	}

	public void back() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LevelButton.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = (Stage) Back.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.getRoot());
			stage.setScene(scene);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}
}
