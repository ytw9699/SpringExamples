package dao;

import logic.User;

public interface UserDao {
	
	User findByUserIdAndPassword(String userId, String password);
}