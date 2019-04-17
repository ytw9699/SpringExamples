package net.nice19.smboard.login.dao;

import net.nice19.smboard.login.model.LoginSessionModel;

public interface LoginDao {	
	LoginSessionModel checkUserId(String userId);
}