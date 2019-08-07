package view;

public class EasyQuestionsRepository extends QuestionsRepository {
	
	private EasyQuestionsRepository() {

	}

	private static EasyQuestionsRepository _instance = new EasyQuestionsRepository();

	public static EasyQuestionsRepository GetInstnace() {
		return _instance;
	}

	@Override
	protected void CreateQuestions() {

		String path = (getClass().getResource("/resources/")).toString();
		System.out.println(path);

		QuestionRepositoryItem item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the Orange triangle?";
		item.addPath(false, path + "triangle/green%20triangle.jpg");
		item.addPath(true, path + "triangle/orange.jpg");
		item.addPath(false, path + "triangle/purple.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the purple circle?";
		item.addPath(false, path + "circle/grey%20circle.jpg");
		item.addPath(true, path + "circle/purple%20circle.jpg");
		item.addPath(false, path + "circle/blue%20circle.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the red square?";
		item.addPath(false, path + "Square/light%20blue%20Square.jpg");
		item.addPath(true, path + "Square/red%20Square.jpg");
		item.addPath(false, path + "Square/yellow%20Square.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the gray square?";
		item.addPath(false, path + "triangle/grey%20triangle.jpg");
		item.addPath(true, path + "Square/gray%20Square.jpg");
		item.addPath(false, path + "circle/grey%20circle.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture is the yellow cicrle?";
		item.addPath(false, path + "Square/yellow%20Square.jpg");
		item.addPath(true, path + "circle/yellow%20circle.jpg");
		item.addPath(false, path + "triangle/yellow%20triangle.jpg");
		AddQuestion(item);

	}

}
