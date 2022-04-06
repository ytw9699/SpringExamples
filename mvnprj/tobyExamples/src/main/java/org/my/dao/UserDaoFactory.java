package org.my.dao;

public class UserDaoFactory {
	
	public UserDao3 userDao() {
		UserDao3 dao = new UserDao3(connectionMaker());
		return dao;
	}

	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
