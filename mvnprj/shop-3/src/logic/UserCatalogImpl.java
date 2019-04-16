package logic;

import dao.UserDao;

public class UserCatalogImpl implements UserCatalog {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserByUserIdAndPassword(String userId, String password) {
		return this.userDao.findByUserIdAndPassword(userId, password);
	}
}