package view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class UserRepository {

	private UserRepository() {

	}

	private static UserRepository _instance = new UserRepository();

	/**
	 * Get UserRepository singleton
	 * 
	 * @return
	 */
	public static UserRepository GetInstnace() {
		return _instance;
	}

	/**
	 * Get or set the user currently logged in
	 */
	public UserRepositoryItem loggedUser;

	List<UserRepositoryItem> _allUsers = new ArrayList<UserRepositoryItem>();
	String _fileName = "C:\\Users\\user\\eclipse-workspace\\javafx finalproject\\src\\files\\datafile.xlsx";

	/**
	 * loads all users from the xlsx file to the repository
	 */
	public void loadUsersToMemory() {
		_allUsers.clear();

		try {
		
			Workbook workBook = Workbook.getWorkbook(new File(_fileName));
			Sheet sheet = workBook.getSheet(0);

			int numOfRows = sheet.getRows();
			// going over the rows in the exel starting from line 2 (line 1 is headers)
			for (int i = 1; i < numOfRows; ++i) {
				UserRepositoryItem user = new UserRepositoryItem();
				Cell cell = sheet.getCell(0, i);
				user.firstName = cell.getContents();

				cell = sheet.getCell(1, i);
				user.lastName = cell.getContents();

				cell = sheet.getCell(2, i);
				user.loginName = cell.getContents();
				cell = sheet.getCell(3, i);
				user.score = Integer.parseInt(cell.getContents());
				_allUsers.add(user);
			}
		} catch (Exception e) {
			System.out.println("e.getMessage (): " + e.getMessage());
		}
	}

	/**
	 * save all users in repository in to execl file
	 */
	public void SaveChanges() {

		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File(_fileName));
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);

			Label label = new Label(0, 0, "FirstName");
			sheet.addCell(label);

			label = new Label(1, 0, "LastName");
			sheet.addCell(label);

			label = new Label(2, 0, "LoginName");
			sheet.addCell(label);

			label = new Label(3, 0, "Score");
			sheet.addCell(label);

			// going over users and write them to the file.
			// note: user i is written to line i+1 because he first row is saved for headers
			for (int i = 0; i < _allUsers.size(); i++) {
				UserRepositoryItem user = _allUsers.get(i);
				label = new Label(0, i + 1, user.firstName);
				sheet.addCell(label);
				label = new Label(1, i + 1, user.lastName);
				sheet.addCell(label);
				label = new Label(2, i + 1, user.loginName);
				sheet.addCell(label);
				Number number = new Number(3, i + 1, user.score);
				sheet.addCell(number);
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			System.out.println("e.getMessage (): " + e.getMessage());
		}

	}

/**
 * return all the users in the repository
 * @return
 */
	public List<UserRepositoryItem> GetAllUsers() {
		return _allUsers;
	}
	
	/**
	 * try to add the to the repository
	 * User can't be added if another user exists with the same login name
	 * @return true if the user was added or false if not
	 */
	public boolean AddUser(UserRepositoryItem user) {

		for (int i = 0; i < _allUsers.size(); i++) {
			UserRepositoryItem item = _allUsers.get(i);
			if (item.loginName.equals(user.loginName)) {
				return false;
			}

		}

		_allUsers.add(user);
		return true;

	}
	
	public static UserRepository TEST_createRepository()
	{
		return new UserRepository();
	}
	
	public void TEST_setList(List<UserRepositoryItem> lst)
	{
		this._allUsers = lst;
	}
	
	public List<UserRepositoryItem> TEST_getList()
	{
		return this._allUsers;
	}
	
	public void TEST_setFilePath(String path)
	{
		this._fileName = path;
	}
	
	
}