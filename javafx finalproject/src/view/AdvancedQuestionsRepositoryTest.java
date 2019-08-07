package view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdvancedQuestionsRepositoryTest {

	@Test
	void ValidateRepository() {
		AdvancedQuestionsRepository.GetInstnace().RefreshList();
		QuestionRepositoryItem item = AdvancedQuestionsRepository.GetInstnace().GetRandomItem();
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
			
			item = AdvancedQuestionsRepository.GetInstnace().GetRandomItem();
		}
	}

}
