package view;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryItem {
	
	public QuestionRepositoryItem()
	{
		_allPaths = new ArrayList<String>();
	}
	
	public String questionText;
	private String correntPath;
	private List<String> _allPaths;
	
	public void addPath(boolean isCorrect, String path)
	// this is place to add optional answer
	{
		_allPaths.add(path);
		if (isCorrect)
			correntPath = path;
	}
	
	public List<String> getPaths()
	{
		List<String> lst = new ArrayList<String>();
		lst.addAll(_allPaths);
		return lst;
	}
	
	public boolean isCorrectPath(String path)
	{
		return path.equals(correntPath);
	}


}
