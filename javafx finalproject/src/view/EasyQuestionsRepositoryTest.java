package view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EasyQuestionsRepositoryTest {

	@Test
	void ValidateRepository() {
		EasyQuestionsRepository.GetInstnace().RefreshList();
		QuestionRepositoryItem item = EasyQuestionsRepository.GetInstnace().GetRandomItem();
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
			
			item = EasyQuestionsRepository.GetInstnace().GetRandomItem();
		}
	}


}
