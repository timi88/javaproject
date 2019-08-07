package view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MediumQuestionsRepositoryTest {

	@Test
	void ValidateRepository() {
		MediumQuestionsRepository.GetInstnace().RefreshList();
		QuestionRepositoryItem item = MediumQuestionsRepository.GetInstnace().GetRandomItem();
		while(item != null)
		{
			assertEquals(3,  item.getPaths().size());
			int sum = 0;
			for (int i = 0; i < 3; ++i)
			{
				if (item.isCorrectPath(item.getPaths().get(i)))
				{
					sum = sum + 1;
				}
			}
			
			assertEquals(1,  sum);
			
			item = MediumQuestionsRepository.GetInstnace().GetRandomItem();
		}
	}

}
