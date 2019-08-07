package view;

public class MediumQuestionsRepository extends QuestionsRepository {

	private MediumQuestionsRepository() {

	}

	private static MediumQuestionsRepository _instance = new MediumQuestionsRepository();

	public static MediumQuestionsRepository GetInstnace() {
		return _instance;
	}

	@Override
	protected void CreateQuestions() {

		String path = (getClass().getResource("/resources/")).toString();
		System.out.println(path);

		QuestionRepositoryItem item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the Orange triangle?";
		item.addPath(false, path + "circle/orange%20circle.jpg");
		item.addPath(true, path + "triangle/orange.jpg");
		item.addPath(false, path + "triangle/purple.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the purple circle?";
		item.addPath(false, path + "circle/grey%20circle.jpg");
		item.addPath(true, path + "circle/purple%20circle.jpg");
		item.addPath(false, path + "triangle/purple.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the black circle?";
		item.addPath(false, path + "Square/black%20Square.jpg");
		item.addPath(true, path + "circle/black%20circle.jpg");
		item.addPath(false, path + "Square/red%20Square.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the blue circle?";
		item.addPath(false, path + "circle/green%20circle.jpg");
		item.addPath(true, path + "circle/blue%20circle.jpg");
		item.addPath(false, path + "Square/blue%20Square.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the blue Square?";
		item.addPath(false, path + "circle/green%20circle.jpg");
		item.addPath(true, path + "Square/blue%20Square.jpg");
		item.addPath(false, path + "circle/blue%20circle.jpg");
		AddQuestion(item);
	}

}
