package net.nice19.smboard.login.service;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import net.nice19.smboard.login.dao.LoginDao;
import net.nice19.smboard.login.model.LoginSessionModel;

public class LoginService implements LoginDao {
	
private SqlMapClientTemplate sqlMapClientTemplate;

public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
	this.sqlMapClientTemplate = sqlMapClientTemplate;//주입받고
}
@Override
public LoginSessionModel checkUserId(String userId) {//dao로부터 오버라이드
	return (LoginSessionModel) sqlMapClientTemplate.queryForObject("login.loginCheck", userId);//자바빈리턴!
										//login.xml과연결 login은 네임스페이스 . loginCheck는 id
	}	
}