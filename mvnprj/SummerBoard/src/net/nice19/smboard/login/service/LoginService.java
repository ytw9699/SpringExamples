package net.nice19.smboard.login.service;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import net.nice19.smboard.login.dao.LoginDao;
import net.nice19.smboard.login.model.LoginSessionModel;

public class LoginService implements LoginDao {
	
private SqlMapClientTemplate sqlMapClientTemplate;

public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
	this.sqlMapClientTemplate = sqlMapClientTemplate;//���Թް�
}
@Override
public LoginSessionModel checkUserId(String userId) {//dao�κ��� �������̵�
	return (LoginSessionModel) sqlMapClientTemplate.queryForObject("login.loginCheck", userId);//�ڹٺ���!
										//login.xml������ login�� ���ӽ����̽� . loginCheck�� id
	}	
}