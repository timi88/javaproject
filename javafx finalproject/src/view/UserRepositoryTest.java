package view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	private String readOnlyRepositoryPath = "C:\\Users\\user\\eclipse-workspace\\javafx finalproject\\src\\files\\TEST_readOnly.xlsx";
	private String readOnlyEmptyRepositoryPath = "C:\\Users\\user\\eclipse-workspace\\javafx finalproject\\src\\files\\TEST_readOnlyEmpty.xlsx";
	private String changedRepositoryPath = "C:\\Users\\user\\eclipse-workspace\\javafx finalproject\\src\\files\\TEST_changed.xlsx";;

	@Test
	void loadUsersToMemory_fileIsEmpty_repositoryIsEmpty() {
		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);
		repository.TEST_setFilePath(readOnlyEmptyRepositoryPath);

		repository.loadUsersToMemory();

		assertEquals(0, repository.TEST_getList().size());
	}

	@Test
	void loadUsersToMemory_fileHasData_dataLoaded() {
		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);
		repository.TEST_setFilePath(readOnlyRepositoryPath);

		repository.loadUsersToMemory();

		assertEquals(2, repository.TEST_getList().size());
		UserRepositoryItem user = repository.TEST_getList().get(0);
		assertEquals("test1LoginName", user.loginName);
		assertEquals("test1FirstName", user.firstName);
		assertEquals("test1LastName", user.lastName);
		assertEquals(94, user.score);

		user = repository.TEST_getList().get(1);
		assertEquals("test2LoginName", user.loginName);
		assertEquals("test2FirstName", user.firstName);
		assertEquals("test2LastName", user.lastName);
		assertEquals(49, user.score);
	}

	@Test
	void loadUsersToMemory_calledTwice_dataNotDuicated() {
		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);
		repository.TEST_setFilePath(readOnlyRepositoryPath);

		repository.loadUsersToMemory();
		repository.loadUsersToMemory();

		assertEquals(2, repository.TEST_getList().size());
		UserRepositoryItem user = repository.TEST_getList().get(0);
		assertEquals("test1LoginName", user.loginName);
		assertEquals("test1FirstName", user.firstName);
		assertEquals("test1LastName", user.lastName);
		assertEquals(94, user.score);

		user = repository.TEST_getList().get(1);
		assertEquals("test2LoginName", user.loginName);
		assertEquals("test2FirstName", user.firstName);
		assertEquals("test2LastName", user.lastName);
		assertEquals(49, user.score);
	}

	@Test
	void saveChanges_ChangeScore_scoreChanged() {
		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);
		repository.TEST_setFilePath(readOnlyRepositoryPath);

		repository.loadUsersToMemory();
		UserRepositoryItem user = repository.TEST_getList().get(0);
		user.score = 100;

		repository.TEST_setFilePath(changedRepositoryPath);
		repository.SaveChanges();

		repository.loadUsersToMemory();
		user = repository.TEST_getList().get(0);
		assertEquals(100, user.score);
	}

	@Test
	void saveChanges_ChangeFirstNameAndLastName_nameChanged() {

		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);
		repository.TEST_setFilePath(readOnlyRepositoryPath);

		repository.loadUsersToMemory();
		UserRepositoryItem user = repository.TEST_getList().get(0);
		user.firstName = "X";
		user.lastName = "Y";

		repository.TEST_setFilePath(changedRepositoryPath);
		repository.SaveChanges();

		repository.loadUsersToMemory();
		user = repository.TEST_getList().get(0);
		assertEquals("X", user.firstName);
		assertEquals("Y", user.lastName);

	}

	@Test
	void saveChanges_userAdded_userSaved() {

		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);
		repository.TEST_setFilePath(readOnlyRepositoryPath);

		UserRepositoryItem user = new UserRepositoryItem();
		user.loginName = "test1LoginName";
		user.firstName = "test1FirstName";
		user.lastName = "test1LastName";
		user.score = 94;
		repository.TEST_getList().add(user);

		user = new UserRepositoryItem();
		user.loginName = "test2LoginName";
		user.firstName = "test2FirstName";
		user.lastName = "test2LastName";
		user.score = 49;
		repository.TEST_getList().add(user);

		repository.SaveChanges();
		repository.loadUsersToMemory();

		assertEquals(2, repository.TEST_getList().size());
		user = repository.TEST_getList().get(0);
		assertEquals("test1LoginName", user.loginName);
		assertEquals("test1FirstName", user.firstName);
		assertEquals("test1LastName", user.lastName);
		assertEquals(94, user.score);

		user = repository.TEST_getList().get(1);
		assertEquals("test2LoginName", user.loginName);
		assertEquals("test2FirstName", user.firstName);
		assertEquals("test2LastName", user.lastName);
		assertEquals(49, user.score);

	}

	@Test
	void getAllUsers_repositoryIsEmpty_returnEmptyList() {
		UserRepository repository = UserRepository.TEST_createRepository();
		int size = repository.GetAllUsers().size();
		assertEquals(0, size);
	}

	@Test
	void getAllUsers_repositoryHasData_returnList() {
		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);

		UserRepositoryItem user = new UserRepositoryItem();
		user.loginName = "test1LoginName";
		user.firstName = "test1FirstName";
		user.lastName = "test1LastName";
		user.score = 94;
		repository.TEST_getList().add(user);

		user = new UserRepositoryItem();
		user.loginName = "test2LoginName";
		user.firstName = "test2FirstName";
		user.lastName = "test2LastName";
		user.score = 49;
		repository.TEST_getList().add(user);

		List<UserRepositoryItem> users = repository.GetAllUsers();

		assertEquals(2, users.size());
		user = users.get(0);
		assertEquals("test1LoginName", user.loginName);
		assertEquals("test1FirstName", user.firstName);
		assertEquals("test1LastName", user.lastName);
		assertEquals(94, user.score);

		user = users.get(1);
		assertEquals("test2LoginName", user.loginName);
		assertEquals("test2FirstName", user.firstName);
		assertEquals("test2LastName", user.lastName);
		assertEquals(49, user.score);
	}

	@Test
	void addUser_newUser_userAddedAndReturnTrue() {
		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);

		UserRepositoryItem user = new UserRepositoryItem();
		user.loginName = "Test";
		lst.add(user);

		user = new UserRepositoryItem();
		user.loginName = "Test2";

		Boolean returnValue = repository.AddUser(user);
		assertTrue(returnValue);
		assertEquals(2, lst.size());
	}

	@Test
	void addUser_existingUser_userNotAddedAndReturnFalse() {
		UserRepository repository = UserRepository.TEST_createRepository();
		List<UserRepositoryItem> lst = new ArrayList<UserRepositoryItem>();
		repository.TEST_setList(lst);

		UserRepositoryItem user = new UserRepositoryItem();
		user.loginName = "Test";
		lst.add(user);

		user = new UserRepositoryItem();
		user.loginName = "Test";

		Boolean returnValue = repository.AddUser(user);
		assertFalse(returnValue);
		assertEquals(1, lst.size());
	}

}
