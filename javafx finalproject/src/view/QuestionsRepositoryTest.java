package view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QuestionsRepositoryTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void getRandomItem_questionExists_returnQuestion() {
		QuestionsRepository repository = new QuestionsRepository();
		List<QuestionRepositoryItem> lst = new ArrayList<QuestionRepositoryItem>();
		QuestionRepositoryItem expectedItem = new QuestionRepositoryItem();
		lst.add(expectedItem);
		repository.TEST_setList(lst);

		QuestionRepositoryItem item = repository.GetRandomItem();

		assertEquals(expectedItem, item);
	}

	@Test
	void getRandomItem_questionExists_questionRemoved() {
		QuestionsRepository repository = new QuestionsRepository();
		List<QuestionRepositoryItem> lst = new ArrayList<QuestionRepositoryItem>();
		QuestionRepositoryItem expectedItem = new QuestionRepositoryItem();
		lst.add(expectedItem);
		repository.TEST_setList(lst);

		QuestionRepositoryItem item = repository.GetRandomItem();

		assertEquals(0, lst.size());
	}

	@Test
	void getRandomItem_noMoreQuestions_returnNull() {
		QuestionsRepository repository = new QuestionsRepository();
		QuestionRepositoryItem item = repository.GetRandomItem();

		assertNull(item);
	}

	@Test
	void getNumberOfQuestion_noQuestion_returnZero() {
		QuestionsRepository repository = new QuestionsRepository();
		int size = repository.GetNumberOfQuestions();
		assertEquals(0, size);

	}

	@Test
	void getNumberOfQuestion_twoQuestion_returnTwo() {
		QuestionsRepository repository = new QuestionsRepository();
		List<QuestionRepositoryItem> lst = new ArrayList<QuestionRepositoryItem>();
		lst.add(new QuestionRepositoryItem());
		lst.add(new QuestionRepositoryItem());
		repository.TEST_setList(lst);
		int size = repository.GetNumberOfQuestions();
		assertEquals(2, size);

	}

	@Test
	void refreshList_twoQuestion_repositorycleared() {
		QuestionsRepository repository = new QuestionsRepository();
		List<QuestionRepositoryItem> lst = new ArrayList<QuestionRepositoryItem>();
		repository.TEST_setList(lst);
		lst.add(new QuestionRepositoryItem());
		lst.add(new QuestionRepositoryItem());
		repository.RefreshList();
		int size = lst.size();
		assertEquals(0, size);

	}

	@Test
	void addQuestion_createQuestion_questionAddedToRepository() {
		QuestionsRepository repository = new QuestionsRepository();
		List<QuestionRepositoryItem> lst = new ArrayList<QuestionRepositoryItem>();
		repository.TEST_setList(lst);
		repository.AddQuestion(new QuestionRepositoryItem());
		int size = lst.size();
		assertEquals(1, size);
		repository.AddQuestion(new QuestionRepositoryItem());
		size = lst.size();
		assertEquals(2, size);
	}
	
}