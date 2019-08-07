package view;

public class AdvancedQuestionsRepository extends QuestionsRepository {
	
	private AdvancedQuestionsRepository() {

	}

	private static AdvancedQuestionsRepository _instance = new AdvancedQuestionsRepository();

	public static AdvancedQuestionsRepository GetInstnace() {
		return _instance;
	}

	@Override
	protected void CreateQuestions() {

		String path = (getClass().getResource("/resources/")).toString();
		System.out.println(path);

		// TODO : Fill the list with items

		QuestionRepositoryItem item = new QuestionRepositoryItem();
		item.questionText = "Which picture has more pink color?";
		item.addPath(false, path + "circle/pink%20circles.jpg");
		item.addPath(true, path + "Square/pink%20Squares.jpg");
		item.addPath(false, path + "Square/brown%20Squares.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture have more Squares?";
		item.addPath(false, path + "Square/light%20blue%20Square.jpg");
		item.addPath(true, path + "Square/light%20blue%20Squares.jpg");
		item.addPath(false, path + "triangle/orange.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture have more Squares?";
		item.addPath(false, path + "Square/big%20Square.jpg");
		item.addPath(true, path + "Square/gray%20Squares.jpg");
		item.addPath(false, path + "circle/orange%20circles.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture have more purple circles?";
		item.addPath(false, path + "circle/light%20blue%20circles.jpg");
		item.addPath(true, path + "circle/purple%20circles.jpg");
		item.addPath(false, path + "circle/pink%20circles.jpg");
		AddQuestion(item);

		item = new QuestionRepositoryItem();
		item.questionText = "Which picture have more orange triangle?";
		item.addPath(false, path + "triangle/yellow%20triangles.jpg");
		item.addPath(true, path + "triangle/orange%20triangles.jpg");
		item.addPath(false, path + "triangle/gray%20triangles.jpg");
		AddQuestion(item);
	}

}
