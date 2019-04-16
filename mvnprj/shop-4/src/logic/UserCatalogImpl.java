package logic;

import dao.UserDao;

public class UserCatalogImpl implements UserCatalog {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void entryUser(User user) {
		this.userDao.create(user);
	}
}