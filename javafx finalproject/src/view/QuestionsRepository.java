package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionsRepository {

	private List<QuestionRepositoryItem> _allQuestions;

	public QuestionsRepository() {
		_allQuestions = new ArrayList<QuestionRepositoryItem>();
	}

	protected void AddQuestion(QuestionRepositoryItem questionItem) {
		_allQuestions.add(questionItem);
	}

	/**
	 * Override this method to create the list of questions
	 */
	protected void CreateQuestions() {
	}

	/**
	 * Reload all questions into the repository
	 */
	public void RefreshList() {
		
		// Remove all old questions
		_allQuestions.clear();
		
		// Create new questions
		CreateQuestions();
	}

	public int GetNumberOfQuestions() {
		return _allQuestions.size();
	}

	/**
	 * Get a random question from the repository and remove it from the repository.
	 * If the repository is empty, return null
	 * @return
	 */
	public QuestionRepositoryItem GetRandomItem() {
		int numOfQuestions = _allQuestions.size();
		if (numOfQuestions == 0)
			return null;

		Random rand = new Random();
		
		// get a random index for the question
		int i = rand.nextInt(numOfQuestions);

		// Get the question
		QuestionRepositoryItem item = _allQuestions.get(i);
		
		// Remove from the list
		_allQuestions.remove(i);

		return item;

	}
	
	public void TEST_setList(List<QuestionRepositoryItem> lst)
	{
		_allQuestions = lst;
	}

}
